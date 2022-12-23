package baseline.sysmgmt.service.impl;

import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
public interface BaseService<T,Q> {

    boolean create(T object);

    T queryById(String id);

    List<T> queryAll();

    boolean update(T object) throws Exception;

    void deleteById(String id);

    Page<T> page(Page<T> page);

    /**
     * 使用mybatis plus手动分页，自定义查询语句
     *
     * @param pageBean
     * @return
     */
    Page<T> manualPage(@RequestBody Page<Q> pageBean);
}
