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
 * 沟通记录表
 * </p>
 *
 * @author crelle
 * @since 2023-02-03 02:50:00
 */
@Getter
@Setter
@TableName("t_communicate")
@ApiModel(value = "CommunicateVo", description = "沟通记录表页面模型")
public class CommunicateVo {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("状态表id")
    @TableField("job_no")
    private String jobNo;

    @ApiModelProperty("时间")
    @TableField("time")
    private Date time;

    @ApiModelProperty("操作人")
    @TableField("recorder")
    private String recorder;

    @ApiModelProperty("操作人工号")
    @TableField("recorder_no")
    private String recorderNo;

    @ApiModelProperty("沟通信息")
    @TableField("text")
    private String text;


}
