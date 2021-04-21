package crelle.family.mapper;

import java.util.List;

/**
 * @author:crelle
 * @className:BaseMapper
 * @version:1.0.0
 * @date:2021/4/21
 * @description:XX
 **/
public interface BaseMapper<R, Q> {

    R create(Q request);

    int deleteById(Long id);

    int updateById(Long id);

    R queryById(Long id);

    List<R> queryByPage(Q request);

}
