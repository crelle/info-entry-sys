package baseline.app.pojo.query;

import baseline.app.pojo.entity.Employee;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmployeeQuery extends Employee {
    @TableField("department_id")
    private  String departmentId;

    @TableField("department")
    private  String department;

    @TableField("region_id")
    private  String regionId;

    @TableField("region_name")
    private  String regionName;

    @TableField("Interface_id")
    private  String InterfaceId;


    @TableField("Interface_name")
    private  String InterfaceName;

    @TableField("customer_id")
    private  String customerId;

    @TableField("customer_name")
    private  String customerName;

    @TableField("project")
    private  String project;

    @ApiModelProperty("员工状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("岗位")
    @TableField("post_name")
    private String postName;


}
