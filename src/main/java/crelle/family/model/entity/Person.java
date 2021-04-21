package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author:crelle
 * @className:Person
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
@ApiModel(value = "Person",description = "人物实体")
@Data
public class Person {

    @ApiModelProperty(value = "id",name = "")
    private Long id;

    @ApiModelProperty(value = "yearsId",name = "")
    private String yearsId;

    @ApiModelProperty(value = "personName",name = "")
    private String personName;

    @ApiModelProperty(value = "startDate",name = "")
    private Date startDate;

    @ApiModelProperty(value = "endDate",name = "")
    private Date endDate;

    @ApiModelProperty(value = "personPhone",name = "")
    private String personPhone;

    @ApiModelProperty(value = "personIdentity",name = "")
    private String personIdentity;

    @ApiModelProperty(value = "personEmail",name = "")
    private String personEmail;

    @ApiModelProperty(value = "birthPlace",name = "")
    private String birthPlace;
}
