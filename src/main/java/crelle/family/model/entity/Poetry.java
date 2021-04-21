package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author:crelle
 * @className:Poetry
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@ApiModel(value = "Poetry",description = "诗词实体")
@Data
public class Poetry {

    @ApiModelProperty(value = "id",name = "")
    private Long id;

    @ApiModelProperty(value = "personId",name = "")
    private Long personId;

    @ApiModelProperty(value = "poetryType",name = "")
    private String poetryType;

    @ApiModelProperty(value = "nameOfCiPa",name = "")
    private String nameOfCiPa;

    @ApiModelProperty(value = "poetryTitle",name = "")
    private String poetryTitle;

    @ApiModelProperty(value = "poetryAuthor",name = "")
    private String poetryAuthor;

    @ApiModelProperty(value = "descBoj",name = "")
    private String descBoj;

    @ApiModelProperty(value = "poetryContent",name = "")
    private String poetryContent;

    @ApiModelProperty(value = "remark",name = "")
    private String remark;
}
