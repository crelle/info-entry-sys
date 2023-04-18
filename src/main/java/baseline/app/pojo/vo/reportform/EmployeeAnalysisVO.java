package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "员工分析")
public class EmployeeAnalysisVO {


    @ApiModelProperty("员工姓名")
    private String id;

    @ApiModelProperty("员工姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("出生年月")
    private Date birthday;

    @ApiModelProperty("联系电话")
    private String cellPhone;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("户籍地")
    private String registeredResidence;

    @ApiModelProperty("现居住地")
    private String residence;

    @ApiModelProperty("毕业院校")
    private String school;

    @ApiModelProperty("毕业时间")
    private Date schoolTime;

    @ApiModelProperty("工作年限")
    private Integer workingHours;

    @ApiModelProperty("婚姻状况")
    private String marriage;

    @ApiModelProperty("有无小孩")
    private String child;

    @ApiModelProperty("工作技能")
    private String skill;

    @ApiModelProperty("工号")
    private String jobNo;

    @ApiModelProperty("入职时间")
    private Date time;

    @ApiModelProperty("项目ID")
    private String projectId;

    @ApiModelProperty("post_id")
    private String postId;

    @ApiModelProperty("项目编号")
    private String tPProjectId;

    @ApiModelProperty("户籍地址")
    private String nativeAddress;

    @ApiModelProperty("经度")
    private String longitude;

    @ApiModelProperty("纬度")
    private String latitude;

    @ApiModelProperty("经纬度")
    private List<String> value;
}
