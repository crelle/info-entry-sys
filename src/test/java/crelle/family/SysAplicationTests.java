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
import java.util.List;

@SpringBootTest
class SysAplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    MenuDao menuDao;

    @Autowired
    RoleDao roleDao;

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
        List<Role> rs1 = new ArrayList<>();
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
        List<Role> rs2 = new ArrayList<>();
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
        List<Role> rs3 = new ArrayList<>();
        Role r3 = new Role();
        r3.setName("ROLE_guest");
        r3.setNameZh("访客");
        rs3.add(r3);
        u3.setRoles(rs3);
        userDao.save(u3);


    }

    void initMenuWithRole(){
        List<Menu> menus = new ArrayList<>();
        Menu menu1 = new Menu();
        menu1.setName("系统管理");
        menu1.setUrl("/sys/");
        menu1.setComponent("/sys/component/");

        List<Role> roles = roleDao.findAll();
        menus.add(menu1);

        Menu menu2 = new Menu();
        menu2.setName("植物管理");
        menu2.setUrl("/plant/");
        menu2.setComponent("/plant/component/");
        menus.add(menu2);

        Menu menu3 = new Menu();
        menu3.setName("学科管理");
        menu3.setUrl("/object/");
        menu3.setComponent("/object/component/");
        menus.add(menu3);

        menuDao.saveAll(menus);
    }

}
