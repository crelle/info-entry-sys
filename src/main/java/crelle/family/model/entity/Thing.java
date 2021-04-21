package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author:crelle
 * @className:Thing
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@ApiModel(value = "Thing",description = "事情实体")
@Data
public class Thing {

    @ApiModelProperty(value = "id",name = "")
    private Long id;

    @ApiModelProperty(value = "planId",name = "")
    private Long planId;

    @ApiModelProperty(value = "personId",name = "")
    private Long personId;

    @ApiModelProperty(value = "thingTitle",name = "")
    private String thingTitle;

    @ApiModelProperty(value = "thingGoal",name = "")
    private String thingGoal;

    @ApiModelProperty(value = "thingScene",name = "")
    private String thingScene;
}
