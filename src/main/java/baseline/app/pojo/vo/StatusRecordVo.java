package baseline.app.pojo.vo;

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
 * 记录表
 * </p>
 *
 * @author crelle
 * @since 2023-02-07 04:54:21
 */
@Getter
@Setter
@TableName("t_status_record")
@ApiModel(value = "StatusRecordVo", description = "状态记录表页面模型")
public class StatusRecordVo {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("员工工号")
    @TableField("job_no")
    private String jobNo;

    @ApiModelProperty("员工状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("操作人")
    @TableField("recorder")
    private String recorder;

    @ApiModelProperty("操作人工号")
    @TableField("recorder_no")
    private String recorderNo;

    @ApiModelProperty("地区")
    @TableField("area")
    private String area;

    @ApiModelProperty("时间")
    @TableField("time")
    private Date time;

    @ApiModelProperty("周期")
    @TableField("cycle")
    private String cycle;
}
