package baseline.sysmgmt.pojo.entity;

import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户菜单关系表
 * </p>
 *
 * @author crelle
 * @since 2022-12-06 05:31:13
 */
@Getter
@Setter
@TableName("t_role_menu")
@ApiModel(value = "RoleMenu", description = "用户菜单关系表实体模型")
public class RoleMenu extends BaseDo {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("角色id")
    @TableField(value = "role_id")
    private String roleId;

    @ApiModelProperty("菜单id")
    @TableField(value = "menu_id")
    private String menuId;
}
