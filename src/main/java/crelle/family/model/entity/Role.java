package crelle.family.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:crelle
 * @date:2021/3/18
 * @title:
 * @description:
 * @params:
 * @return:
 * @throw:
 */
@ApiModel(value = "role", description = "角色实体")
@Entity(name = "role")
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "角色标识", hidden = true)
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "角色编码")
    private String name;

    @Column(name = "nameZh")
    @ApiModelProperty(value = "角色名称")
    private String nameZh;

    //角色表为关系维护表,
    // 1.没有添加CascadeType.REMOVE
    //      删除角色，只会删除role和role_menu表中对应的数据
    //2.添加了CascadeType.REMOVE
    //      删除角色，会删除role,role_menu和menu表中对应的数据
    @ApiModelProperty(value = "菜单列表", hidden = true)
    @JsonIgnoreProperties(value = "roles")
    @ManyToMany(targetEntity = Menu.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "role_menu",
            //中间表role_menu中角色外键对应的字段名称
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            //中间表role_menu中菜单外键对应的字段名称
            inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")}
    )
    private Set<Menu> menus = new HashSet<>();

    // mappedBy指示了角色表放弃维护关系表，由用户表来维护
    @JsonIgnore
    @ApiModelProperty(value = "用户列表", hidden = true)
    @JsonIgnoreProperties(value = "roles")
    @ManyToMany(targetEntity = User.class, mappedBy = "roles", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }


    @Override
    public String toString() {
        //查询角色的时候不需要用用户信息
        if (!CollectionUtils.isEmpty(this.users)) {
                this.users.clear();
        }
        if (!CollectionUtils.isEmpty(this.menus)) {
            for (Menu menu : this.menus) {
                menu.getRoles().clear();
            }
        }
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", menus=" + menus +
                ", users=" + users +
                '}';
    }
}
