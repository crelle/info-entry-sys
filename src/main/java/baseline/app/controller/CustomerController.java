package baseline.app.controller;


import baseline.app.pojo.entity.ContactPerson;
import baseline.app.pojo.entity.Customer;
import baseline.app.pojo.query.CustomerQuery;
import baseline.app.pojo.vo.CustomerVo;
import baseline.app.service.ContactPersonService;
import baseline.app.service.CustomerService;
import baseline.common.annotation.EnablePagination;
import baseline.common.baseBean.BaseController;
import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@RestController
@RequestMapping("/app/customer")
@Api(tags = "客户服务")
public class CustomerController implements BaseController<CustomerVo, Customer, CustomerQuery> {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ContactPersonService contactPersonService;

    @ApiOperation(value = "创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Customer> create(@Validated(Customer.POST.class) Customer object) {
        ResponseResult<Customer> result = new ResponseResult<>();
        customerService.create(object);
        result.setData(customerService.getById(object.getId()));
        return result;
    }

    @ApiOperation(value = "批量创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/creates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Customer> creates(@Validated(Customer.POST.class) List<Customer> objects) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = customerService.create(objects);
        if (!isSuccess) {
            result.buildFail("批量创建失败！");
        }
        return result;
    }

    @ApiOperation(value = "根据ID删除")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteById(@NotBlank String id) {
        ResponseResult result = new ResponseResult();
        List<ContactPerson> contactPersonList = contactPersonService
                .list()
                .stream()
                .filter(contactPerson -> contactPerson.getCustomerId().equals(id))
                .collect(Collectors.toList());
        if (!contactPersonList.isEmpty()) {
            result.buildFail("有接口人在使用此客户，无法删除！");
            return result;
        }
        customerService.deleteById(id);
        return result;
    }

    @ApiOperation(value = "根据ID批量删除")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteByIds", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteByIds(@RequestBody List<String> ids) {
        return null;
    }

    @ApiOperation(value = "根据ID更新")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/updateById", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(@RequestBody @Validated(Customer.PUT.class) Customer object) {
        customerService.updateById(object);
        ResponseResult result = new ResponseResult();
        return result;
    }

    @ApiOperation(value = "分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/pageByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Customer>> page(@RequestBody Page<Customer> pageBean) {
        ResponseResult result = new ResponseResult();
        Page<Customer> page = customerService.pageByCondition(pageBean);
        result.setData(page);
        return result;
    }

    @ApiOperation(value = "手动分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/manualPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @EnablePagination
    @Override
    public ResponseResult<Page<CustomerVo>> manualPage(Page<CustomerQuery> pageBean) {
        ResponseResult responseResult = new ResponseResult();
        Page<CustomerVo> page = customerService.manualPage(pageBean);
        responseResult.setData(page);
        return responseResult;
    }
}
