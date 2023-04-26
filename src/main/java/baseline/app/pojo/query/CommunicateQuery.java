package baseline.app.pojo.query;

import baseline.app.pojo.entity.Communicate;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "CommunicateQuery",description = "沟通记录查询体")
@Data
public class CommunicateQuery extends Communicate {
}
