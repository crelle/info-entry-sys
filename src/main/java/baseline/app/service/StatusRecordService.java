package baseline.app.service;

import baseline.app.pojo.entity.StatusRecord;
import baseline.app.pojo.query.StatusRecordQuery;
import baseline.common.baseBean.BaseService;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 记录表 服务类
 * </p>
 *
 * @author crelle
 * @since 2023-02-07 04:54:21
 */
public interface StatusRecordService extends IService<StatusRecord>, BaseService<StatusRecord, StatusRecordQuery> {

}
