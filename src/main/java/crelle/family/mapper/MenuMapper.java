package crelle.family.mapper;

import crelle.family.model.entity.Menu;

import java.util.List;

/**
 * @author:crelle
 * @className:MenuMapper
 * @version:1.0.0
 * @date:2021/3/31
 * @description:XX
 **/
public interface MenuMapper {

    List<Menu> queryMenuByRoleId(String roleId);
}
