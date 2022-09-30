package baseline.sysmgmt.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@TableName("menu")
@ApiModel(value = "Menu对象", description = "")
public class Menu {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("component")
    private String component;

    @TableField("enabled")
    private Boolean enabled;

    @TableField("icon_ls")
    private String iconLs;

    @TableField("keep_alive")
    private Boolean keepAlive;

    @TableField("name")
    private String name;

    @TableField("parent_id")
    private Long parentId;

    @TableField("path")
    private String path;

    @TableField("require_auth")
    private Boolean requireAuth;

    @TableField("url")
    private String url;

    @TableField("menu_type")
    private String menuType;

    @TableField("menu_sort")
    private Long menuSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
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

    @Override
    public String toString() {
        return "Menu{" +
            "id=" + id +
            ", component=" + component +
            ", enabled=" + enabled +
            ", iconLs=" + iconLs +
            ", keepAlive=" + keepAlive +
            ", name=" + name +
            ", parentId=" + parentId +
            ", path=" + path +
            ", requireAuth=" + requireAuth +
            ", url=" + url +
            ", menuType=" + menuType +
            ", menuSort=" + menuSort +
        "}";
    }
}
