package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author:crelle
 * @className:PlantPoetry
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@ApiModel(value = "PlantPoetry",description = "植物诗词实体")
@Data
public class PlantPoetry {

    @ApiModelProperty(value = "id",name = "")
    private Long id;

    @ApiModelProperty(value = "plantId",name = "")
    private  Long plantId;

    @ApiModelProperty(value = "poetryId",name = "")
    private Long poetryId;
}
