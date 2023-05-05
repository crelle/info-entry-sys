package baseline.app.service.impl;

import baseline.app.mapper.AssetMapper;
import baseline.app.mapper.DepartmentMapper;
import baseline.app.mapper.ProjectMapper;
import baseline.app.pojo.entity.Department;
import baseline.app.pojo.query.DepartmentQuery;
import baseline.app.pojo.vo.DepartmentVo;
import baseline.app.service.DepartmentService;
import baseline.common.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private AssetMapper assetMapper;

    @Override
    public boolean create(Department object) {
        return save(object);
    }

    @Override
    public boolean create(List<Department> objects) {
        return saveBatch(objects);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(String id) {
        if (CollectionUtils.isNotEmpty(departmentMapper.queryByParentId(id))) {
            throw new BusinessException("此部门下面有子部门,无法删除");
        }
        if (CollectionUtils.isNotEmpty(projectMapper.queryByDepartmentId(id))) {
            throw new BusinessException("此部门下面有项目,无法删除");
        }

        if (CollectionUtils.isNotEmpty(assetMapper.queryByDepartmentId(id))) {
            throw new BusinessException("此部门下面有资产,无法删除");
        }
        removeById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        removeByIds(ids);
    }

    @Override
    public boolean update(Department object) {
        return updateById(object);
    }

    @Override
    public Page<Department> pageByCondition(Page<Department> page) {
        Department department = page.getRecords().get(0);
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>(department);
        if (StringUtils.isNotBlank(department.getName())) {
            queryWrapper.select().like("name", department.getName());
            return page(page, queryWrapper);
        } else {
            return page(page);
        }
    }

    @Override
    public Page<DepartmentVo> manualPage(Page<DepartmentQuery> pageBean) {
        DepartmentQuery departmentQuery = pageBean.getRecords().get(0);
        Page<DepartmentVo> page = new Page<>();
        List<DepartmentVo> list = departmentMapper.manualPage(departmentQuery);
        PageInfo<DepartmentVo> pageInfo = new PageInfo<>(list);
        page.setRecords(list);
        page.setTotal(pageInfo.getTotal());
        page.setCurrent(pageInfo.getPageNum());
        return page;
    }

    @Override
    public Department queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Department> queryByIds(List<String> ids) {
        return null;
    }

    @Override
    public List<Department> queryDepartmentUp() {
        QueryWrapper<Department> queryWrapper = new QueryWrapper();
        queryWrapper.select().isNull("department_up");
        return list(queryWrapper);
    }
}
