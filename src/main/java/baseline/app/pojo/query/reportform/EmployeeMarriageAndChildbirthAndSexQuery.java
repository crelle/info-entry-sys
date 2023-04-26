package baseline.app.pojo.query.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EmployeeMarriageAndChildbirthAndSexQuery", description = "员工婚育和性别分析请求体")
public class EmployeeMarriageAndChildbirthAndSexQuery {

    @ApiModelProperty(value = "区域名称")
    private String regionName;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty("部门名称")
    private String departmentName;
}
