package baseline.app.service.impl;

import baseline.app.mapper.AssetMapper;
import baseline.app.pojo.entity.Asset;
import baseline.app.pojo.query.AssetQuery;
import baseline.app.pojo.vo.AssetVo;
import baseline.app.service.AssetService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 资产表 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2023-02-28 05:09:23
 */
@Service
public class AssetServiceImpl extends ServiceImpl<AssetMapper, Asset> implements AssetService {

    @Override
    public boolean create(Asset object) {
        return save(object);
    }

    @Override
    public boolean create(List<Asset> objects) {
        return saveBatch(objects);
    }

    @Override
    public void deleteById(String id) {
        deleteById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {

    }

    @Override
    public boolean update(Asset object) {
        return false;
    }

    @Override
    public Page<Asset> pageByCondition(Page<Asset> page) {
        Asset asset = page.getRecords().get(0);
        LambdaQueryWrapper<Asset> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Asset::getUpdateTime);
        return page(page, queryWrapper);
    }

    @Override
    public Page<AssetVo> manualPage(Page<AssetQuery> pageBean) {
        return null;
    }

    @Override
    public Asset queryById(String id) {
        return queryById(id);
    }

    @Override
    public List<Asset> queryByIds(List<String> ids) {
        return null;
    }


    @Override
    public List<Asset> queryByEmployeeId(String employeeId) {
        return list()
                .stream()
                .filter(asset -> employeeId.equals(asset.getEmployeeId()))
                .sorted(Comparator.comparing(Asset::getUpdateTime))
                .collect(Collectors.toList());
    }
}
