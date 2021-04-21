package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author:crelle
 * @className:Years
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@ApiModel(value = "Years",description = "年代实体")
@Data
public class Years {

    @ApiModelProperty(value = "id",name = "")
    private Long id;

    @ApiModelProperty(value = "reignTitle",name = "")
    private String reignTitle;

    @ApiModelProperty(value = "dynasty",name = "")
    private String dynasty;

    @ApiModelProperty(value = "solarCalendar",name = "")
    private String solarCalendar;

    @ApiModelProperty(value = "gregorianCalendar",name = "")
    private String gregorianCalendar;

    @ApiModelProperty(value = "ad",name = "")
    private String ad;

    @ApiModelProperty(value = "dynastyStartTime",name = "")
    private Date dynastyStartTime;

    @ApiModelProperty(value = "dynastyEndTime",name = "")
    private Date dynastyEndTime;
}
