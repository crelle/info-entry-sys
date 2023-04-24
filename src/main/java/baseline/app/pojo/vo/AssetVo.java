package baseline.app.pojo.vo;


import baseline.app.pojo.entity.Asset;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AssetVo extends Asset {

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("员工名称")
    private String employeeName;

}
