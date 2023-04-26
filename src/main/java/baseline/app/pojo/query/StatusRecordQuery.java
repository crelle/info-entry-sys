package baseline.app.pojo.query;

import baseline.app.pojo.entity.StatusRecord;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "StatusRecordQuery",description = "状态记录查询体")
public class StatusRecordQuery extends StatusRecord {
}
