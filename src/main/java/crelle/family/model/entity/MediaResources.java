package crelle.family.model.entity;

/**
 * @author:crelle
 * @className:MediaResources
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
public class MediaResources {

    private Long id;

    private Long plantId;

    private Long personId;

    private Long poetryId;

    private Long userId;

    private String mediaUrl;

    private String mediaType;

    private String mediaSecType;

    private String mediaDesc;

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
