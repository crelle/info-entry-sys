package baseline.sysmgmt.pojo.query;

import baseline.sysmgmt.pojo.entity.UserRole;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "UserRoleQuery",description = "用户角色关系表查询体")
public class UserRoleQuery extends UserRole {
}
