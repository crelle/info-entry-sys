package baseline.app.service.impl;

import baseline.app.mapper.ContactPersonMapper;
import baseline.app.mapper.ContactPersonProjectMapper;
import baseline.app.pojo.entity.ContactPerson;
import baseline.app.pojo.entity.ContactPersonProject;
import baseline.app.pojo.entity.Project;
import baseline.app.pojo.query.ContactPersonQuery;
import baseline.app.pojo.vo.ContactPersonVo;
import baseline.app.service.ContactPersonProjectService;
import baseline.app.service.ContactPersonService;
import baseline.app.service.ProjectService;
import baseline.common.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-11-24 10:45:04
 */
@Service
public class ContactPersonServiceImpl extends ServiceImpl<ContactPersonMapper, ContactPerson> implements ContactPersonService {
    @Autowired
    private ContactPersonMapper contactPersonMapper;

    @Autowired
    private ContactPersonProjectMapper contactPersonProjectMapper;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ContactPersonProjectService contactPersonProjectService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean create(ContactPerson object) {
        save(object);
        List<Project> projects = object.getProjects();
        List<ContactPersonProject> contactPersonProjects = new ArrayList<>(projects.size());
        if (CollectionUtils.isNotEmpty(projects)) {
            projects.forEach(project -> {
                ContactPersonProject contactPersonProject = new ContactPersonProject();
                contactPersonProject.setProjectId(project.getId());
                contactPersonProject.setContactPersonId(object.getId());
                contactPersonProjects.add(contactPersonProject);
            });
        }
        contactPersonProjectService.saveBatch(contactPersonProjects);
        return true;
    }

    @Override
    public boolean create(List<ContactPerson> objects) {
        return saveBatch(objects);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(String id) {
        List<ContactPersonProject> contactPersonProjectList = contactPersonProjectMapper.selectByProjectIdAndContactPersonId(null, id);
        ;
        if (CollectionUtils.isNotEmpty(contactPersonProjectList)) {
            List<String> projectIds = contactPersonProjectList.stream().map(ContactPersonProject::getProjectId).collect(Collectors.toList());
            List<Project> projects = projectService.queryByIds(projectIds);
            StringBuffer sb = new StringBuffer();
            if (CollectionUtils.isNotEmpty(projects)) {
                projects.forEach(project -> sb.append(project.getName()).append(","));
            }
            throw new BusinessException("此接口人负责了" + sb.toString() + "项目,无法删除!");
        }
        //删除接口人
        removeById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        removeByIds(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(ContactPerson object) {
        contactPersonProjectMapper.deleteByProjectIdAndContactPersonId(null, object.getId());
        List<ContactPersonProject> contactPersonProjects = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(object.getProjects())) {
            object.getProjects().forEach(project -> {
                ContactPersonProject contactPersonProject = new ContactPersonProject();
                contactPersonProject.setProjectId(project.getId());
                contactPersonProject.setContactPersonId(object.getId());
                contactPersonProjects.add(contactPersonProject);
            });
        }
        contactPersonProjectService.saveBatch(contactPersonProjects);
        return updateById(object);
    }

    @Override
    public Page<ContactPerson> pageByCondition(Page<ContactPerson> page) {
        ContactPerson contactPerson = page.getRecords().get(0);
        LambdaQueryWrapper<ContactPerson> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper
                .like(StringUtils.isNotBlank(contactPerson.getCustomerId()), ContactPerson::getCustomerId, contactPerson.getCustomerId())
                .like(StringUtils.isNotBlank(contactPerson.getName()), ContactPerson::getName, contactPerson.getName());
        return page(page, lambdaQueryWrapper);
    }

    @Override
    public Page<ContactPersonVo> manualPage(Page<ContactPersonQuery> pageBean) {
        ContactPersonQuery contactPersonQuery = pageBean.getRecords().get(0);
        List<ContactPersonVo> contactPersonVoList = contactPersonMapper.manualPage(contactPersonQuery);
        PageInfo<ContactPersonVo> personVoPageInfo = new PageInfo<>(contactPersonVoList);
        Page<ContactPersonVo> result = new Page<>();
        result.setTotal(personVoPageInfo.getTotal());
        result.setRecords(contactPersonVoList);
        result.setCurrent(personVoPageInfo.getPageNum());
        return result;
    }

    @Override
    public ContactPerson queryById(String id) {
        return getById(id);
    }

    @Override
    public List<ContactPerson> queryByIds(List<String> ids) {
        return null;
    }
}
