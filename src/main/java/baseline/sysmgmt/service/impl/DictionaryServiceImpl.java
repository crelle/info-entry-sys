package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.pojo.entity.Dictionary;
import baseline.sysmgmt.mapper.DictionaryMapper;
import baseline.sysmgmt.pojo.query.DictionaryQuery;
import baseline.sysmgmt.service.DictionaryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
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
        LambdaQueryWrapper<Dictionary> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (!CollectionUtils.isEmpty(page.getRecords())) {
            Dictionary dictionary = page.getRecords().get(0);
            lambdaQueryWrapper.like(StringUtils.isNotBlank(dictionary.getName()), Dictionary::getName, dictionary.getName())
                    .isNotNull(Dictionary::getParentId);
        }
        return super.page(page, lambdaQueryWrapper);
    }

    @Override
    public Page<Dictionary> manualPage(Page<DictionaryQuery> pageBean) {
        return null;
    }
}
