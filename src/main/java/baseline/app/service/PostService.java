package baseline.app.service;

import baseline.app.pojo.entity.Post;
import baseline.app.pojo.query.PostQuery;
import baseline.common.baseBean.BaseService;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
public interface PostService extends IService<Post>, BaseService<Post, PostQuery> {

}
