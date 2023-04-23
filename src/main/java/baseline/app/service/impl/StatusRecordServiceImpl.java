package baseline.app.service.impl;

import baseline.app.mapper.StatusRecordMapper;
import baseline.app.pojo.entity.StatusRecord;
import baseline.app.pojo.query.StatusRecordQuery;
import baseline.app.pojo.vo.StatusRecordVo;
import baseline.app.service.StatusRecordService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 记录表 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2023-02-07 04:54:21
 */
@Service
public class StatusRecordServiceImpl extends ServiceImpl<StatusRecordMapper, StatusRecord> implements StatusRecordService {


    @Override
    public boolean create(StatusRecord object) {
        object.setCreateTime(new Date());
        return save(object);
    }

    @Override
    public boolean create(List<StatusRecord> objects) {
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
    public boolean update(StatusRecord object) {
        return false;
    }

    @Override
    public Page<StatusRecord> pageByCondition(Page<StatusRecord> page) {

        StatusRecord statusRecord = page.getRecords().get(0);
        LambdaQueryWrapper<StatusRecord> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNotBlank(statusRecord.getJobNo()), StatusRecord::getJobNo, statusRecord.getJobNo())
                .orderByDesc(StatusRecord::getCreateTime);
        return page(page, queryWrapper);
    }

    @Override
    public Page<StatusRecordVo> manualPage(Page<StatusRecordQuery> pageBean) {
        return null;
    }

    @Override
    public StatusRecord queryById(String id) {
        return null;
    }

    @Override
    public List<StatusRecord> queryByIds(List<String> ids) {
        return null;
    }
}
