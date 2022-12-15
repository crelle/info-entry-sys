package baseline.sysmgmt.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import baseline.sysmgmt.pojo.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    int deleteByUserId(@Param("userId") String userId);

}
