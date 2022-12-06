package baseline.sysmgmt.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author:crelle
 * @className:BaseService
 * @version:1.0.0
 * @date:2021/4/3
 * @description:XX
 **/
public interface BaseService<T> {

    boolean create(T object);

    T queryById(String id);

    List<T> queryAll();

    boolean update(T object);

    void deleteById(String id);

    Page<T> pageByCondition(Page<T> page);
}
