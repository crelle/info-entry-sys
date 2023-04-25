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
public class Department extends BaseDo {

    @ApiModelProperty("部门id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {DELETE.class,PUT.class})
    private String id;

    @ApiModelProperty(value = "部门名称",required = true)
    @TableField("name")
    @NotBlank(groups = POST.class)
    private String name;

    @ApiModelProperty("负责人id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "部门地址",required = true)
    @TableField("address")
    @NotBlank(groups = POST.class)
    private String address;

    @ApiModelProperty("部门介绍")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty("上级部门")
    @TableField("parent_id")
    private String parentId;

}
