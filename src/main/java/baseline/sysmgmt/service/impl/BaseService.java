package baseline.sysmgmt.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author:crelle
 * @className:BaseService
 * @version:1.0.0
 * @date:2021/4/3
 * @description:XX
 **/
public interface BaseService<V,T,Q> {

    boolean create(T object);

    T queryById(String id);

    List<T> queryAll();

    boolean update(T object);

    boolean deleteById(String id);

    Page<T> page(Page<T> page);

    /**
     * 使用mybatis plus手动分页，自定义查询语句
     *
     * @param pageBean
     * @return
     */
    Page<V> manualPage(@RequestBody Page<Q> pageBean);
}
