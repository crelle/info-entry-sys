package baseline.sysmgmt.common.config;

import baseline.common.pojo.vo.ResponseResult;
import baseline.common.config.ConfigProperties;
import baseline.common.util.ResultUtils;
import baseline.sysmgmt.pojo.entity.Menu;
import baseline.sysmgmt.pojo.entity.RoleMenu;
import baseline.sysmgmt.pojo.entity.User;
import baseline.sysmgmt.service.MenuService;
import baseline.sysmgmt.service.RoleMenuService;
import baseline.sysmgmt.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:crelle
 * @className:SecurityConfig
 * @version:1.0.0
 * @date:2021/3/17
 * @description:XX
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    UserService userService;

    @Autowired
    CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;

    @Autowired
    CustomUrlDecisionManager customUrlDecisionManager;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private MenuService menuService;

    //密文
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    MyFtpClient ftpClient() {
//        return new MyFtpClient(configProperties.getConfigValue("ftp.ip"),
//                Integer.valueOf(configProperties.getConfigValue("ftp.port")),
//                configProperties.getConfigValue("ftp.username"),
//                configProperties.getConfigValue("ftp.password"),
//                Integer.valueOf(configProperties.getConfigValue("ftp.active.min.port")),
//                Integer.valueOf(configProperties.getConfigValue("ftp.active.max.port")));
//    }

    //明文
//    @Bean
//    NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    RestAccessDeniedHandler accessDeniedHandler() {
        return new RestAccessDeniedHandler();
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
//        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
//        corsConfiguration.setAllowedOrigins(Arrays.asList(configProperties.getConfigValue("allowed.origin")));
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.setMaxAge(3600L);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        //所有的请求都允许跨域
//        source.registerCorsConfiguration("/**", corsConfiguration);
//        return source;
//
//
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/index.html", "/img/**", "/fonts/**", "/favicon.ico", "/verifyCode",
                "/sysmgmt/user/create",
                "/sysmgmt/user/uploadAvatar",
                "/sysmgmt/user/deleteAvatar",
                "/sysmgmt/user/page",
                "/sysmgmt/dictionary/**",
                "/app/**",
                "/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/v2/**", "/api/**");
    }

    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                User user = (User) authentication.getPrincipal();
                //子菜单排序
                user.getRoles().forEach(role -> {
                    role.getMenus().forEach(menu -> {
                        // 子菜单赋值
                        List<String> roleMenuList = roleMenuService
                                .list()
                                .stream()
                                .filter(roleMenu -> roleMenu.getRoleId().equals(role.getId()))
                                .map(RoleMenu::getMenuId)
                                .collect(Collectors.toList());
                        List<String> dbMenuList = menuService
                                .queryAll()
                                .stream()
                                .filter(menu1 -> menu1.getParentId() != null && menu1.getParentId().equals(menu.getId()))
                                .map(Menu::getId)
                                .collect(Collectors.toList());
                        List<String> childMenuList = roleMenuList.stream().filter(dbMenuList::contains).collect(Collectors.toList());
                        TreeSet<Menu> childrenMenuTreeSet = new TreeSet<>(((o1, o2) -> Long.compare(o1.getMenuSort(), o2.getMenuSort())));
                        for (String childMenuId : childMenuList) {
                            childrenMenuTreeSet.add(menuService.queryById(childMenuId));
                        }
                        menu.setChildrenMenus(childrenMenuTreeSet);
                    });
                    //父菜单排序
                    TreeSet<Menu> menuTreeSet = new TreeSet<>(((o1, o2) -> Long.compare(o1.getMenuSort(), o2.getMenuSort())));
                    menuTreeSet.addAll(role.getMenus());
                    List<Menu> menus = new ArrayList<>();
                    menus.addAll(menuTreeSet);
                    role.setMenus(menus);
                });
                user.setPassword(user.getPassword());
                ResponseResult responseResult = ResultUtils.success("登录成功!", user);
                String s = new ObjectMapper().writeValueAsString(responseResult);
                out.write(s);
                out.flush();
                out.close();
            }
        });
        loginFilter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                ResponseResult responseResult = ResultUtils.fail(exception.getMessage());
                if (exception instanceof LockedException) {
                    responseResult.setMessage("账户被锁定，请联系管理员!");
                } else if (exception instanceof CredentialsExpiredException) {
                    responseResult.setMessage("密码过期，请联系管理员!");
                } else if (exception instanceof AccountExpiredException) {
                    responseResult.setMessage("账户过期，请联系管理员!");
                } else if (exception instanceof DisabledException) {
                    responseResult.setMessage("账户被禁用，请联系管理员!");
                } else if (exception instanceof BadCredentialsException) {
                    responseResult.setMessage("用户名或者密码输入错误，请重新输入!");
                }
                out.write(new ObjectMapper().writeValueAsString(responseResult));
                out.flush();
                out.close();
            }
        });
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/doLogin");
        return loginFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customUrlDecisionManager);
                        object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        return object;
                    }
                }).and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(ResultUtils.success("注销成功!")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                //没有认证时，在这里处理结果，不要重定向
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authException) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        resp.setStatus(401);
                        PrintWriter out = resp.getWriter();
                        ResponseResult responseResult = ResultUtils.fail("访问失败!");
                        responseResult.setCode("CMA0200");
                        if (authException instanceof InsufficientAuthenticationException) {
                            responseResult.setMessage("没有登录认证，请先登录!");
                        }
                        out.write(new ObjectMapper().writeValueAsString(responseResult));
                        out.flush();
                        out.close();
                    }
                }).and()
                .cors(Customizer.withDefaults())
                //自定处理accessDeniedException异常
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler()).and()
                .addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
        //开启controller级别 @CrossOrigin注解(和CorsConfig冲突,需要关闭)
        //http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

    }

}
