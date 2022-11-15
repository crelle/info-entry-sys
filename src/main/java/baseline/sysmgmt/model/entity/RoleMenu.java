package baseline.sysmgmt.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

/**
 * <p>
 *
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@TableName("role_menu")
@ApiModel(value = "RoleMenu对象", description = "")
public class RoleMenu {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("role_id")
    private String roleId;

    @TableField("menu_id")
    private String menuId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", menuId='" + menuId + '\'' +
                '}';
    }
}
