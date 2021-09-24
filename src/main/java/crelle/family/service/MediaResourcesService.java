package crelle.family.service;

import crelle.family.model.PageBean;
import crelle.family.model.ao.MediaResourcesAO;
import crelle.family.model.entity.MediaResources;
import crelle.family.service.BaseService;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author:crelle
 * @className:MediaResourcesService
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
public interface MediaResourcesService extends BaseService<MediaResources, MediaResourcesAO> {

    int deleteMediaResourcesById(Long id);

    int deleteByPrimaryKey(Long id);

}
