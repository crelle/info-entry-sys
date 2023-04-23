package baseline.app.pojo.vo;

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
public class RegionVo {

    @ApiModelProperty("地域编号")
    private String id;

    @ApiModelProperty("地域名称")
    private String name;

    @ApiModelProperty("地域编码")
    private String code;


}
