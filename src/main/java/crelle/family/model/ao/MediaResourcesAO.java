package crelle.family.model.ao;

/**
 * @author:crelle
 * @className:MediaResourcesAO
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
public class MediaResourcesAO {

    private Long plantId;

    private Long personId;

    private Long poetryId;

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
