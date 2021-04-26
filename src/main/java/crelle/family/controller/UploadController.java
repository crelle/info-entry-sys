package crelle.family.controller;

import crelle.family.common.ResponseResult;
import crelle.family.common.config.ConfigProperties;
import crelle.family.common.util.CommonUtils;
import crelle.family.model.ao.FileTypeAO;
import crelle.family.service.FtpService;
import crelle.ftp.client.MyFtpClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;


/**
 * @author:crelle
 * @className:UploadController
 * @version:1.0.0
 * @date:2021/4/26
 * @description:XX
 **/
@Api(tags = "上传服务")
@RestController
@RequestMapping(value = "/media")
@CrossOrigin
public class UploadController {


    @Autowired
    private FtpService ftpService;


    @ApiOperation(value = "上传媒体资源文件")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseResult<String> upload(@RequestPart("file") MultipartFile multipartFile, @RequestParam("fileType") String fileType) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            if (multipartFile.isEmpty()) {
                responseResult.buildFail("请选择文件！");
                return responseResult;
            }
            String absolutelyUri = ftpService.uploadFromMultipartFile(multipartFile, fileType);
            responseResult.setData(absolutelyUri);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }


    @ApiOperation(value = "删除媒体资源文件")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> delete(String absoluteUri) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            if (StringUtils.isBlank(absoluteUri)) {
                responseResult.buildFail("请传入要删除的资源路径！");
                return responseResult;
            }
            if (ftpService.deleteByAbsoluteUri(absoluteUri)) {
                responseResult.buildFail("删除失败！");
                return responseResult;
            }
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }


}
