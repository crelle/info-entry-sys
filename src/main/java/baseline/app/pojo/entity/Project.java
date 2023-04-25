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
public class Project extends BaseDo {

    @ApiModelProperty("项目编号")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {DELETE.class,PUT.class})
    private String id;

    @ApiModelProperty(value = "项目名称",required = true)
    @TableField("name")
    @NotBlank(groups = POST.class)
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

}
