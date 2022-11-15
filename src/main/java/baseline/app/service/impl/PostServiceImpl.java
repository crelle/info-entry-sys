package baseline.app.service.impl;

import baseline.app.model.entity.Post;
import baseline.app.mapper.PostMapper;
import baseline.app.service.PostService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Override
    public boolean create(Post object) {
        return save(object);
    }

    @Override
    public boolean create(List<Post> objects) {
        return saveBatch(objects);
    }

    @Override
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        removeByIds(ids);
    }

    @Override
    public boolean update(Post object) {
        return updateById(object);
    }

    @Override
    public Page<Post> pageByCondition(Page<Post> page) {
        return page(page);
    }

    @Override
    public Post queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Post> queryByIds(List<String> ids) {
        return null;
    }
}
