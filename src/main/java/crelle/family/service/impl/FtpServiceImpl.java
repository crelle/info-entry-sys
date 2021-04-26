package crelle.family.service.impl;

import crelle.family.common.config.ConfigProperties;
import crelle.family.common.util.CommonUtils;
import crelle.family.service.FtpService;
import crelle.ftp.client.MyFtpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author:crelle
 * @className:FtpServiceImpl
 * @version:1.0.0
 * @date:2021/4/26
 * @description:XX
 **/
@Service
public class FtpServiceImpl implements FtpService {
    @Autowired
    private MyFtpClient myFtpClient;

    @Autowired
    private ConfigProperties configProperties;

    @Override
    public String uploadFromMultipartFile(MultipartFile multipartFile, String fileType) throws Exception {
        String fileSuffix = CommonUtils.getFileSuffixFromMultipartFile(multipartFile);
        myFtpClient.open();
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
        }
        //相对资源地址
        String relativeUri = CommonUtils.generateRelativeMediaResourcesUri(secDir + thriPicDir, fileSuffix);
        myFtpClient.putFileToPath(multipartFile.getInputStream(), relativeUri);
        String nginxIp = configProperties.getConfigValue("nginx.ip");
        String nginxPort = configProperties.getConfigValue("nginx.port");
        //绝对资源地址
        StringBuffer absolutelyUri = new StringBuffer();
        absolutelyUri.append(nginxIp).append(":").append(nginxPort).append("/").append(relativeUri);
        return absolutelyUri.toString();
    }

    @Override
    public boolean deleteByAbsoluteUri(String absoluteUri) throws IOException {
        myFtpClient.open();
        int index = absoluteUri.indexOf("/");
        String relativeUri = absoluteUri.substring(index + 1, absoluteUri.length());
        return myFtpClient.deleteFile(relativeUri);
    }
}
