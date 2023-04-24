package baseline.app.controller;


import baseline.app.pojo.entity.Communicate;
import baseline.app.pojo.query.CommunicateQuery;
import baseline.app.pojo.vo.CommunicateVo;
import baseline.app.service.CommunicateService;
import baseline.common.baseBean.BaseController;
import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 沟通记录表 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2023-02-03 02:50:00
 */
@RestController
@RequestMapping("/app/communicate")
@Api(tags = "沟通记录服务")
public class CommunicateController implements BaseController<CommunicateVo, Communicate, CommunicateQuery> {
    @Autowired
    private CommunicateService communicateService;

    @ApiOperation(value = "创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Communicate> create(@Validated(Communicate.POST.class) Communicate object) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = communicateService.create(object);
        if (!isSuccess) {
            result.buildFail("创建沟通记录失败！");
        }
        return result;
    }

    @Override
    public ResponseResult<Communicate> creates(List<Communicate> objects) {
        return null;
    }

    @Override
    public ResponseResult<String> deleteById(String id) {
        return null;
    }

    @Override
    public ResponseResult<String> deleteByIds(List<String> ids) {
        return null;
    }

    @Override
    public ResponseResult<String> updateById(Communicate object) {
        return null;
    }


    @ApiOperation(value = "分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/pageByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Communicate>> page(Page<Communicate> pageBean) {
        ResponseResult result = new ResponseResult();
        result.setData(communicateService.pageByCondition(pageBean));
        return result;
    }

    @Override
    public ResponseResult<Page<CommunicateVo>> manualPage(Page<CommunicateQuery> pageBean) {
        return null;
    }

}
