package baseline.sysmgmt.pojo.vo;

import baseline.sysmgmt.pojo.entity.UserRole;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "UserRoleVo",description = "用户角色关系表页面模型")
public class UserRoleVo  extends UserRole {
}
