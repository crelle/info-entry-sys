package baseline.app.service.impl;

import baseline.app.mapper.CommunicateMapper;
import baseline.app.pojo.entity.Communicate;
import baseline.app.pojo.query.CommunicateQuery;
import baseline.app.pojo.vo.CommunicateVo;
import baseline.app.service.CommunicateService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 沟通记录表 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2023-02-03 02:50:00
 */
@Service
public class CommunicateServiceImpl extends ServiceImpl<CommunicateMapper, Communicate> implements CommunicateService {

    @Override
    public boolean create(Communicate object) {
        object.setTime(new Date());
        return save(object);
    }

    @Override
    public boolean create(List<Communicate> objects) {
        return false;
    }

    @Override
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {

    }

    @Override
    public boolean update(Communicate object) {
        return false;
    }

    @Override
    public Page<Communicate> pageByCondition(Page<Communicate> page) {
        Communicate communicate = page.getRecords().get(0);
        LambdaQueryWrapper<Communicate> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNotBlank(communicate.getJobNo()), Communicate::getJobNo, communicate.getJobNo())
                .orderByDesc(Communicate::getTime);
        return page(page, queryWrapper);
    }

    @Override
    public Page<CommunicateVo> manualPage(Page<CommunicateQuery> pageBean) {
        return null;
    }

    @Override
    public Communicate queryById(String id) {
        return null;
    }

    @Override
    public List<Communicate> queryByIds(List<String> ids) {
        return null;
    }
}
