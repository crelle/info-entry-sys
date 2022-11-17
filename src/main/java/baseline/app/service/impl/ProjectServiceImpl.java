package baseline.app.service.impl;

import baseline.app.pojo.entity.Project;
import baseline.app.mapper.ProjectMapper;
import baseline.app.pojo.entity.Region;
import baseline.app.service.ProjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Override
    public boolean create(Project object) {
        return save(object);
    }

    @Override
    public boolean create(List<Project> objects) {
        return saveBatch(objects);
    }

    @Override
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        removeByIds(ids);
    }

    @Override
    public boolean update(Project object) {
        return updateById(object);
    }

    @Override
    public Page<Project> pageByCondition(Page<Project> page) {
        Project project = page.getRecords().get(0);
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>(project);
        if (StringUtils.isNotBlank(project.getProject())) {
            queryWrapper.select().like("project", project.getProject());
            return page(page, queryWrapper);
        } else {
            return page(page);
        }
    }

    @Override
    public Project queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Project> queryByIds(List<String> ids) {
        return null;
    }
}
