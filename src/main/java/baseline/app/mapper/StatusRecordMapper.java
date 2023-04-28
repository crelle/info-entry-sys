package baseline.app.mapper;
import org.apache.ibatis.annotations.Param;

import baseline.app.pojo.entity.StatusRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 记录表 Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2023-02-07 04:54:21
 */
@Mapper
public interface StatusRecordMapper extends BaseMapper<StatusRecord> {
    int deleteByJobNo(@Param("jobNo") String jobNo);
}
