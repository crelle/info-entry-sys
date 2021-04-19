package crelle.family.model.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author:crelle
 * @className:RoleAO
 * @version:1.0.0
 * @date:2021/4/3
 * @description:XX
 **/
@ApiModel(value = "roleAO",description = "角色AO")
public class RoleAO {

    @ApiModelProperty(value = "name",name = "角色编码")
    private String name;

    @ApiModelProperty(value = "nameZh",name = "角色名称")
    private String nameZh;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    @Override
    public String toString() {
        return "RoleAO{" +
                "name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                '}';
    }
}
