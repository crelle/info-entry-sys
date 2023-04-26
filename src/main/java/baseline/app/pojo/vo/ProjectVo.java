package baseline.app.pojo.vo;

import baseline.app.pojo.entity.Project;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * <p>
 * 项目表
 * </p>
 *
 * @author crelle
 * @since 2022-12-06 05:57:05
 */
@Getter
@Setter
@ApiModel(value = "ProjectVo", description = "项目表页面模型")
public class ProjectVo extends Project {

    @ApiModelProperty("接口人ID")
    private String interfaceId;

    @ApiModelProperty("接口人姓名")
    private String InterfaceName;

    @ApiModelProperty("接口人手机号")
    private String cellPhone;

    @ApiModelProperty("接口人邮箱")
    private String email;

    @ApiModelProperty("客户")
    private String customerId;

    @ApiModelProperty("客户")
    private String customerName;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("区域")
    private String regionName;


}
