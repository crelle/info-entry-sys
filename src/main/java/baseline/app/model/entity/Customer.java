package baseline.app.model.entity;

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
@TableName("t_customer")
@ApiModel(value = "Customer对象", description = "")
public class Customer {

    @ApiModelProperty("客户编号")
    @TableId(value = "customer_id", type = IdType.ASSIGN_UUID)
    private String customerId;

    @ApiModelProperty("客户名称")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty("地域ID")
    @TableField("region_id")
    private String regionId;

    @ApiModelProperty("办公地点")
    @TableField("address")
    private String address;

    @ApiModelProperty("负责人ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("联系电话")
    @TableField("cell_phone")
    private String cellPhone;

    @ApiModelProperty("电子邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("客户介绍")
    @TableField("introduce")
    private String introduce;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "customerId=" + customerId +
            ", customerName=" + customerName +
            ", regionId=" + regionId +
            ", address=" + address +
            ", userId=" + userId +
            ", cellPhone=" + cellPhone +
            ", email=" + email +
            ", introduce=" + introduce +
        "}";
    }
}
