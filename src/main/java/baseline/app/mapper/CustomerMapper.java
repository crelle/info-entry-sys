package baseline.app.mapper;

import baseline.app.pojo.entity.Customer;
import baseline.app.pojo.query.CustomerQuery;
import baseline.app.pojo.vo.CustomerVo;
import baseline.sysmgmt.pojo.entity.User;
import baseline.sysmgmt.pojo.query.UserQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    List<CustomerVo> manualPage(@Param("param") CustomerQuery customerQuery);

}
