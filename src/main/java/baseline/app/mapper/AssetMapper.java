package baseline.app.mapper;

import baseline.app.pojo.entity.Asset;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 资产表 Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2023-02-28 05:09:23
 */
@Mapper
public interface AssetMapper extends BaseMapper<Asset> {

}
