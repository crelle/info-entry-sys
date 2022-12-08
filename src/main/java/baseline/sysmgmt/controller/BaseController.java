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
public interface BaseController<T> {


    ResponseResult<T> create(@RequestBody T obj);


     ResponseResult<T> queryById(@PathVariable String id);


     ResponseResult<Page<T>> pageByCondition(@RequestBody Page<T> pageBean);


     ResponseResult<List<T>> queryAll();


     ResponseResult<String> updateById(@PathVariable String id, @RequestBody T obj);

     ResponseResult<String> deleteById(@PathVariable String id);
}
