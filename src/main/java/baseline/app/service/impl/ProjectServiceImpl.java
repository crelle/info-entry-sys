package baseline.app.service.impl;

import baseline.app.pojo.entity.Project;
import baseline.app.mapper.ProjectMapper;
import baseline.app.pojo.entity.Region;
import baseline.app.pojo.query.ProjectQuery;
import baseline.app.pojo.vo.ProjectVo;
import baseline.app.service.ProjectService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ProjectMapper projectMapper;

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
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNotBlank(project.getProject()), Project::getProject, project.getProject())
                .like(StringUtils.isNotBlank(project.getStatus()), Project::getStatus, project.getStatus())
                .like(StringUtils.isNotBlank(project.getRegionId()), Project::getRegionId, project.getRegionId())
                .like(StringUtils.isNotBlank(project.getInterfaceId()), Project::getInterfaceId, project.getInterfaceId())
                .like(StringUtils.isNotBlank(project.getDepartmentId()), Project::getDepartmentId, project.getDepartmentId());
        return page(page, queryWrapper);
    }

    @Override
    public Page<ProjectVo> manualPage(Page<ProjectQuery> pageBean) {
        ProjectQuery projectQuery = pageBean.getRecords().get(0);
        Page<ProjectVo> page = new Page<>();
        List<ProjectVo> list = projectMapper.manualPage(projectQuery);
        PageInfo<ProjectVo> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        page.setRecords(list);
        return page;
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
