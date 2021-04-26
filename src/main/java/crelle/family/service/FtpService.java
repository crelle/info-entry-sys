package crelle.family.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author:crelle
 * @className:FtpService
 * @version:1.0.0
 * @date:2021/4/26
 * @description:XX
 **/
public interface FtpService {

    /**
     *@author:crelle
     *@date:2021/4/26
     *@title:uploadFromMultipartFile
     *@description:从MultipartFile中上传文件
     *@params:[multipartFile, fileType]
     *@return:java.lang.String
     *@throw:
     */
    String uploadFromMultipartFile(MultipartFile multipartFile, String fileType) throws Exception;

    /**
     *@author:crelle
     *@date:2021/4/26
     *@title:deleteByAbsoluteUri
     *@description:根据绝对资源路径删除文件
     *@params:[absoluteUri]
     *@return:boolean
     *@throw:
     */
    boolean deleteByAbsoluteUri(String absoluteUri) throws IOException;
}
