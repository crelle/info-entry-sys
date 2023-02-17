package baseline.app.pojo.query;

import baseline.app.pojo.entity.ContactPerson;
import lombok.Data;

@Data
public class ContactPersonQuery extends ContactPerson {
    private String customerName;
}
