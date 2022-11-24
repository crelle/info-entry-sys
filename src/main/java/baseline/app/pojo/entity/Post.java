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
@TableName("t_post")
@ApiModel(value = "Post对象", description = "")
public class Post {

    @ApiModelProperty("岗位编号")
    @TableId(value = "post_id", type = IdType.ASSIGN_UUID)
    private String postId;

    @ApiModelProperty("岗位名称")
    @TableField("post_name")
    private String postName;

    @ApiModelProperty("岗位职责")
    @TableField("position")
    private String position;

    @ApiModelProperty("岗位要求")
    @TableField("requirements")
    private String requirements;

    @ApiModelProperty("技能")
    @TableField("skill")
    private String skill;

    @ApiModelProperty("项目ID")
    @TableField("project_id")
    private String projectId;

    @ApiModelProperty("客户")
    @TableField("customer")
    private String customer;

    @ApiModelProperty("岗位需求人数")
    @TableField("number")
    private String number;

    @ApiModelProperty("计划满足日期")
    @TableField("date")
    private Date date;

    @ApiModelProperty("办公地点")
    @TableField("address")
    private String address;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Post{" +
            "postId=" + postId +
            ", postName=" + postName +
            ", position=" + position +
            ", requirements=" + requirements +
            ", skill=" + skill +
            ", projectId=" + projectId +
            ", customer=" + customer +
            ", number=" + number +
            ", date=" + date +
            ", address=" + address +
        "}";
    }
}
