package baseline.app.pojo.query.reportform;


import baseline.common.pojo.validation.Validation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value = "EmployeeSeniorityQuery", description = "工龄分布查询体")
@Getter
@Setter
public class EmployeeSeniorityQuery extends Validation {


    @ApiModelProperty(value = "区域")
    private String regionName;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

}
