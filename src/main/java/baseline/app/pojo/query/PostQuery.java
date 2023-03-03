package baseline.app.pojo.query;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class PostQuery {
    @TableField("post_id")
    private String postId;

    @TableField("post_name")
    private String postName;

    @TableField("skill")
    private String skill;

    @TableField("project_id")
    private String projectId;

    @TableField("project")
    private String project;

    @TableField("address")
    private String address;

    @TableField("customer_name")
    private String customerName;

    @TableField("number")
    private String number;

    @TableField("date")
    private String date;

    @TableField("position")
    private String position;

    @TableField("requirements")
    private String requirements;

    @TableField("update_time")
    private String updateTime;

    private String needPeopleNum;
}
