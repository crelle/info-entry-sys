package baseline.app.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author crelle
 * @since 2022-11-24 10:45:04
 */
@TableName("t_employee")
@ApiModel(value = "Employee对象", description = "")
public class Employee {

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
    @TableField("native_address")
    private String nativeAddress;

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
    @TableId(value = "job_no", type = IdType.ASSIGN_UUID)
    private String jobNo;

    @ApiModelProperty("入职时间")
    @TableField("time")
    private Date time;

    @ApiModelProperty("项目ID")
    @TableField("project_id")
    private String projectId;

    @TableField("post_id")
    private String postId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNativeAddress() {
        return nativeAddress;
    }

    public void setNativeAddress(String nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getEmergencyTelephone() {
        return emergencyTelephone;
    }

    public void setEmergencyTelephone(String emergencyTelephone) {
        this.emergencyTelephone = emergencyTelephone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(Date schoolTime) {
        this.schoolTime = schoolTime;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", cellPhone='" + cellPhone + '\'' +
                ", email='" + email + '\'' +
                ", nativeAddress='" + nativeAddress + '\'' +
                ", residence='" + residence + '\'' +
                ", emergency='" + emergency + '\'' +
                ", emergencyTelephone='" + emergencyTelephone + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", schoolTime=" + schoolTime +
                ", workingHours=" + workingHours +
                ", marriage='" + marriage + '\'' +
                ", child='" + child + '\'' +
                ", certificate='" + certificate + '\'' +
                ", hobby='" + hobby + '\'' +
                ", skill='" + skill + '\'' +
                ", jobNo='" + jobNo + '\'' +
                ", time=" + time +
                ", projectId='" + projectId + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}
