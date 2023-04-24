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
 * 资产表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_asset")
@ApiModel(value = "Asset对象", description = "资产表")
public class Asset extends BaseDo {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {PUT.class, DELETE.class})
    private String id;

    @ApiModelProperty("部门id")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty("员工id")
    @TableField("employee_id")
    private String employeeId;

    @ApiModelProperty("资产编号")
    @TableField("no")
    @NotBlank(groups = {POST.class})
    private String no;

    @ApiModelProperty("资产序列号")
    @TableField("serial_number")
    @NotBlank(groups = {POST.class})
    private String serialNumber;

    @ApiModelProperty("资产名称")
    @TableField("name")
    @NotBlank(groups = {POST.class})
    private String name;

}
