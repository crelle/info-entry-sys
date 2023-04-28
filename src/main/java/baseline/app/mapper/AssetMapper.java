package baseline.app.mapper;

import baseline.app.pojo.entity.Asset;
import baseline.app.pojo.query.AssetQuery;
import baseline.app.pojo.vo.AssetVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<AssetVo> manualPage(@Param("param")AssetQuery assetQuery);

    List<Asset> queryByDepartmentId(@Param("departmentId") String departmentId);
}
