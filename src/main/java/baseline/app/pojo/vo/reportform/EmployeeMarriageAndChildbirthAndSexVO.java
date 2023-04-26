package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "EmployeeMarriageAndChildbirthAndSexVO",description = "员工婚育和性别分析页面模型")
@Data
public class EmployeeMarriageAndChildbirthAndSexVO {

    @ApiModelProperty("已婚未育数量")
    private Long marriedAndNoPregnantNum;

    @ApiModelProperty("已婚已育数量")
    private Long marriedAndPregnantNum;

    @ApiModelProperty("未婚未育数量")
    private Long noMarriedAndNoPregnantNum;

    @ApiModelProperty("男生数量")
    private Long manNum;

    @ApiModelProperty("女生数量")
    private Long womenNum;

    @ApiModelProperty("总数")
    private Long total;
}
