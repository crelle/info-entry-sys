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
 * @since 2022-11-09 10:06:28
 */
@TableName("t_project")
@ApiModel(value = "Project对象", description = "")
public class Project {

    @ApiModelProperty("项目编号")
    @TableId(value = "project_id", type = IdType.ASSIGN_UUID)
    private String projectId;

    @ApiModelProperty("项目名称")
    @TableField("project")
    private String project;

    @ApiModelProperty("立项时间")
    @TableField("time")
    private Date time;

    @ApiModelProperty("项目状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("接口人ID")
    @TableField("Interface_id")
    private String interfaceId;

    @ApiModelProperty("部门")
    @TableField("department_id")
    private String departmentId;

    @ApiModelProperty("合作模式")
    @TableField("cooperation")
    private String cooperation;

    @ApiModelProperty("项目简介")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty("地域ID")
    @TableField("region_id")
    private String regionId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "Project{" +
            "projectId=" + projectId +
            ", project=" + project +
            ", time=" + time +
            ", status=" + status +
            ", interfaceId=" + interfaceId +
            ", departmentId=" + departmentId +
            ", cooperation=" + cooperation +
            ", introduce=" + introduce +
            ", regionId=" + regionId +
        "}";
    }
}
