package baseline.sysmgmt.pojo.query;

import baseline.sysmgmt.pojo.entity.Role;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "RoleQuery",description = "角色表查询体")
public class RoleQuery extends Role {
}
