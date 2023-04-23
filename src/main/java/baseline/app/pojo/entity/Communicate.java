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
 * 员工沟通记录表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_communicate")
@ApiModel(value = "Communicate对象", description = "员工沟通记录表")
public class Communicate extends BaseDo {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("工号")
    @TableField("job_no")
    private String jobNo;

    @ApiModelProperty("时间")
    @TableField("time")
    private Date time;

    @ApiModelProperty("操作人工号")
    @TableField("recorder_no")
    private String recorderNo;

    @ApiModelProperty("操作人姓名")
    @TableField("recorder_name")
    private String recorderName;

    @ApiModelProperty("沟通信息")
    @TableField("text")
    private String text;
}
