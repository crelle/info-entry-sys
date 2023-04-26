package baseline.sysmgmt.pojo.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "RoleMenuQuery",description = "角色菜单关系表查询体")
public class RoleMenuQuery extends MenuQuery {
}
