package crelle.family.controller;

import crelle.family.common.ResponseResult;
import crelle.family.model.PageBean;
import crelle.family.model.ao.MediaResourcesAO;
import crelle.family.model.entity.MediaResources;
import crelle.family.model.entity.Menu;
import crelle.family.service.MediaResourcesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:crelle
 * @className:MediaResourcesController
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
@RestController
@Api(tags = "媒体资源服务")
@RequestMapping(value = "/mediaResources")
@CrossOrigin
public class MediaResourcesController implements BaseController<MediaResources, MediaResourcesAO> {

    @Autowired
    MediaResourcesService mediaResourcesService;


    @ApiOperation(value = "创建媒体资源")
    @ApiParam(required = true, name = "MediaResources", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<MediaResources> create(@RequestBody MediaResources obj) {
        ResponseResult<MediaResources> mediaResourcesResponseResult = new ResponseResult<>();
        try {
            MediaResources mediaResources = mediaResourcesService.create(obj);
            mediaResourcesResponseResult.setData(mediaResources);
        } catch (Exception e) {
            mediaResourcesResponseResult.buildFail(e.getMessage());
        }
        return mediaResourcesResponseResult;
    }


    @ApiOperation(value = "创建媒体资源")
    @ApiParam(required = true, name = "MediaResources", value = "入参")
    @RequestMapping(value = "/updateById", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(Long id, MediaResources obj) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            mediaResourcesService.update(id, obj);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据外键标识删除媒体资源")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteById(Long id) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            mediaResourcesService.deleteMediaResourcesById(id);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据主键标识删除媒体资源")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteByPrimaryKey(Long id) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            mediaResourcesService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @Override
    public ResponseResult<MediaResources> queryById(Long id) {
        return null;
    }

    @Override
    public ResponseResult<Page<MediaResources>> pageByCondition(PageBean<MediaResourcesAO> pageBean) {
        return null;
    }

    @ApiOperation(value = "创建媒体资源")
    @ApiParam(required = true, name = "MediaResources", value = "入参")
    @RequestMapping(value = "/all", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<List<MediaResources>> queryAll() {
        try{
            mediaResourcesService.queryAll();
        }catch (Exception e){

        }
        return null;
    }
}
