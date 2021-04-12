package crelle.family.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import crelle.family.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import crelle.family.common.ResponseResult;
import crelle.family.common.util.ResultUtils;
import crelle.family.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    UserServiceImpl userService;

    @Autowired
    CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    @Autowired
    CustomUrlDecisionManager customUrlDecisionManager;

    //密文
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    //明文
    @Bean
    NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    RestAccessDeniedHandler accessDeniedHandler() {
        return new RestAccessDeniedHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/login.html", "/img/**", "/fonts/**", "/favicon.ico", "/verifyCode",
//                "/user/**" , "/role/**" , "/menu/**" ,
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
                user.setPassword(null);
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

        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customUrlDecisionManager);
                        object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        return object;
                    }
                })
                .and()
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
                        if (authException instanceof InsufficientAuthenticationException) {
                            responseResult.setMessage("没有登录认证，请先登录!");
                        }
                        out.write(new ObjectMapper().writeValueAsString(responseResult));
                        out.flush();
                        out.close();
                    }
                })
                //自定处理accessDeniedException异常
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler());

        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
