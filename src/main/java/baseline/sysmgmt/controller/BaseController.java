package baseline.sysmgmt.controller;


import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author:crelle
 * @className:BaseController
 * @version:1.0.0
 * @date:2021/4/3
 * @description:XX
 **/
public interface BaseController<V,T, Q> {


    ResponseResult<T> create(@RequestBody T obj);


    ResponseResult<T> queryById(@PathVariable String id);

    /**
     * 使用mybatis plus自动分页，支持单表查询
     *
     * @param pageBean
     * @return
     */
    ResponseResult<Page<T>> page(@RequestBody Page<T> pageBean);

    /**
     * 使用mybatis plus手动分页，自定义查询语句
     *
     * @param pageBean
     * @return
     */
    ResponseResult<Page<V>> manualPage(@RequestBody Page<Q> pageBean);


    ResponseResult<List<T>> queryAll();


    ResponseResult<String> updateById(@PathVariable String id, @RequestBody T obj);

    ResponseResult<String> deleteById(@PathVariable String id);
}
