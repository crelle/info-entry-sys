package baseline.sysmgmt.common.config;


import baseline.sysmgmt.pojo.entity.Menu;
import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author:crelle
 * @date:2021/3/24
 * @title:
 * @description:这个类的作用，主要是根据用户传来的请求地址，分析出请求需要的角色
 * @params:
 * @return:
 * @throw:
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> menus = menuService.queryAll();
        for (Menu menu : menus) {
            if (null!=menu.getUrl() && antPathMatcher.match(menu.getUrl(), requestUrl)) {
                Set<Role> roles = null;
                if (null != menu.getParentMenu()) {
                    roles = menu.getParentMenu().getRoles();
                } else {
                    roles = menu.getRoles();
                }
                ArrayList<Role> roleList = new ArrayList<Role>(roles);
                if (CollectionUtils.isEmpty(roles)) {
                    continue;
                }
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roleList.get(i).getName();
                }
                //告诉springSecurity Url所需要的角色
                return SecurityConfig.createList(str);
            }
        }
        //返回默认的登录角色,让用户登录
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
