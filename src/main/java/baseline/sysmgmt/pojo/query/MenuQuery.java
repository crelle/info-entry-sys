package baseline.sysmgmt.pojo.query;

import baseline.sysmgmt.pojo.entity.Menu;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "MenuQuery",description = "菜单表查询体")
public class MenuQuery extends Menu {
}
