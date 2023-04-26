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
@ApiModel(value = "CustomerVo", description = "客户表页面模型")
public class CustomerVo {

    @ApiModelProperty("客户编号")
    private String id;

    @ApiModelProperty("客户名称")
    private String name;

    @ApiModelProperty("地域编号")
    private String regionId;

    @ApiModelProperty("地域")
    private String regionName;

    @ApiModelProperty("办公地点")
    private String address;

    @ApiModelProperty("负责人ID")
    private String userId;

    @ApiModelProperty("负责人姓名")
    private String userName;

    @ApiModelProperty("联系电话")
    private String cellPhone;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("客户介绍")
    private String introduce;

    @ApiModelProperty("修改时间")
    private Date updateTime;


}
