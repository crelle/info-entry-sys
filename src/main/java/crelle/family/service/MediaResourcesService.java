package crelle.family.service;

import crelle.family.model.ao.MediaResourcesAO;
import crelle.family.model.entity.MediaResources;
import crelle.family.service.BaseService;

import java.util.List;

/**
 * @author:crelle
 * @className:MediaResourcesService
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
public interface MediaResourcesService extends BaseService<MediaResources, MediaResourcesAO> {

    List<MediaResources> queryListById(MediaResourcesAO mediaResourcesAO);

    int deleteMediaResourcesById(Long id);

    int deleteByPrimaryKey(Long id);
}
