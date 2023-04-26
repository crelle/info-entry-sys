package baseline.sysmgmt.pojo.query;

import baseline.sysmgmt.pojo.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "UserQuery", description = "用户表查询体")
public class UserQuery extends User {
    private String roleName;
}
