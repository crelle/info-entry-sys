package baseline.sysmgmt.controller;


import baseline.sysmgmt.model.ao.UserAO;
import baseline.sysmgmt.model.entity.User;
import crelle.family.common.ResponseResult;
import crelle.family.model.PageBean;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@RestController
@RequestMapping("/sysmgmt/user")
public class UserController implements BaseController<User, UserAO> {


    @Override
    public ResponseResult<User> create(User obj) {
        return null;
    }

    @Override
    public ResponseResult<User> queryById(Long id) {
        return null;
    }

    @Override
    public ResponseResult<Page<User>> pageByCondition(PageBean<UserAO> pageBean) {
        return null;
    }

    @Override
    public ResponseResult<List<User>> queryAll() {
        return null;
    }

    @Override
    public ResponseResult<String> updateById(Long id, User obj) {
        return null;
    }

    @Override
    public ResponseResult<String> deleteById(Long id) {
        return null;
    }
}
