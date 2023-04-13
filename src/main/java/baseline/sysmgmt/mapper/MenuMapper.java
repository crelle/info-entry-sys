package baseline.sysmgmt.mapper;

import baseline.sysmgmt.pojo.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    Integer queryMenuMaxMenuSort();
}
