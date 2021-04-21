package crelle.family.model.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author:crelle
 * @className:BiologyPlantAO
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@ApiModel(value = "BiologyPlantAO",description = "查询植物AO")
@Data
public class BiologyPlantAO {

    @ApiModelProperty(value = "plantName",name = "")
    private String plantName;

    @ApiModelProperty(value = "plantAlias",name = "")
    private String plantAlias;

    @ApiModelProperty(value = "enterBy",name = "")
    private String enterBy;

    @ApiModelProperty(value = "biologyDomain",name = "域")
    private String biologyDomain;

    @ApiModelProperty(value = "biologyKingdom",name = "界")
    private String biologyKingdom;

    @ApiModelProperty(value = "biologyPhylum",name = "门")
    private String biologyPhylum;


    @ApiModelProperty(value = "biologyClass",name = "纲")
    private String biologyClass;


    @ApiModelProperty(value = "biologyCatalogue",name = "目")
    private String biologyCatalogue;

    @ApiModelProperty(value = "biologyFamily",name = "科")
    private String biologyFamily;


    @ApiModelProperty(value = "biologyGenus",name = "属")
    private String biologyGenus;

    @ApiModelProperty(value = "biologySpecies",name = "种")
    private  String biologySpecies;

}
