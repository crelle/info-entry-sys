package baseline.app.controller;


import baseline.app.pojo.entity.StatusRecord;
import baseline.app.pojo.query.StatusRecordQuery;
import baseline.app.pojo.vo.StatusRecordVo;
import baseline.app.service.StatusRecordService;
import baseline.common.baseBean.BaseController;
import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 记录表 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2023-02-07 04:54:21
 */
@RestController
@RequestMapping("/app/status-record")
@Api(tags = "状态服务")
public class StatusRecordController implements BaseController<StatusRecordVo,StatusRecord, StatusRecordQuery> {
    @Autowired
    private StatusRecordService statusRecordService;

    @ApiOperation(value = "创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<StatusRecord> create(StatusRecord object) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = statusRecordService.create(object);
        if (!isSuccess) {
            result.buildFail("创建失败！");
        }
        return result;
    }

    @Override
    public ResponseResult<StatusRecord> creates(List<StatusRecord> objects) {
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
    public ResponseResult<String> updateById(StatusRecord object) {
        return null;
    }


    @ApiOperation(value = "分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/pageByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<StatusRecord>> page(Page<StatusRecord> pageBean) {
        ResponseResult result = new ResponseResult();
        result.setData(statusRecordService.pageByCondition(pageBean));
        return result;
    }

    @Override
    public ResponseResult<Page<StatusRecordVo>> manualPage(Page<StatusRecordQuery> pageBean) {
        return null;
    }

}
