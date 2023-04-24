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

    @ApiModelProperty("岗位名称")
    @TableField("name")
    @NotBlank(groups = POST.class)
    private String name;

    @ApiModelProperty("岗位职责")
    @TableField("position")
    @NotBlank(groups = POST.class)
    private String position;

    @ApiModelProperty("岗位要求")
    @TableField("requirements")
    @NotBlank(groups = POST.class)
    private String requirements;

    @ApiModelProperty("技能")
    @TableField("skill")
    @NotBlank(groups = POST.class)
    private String skill;

    @ApiModelProperty("项目ID")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty("客户")
    @TableField("customer_id")
    private String customerId;

    @ApiModelProperty("岗位需求人数")
    @TableField("number")
    @NotBlank(groups = POST.class)
    private String number;

    @ApiModelProperty("计划满足日期")
    @TableField("date")
    @FutureOrPresent(groups = POST.class)
    private Date date;

    @ApiModelProperty("办公地点")
    @TableField("address")
    @NotBlank(groups = POST.class)
    private String address;

    @ApiModelProperty("到岗最晚时间")
    @TableField("latest_arrival_time")
    @FutureOrPresent(groups = POST.class)
    private Date latestArrivalTime;

}
