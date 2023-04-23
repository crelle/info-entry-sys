package baseline.app.pojo.vo;

import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
@TableName("t_project")
@ApiModel(value = "Project对象", description = "项目表")
public class ProjectVo extends BaseDo {

    @ApiModelProperty("项目编号")
    private String id;

    @ApiModelProperty("项目名称")
    private String name;

    @ApiModelProperty("接口人ID")
    @TableField("Interface_id")
    private String interfaceId;

    @ApiModelProperty("接口人")
    @TableField("Interface_name")
    private String InterfaceName;

    @ApiModelProperty("手机号")
    @TableField("cell_phone")
    private String cellPhone;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("项目状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("客户")
    @TableField("customer_id")
    private String customer_id;

    @ApiModelProperty("客户")
    @TableField("customer_name")
    private String customerName;


    @ApiModelProperty("部门")
    @TableField("department_id")
    private String departmentId;

    @ApiModelProperty("部门")
    @TableField("department")
    private String department;

    @ApiModelProperty("区域")
    @TableField("region_id")
    private String regionId;

    @ApiModelProperty("区域")
    @TableField("region_name")
    private String regionName;


}
