package baseline.app.service.impl;

import baseline.app.mapper.RegionMapper;
import baseline.app.pojo.entity.Region;
import baseline.app.pojo.query.RegionQuery;
import baseline.app.pojo.vo.RegionVo;
import baseline.app.service.RegionService;
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
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
    @Override
    public boolean create(Region object) {
        return save(object);
    }

    @Override
    public boolean create(List<Region> objects) {
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
    public boolean update(Region object) {
        return updateById(object);
    }

    @Override
    public Page<Region> pageByCondition(Page<Region> page) {
        Region region = page.getRecords().get(0);
        QueryWrapper<Region> queryWrapper = new QueryWrapper<>(region);
        if (StringUtils.isNotBlank(region.getName())) {
            queryWrapper.select().like("name", region.getName());
            return page(page, queryWrapper);
        } else {
            return page(page);
        }

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
