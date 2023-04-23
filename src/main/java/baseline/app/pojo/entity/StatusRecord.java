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

/**
 * <p>
 * 状态记录表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_status_record")
@ApiModel(value = "StatusRecord对象", description = "状态记录表")
public class StatusRecord extends BaseDo {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("工号")
    @TableField("job_no")
    private String jobNo;

    @ApiModelProperty("员工状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("操作人工号")
    @TableField("recorder_no")
    private String recorderNo;

    @ApiModelProperty("操作人姓名")
    @TableField("recorder_name")
    private String recorderName;

    @ApiModelProperty("出差地域")
    @TableField("area")
    private String area;

    @ApiModelProperty("出差时间")
    @TableField("time")
    private Date time;

    @ApiModelProperty("出差周期")
    @TableField("cycle")
    private String cycle;

}
