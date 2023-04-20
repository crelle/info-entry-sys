package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("员工年龄分布返回体")
public class EmployeeAgeVO {

    @ApiModelProperty("出生年份")
    private Integer birthdayYear;

    @ApiModelProperty("数量")
    private Integer num;
}
