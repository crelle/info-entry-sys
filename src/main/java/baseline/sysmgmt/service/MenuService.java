package baseline.sysmgmt.service;

import baseline.sysmgmt.common.ResponseResult;
import baseline.sysmgmt.model.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
public interface MenuService extends IService<Menu>, BaseService<Menu> {
    //根据菜单名称查询菜单信息
    Menu queryByName(String menuName);

    //修改菜单目录
    ResponseResult<String> updateParentMenu(List<Menu> menus);

    //查询所有菜单 分级
    ResponseResult<List<Menu>> queryAllMenus();
}
