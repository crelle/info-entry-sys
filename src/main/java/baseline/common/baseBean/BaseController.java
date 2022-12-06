package baseline.common.baseBean;

import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BaseController<T> {

    /**
     * 创建一个
     *
     * @param object
     * @return
     */
    ResponseResult<T> create(@RequestBody T object);

    /**
     * 创建多个
     *
     * @param objects
     * @return
     */
    ResponseResult<T> creates(@RequestBody List<T> objects);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */

    ResponseResult<String> deleteById(@PathVariable String id);

    /**
     * 根据ID批量删除
     *
     * @param ids
     * @return
     */
    ResponseResult<String> deleteByIds(@RequestBody List<String> ids);

    /**
     * 根据ID修改
     *
     * @param object
     * @return
     */
    ResponseResult<String> updateById(@RequestBody T object);

    /**
     * 根据条件分页查询
     *
     * @param pageBean
     * @return
     */
    ResponseResult<Page<T>> pageByCondition(@RequestBody Page<T> pageBean);


}