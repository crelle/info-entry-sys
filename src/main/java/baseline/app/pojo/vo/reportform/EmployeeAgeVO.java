package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "EmployeeAgeVO",description = "员工年纪分析页面模型")
public class EmployeeAgeVO {

    @ApiModelProperty("出生年份")
    private Integer birthdayYear;

    @ApiModelProperty("数量")
    private Integer num;
}
