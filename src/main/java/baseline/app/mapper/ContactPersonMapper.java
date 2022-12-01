package baseline.app.mapper;

import baseline.app.pojo.entity.ContactPerson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2022-11-24 10:45:04
 */
@Mapper
public interface ContactPersonMapper extends BaseMapper<ContactPerson> {
}
