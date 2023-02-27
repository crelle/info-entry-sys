package baseline.app.mapper;

import baseline.app.pojo.entity.ContactPerson;
import baseline.app.pojo.entity.Customer;
import baseline.app.pojo.query.ContactPersonQuery;
import baseline.app.pojo.query.CustomerQuery;
import baseline.app.pojo.vo.ContactPersonVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
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
 * @since 2022-11-24 10:45:04
 */
@Mapper
public interface ContactPersonMapper extends BaseMapper<ContactPerson> {

    Page<ContactPersonVo> manualPage(@Param("page") Page<ContactPerson> page,@Param("param") ContactPersonQuery contactPersonQuery);

}
