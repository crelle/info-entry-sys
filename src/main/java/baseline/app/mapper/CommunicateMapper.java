package baseline.app.mapper;
import org.apache.ibatis.annotations.Param;

import baseline.app.pojo.entity.Communicate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 沟通记录表 Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2023-02-03 02:50:00
 */
@Mapper
public interface CommunicateMapper extends BaseMapper<Communicate> {
    int deleteByJobNo(@Param("jobNo") String jobNo);
}
