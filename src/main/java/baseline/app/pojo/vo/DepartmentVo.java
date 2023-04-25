package baseline.app.pojo.vo;

import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author crelle
 * @since 2022-12-06 05:57:05
 */
@Getter
@Setter
@TableName("t_department")
@ApiModel(value = "Department对象", description = "部门表")
public class DepartmentVo extends BaseDo {

    @ApiModelProperty("部门编号")
    private String id;

    @ApiModelProperty("部门名称")
    private String name;

    @ApiModelProperty("负责人Id")
    private String userId;

    @ApiModelProperty("负责人工号")
    private String jobNo;

    @ApiModelProperty("负责人电话")
    private String cellPhone;

    @ApiModelProperty("负责人邮箱")
    private String email;

    @ApiModelProperty("部门地址")
    private String address;

    @ApiModelProperty("部门介绍")
    private String introduce;

    @ApiModelProperty("上级部门Id")
    private String parentId;

    @ApiModelProperty("上级部门名称")
    private String parentName;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("账号是否可用，1可以，0不可用，默认1")
    private Boolean enabled;


}
