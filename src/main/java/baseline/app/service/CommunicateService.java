package baseline.app.service;

import baseline.app.pojo.entity.Communicate;
import baseline.app.pojo.query.CommunicateQuery;
import baseline.app.pojo.vo.CommunicateVo;
import baseline.common.baseBean.BaseService;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 沟通记录表 服务类
 * </p>
 *
 * @author crelle
 * @since 2023-02-03 02:50:00
 */
public interface CommunicateService extends IService<Communicate>, BaseService<CommunicateVo,Communicate, CommunicateQuery> {

}
