package baseline.sysmgmt.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User implements UserDetails {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("account_non_expired")
    private Boolean accountNonExpired;

    @TableField("account_non_locked")
    private Boolean accountNonLocked;

    @TableField("credentails_non_expired")
    private Boolean credentailsNonExpired;

    @TableField("enabled")
    private Boolean enabled;

    @TableField("password")
    private String password;

    @TableField("user_email")
    private String userEmail;

    @TableField("user_nick_name")
    private String userNickName;

    @TableField("user_phone")
    private String userPhone;

    @TableField("username")
    private String username;

    @TableField("user_avatar")
    private String userAvatar;

    @TableField(exist = false)
    private List<Role> roles;

    /**
     * 用户权限设置
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (!CollectionUtils.isEmpty(getRoles())) {
            for (Role role : getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentailsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentailsNonExpired(Boolean credentailsNonExpired) {
        this.credentailsNonExpired = credentailsNonExpired;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentailsNonExpired=" + credentailsNonExpired +
                ", enabled=" + enabled +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", username='" + username + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", roles=" + roles +
                '}';
    }
}
