package baseline.app.pojo.query;

import baseline.app.pojo.entity.Asset;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AssetQuery",description = "资产查询体")
public class AssetQuery extends Asset {

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("员工名称")
    private String employeeName;

}
