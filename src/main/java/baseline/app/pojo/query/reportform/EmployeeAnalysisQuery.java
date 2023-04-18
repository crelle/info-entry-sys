package baseline.app.pojo.query.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "员工分析请求体")
@Data
public class EmployeeAnalysisQuery {

    @ApiModelProperty("员工姓名")
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("出生年月")
    private Date birthday;


    @ApiModelProperty("毕业时间")
    private Date schoolTime;

    @ApiModelProperty("工作年限")
    private Integer workingHours;

    @ApiModelProperty("婚姻状况")
    private String marriage;

    @ApiModelProperty("有无小孩")
    private String child;

    @ApiModelProperty("入职时间")
    private Date time;

    @ApiModelProperty("经度")
    private String longitude;

    @ApiModelProperty("纬度")
    private String latitude;
}
