package baseline.sysmgmt.pojo.query;

import baseline.sysmgmt.pojo.entity.User;
import lombok.Data;

@Data
public class UserQuery extends User {
    private String roleName;
}
