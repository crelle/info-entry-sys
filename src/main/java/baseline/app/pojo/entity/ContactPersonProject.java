package baseline.app.pojo.entity;

import baseline.common.pojo.entity.BaseDo;
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
 * 接口人项目关系表
 * </p>
 *
 * @author crelle
 * @since 2023-04-23 02:35:38
 */
@Getter
@Setter
@TableName("t_contact_person_project")
@ApiModel(value = "ContactPersonProject对象", description = "接口人项目关系表")
public class ContactPersonProject extends BaseDo {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("接口人id")
    @TableField("contact_person_id")
    private String contactPersonId;

    @ApiModelProperty("项目id")
    @TableField("project_id")
    private String projectId;


}
