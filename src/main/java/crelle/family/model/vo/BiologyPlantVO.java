package crelle.family.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author:crelle
 * @className:BiologyPlant
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@ApiModel(value = "BiologyPlantVO",description = "植物列表VO")
@Data
public class BiologyPlantVO {
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

    @ApiModelProperty(value = "biologyDomain",name = "域")
    private String biologyDomain;

    @ApiModelProperty(value = "biologyKingdom",name = "界")
    private String biologyKingdom;

    @ApiModelProperty(value = "biologyPhylum",name = "门")
    private String biologyPhylum;

    @ApiModelProperty(value = "biologySecPhylum",name = "亚门")
    private String biologySecPhylum;

    @ApiModelProperty(value = "biologyClass",name = "纲")
    private String biologyClass;

    @ApiModelProperty(value = "biologySecClass",name = "亚纲")
    private String biologySecClass;

    @ApiModelProperty(value = "biologyCatalogue",name = "目")
    private String biologyCatalogue;

    @ApiModelProperty(value = "biologyFamily",name = "科")
    private String biologyFamily;

    @ApiModelProperty(value = "biologySecFamily",name = "亚科")
    private String biologySecFamily;

    @ApiModelProperty(value = "biologyGenus",name = "属")
    private String biologyGenus;

    @ApiModelProperty(value = "biologySpecies",name = "种")
    private  String biologySpecies;
}
