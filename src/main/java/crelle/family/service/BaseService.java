package crelle.family.service;

import crelle.family.model.entity.Role;

import java.util.List;
import java.util.Optional;

/**
 * @author:crelle
 * @className:BaseService
 * @version:1.0.0
 * @date:2021/4/3
 * @description:XX
 **/
public interface BaseService<T> {

    T create(T role);

    Optional<T> queryById(Long id);

    List<T> queryAll();

    int update(Long id,T obj);

    void deleteById(Long id);
}
