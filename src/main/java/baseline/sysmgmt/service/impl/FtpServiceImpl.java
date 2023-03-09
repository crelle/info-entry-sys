package baseline.sysmgmt.service.impl;


import baseline.common.config.ConfigProperties;
import baseline.common.constant.FesConstants;
import baseline.common.util.CommonUtils;
import baseline.sysmgmt.service.FtpService;
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
//    @Autowired
//    private MyFtpClient myFtpClient;

    @Autowired
    private ConfigProperties configProperties;

    @Override
    public String uploadFromMultipartFile(MultipartFile multipartFile, String fileType) throws Exception {
        String fileSuffix = CommonUtils.getFileSuffixFromMultipartFile(multipartFile);
//        myFtpClient.open();
        String firDir = configProperties.getConfigValue("nginx.location.root");
        String secDir = configProperties.getConfigValue("nginx.location.sec.dir");
        String thriPicDir = null;
        if (FesConstants.MEDIA_RES_TYPE.PICTURE.equals(fileType)) {
            String allowFileSuffix = configProperties.getConfigValue("upload.media.resource.picture");
            if (!allowFileSuffix.contains(fileSuffix)) {
                throw new Exception("文件类型后缀必须为:" + allowFileSuffix);
            }
            thriPicDir = configProperties.getConfigValue("nginx.location.thri.picture.dir");
        } else if (FesConstants.MEDIA_RES_TYPE.VIDEO.equals(fileType)) {
            String allowFileSuffix = configProperties.getConfigValue("upload.media.resource.video");
            if (!allowFileSuffix.contains(fileSuffix)) {
                throw new Exception("文件类型后缀必须为:" + allowFileSuffix);
            }
            thriPicDir = configProperties.getConfigValue("nginx.location.thri.video.dir");
        } else if (FesConstants.MEDIA_RES_TYPE.AUDIO.equals(fileType)) {
            String allowFileSuffix = configProperties.getConfigValue("upload.media.resource.audio");
            if (!allowFileSuffix.contains(fileSuffix)) {
                throw new Exception("文件类型后缀必须为:" + allowFileSuffix);
            }
            thriPicDir = configProperties.getConfigValue("nginx.location.thri.audio.dir");
        } else if (FesConstants.MEDIA_RES_TYPE.OTHER.equals(fileType)) {
            String allowFileSuffix = configProperties.getConfigValue("upload.media.resource.other");
            if (!allowFileSuffix.contains(fileSuffix)) {
                throw new Exception("文件类型后缀必须为:" + allowFileSuffix);
            }
            thriPicDir = configProperties.getConfigValue("nginx.location.thri.other.dir");
        }
        //相对资源地址
        String relativeUri = CommonUtils.generateRelativeMediaResourcesUri(firDir + secDir + thriPicDir, fileSuffix);
//        myFtpClient.putFileToPath(multipartFile.getInputStream(), relativeUri);
        String nginxIp = configProperties.getConfigValue("nginx.ip");
        String nginxFtpPort = configProperties.getConfigValue("nginx.ftp.port");
        //绝对资源地址l
        StringBuffer absolutelyUri = new StringBuffer();
        absolutelyUri.append(nginxIp).append(":").append(nginxFtpPort).append(relativeUri);
        return absolutelyUri.toString();
    }

    @Override
    public boolean deleteByAbsoluteUri(String absoluteUri) throws IOException {
//        myFtpClient.open();
        int index = absoluteUri.indexOf("/");
        String relativeUri = absoluteUri.substring(index + 1, absoluteUri.length());
//        return myFtpClient.deleteFile(relativeUri);
        return true;
    }
}
