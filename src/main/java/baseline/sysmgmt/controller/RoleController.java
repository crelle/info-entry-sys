package baseline.sysmgmt.controller;


import baseline.common.enumeration.ResponseEnum;
import baseline.common.exception.BusinessException;
import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.service.RoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@Api(tags = "角色服务")
@RestController
@RequestMapping("/sysmgmt/role")
public class RoleController implements BaseController<Role> {

    @Autowired
    private RoleService roleService;


    @ApiOperation(value = "创建角色")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Role> create(@RequestBody Role role) {
        ResponseResult<Role> responseResult = new ResponseResult<>();
        try {
            List<Role> role1 = roleService.queryByName(role.getName());
            if (!CollectionUtils.isEmpty(role1)) {
                responseResult.buildFail("新增的角色名称已经存在!");
                return responseResult;
            }
            List<Role> role2 = roleService.queryByNameZh(role.getNameZh());
            if (!CollectionUtils.isEmpty(role2)) {
                responseResult.buildFail("新增的角色编码已经存在!");
                return responseResult;
            }
            if(!role.getName().startsWith("ROLE_")){
                responseResult.buildFail("角色编码必须以ROLE_开头!");
                return responseResult;
            }
            roleService.create(role);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
        return responseResult;
    }

    @ApiOperation(value = "根据角色标识查询角色")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Role> queryById(@PathVariable String id) {
        ResponseResult<Role> responseResult = new ResponseResult<>();
        try {
            Role role = roleService.queryById(id);
            responseResult.setData(role);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
        return responseResult;
    }

    @ApiOperation(value = "分页查询角色")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/page", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Role>> pageByCondition(@RequestBody Page<Role> pageBean) {
        ResponseResult<Page<Role>> responseResult = new ResponseResult<>();
        try {
            Page<Role> page = roleService.pageByCondition(pageBean);
            responseResult.setData(page);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
        return responseResult;
    }

    @ApiOperation(value = "查询所有角色")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<Role>> queryAll() {
        ResponseResult<List<Role>> responseResult = new ResponseResult<>();
        try {
            List<Role> roles = roleService.queryAll();
            responseResult.setData(roles);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
        return responseResult;
    }

    @ApiOperation(value = "根据角色标识更新角色")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> updateById(@PathVariable String id, @RequestBody Role role) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            Role oldRole = roleService.queryById(id);
            if (null == oldRole) {
                responseResult.buildFail("要更新的角色不存在！");
                return responseResult;
            }
            BeanUtils.copyProperties(role, oldRole, "id", "menus", "users");
            boolean isSuccess = roleService.update(oldRole);
            if (!isSuccess) {
                responseResult.buildFail("更新角色失败！");
            }
        } catch (Exception e) {
            throw new BusinessException(e);
        }
        return responseResult;
    }

    @ApiOperation(value = "根据角色标识删除角色")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteById(@RequestBody String id) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            roleService.deleteById(id);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            responseResult.buildFail("有用户在使用此角色，无法删除！");
        } catch (NoSuchElementException noSuchElementException) {
            responseResult.buildFail("没有此角色！");
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.UNKNOWN);
        }
        return responseResult;
    }
}
