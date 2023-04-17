package baseline.sysmgmt.mapper;

import baseline.sysmgmt.pojo.entity.Dictionary;
import baseline.sysmgmt.pojo.query.DictionaryQuery;
import baseline.sysmgmt.pojo.vo.DictionaryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2022-12-23 05:23:32
 */
@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    Page<DictionaryVo> manualPage(@Param("page") Page<Dictionary> page, @Param("param") DictionaryQuery departmentQuery);

    List<DictionaryVo> queryByParentId(@Param("parentId") String parentId);

    List<DictionaryVo> queryByParentName(@Param("parentName") String parentName);
}
