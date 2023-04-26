package baseline.app.pojo.query;

import baseline.app.pojo.entity.ContactPerson;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "ContactPersonQuery",description = "接口人查询体")
public class ContactPersonQuery extends ContactPerson {
    private String customerName;
}
