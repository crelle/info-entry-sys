package crelle.family.model.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author:crelle
 * @className:MediaResourcesAO
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
@ApiModel(value = "MediaResourcesAO",description = "媒体资源AO")
public class MediaResourcesAO {

    @ApiModelProperty(value = "plantId",name = "植物标识")
    private Long plantId;

    @ApiModelProperty(value = "plantId",name = "人物标识")
    private Long personId;

    @ApiModelProperty(value = "poetryId",name = "诗词标识")
    private Long poetryId;

    @ApiModelProperty(value = "userId",name = "用户标识")
    private Long userId;

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

    @Override
    public String toString() {
        return "MediaResourcesAO{" +
                "plantId=" + plantId +
                ", personId=" + personId +
                ", poetryId=" + poetryId +
                ", userId=" + userId +
                '}';
    }
}
