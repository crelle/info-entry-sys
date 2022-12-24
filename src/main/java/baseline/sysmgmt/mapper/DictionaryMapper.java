package baseline.sysmgmt.mapper;

import baseline.sysmgmt.pojo.entity.Dictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2022-12-23 05:23:32
 */
@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

}
