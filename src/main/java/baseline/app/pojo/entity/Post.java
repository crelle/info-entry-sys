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
public class Post {

    @ApiModelProperty("岗位id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("岗位名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("岗位职责")
    @TableField("position")
    private String position;

    @ApiModelProperty("岗位要求")
    @TableField("requirements")
    private String requirements;

    @ApiModelProperty("技能")
    @TableField("skill")
    private String skill;

    @ApiModelProperty("项目ID")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty("客户")
    @TableField("customer")
    private String customer;

    @ApiModelProperty("岗位需求人数")
    @TableField("number")
    private String number;

    @ApiModelProperty("计划满足日期")
    @TableField("date")
    private Date date;

    @ApiModelProperty("办公地点")
    @TableField("address")
    private String address;

    @ApiModelProperty("到岗最晚时间")
    @TableField("latest_arrival_time")
    private Date latestArrivalTime;

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
