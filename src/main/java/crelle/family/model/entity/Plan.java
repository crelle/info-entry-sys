package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author:crelle
 * @className:Plan
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@ApiModel(value = "Plan",description = "计划实体")
@Data
public class Plan {

    @ApiModelProperty(value = "id",name = "")
    private Long id;

    @ApiModelProperty(value = "planName",name = "")
    private String planName;

    @ApiModelProperty(value = "isFinished",name = "")
    private String isFinished;

    @ApiModelProperty(value = "startTime",name = "")
    private Date startTime;

    @ApiModelProperty(value = "endTime",name = "")
    private Date endTime;
}
