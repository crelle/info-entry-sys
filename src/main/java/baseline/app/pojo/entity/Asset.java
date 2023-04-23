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
public class Asset {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("部门id")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty("员工id")
    @TableField("employee_id")
    private String employeeId;

    @ApiModelProperty("资产编号")
    @TableField("asset_no")
    private String assetNo;

    @ApiModelProperty("资产序列号")
    @TableField("asset_serial_number")
    private String assetSerialNumber;

    @ApiModelProperty("资产名称")
    @TableField("asset_name")
    private String assetName;

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
