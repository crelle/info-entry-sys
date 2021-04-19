package crelle.family;

import crelle.family.dao.MenuDao;
import crelle.family.dao.RoleDao;
import crelle.family.model.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import crelle.family.dao.UserDao;
import crelle.family.model.entity.Role;
import crelle.family.model.entity.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class SysAplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    MenuDao menuDao;

    @Autowired
    RoleDao roleDao;

    //初始化用户和用户对应的角色
    @Test
    void initUserWithRole() {
        User u1 = new User();
        u1.setUsername("admin");
        u1.setPassword("admin");
        u1.setUserNickName("aa");
        u1.setUserEmail("aa.qq.com");
        u1.setUserPhone("12345678910");
        u1.setAccountNonExpired(true);
        u1.setAccountNonLocked(true);
        u1.setCredentialsNonExpired(true);
        u1.setEnabled(true);
        Set<Role> rs1 = new HashSet<>();
        Role r1 = new Role();
        r1.setName("ROLE_admin");
        r1.setNameZh("管理员");
        rs1.add(r1);
        u1.setRoles(rs1);
        userDao.save(u1);


        User u2 = new User();
        u2.setUsername("user");
        u2.setPassword("user");
        u2.setUserNickName("uu");
        u2.setUserEmail("uu.qq.com");
        u2.setUserPhone("12345678910");
        u2.setAccountNonExpired(true);
        u2.setAccountNonLocked(true);
        u2.setCredentialsNonExpired(true);
        u2.setEnabled(true);
        Set<Role> rs2 = new HashSet<>();
        Role r2 = new Role();
        r2.setName("ROLE_user");
        r2.setNameZh("普通用户");
        rs2.add(r2);
        u2.setRoles(rs2);
        userDao.save(u2);


        User u3 = new User();
        u3.setUsername("guest");
        u3.setPassword("guest");
        u3.setUserNickName("gg");
        u3.setUserEmail("gg.qq.com");
        u3.setUserPhone("12345678910");
        u3.setAccountNonExpired(true);
        u3.setAccountNonLocked(true);
        u3.setCredentialsNonExpired(true);
        u3.setEnabled(true);
        Set<Role> rs3 = new HashSet<>();
        Role r3 = new Role();
        r3.setName("ROLE_guest");
        r3.setNameZh("访客");
        rs3.add(r3);
        u3.setRoles(rs3);
        userDao.save(u3);


    }

    //初始化菜单
    @Test
    void initMenu() {
        Menu menu1 = new Menu();
        menu1.setName("系统管理");
        menu1.setPath("/sys/component/");
        menu1.setUrl("/sys/");
        menu1.setRequireAuth(true);
        menu1.setEnabled(true);
        menu1.setKeepAlive(true);
        menuDao.save(menu1);

        Menu menu2 = new Menu();
        menu2.setName("植物管理");
        menu2.setPath("/plant/component/");
        menu2.setUrl("/plant/");
        menu2.setRequireAuth(true);
        menu2.setEnabled(true);
        menu2.setKeepAlive(true);
        menuDao.save(menu2);

        Menu menu3 = new Menu();
        menu3.setName("学科管理");
        menu3.setPath("/object/component/");
        menu3.setUrl("/object/");
        menu3.setRequireAuth(true);
        menu3.setEnabled(true);
        menu3.setKeepAlive(true);
        menuDao.save(menu3);

        Menu menu4 = new Menu();
        menu4.setName("权限管理");
        menu4.setPath("/sys/privilege/");
        menu4.setUrl("/privilege/");
        menu4.setRequireAuth(true);
        menu4.setEnabled(true);
        menu4.setKeepAlive(true);
        menu4.setParentId(new Long(1));
        menuDao.save(menu4);

        Menu menu5 = new Menu();
        menu5.setName("数学");
        menu5.setPath("/object/math/");
        menu5.setUrl("/math/");
        menu5.setRequireAuth(true);
        menu5.setEnabled(true);
        menu5.setKeepAlive(true);
        menu5.setParentId(new Long(3));
        menuDao.save(menu5);

        Menu menu6 = new Menu();
        menu6.setName("语文");
        menu6.setPath("/object/chinese/");
        menu6.setUrl("/chinese/");
        menu6.setRequireAuth(true);
        menu6.setEnabled(true);
        menu6.setKeepAlive(true);
        menu6.setParentId(new Long(3));
        menuDao.save(menu6);

    }

    //为角色初始化菜单
    @Test
    void initMenuWithRole() {
        List<Menu> menus = menuDao.findAll();
        Set<Menu> adminMenus = new HashSet<>();
        Set<Menu> userMenus = new HashSet<>();
        Set<Menu> guestMenus = new HashSet<>();
        menus.forEach(menu -> {
            if (menu.getName().equals("系统管理")) {
                adminMenus.add(menu);
                userMenus.add(menu);
            } else if (menu.getName().equals("植物管理")) {
                adminMenus.add(menu);
                userMenus.add(menu);
            } else if (menu.getName().equals("学科管理")) {
                adminMenus.add(menu);
                guestMenus.add(menu);
            }
        });


        List<Role> allRoles = roleDao.findAll();
        allRoles.forEach(role -> {
            if (role.getName().equals("ROLE_admin")) {
                role.setMenus(adminMenus);
                roleDao.save(role);
            } else if (role.getName().equals("ROLE_user")) {
                role.setMenus(userMenus);
                roleDao.save(role);
            } else if (role.getName().equals("ROLE_guest")) {
                role.setMenus(guestMenus);
                roleDao.save(role);
            }
        });

    }

}
