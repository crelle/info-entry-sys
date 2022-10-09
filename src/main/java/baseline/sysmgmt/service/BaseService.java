package baseline.sysmgmt.service;

import java.util.List;

/**
 * @author:crelle
 * @className:BaseService
 * @version:1.0.0
 * @date:2021/4/3
 * @description:XX
 **/
public interface BaseService<T> {

    T create(T object);

    T queryById(Long id);

    List<T> queryAll();

    int update(Long id, T object);

    void deleteById(Long id);
}
