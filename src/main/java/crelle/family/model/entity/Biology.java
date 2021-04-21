package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author:crelle
 * @className:biology
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@Data
@ApiModel(value = "Biology" ,description = "生物实体")
public class Biology {

    @ApiModelProperty(value = "id")
    private Long id;

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
