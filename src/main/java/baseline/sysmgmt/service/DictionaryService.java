package baseline.sysmgmt.service;

import baseline.sysmgmt.pojo.entity.Dictionary;
import baseline.sysmgmt.pojo.query.DictionaryQuery;
import baseline.sysmgmt.pojo.vo.DictionaryVo;
import baseline.sysmgmt.service.impl.BaseService;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-12-23 05:23:32
 */
public interface DictionaryService extends IService<Dictionary> , BaseService<DictionaryVo,Dictionary, DictionaryQuery> {

}
