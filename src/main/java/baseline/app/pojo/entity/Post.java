package baseline.app.pojo.entity;

import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 岗位表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_post")
@ApiModel(value = "Post对象", description = "岗位表")
public class Post extends BaseDo {

    @ApiModelProperty("岗位id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {DELETE.class,PUT.class})
    private String id;

    @ApiModelProperty(value = "岗位名称",required = true)
    @TableField("name")
    @NotBlank(groups = POST.class)
    private String name;

    @ApiModelProperty(value = "岗位职责",required = true)
    @TableField("position")
    @NotBlank(groups = POST.class)
    private String position;

    @ApiModelProperty(value = "岗位要求",required = true)
    @TableField("requirements")
    @NotBlank(groups = POST.class)
    private String requirements;

    @ApiModelProperty(value = "技能",required = true)
    @TableField("skill")
    @NotBlank(groups = POST.class)
    private String skill;

    @ApiModelProperty("项目ID")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty("客户")
    @TableField("customer_id")
    private String customerId;

    @ApiModelProperty(value = "岗位需求人数",required = true)
    @TableField("number")
    @NotBlank(groups = POST.class)
    private String number;

    @ApiModelProperty(value = "计划满足日期",required = true)
    @TableField("date")
    @FutureOrPresent(groups = POST.class)
    private Date date;

    @ApiModelProperty(value = "办公地点",required = true)
    @TableField("address")
    @NotBlank(groups = POST.class)
    private String address;

    @ApiModelProperty(value = "到岗最晚时间",required = true)
    @TableField("latest_arrival_time")
    @FutureOrPresent(groups = POST.class)
    private Date latestArrivalTime;

}
