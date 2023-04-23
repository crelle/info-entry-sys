package baseline.app.pojo.query;

import baseline.app.pojo.entity.Employee;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("员工服务请求体")
public class EmployeeQuery extends Employee {
    @ApiModelProperty("部门Id")
    private String departmentId;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("区域Id")
    private String regionId;

    @ApiModelProperty("区域名称")
    private String regionName;

    @ApiModelProperty("接口人Id")
    private String interfaceId;

    @ApiModelProperty("接口人名称")
    private String interfaceName;

    @ApiModelProperty("客户Id")
    private String customerId;

    @ApiModelProperty("客户名称")
    private String customerName;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("员工状态")
    private String status;

    @ApiModelProperty("岗位")
    private String postName;

    @ApiModelProperty("状态时间")
    private String statusTime;


}
