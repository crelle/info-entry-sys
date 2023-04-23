package baseline.app.service;

import baseline.app.pojo.entity.Asset;
import baseline.app.pojo.query.AssetQuery;
import baseline.app.pojo.vo.AssetVo;
import baseline.common.baseBean.BaseService;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 资产表 服务类
 * </p>
 *
 * @author crelle
 * @since 2023-02-28 05:09:23
 */
public interface AssetService extends IService<Asset> , BaseService<AssetVo, Asset, AssetQuery>{

    List<Asset> queryByEmployeeId(String employeeId);
}
