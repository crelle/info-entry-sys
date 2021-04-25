package crelle.family.mapper;

import crelle.family.model.ao.MediaResourcesAO;
import crelle.family.model.entity.MediaResources;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:crelle
 * @className:MediaResourcesMapper
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
public interface MediaResourcesMapper {

    int create(MediaResources mediaResources);

    int deleteByPrimaryKey(Long id);

    int deleteById(Long id);

    int updateMediaResourcesById(MediaResources mediaResources);

    List<MediaResources> queryMediaResourcesById(@Param("mr") MediaResourcesAO mediaResourcesAO);

}
