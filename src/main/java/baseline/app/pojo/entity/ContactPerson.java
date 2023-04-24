package baseline.app.pojo.entity;

import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 接口人表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_contact_person")
@ApiModel(value = "ContactPerson对象", description = "接口人表")
public class ContactPerson extends BaseDo {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {PUT.class, DELETE.class})
    private String id;

    @ApiModelProperty("接口人姓名")
    @TableField("name")
    @NotBlank(groups = {POST.class})
    private String name;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("联系电话")
    @TableField("cell_phone")
    @NotBlank(groups = {POST.class})
    private String cellPhone;

    @ApiModelProperty("邮箱地址")
    @TableField("email")
    private String email;

    @ApiModelProperty("办公地址")
    @TableField("address")
    @NotBlank(groups = {POST.class})
    private String address;

    @ApiModelProperty("详细地址")
    @TableField("address_detail")
    private String addressDetail;

    @ApiModelProperty("介绍")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty("客户ID")
    @TableField("customer_id")
    private String customerId;

    @ApiModelProperty("项目Id")
    @TableField("project_id")
    private String projectId;

}
