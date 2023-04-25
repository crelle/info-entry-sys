package baseline.app.pojo.vo;

import baseline.app.pojo.entity.Employee;
import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author crelle
 * @since 2022-12-06 05:57:05
 */
@Getter
@Setter
@TableName("t_employee")
@ApiModel(value = "Employee对象", description = "员工表")
public class EmployeeVo extends Employee {

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
    private String projectId;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("员工状态")
    private String status;

    @ApiModelProperty("岗位")
    private String postName;

    @ApiModelProperty("状态时间")
    private String statusTime;

    @ApiModelProperty("经纬度")
    private List<String> value;


}
