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
 * 
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_department")
@ApiModel(value = "Department对象", description = "")
public class Department {

    @ApiModelProperty("部门id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("部门名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("负责人id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("联系电话")
    @TableField("cell_phone")
    private String cellPhone;

    @ApiModelProperty("电子邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("部门地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("部门介绍")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty("上级部门")
    @TableField("department_up")
    private String departmentUp;

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
