package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author:crelle
 * @className:StandardCode
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/

@ApiModel(value = "StandardCode",description = "标准编码实体")
@Data
public class StandardCode {

    @ApiModelProperty(value = "id",name = "")
    private Long id;

    @ApiModelProperty(value = "standardName",name = "")
    private String standardName;

    @ApiModelProperty(value = "standardKey",name = "")
    private String standardKey;

    @ApiModelProperty(value = "standardValue",name = "")
    private String standardValue;

    @ApiModelProperty(value = "standardDesc",name = "")
    private String standardDesc;
}
