package baseline.app.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 区域表
 * </p>
 *
 * @author crelle
 * @since 2022-12-06 05:57:05
 */
@Getter
@Setter
@TableName("t_region")
@ApiModel(value = "Region对象", description = "区域表")
public class Region {

    @ApiModelProperty("地域编号")
    @TableId(value = "region_id", type = IdType.ASSIGN_UUID)
    private String regionId;

    @ApiModelProperty("地域名称")
    @TableField("region_name")
    private String regionName;


}
