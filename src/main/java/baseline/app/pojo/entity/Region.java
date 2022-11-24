package baseline.app.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@TableName("t_region")
@ApiModel(value = "Region对象", description = "")
public class Region {

    @ApiModelProperty("地域编号")
    @TableId(value = "region_id", type = IdType.ASSIGN_UUID)
    private String regionId;

    @ApiModelProperty("地域名称")
    @TableField("region_name")
    private String regionName;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "Region{" +
            "regionId=" + regionId +
            ", regionName=" + regionName +
        "}";
    }
}
