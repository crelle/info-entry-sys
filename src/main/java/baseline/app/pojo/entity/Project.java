package baseline.app.pojo.entity;

import baseline.common.pojo.BaseDo;
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
public class Project extends BaseDo {

    @ApiModelProperty("项目编号")
    @TableId(value = "project_id", type = IdType.ASSIGN_UUID)
    private String projectId;

    @ApiModelProperty("地域编号")
    @TableField("t_r_region_id")
    private String tRRegionId;

    @ApiModelProperty("部门编号")
    @TableField("t_d_department_id")
    private String tDDepartmentId;

    @ApiModelProperty("接口人编号")
    @TableField("t_c_Interface_id")
    private String tCInterfaceId;

    @ApiModelProperty("项目名称")
    @TableField("project")
    private String project;

    @ApiModelProperty("立项时间")
    @TableField("time")
    private Date time;

    @ApiModelProperty("项目状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("接口人ID")
    @TableField("Interface_id")
    private String interfaceId;

    @ApiModelProperty("部门")
    @TableField("department_id")
    private String departmentId;

    @ApiModelProperty("合作模式")
    @TableField("cooperation")
    private String cooperation;

    @ApiModelProperty("项目简介")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty("地域ID")
    @TableField("region_id")
    private String regionId;

}
