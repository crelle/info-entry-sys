package baseline.sysmgmt.pojo.vo;

import baseline.sysmgmt.pojo.entity.Menu;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "MenuVo",description = "菜单表页面模型")
public class MenuVo extends Menu {
}
