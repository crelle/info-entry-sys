package baseline.app.pojo.entity;

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
public class ContactPerson {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("接口人姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("联系电话")
    @TableField("cell_phone")
    private String cellPhone;

    @ApiModelProperty("邮箱地址")
    @TableField("email")
    private String email;

    @ApiModelProperty("办公地址")
    @TableField("address")
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

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("创建人")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("修改人")
    @TableField("update_by")
    private String updateBy;

    @ApiModelProperty("账号是否可用，1可以，0不可用，默认1")
    @TableField("enabled")
    private Boolean enabled;


}
