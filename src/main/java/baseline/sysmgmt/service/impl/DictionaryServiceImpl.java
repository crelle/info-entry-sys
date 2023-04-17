package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.pojo.entity.Dictionary;
import baseline.sysmgmt.mapper.DictionaryMapper;
import baseline.sysmgmt.pojo.query.DictionaryQuery;
import baseline.sysmgmt.pojo.vo.DictionaryVo;
import baseline.sysmgmt.service.DictionaryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-12-23 05:23:32
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public boolean create(Dictionary object) {
        return save(object);
    }

    @Override
    public Dictionary queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Dictionary> queryAll() {
        return list();
    }

    @Override
    public boolean update(Dictionary object) {
        return updateById(object);
    }

    @Override
    public boolean deleteById(String id) {
        return removeById(id);
    }

    @Override
    public Page<Dictionary> page(Page<Dictionary> page) {
        return null;
    }

    @Override
    public Page<DictionaryVo> manualPage(Page<DictionaryQuery> pageBean) {
        DictionaryQuery dictionaryQuery = pageBean.getRecords().get(0);
        Page<Dictionary> page = new Page<>();
        return dictionaryMapper.manualPage(page, dictionaryQuery);
    }

    @Override
    public List<DictionaryVo> queryByParentId(String parentId) {
        return dictionaryMapper.queryByParentId(parentId);
    }
}
