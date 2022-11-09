package baseline.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface BaseService<T> {

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
     * 根据条件分页查询
     *
     * @param page
     * @return
     */
    Page<T> pageByCondition(Page<T> page);

    /**
     * 根据id查询
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
