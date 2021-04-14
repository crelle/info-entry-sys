package crelle.family.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.websocket.ClientEndpoint;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:crelle
 * @className:Menu
 * @version:1.0.0
 * @date:2021/3/22
 * @description:XX
 **/

@Entity(name = "menu")
@Table(name = "menu")
@ApiModel(value = "menu", description = "菜单实体")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "菜单标识", hidden = true)
    private Long id;

    @ApiModelProperty(value = "后台资源地址")
    @Column(name = "url")
    private String url;

    @ApiModelProperty(value = "前台页面路径")
    @Column(name = "path")
    private String path;

    @ApiModelProperty(value = "前台组件名称")
    @Column(name = "component")
    private String component;

    @ApiModelProperty(value = "菜单名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "菜单图标")
    @Column(name = "icon_ls")
    private String iconCls;

    @ApiModelProperty(value = "菜单类型")
    @Column(name = "menu_type")
    private String menuType;

    @ApiModelProperty(value = "是否存活")
    @Column(name = "keep_alive")
    private boolean keepAlive;

    @ApiModelProperty(value = "是否需要鉴权")
    @Column(name = "require_auth")
    private boolean requireAuth;

    @ApiModelProperty(value = "父菜单标识", hidden = true)
    @Column(name = "parent_id", insertable = false, updatable = false)
    private Long parentId;

    @ApiModelProperty(value = "是否可用")
    @Column(name = "enabled")
    private boolean enabled;


    @ApiModelProperty(value = "子菜单集合", hidden = true)
    @OneToMany(targetEntity = Menu.class, mappedBy = "parentMenu", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Menu> childrenMenus = new HashSet<>();

    //解决循环嵌套问题，忽略关联对象任意一方的结果输出
    @ApiModelProperty(value = "父亲菜单", hidden = true)
    @JsonIgnore
    @ManyToOne(targetEntity = Menu.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Menu parentMenu;


    @ApiModelProperty(value = "角色列表", hidden = true)
//    @JsonIgnoreProperties(value = "menus")
    @JsonIgnore
    @ManyToMany(targetEntity = Role.class, mappedBy = "menus", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(boolean requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Menu> getChildrenMenus() {
        return childrenMenus;
    }

    public void setChildrenMenus(Set<Menu> childrenMenus) {
        this.childrenMenus = childrenMenus;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        //角色循环嵌套处理
        if (!CollectionUtils.isEmpty(this.getRoles())) {
//            for (Role role : this.getRoles()) {
//                role.getUsers().clear();
//                role.getMenus().clear();
//            }
            this.getRoles().clear();
        }
        //子菜单循环嵌套处理
        if (!CollectionUtils.isEmpty(this.getChildrenMenus())) {
            for (Menu menu : this.getChildrenMenus()) {
                menu.getRoles().clear();
                menu.getChildrenMenus().clear();
            }
        }
        //父菜单循环嵌套处理
        if (null != parentMenu) {
            this.getParentMenu().getChildrenMenus().clear();
            this.getRoles().clear();
        }
        return "Menu{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", menuType='" + menuType + '\'' +
                ", keepAlive=" + keepAlive +
                ", requireAuth=" + requireAuth +
                ", parentId=" + parentId +
                ", enabled=" + enabled +
                ", childrenMenus=" + childrenMenus +
                ", parentMenu=" + parentMenu +
                ", roles=" + roles +
                '}';
    }
}
