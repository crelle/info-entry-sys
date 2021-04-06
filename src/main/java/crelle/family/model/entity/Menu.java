package crelle.family.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.JoinColumnOrFormula;

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
    @ApiModelProperty(value = "菜单标识")
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

    @ApiModelProperty(value = "是否存活")
    @Column(name = "keep_alive")
    private String keepAlive;

    @ApiModelProperty(value = "是否需要鉴权")
    @Column(name = "require_auth")
    private String requireAuth;

    @ApiModelProperty(value = "父菜单标识")
    @Column(name = "parent_id",insertable = false,updatable = false)
    private Long parentId;

    @ApiModelProperty(value = "是否可用")
    @Column(name = "enabled")
    private String enabled;


    @OneToMany(targetEntity = Menu.class, mappedBy = "parentMenu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Menu> childrenMenus = new HashSet<>();

    //解决循环嵌套问题，忽略关联对象任意一方的结果输出
    @JsonIgnore
    @ManyToOne(targetEntity = Menu.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Menu parentMenu;


    @ApiModelProperty(value = "角色列表")
    @JsonIgnoreProperties(value = "menus")
    @ManyToMany(targetEntity = Role.class, mappedBy = "menus", cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.LAZY)
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

    public String getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(String keepAlive) {
        this.keepAlive = keepAlive;
    }

    public String getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(String requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", keepAlive='" + keepAlive + '\'' +
                ", requireAuth='" + requireAuth + '\'' +
                ", parentId=" + parentId +
                ", enabled='" + enabled + '\'' +
                ", childrenMenus=" + childrenMenus +
                ", parentMenu=" + parentMenu +
                ", roles=" + roles +
                '}';
    }
}
