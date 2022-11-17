package baseline.app.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@TableName("t_department")
@ApiModel(value = "Department对象", description = "")
public class Department {

    @ApiModelProperty("部门编号")
    @TableId(value = "department_id", type = IdType.ASSIGN_UUID)
    private String departmentId;

    @ApiModelProperty("部门名称")
    @TableField("department")
    private String department;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("工号")
    @TableField("job_no")
    private String jobNo;

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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
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
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Department{" +
            "departmentId=" + departmentId +
            ", department=" + department +
            ", userId=" + userId +
            ", jobNo=" + jobNo +
            ", cellPhone=" + cellPhone +
            ", email=" + email +
            ", address=" + address +
            ", introduce=" + introduce +
        "}";
    }
}
