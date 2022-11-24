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
 * @since 2022-11-24 10:45:04
 */
@TableName("t_contact_person")
@ApiModel(value = "ContactPerson对象", description = "")
public class ContactPerson {

    @ApiModelProperty("接口人编号")
    @TableId(value = "Interface_id", type = IdType.ASSIGN_UUID)
    private String interfaceId;

    @ApiModelProperty("接口人姓名")
    @TableField("Interface_name")
    private String interfaceName;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("联系电话")
    @TableField("cell_phone")
    private String cellPhone;

    @ApiModelProperty("邮箱地址")
    @TableField("email")
    private String email;

    @ApiModelProperty("办公地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("介绍")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty("客户ID")
    @TableField("customer_id")
    private String customerId;

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }
    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
            "interfaceId=" + interfaceId +
            ", interfaceName=" + interfaceName +
            ", gender=" + gender +
            ", cellPhone=" + cellPhone +
            ", email=" + email +
            ", address=" + address +
            ", introduce=" + introduce +
            ", customerId=" + customerId +
        "}";
    }
}
