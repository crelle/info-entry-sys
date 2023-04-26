package baseline.app.pojo.query.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "EmployeeAgeQuery", description = "员工年龄分布请求体")
public class EmployeeAgeQuery {

    @ApiModelProperty(value = "区域")
    private String regionName;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;
}
