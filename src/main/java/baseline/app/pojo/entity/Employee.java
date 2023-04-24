package baseline.app.pojo.entity;

import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_employee")
@ApiModel(value = "Employee对象", description = "员工表")
public class Employee extends BaseDo {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {DELETE.class,PUT.class})
    private String id;

    @ApiModelProperty("员工姓名")
    @TableField("name")
    @NotBlank(groups = POST.class)
    private String name;

    @ApiModelProperty("性别")
    @TableField("gender")
    @NotBlank(groups = POST.class)
    private String gender;

    @ApiModelProperty("年龄")
    @TableField("age")
    @NotBlank(groups = POST.class)
    private Integer age;

    @ApiModelProperty("出生年月")
    @TableField("birthday")
    @Past(groups = POST.class)
    private Date birthday;

    @ApiModelProperty("联系电话")
    @TableField("cell_phone")
    @NotBlank(groups = POST.class)
    private String cellPhone;

    @ApiModelProperty("电子邮箱")
    @TableField("email")
    @NotBlank(groups = POST.class)
    private String email;

    @ApiModelProperty("户籍地")
    @TableField("registered_residence")
    private String registeredResidence;

    @ApiModelProperty("现居住地")
    @TableField("residence")
    @NotBlank(groups = POST.class)
    private String residence;

    @ApiModelProperty("紧急联系人")
    @TableField("emergency")
    @NotBlank(groups = POST.class)
    private String emergency;

    @ApiModelProperty("紧急联系人电话")
    @TableField("emergency_telephone")
    private String emergencyTelephone;

    @ApiModelProperty("最高学历")
    @TableField("education")
    private String education;

    @ApiModelProperty("毕业院校")
    @TableField("school")
    private String school;

    @ApiModelProperty("毕业时间")
    @TableField("school_time")
    @Past(groups = POST.class)
    @Future(groups = POST.class)
    private Date schoolTime;

    @ApiModelProperty("工作年限")
    @TableField("working_hours")
    @NotBlank(groups = POST.class)
    private Integer workingHours;

    @ApiModelProperty("婚姻状况")
    @TableField("marriage")
    @NotBlank(groups = POST.class)
    private String marriage;

    @ApiModelProperty("有无小孩")
    @TableField("child")
    private String child;

    @ApiModelProperty("证书")
    @TableField("certificate")
    private String certificate;

    @ApiModelProperty("兴趣爱好")
    @TableField("hobby")
    private String hobby;

    @ApiModelProperty("工作技能")
    @TableField("skill")
    private String skill;

    @ApiModelProperty("工号")
    @TableField("job_no")
    @NotBlank(groups = POST.class)
    private String jobNo;

    @ApiModelProperty("入职时间")
    @TableField("time")
    @Past(groups = POST.class)
    @Future(groups = POST.class)
    private Date time;

    @ApiModelProperty("项目ID")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty("岗位id")
    @TableField("post_id")
    private String postId;

    @ApiModelProperty("户籍地址")
    @TableField("native_address")
    private String nativeAddress;


}
