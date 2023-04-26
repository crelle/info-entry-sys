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
 * 员工沟通记录表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_communicate")
@ApiModel(value = "Communicate", description = "员工沟通记录表实体模型")
public class Communicate extends BaseDo {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {DELETE.class, PUT.class})
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

    @ApiModelProperty(value = "沟通信息", required = true)
    @TableField("text")
    @NotBlank(groups = POST.class)
    private String text;
}
