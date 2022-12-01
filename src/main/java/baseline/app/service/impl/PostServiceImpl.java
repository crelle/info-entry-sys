package baseline.app.service.impl;

import baseline.app.pojo.entity.Post;
import baseline.app.mapper.PostMapper;
import baseline.app.pojo.entity.Project;
import baseline.app.service.PostService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
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
        Post post = page.getRecords().get(0);
        LambdaQueryWrapper<Post> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(post.getPostName()), Post::getPostName, post.getPostName())
                .like(StringUtils.isNotBlank(post.getAddress()), Post::getAddress, post.getAddress())
                .like(StringUtils.isNotBlank(post.getSkill()), Post::getSkill, post.getSkill());
        return page(page, queryWrapper);
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
