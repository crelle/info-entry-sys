package baseline.sysmgmt.pojo.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author:crelle
 * @className:FileTypeAO
 * @version:1.0.0
 * @date:2021/4/26
 * @description:XX
 **/
@ApiModel(value = "FileTypeAO",description = "文件类型")
public class FileTypeAO {
    @ApiModelProperty(value = "文件类型0:图片 1:视频 2：音频 3：其他",name = "fileType",required = true)
    private String fileType;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "FileTypeAO{" +
                "fileType='" + fileType + '\'' +
                '}';
    }
}
