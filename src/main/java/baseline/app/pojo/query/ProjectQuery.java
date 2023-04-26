package baseline.app.pojo.query;

import baseline.app.pojo.vo.ProjectVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "ProjectQuery",description = "项目查询体")
public class ProjectQuery extends ProjectVo {
}
