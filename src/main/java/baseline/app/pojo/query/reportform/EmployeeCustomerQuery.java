package baseline.app.pojo.query.reportform;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("客户分布请求体")
public class EmployeeCustomerQuery {

    @ApiModelProperty(value = "区域名称")
    private String regionName;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

}
