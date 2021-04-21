package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author:crelle
 * @className:Plant
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@Data
@ApiModel(value = "Plant",description = "植物实体")
public class Plant {

    @ApiModelProperty(value = "id",name = "")
    private Long id;

    @ApiModelProperty(value = "biologyId",name = "")
    private String biologyId;

    @ApiModelProperty(value = "plantName",name = "")
    private String plantName;

    @ApiModelProperty(value = "plantAlias",name = "")
    private String plantAlias;

    @ApiModelProperty(value = "picUrl",name = "")
    private String picUrl;

    @ApiModelProperty(value = "plantHeigh",name = "")
    private String plantHeigh;

    @ApiModelProperty(value = "coldLevel",name = "")
    private String coldLevel;

    @ApiModelProperty(value = "droughtLevel",name = "")
    private String droughtLevel;

    @ApiModelProperty(value = "sunshineLevel",name = "")
    private String sunshineLevel;

    @ApiModelProperty(value = "plantPlaceOfOrigin",name = "")
    private String plantPlaceOfOrigin;

    @ApiModelProperty(value = "plantTimeSlot",name = "")
    private String plantTimeSlot;

    @ApiModelProperty(value = "plantAge",name = "")
    private String plantAge;

    @ApiModelProperty(value = "remarks",name = "")
    private String remarks;

    @ApiModelProperty(value = "plantColor",name = "")
    private String plantColor;

    @ApiModelProperty(value = "enterBy",name = "")
    private String enterBy;

    @ApiModelProperty(value = "enterDate",name = "")
    private Date enterDate;

    @ApiModelProperty(value = "lastModifyBy",name = "")
    private String lastModifyBy;

    @ApiModelProperty(value = "lastModifyDate",name = "")
    private Date lastModifyDate;
}
