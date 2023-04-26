package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DepartmentAnalysisVO", description = "部门分析页面模型")
public class DepartmentAnalysisVO {

    @ApiModelProperty("部门人数")
    private String departmentNum;

    @ApiModelProperty("部门名称")
    private String departmentName;
}
