package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SkillAnalysisVO", description = "技能分析页面模型")
public class SkillAnalysisVO {

    @ApiModelProperty("技能名称")
    private String skillName;

    @ApiModelProperty("技能人数")
    private String skillNum;

}
