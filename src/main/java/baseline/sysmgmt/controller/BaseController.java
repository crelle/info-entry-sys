package baseline.sysmgmt.controller;

import crelle.family.common.ResponseResult;
import crelle.family.model.PageBean;
import org.springframework.data.domain.Page;
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
public interface BaseController<T,A> {


    ResponseResult<T> create(@RequestBody T obj);


    public ResponseResult<T> queryById(@PathVariable Long id);


    public ResponseResult<Page<T>> pageByCondition(@RequestBody PageBean<A> pageBean);


    public ResponseResult<List<T>> queryAll();


    public ResponseResult<String> updateById(@PathVariable Long id, @RequestBody T obj);

    public ResponseResult<String> deleteById(@PathVariable Long id);
}
