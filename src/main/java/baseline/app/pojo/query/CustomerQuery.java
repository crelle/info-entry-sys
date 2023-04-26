package baseline.app.pojo.query;

import baseline.app.pojo.entity.Customer;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "CustomerQuery",description = "客户查询体")
public class CustomerQuery extends Customer {
    private String regionName;
}
