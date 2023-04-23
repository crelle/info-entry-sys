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
 * 客户表
 * </p>
 *
 * @author crelle
 * @since 2022-12-06 05:57:05
 */
@Getter
@Setter
@TableName("t_customer")
@ApiModel(value = "Customer对象", description = "客户表")
public class CustomerVo {

    @ApiModelProperty("客户编号")
    private String id;

    @ApiModelProperty("地域编号")
    private String regionId;

    @ApiModelProperty("客户名称")
    @TableField("customer_name")
    private String customerName;


    @ApiModelProperty("地域")
    @TableField("region_name")
    private String regionName;

    @ApiModelProperty("办公地点")
    @TableField("address")
    private String address;

    @ApiModelProperty("负责人ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("联系电话")
    @TableField("cell_phone")
    private String cellPhone;

    @ApiModelProperty("电子邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("客户介绍")
    @TableField("introduce")
    private String introduce;


    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private Date updateTime;


}
