package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ProjectNumberAnalysisVO", description = "项目人数分析页面模型")
public class ProjectNumberAnalysisVO {

    @ApiModelProperty("项目名称")
    private String  projectName;

    @ApiModelProperty("项目人数")
    private String projectNum;
}
