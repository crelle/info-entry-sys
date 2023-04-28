package baseline.app.mapper;

import baseline.app.pojo.entity.ContactPerson;
import baseline.app.pojo.query.ContactPersonQuery;
import baseline.app.pojo.vo.ContactPersonVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

    List<ContactPersonVo> manualPage(@Param("param") ContactPersonQuery contactPersonQuery);

    List<ContactPerson> queryByCustomerId(@Param("customerId") String customerId);
}
