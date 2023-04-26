package baseline.app.pojo.query;

import baseline.app.pojo.entity.Department;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "DepartmentQuery",description = "部门查询体")
public class DepartmentQuery extends Department {
}
