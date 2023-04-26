package baseline.sysmgmt.pojo.vo;

import baseline.sysmgmt.pojo.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "UserVo",description = "用户表页面模型")
public class UserVo extends User {
}
