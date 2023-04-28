package baseline.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import baseline.app.pojo.entity.ContactPersonProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 接口人项目关系表 Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2023-04-28 12:03:47
 */
@Mapper
public interface ContactPersonProjectMapper extends BaseMapper<ContactPersonProject> {
    List<ContactPersonProject> selectByProjectId(@Param("projectId") String projectId);

    List<ContactPersonProject> selectByContactPersonId(@Param("contactPersonId") String contactPersonId);

    List<ContactPersonProject> selectByProjectIdAndContactPersonId(@Param("projectId") String projectId, @Param("contactPersonId") String contactPersonId);

    int deleteByProjectIdAndContactPersonId(@Param("projectId") String projectId, @Param("contactPersonId") String contactPersonId);

    int updateContactPersonIdByProjectId(@Param("contactPersonId") String contactPersonId, @Param("projectId") String projectId);
}
