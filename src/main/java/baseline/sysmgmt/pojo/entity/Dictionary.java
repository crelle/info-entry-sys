package baseline.sysmgmt.pojo.entity;

import baseline.common.pojo.validation.Validation;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.List;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author crelle
 * @since 2022-12-23 05:23:32
 */
@Getter
@Setter
@TableName("t_dictionary")
public class Dictionary extends Validation {
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {DELETE.class, PUT.class})
    private String id;

    @NotBlank(groups = {POST.class, PUT.class})
    @Length(min = 1, max = 32, groups = {POST.class, PUT.class})
    @ApiModelProperty("父级名称")
    @TableField("name")
    private String name;

    @NotBlank(groups = {POST.class, PUT.class})
    @Length(min = 1, max = 32, groups = {POST.class, PUT.class})
    @ApiModelProperty("编码")
    @TableField("code")
    private String code;

    @ApiModelProperty("上级id")
    @TableField("parent_id")
    private String parentId;

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

    @ApiModelProperty("子集字典")
    @TableField(exist = false)
    @Valid
    private List<Dictionary> children;


}
