package baseline.app.service;

import baseline.app.pojo.entity.Project;
import baseline.app.pojo.query.ProjectQuery;
import baseline.app.pojo.vo.ProjectVo;
import baseline.common.baseBean.BaseService;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
public interface ProjectService extends IService<Project> , BaseService<ProjectVo,Project, ProjectQuery> {

}
