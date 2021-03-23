package plant.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

/**
 * @author:crelle
 * @className:Menu
 * @version:1.0.0
 * @date:2021/3/22
 * @description:XX
 **/

@Entity(name = "menu")
@ApiModel(value = "menu",description = "菜单实体")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "菜单标识")
    private Long id;

    @ApiModelProperty(value = "后台资源地址")
    private String url;

    @ApiModelProperty(value = "前台页面路径")
    private String path;

    @ApiModelProperty(value = "前台组件名称")
    private String component;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单图标")
    private String iconCls;

    @ApiModelProperty(value = "是否存活")
    private String keepAlive;

    @ApiModelProperty(value = "是否需要鉴权")
    private String requireAuth;

    @ApiModelProperty(value = "父菜单标识")
    private String parentId;

    @ApiModelProperty(value = "是否可用")
    private String enabled;

    @ApiModelProperty(value = "角色列表")
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private List<Role> roles;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
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
                ", parentId='" + parentId + '\'' +
                ", enabled='" + enabled + '\'' +
                ", roles=" + roles +
                '}';
    }
}
