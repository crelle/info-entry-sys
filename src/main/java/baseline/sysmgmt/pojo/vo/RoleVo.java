package baseline.sysmgmt.pojo.vo;

import baseline.sysmgmt.pojo.entity.Role;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "RoleVo",description = "角色表页面模型")
public class RoleVo extends Role {
}
