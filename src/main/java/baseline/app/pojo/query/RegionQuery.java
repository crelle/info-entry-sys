package baseline.app.pojo.query;

import baseline.app.pojo.entity.Region;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "RegionQuery",description = "区域查询体")
public class RegionQuery extends Region {
}
