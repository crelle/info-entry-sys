package baseline.app.service.impl;

import baseline.app.mapper.EmployeeMapper;
import baseline.app.pojo.entity.Post;
import baseline.app.mapper.PostMapper;
import baseline.app.pojo.query.PostQuery;
import baseline.app.pojo.vo.PostVo;
import baseline.app.service.EmployeeService;
import baseline.app.service.PostService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private EmployeeService employeeService;

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
                .like(StringUtils.isNotBlank(post.getProjectId()), Post::getProjectId, post.getProjectId())
                .like(StringUtils.isNotBlank(post.getSkill()), Post::getSkill, post.getSkill());
        return page(page, queryWrapper);
    }

    @Override
    public Page<PostVo> manualPage(Page<PostQuery> pageBean) {
        PostQuery postQuery = pageBean.getRecords().get(0);
        Page<PostQuery> postQueryPage = new Page<>();
        Page<PostVo> postVoPage = postMapper.manualPage(postQueryPage, postQuery);
        List<PostVo> records = postVoPage.getRecords();
        List<PostVo> postVos = new ArrayList<>();
        for (PostVo record : records) {
            int postSize = employeeService
                    .list()
                    .stream()
                    .filter(employee -> employee.getPostId() != null)
                    .filter(employee -> employee.getPostId().equals(record.getPostId()))
                    .collect(Collectors.toList())
                    .size();
            int number = StringUtils.isBlank(record.getNumber()) ? 0 : Integer.valueOf(record.getNumber());
            int needPeople = number - postSize > 0 ? number - postSize : 0;
            record.setNeedPeopleNum(String.valueOf(needPeople));
            postVos.add(record);
        }
        postVoPage.setRecords(postVos);
        return postVoPage;
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
