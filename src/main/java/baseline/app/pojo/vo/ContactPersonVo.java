package baseline.app.pojo.vo;

import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p>
 * 接口人表
 * </p>
 *
 * @author crelle
 * @since 2022-12-06 05:57:05
 */
@Getter
@Setter
@ApiModel(value = "ContactPersonVo对象", description = "接口人表")
public class ContactPersonVo  {

    @ApiModelProperty("接口人编号")
    @TableId(value = "Interface_id", type = IdType.ASSIGN_UUID)
    private String interfaceId;

    @ApiModelProperty("接口人姓名")
    @TableField("Interface_name")
    private String interfaceName;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("联系电话")
    @TableField("cell_phone")
    private String cellPhone;

    @ApiModelProperty("邮箱地址")
    @TableField("email")
    private String email;

    @ApiModelProperty("客户ID")
    @TableField("customer_id")
    private String customerId;


    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("客户名")
    @TableField("customer_name")
    private String customerName;

}
