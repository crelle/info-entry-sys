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
    private String id;

    @ApiModelProperty("接口人姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("联系电话")
    private String cellPhone;

    @ApiModelProperty("邮箱地址")
    private String email;

    @ApiModelProperty("客户ID")
    private String customerId;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("客户名")
    private String customerName;

}
