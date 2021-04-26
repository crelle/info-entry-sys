package crelle.family.controller;

import crelle.family.common.ResponseResult;
import crelle.family.common.util.CommonUtils;
import crelle.ftp.client.MyFtpClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;


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

    private String uploadRootDir = "fes/picture/";

    @Autowired
    private MyFtpClient myFtpClient;


    @ApiOperation(value = "上传媒体资源文件")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> upload(@RequestParam("file") MultipartFile multipartFile) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            if (multipartFile.isEmpty()) {
                responseResult.buildFail("请选择文件！");
                return responseResult;
            }
            myFtpClient.open();
            String fileType = CommonUtils.getFileTypeFromMultipartFile(multipartFile);
            String filePath = CommonUtils.generateMediaName(uploadRootDir, fileType);
            myFtpClient.putFileToPath(multipartFile.getInputStream(), filePath);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "删除媒体资源文件")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> upload(String fileName) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            if (StringUtils.isBlank(fileName)) {
                responseResult.buildFail("请传入要删除的文件名！");
                return responseResult;
            }
            myFtpClient.open();
            if (!myFtpClient.deleteFile(fileName)) {
                responseResult.buildFail("删除失败！");
                return responseResult;
            }
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }
}
