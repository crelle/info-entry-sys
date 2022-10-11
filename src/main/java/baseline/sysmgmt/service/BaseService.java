package baseline.sysmgmt.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

    T queryById(Long id);

    List<T> queryAll();

    boolean update(T object);

    void deleteById(Long id);

    IPage<T> pageByCondition(IPage<T> page);

    IPage<T> pageByCondition(IPage<T> page, Wrapper<T> queryWrapper);
}
