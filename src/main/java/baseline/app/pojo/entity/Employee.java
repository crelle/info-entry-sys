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
public class Employee {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("员工姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty("出生年月")
    @TableField("birthday")
    private Date birthday;

    @ApiModelProperty("联系电话")
    @TableField("cell_phone")
    private String cellPhone;

    @ApiModelProperty("电子邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("户籍地")
    @TableField("registered_residence")
    private String registeredResidence;

    @ApiModelProperty("现居住地")
    @TableField("residence")
    private String residence;

    @ApiModelProperty("紧急联系人")
    @TableField("emergency")
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
    private Date schoolTime;

    @ApiModelProperty("工作年限")
    @TableField("working_hours")
    private Integer workingHours;

    @ApiModelProperty("婚姻状况")
    @TableField("marriage")
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
    private String jobNo;

    @ApiModelProperty("入职时间")
    @TableField("time")
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
