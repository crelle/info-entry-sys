package baseline.app.pojo.query;

import baseline.app.pojo.entity.Customer;
import lombok.Data;

@Data
public class CustomerQuery extends Customer {
    private String regionName;
}
