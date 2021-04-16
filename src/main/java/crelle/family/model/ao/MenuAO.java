package crelle.family.model.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author:crelle
 * @className:MenuAO
 * @version:1.0.0
 * @date:2021/4/3
 * @description:XX
 **/
@ApiModel(value = "menuAO", description = "菜单AO")
public class MenuAO implements Serializable {

    public static final Long serialVersionID = 1L;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "是否需要鉴权",required = true)
    private boolean requireAuth;

    @ApiModelProperty(value = "是否可用",required = true)
    private boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(boolean requireAuth) {
        this.requireAuth = requireAuth;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    @Override
    public String toString() {
        return "MenuAO{" +
                "name='" + name + '\'' +
                ", requireAuth=" + requireAuth +
                ", enabled=" + enabled +
                '}';
    }
}
