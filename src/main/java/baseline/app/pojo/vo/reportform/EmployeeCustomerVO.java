package baseline.app.pojo.vo.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "EmployeeCustomerVO",description = "客户分析页面模型")
public class EmployeeCustomerVO {

    @ApiModelProperty("客户姓名")
    private String customerName;

    @ApiModelProperty("员工数量")
    private Integer employeeNum;

}
