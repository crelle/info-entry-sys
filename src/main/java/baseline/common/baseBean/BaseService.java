package baseline.common.baseBean;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BaseService<V, T, Q> {

    /**
     * 增加一个
     *
     * @param object
     * @return
     */
    boolean create(T object);

    /**
     * 批量增加
     *
     * @param objects
     * @return
     */
    boolean create(List<T> objects);

    /**
     * 根据ID删除
     *
     * @param id
     */
    void deleteById(String id);

    /**
     * 根据ID批量删除
     *
     * @param ids
     */

    void deleteByIds(List<String> ids);

    /**
     * 根据id修改
     *
     * @param object
     * @return
     */
    boolean update(T object);

    /**
     * 奏定分页查询
     *
     * @param page
     * @return
     */
    Page<T> pageByCondition(Page<T> page);

    /**
     * 使用mybatis plus手动分页，自定义查询语句
     *
     * @param pageBean
     * @return
     */
    Page<V> manualPage(@RequestBody Page<Q> pageBean);

    /**
     * 查询详情
     *
     * @param id
     * @return
     */
    T queryById(String id);

    /**
     * 根据id批量查询
     *
     * @param ids
     * @return
     */
    List<T> queryByIds(List<String> ids);
}
