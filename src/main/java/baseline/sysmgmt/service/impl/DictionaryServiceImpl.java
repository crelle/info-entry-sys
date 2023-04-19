package baseline.sysmgmt.service.impl;

import baseline.common.annotation.EnablePagination;
import baseline.common.exception.BusinessException;
import baseline.sysmgmt.pojo.entity.Dictionary;
import baseline.sysmgmt.mapper.DictionaryMapper;
import baseline.sysmgmt.pojo.query.DictionaryQuery;
import baseline.sysmgmt.pojo.vo.DictionaryVo;
import baseline.sysmgmt.service.DictionaryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean create(Dictionary object) {
        List<DictionaryVo> dictionaryVoList = queryByParentName(object.getName());
        if (CollectionUtils.isNotEmpty(dictionaryVoList)) {
            throw new BusinessException("父级字典名称已经存在!");
        }
        save(object);
        List<DictionaryVo> dictionaryVoList1 = queryByParentName(object.getName());
        String parentId = dictionaryVoList1.get(0).getId();
        object.getChildren().forEach(children -> {
            children.setParentId(parentId);
        });
        saveBatch(object.getChildren());
        return true;
    }

    @Override
    public Dictionary queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Dictionary> queryAll() {
        return list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(Dictionary object) {
        List<Dictionary> dictionaryList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(object.getChildren())) {
            object.getChildren().forEach(dictionary -> {
                //没有主键id，执行新增操作
                if (StringUtils.isBlank(dictionary.getId())) {
                    dictionary.setParentId(object.getId());
                    this.save(dictionary);
                }
            });
            dictionaryList.addAll(object.getChildren());
        }
        dictionaryList.add(object);
        return updateBatchById(dictionaryList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteById(String id) {
        List<DictionaryVo> dictionaryVoList = dictionaryMapper.queryByParentId(id);
        if (CollectionUtils.isNotEmpty(dictionaryVoList)) {
            List<String> ids = dictionaryVoList.stream().map(DictionaryVo::getId).collect(Collectors.toList());
            removeByIds(ids);
        }
        removeById(id);
        return true;
    }

    @Override
    public Page<Dictionary> page(Page<Dictionary> page) {
        return null;
    }

    @Override
    public Page<DictionaryVo> manualPage(Page<DictionaryQuery> pageBean) {
        DictionaryQuery dictionaryQuery = pageBean.getRecords().get(0);
        List<DictionaryVo> dictionaryVoList = dictionaryMapper.manualPage(dictionaryQuery);
        PageInfo<DictionaryVo> pageInfo = new PageInfo<>(dictionaryVoList);
        Page<DictionaryVo> result = new Page<>();
        result.setRecords(pageInfo.getList());
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public List<DictionaryVo> queryByParentId(String parentId) {
        return dictionaryMapper.queryByParentId(parentId);
    }

    @Override
    public List<DictionaryVo> queryByParentName(String parentName) {
        return dictionaryMapper.queryByParentName(parentName);
    }

}
