package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RegionAnalysisVO", description = "区域分析页面模型")
public class RegionAnalysisVO {


    @ApiModelProperty("地域名称")
    private String regionName;

    @ApiModelProperty("地域人数")
    private String regionNum;

}
