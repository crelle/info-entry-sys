package baseline.app.service;

import baseline.app.pojo.entity.Customer;
import baseline.app.pojo.query.CustomerQuery;
import baseline.app.pojo.vo.CustomerVo;
import baseline.app.pojo.vo.ProjectVo;
import baseline.common.baseBean.BaseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
public interface CustomerService extends IService<Customer>, BaseService<CustomerVo, Customer, CustomerQuery> {
    Page<ProjectVo> queryProjectById(String id);
}
