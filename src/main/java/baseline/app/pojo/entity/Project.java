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
 * 项目表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_project")
@ApiModel(value = "Project对象", description = "项目表")
public class Project {

    @ApiModelProperty("项目编号")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("项目名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("立项时间")
    @TableField("time")
    private Date time;

    @ApiModelProperty("项目状态")
    @TableField("status")
    private String status;

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
