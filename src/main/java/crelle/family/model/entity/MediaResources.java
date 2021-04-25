package crelle.family.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author:crelle
 * @className:MediaResources
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
@ApiModel(value = "MediaResources",description = "媒体资源")
public class MediaResources {

    @ApiModelProperty(value = "id",name = "媒体资源标识")
    private Long id;

    @ApiModelProperty(value = "plantId",name = "植物标识")
    private Long plantId;

    @ApiModelProperty(value = "plantId",name = "人物标识")
    private Long personId;

    @ApiModelProperty(value = "poetryId",name = "诗词标识")
    private Long poetryId;

    @ApiModelProperty(value = "userId",name = "用户标识")
    private Long userId;

    @ApiModelProperty(value = "mediaUrl",name = "媒体资源地址")
    private String mediaUrl;

    @ApiModelProperty(value = "mediaType",name = "媒体资源类型")
    private String mediaType;

    @ApiModelProperty(value = "mediaSecType",name = "媒体资源第二类型")
    private String mediaSecType;

    @ApiModelProperty(value = "mediaDesc",name = "媒体资源描述")
    private String mediaDesc;

    @ApiModelProperty(value = "mediaDefault",name = "是否默认的媒体资源")
    private boolean mediaDefault;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getPoetryId() {
        return poetryId;
    }

    public void setPoetryId(Long poetryId) {
        this.poetryId = poetryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaSecType() {
        return mediaSecType;
    }

    public void setMediaSecType(String mediaSecType) {
        this.mediaSecType = mediaSecType;
    }

    public String getMediaDesc() {
        return mediaDesc;
    }

    public void setMediaDesc(String mediaDesc) {
        this.mediaDesc = mediaDesc;
    }

    public boolean isMediaDefault() {
        return mediaDefault;
    }

    public void setMediaDefault(boolean mediaDefault) {
        this.mediaDefault = mediaDefault;
    }

    @Override
    public String toString() {
        return "MediaResources{" +
                "id=" + id +
                ", plantId=" + plantId +
                ", personId=" + personId +
                ", poetryId=" + poetryId +
                ", userId=" + userId +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", mediaSecType='" + mediaSecType + '\'' +
                ", mediaDesc='" + mediaDesc + '\'' +
                ", mediaDefault=" + mediaDefault +
                '}';
    }
}
