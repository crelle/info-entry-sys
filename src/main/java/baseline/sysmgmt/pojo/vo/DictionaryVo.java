package baseline.sysmgmt.pojo.vo;

import baseline.sysmgmt.pojo.query.DictionaryQuery;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "DictionaryVo",description = "字典表页面模型")
public class DictionaryVo extends DictionaryQuery {
}
