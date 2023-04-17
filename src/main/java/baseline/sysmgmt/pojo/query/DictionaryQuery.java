package baseline.sysmgmt.pojo.query;

import baseline.sysmgmt.pojo.entity.Dictionary;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DictionaryQuery extends Dictionary {

    @ApiModelProperty("子级名称")
    private String childrenName;

    private List<Dictionary> children;
}
