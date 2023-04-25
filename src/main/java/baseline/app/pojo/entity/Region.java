package baseline.app.pojo.entity;

import baseline.common.pojo.entity.BaseDo;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * 区域表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_region")
@ApiModel(value = "Region对象", description = "区域表")
public class Region extends BaseDo {

    @ApiModelProperty("地域id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @NotBlank(groups = {DELETE.class,PUT.class})
    private String id;

    @ApiModelProperty(value = "地域名称",required = true)
    @TableField("name")
    @NotBlank(groups = POST.class)
    private String name;

    @ApiModelProperty(value = "地域编码",required = true)
    @TableField("code")
    @NotBlank(groups = POST.class)
    private String code;
}
