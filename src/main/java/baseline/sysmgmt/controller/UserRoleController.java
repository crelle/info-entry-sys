package baseline.sysmgmt.controller;


import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.UserRole;
import baseline.sysmgmt.pojo.query.UserRoleQuery;
import baseline.sysmgmt.pojo.vo.UserRoleVo;
import baseline.sysmgmt.service.UserRoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@RestController
@RequestMapping("/sysmgmt/user-role")
public class UserRoleController implements BaseController<UserRoleVo,UserRole, UserRoleQuery> {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public ResponseResult<UserRole> create(UserRole obj) {
        return null;
    }

    @Override
    public ResponseResult<UserRole> queryById(String id) {
        return null;
    }

    @Override
    public ResponseResult<Page<UserRole>> page(Page<UserRole> pageBean) {
        return null;
    }

    @Override
    public ResponseResult<Page<UserRoleVo>> manualPage(Page<UserRoleQuery> pageBean) {
        return null;
    }

    @Override
    public ResponseResult<List<UserRole>> queryAll() {
        return null;
    }

    @Override
    public ResponseResult<String> updateById(String id, UserRole obj) {
        return null;
    }

    @Override
    public ResponseResult<String> deleteById(String id) {
        return null;
    }
}
