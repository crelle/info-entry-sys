package baseline.sysmgmt.model.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author:crelle
 * @className:UserAO
 * @version:1.0.0
 * @date:2021/4/3
 * @description:XX
 **/
@ApiModel(value = "userAO", description = "菜单AO")
public class UserAO {

    @ApiModelProperty(value = "username" ,name = "用户名")
    private String username;

    @ApiModelProperty(value = "password",name = "密码")
    private String password;

    @ApiModelProperty(value = "code",name = "验证码")
    private String code;

    @ApiModelProperty(value = "userPhone",name = "手机号")
    private String userPhone;

    @ApiModelProperty(value = "enabled",name = "是否可用")
    private boolean enabled;

    @ApiModelProperty(value = "accountNonLocked",name = "账号是否被锁定")
    private boolean accountNonLocked;

    @ApiModelProperty(value = "accountNonExpired",name = "账号是否过期")
    private boolean accountNonExpired;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public String toString() {
        return "UserAO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", enabled=" + enabled +
                ", accountNonLocked=" + accountNonLocked +
                ", accountNonExpired=" + accountNonExpired +
                '}';
    }
}
