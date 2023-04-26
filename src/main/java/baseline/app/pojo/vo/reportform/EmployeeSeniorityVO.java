package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "EmployeeSeniorityVO",description = "工龄分析页面模型")
public class EmployeeSeniorityVO {

    @ApiModelProperty(value = "工龄")
    private Integer seniority;

    @ApiModelProperty(value = "数量")
    private Integer num;
}
