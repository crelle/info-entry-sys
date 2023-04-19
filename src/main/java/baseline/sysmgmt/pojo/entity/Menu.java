package baseline.sysmgmt.pojo.entity;

import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@TableName("t_menu")
@ApiModel(value = "Menu对象", description = "")
public class Menu extends BaseDo {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {DELETE.class, PUT.class})
    private String id;

    @TableField("component")
    private String component;

    @TableField("enabled")
    private Boolean enabled;

    @TableField("icon_ls")
    private String iconLs;

    @TableField("keep_alive")
    private Boolean keepAlive;

    @TableField("name")
    @NotBlank(groups = {POST.class})
    private String name;

    @TableField(value = "parent_id")
    private String parentId;

    @TableField("path")
    @NotBlank(groups = {POST.class})
    private String path;

    @TableField("require_auth")
    private Boolean requireAuth;

    @TableField("url")
    @NotBlank(groups = {POST.class})
    private String url;

    @TableField("menu_type")
    @NotBlank(groups = {POST.class})
    private String menuType;

    @TableField("menu_sort")
    private Long menuSort;

    @TableField(exist = false)
    private Set<Menu> childrenMenus = new HashSet<>();

    @TableField(exist = false)
    private Menu parentMenu;

    @TableField(exist = false)
    private Set<Role> roles = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getIconLs() {
        return iconLs;
    }

    public void setIconLs(String iconLs) {
        this.iconLs = iconLs;
    }

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Long getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Long menuSort) {
        this.menuSort = menuSort;
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

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", component='" + component + '\'' +
                ", enabled=" + enabled +
                ", iconLs='" + iconLs + '\'' +
                ", keepAlive=" + keepAlive +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", path='" + path + '\'' +
                ", requireAuth=" + requireAuth +
                ", url='" + url + '\'' +
                ", menuType='" + menuType + '\'' +
                ", menuSort=" + menuSort +
                ", childrenMenus=" + childrenMenus +
                ", parentMenu=" + parentMenu +
                ", roles=" + roles +
                '}';
    }
}
