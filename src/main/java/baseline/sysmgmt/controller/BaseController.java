package baseline.sysmgmt.controller;


import baseline.common.ResponseResult;
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
public interface BaseController<T> {


    ResponseResult<T> create(@RequestBody T obj);


    public ResponseResult<T> queryById(@PathVariable String id);


    public ResponseResult<Page<T>> pageByCondition(@RequestBody Page<T> pageBean);


    public ResponseResult<List<T>> queryAll();


    public ResponseResult<String> updateById(@PathVariable String id, @RequestBody T obj);

    public ResponseResult<String> deleteById(@PathVariable String id);
}
