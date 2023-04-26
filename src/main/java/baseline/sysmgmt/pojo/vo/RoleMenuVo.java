package baseline.sysmgmt.pojo.vo;

import baseline.sysmgmt.pojo.entity.RoleMenu;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "RoleMenuVo",description = "角色菜单关系表页面模型")
public class RoleMenuVo extends RoleMenu {
}
