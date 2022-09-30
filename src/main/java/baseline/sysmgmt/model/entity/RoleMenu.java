package baseline.sysmgmt.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("role_menu")
@ApiModel(value = "RoleMenu对象", description = "")
public class RoleMenu {

    @TableId(value = "role_id", type = IdType.ASSIGN_UUID)
    private Long roleId;

    @TableId(value = "menu_id", type = IdType.ASSIGN_UUID)
    private Long menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
            "roleId=" + roleId +
            ", menuId=" + menuId +
        "}";
    }
}
