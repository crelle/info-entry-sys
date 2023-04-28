package baseline.app.service.impl;

import baseline.app.mapper.CustomerMapper;
import baseline.app.mapper.ProjectMapper;
import baseline.app.mapper.RegionMapper;
import baseline.app.pojo.entity.Region;
import baseline.app.pojo.query.RegionQuery;
import baseline.app.pojo.vo.RegionVo;
import baseline.app.service.RegionService;
import baseline.common.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.CollationElementIterator;
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
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public boolean create(Region object) {
        return save(object);
    }

    @Override
    public boolean create(List<Region> objects) {
        return saveBatch(objects);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(String id) {
        if (CollectionUtils.isNotEmpty(projectMapper.queryByRegionId(id))) {
            throw new BusinessException("有项目在使用此区域，无法删除");
        }
        if (CollectionUtils.isNotEmpty(customerMapper.queryByRegionId(id))) {
            throw new BusinessException("有客户在使用此区域，无法删除");
        }
        removeById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        removeByIds(ids);
    }

    @Override
    public boolean update(Region object) {
        return updateById(object);
    }

    @Override
    public Page<Region> pageByCondition(Page<Region> page) {
        Region region = page.getRecords().get(0);
        LambdaQueryWrapper<Region> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(region.getName()), Region::getName, region.getName())
                .orderByDesc(Region::getUpdateTime);
        return page(page, lambdaQueryWrapper);

    }

    @Override
    public Page<RegionVo> manualPage(Page<RegionQuery> pageBean) {
        return null;
    }

    @Override
    public Region queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Region> queryByIds(List<String> ids) {
        return null;
    }
}
