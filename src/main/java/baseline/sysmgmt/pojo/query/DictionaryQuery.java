package baseline.sysmgmt.pojo.query;

import baseline.sysmgmt.pojo.entity.Dictionary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value = "DictionaryQuery", description = "字典表查询体")
public class DictionaryQuery extends Dictionary {

    @ApiModelProperty("子级名称")
    private String childrenName;

    private List<Dictionary> children;
}
