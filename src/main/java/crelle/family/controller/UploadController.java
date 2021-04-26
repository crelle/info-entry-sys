package crelle.family.controller;

import crelle.family.common.ResponseResult;
import crelle.family.common.config.ConfigProperties;
import crelle.family.common.util.CommonUtils;
import crelle.family.model.ao.FileTypeAO;
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
    private ConfigProperties configProperties;

    @Autowired
    private MyFtpClient myFtpClient;


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
            myFtpClient.open();
            String fileSuffix = CommonUtils.getFileSuffixFromMultipartFile(multipartFile);
            String secDir = configProperties.getConfigValue("nginx.location.sec.dir");
            String thriPicDir = null;
            if ("0".equals(fileType)) {
                thriPicDir = configProperties.getConfigValue("nginx.location.thri.picture.dir");
            } else if ("1".equals(fileType)) {
                thriPicDir = configProperties.getConfigValue("nginx.location.thri.video.dir");
            } else if ("2".equals(fileType)) {
                thriPicDir = configProperties.getConfigValue("nginx.location.thri.audio.dir");
            } else if ("3".equals(fileType)) {
                thriPicDir = configProperties.getConfigValue("nginx.location.thri.other.dir");
            } else {
                responseResult.buildFail("请传入文件类型！");
                return responseResult;
            }
            //相对资源地址
            String relativeUri = CommonUtils.generateRelativeMediaResourcesUri(secDir + thriPicDir, fileSuffix);
            myFtpClient.putFileToPath(multipartFile.getInputStream(), relativeUri);
            String nginxIp = configProperties.getConfigValue("nginx.ip");
            String nginxPort = configProperties.getConfigValue("nginx.port");
            //绝对资源地址
            StringBuffer absolutelyUri = new StringBuffer();
            absolutelyUri.append(nginxIp).append(":").append(nginxPort).append("/").append(relativeUri);
            responseResult.setData(absolutelyUri.toString());
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }


    @ApiOperation(value = "删除媒体资源文件")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
