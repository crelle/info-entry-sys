package crelle.family.service.impl;

import crelle.family.mapper.MediaResourcesMapper;
import crelle.family.model.PageBean;
import crelle.family.model.ao.MediaResourcesAO;
import crelle.family.model.entity.MediaResources;
import crelle.family.service.MediaResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:crelle
 * @className:MediaResourcesImpl
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
@Service
public class MediaResourcesServiceImpl implements MediaResourcesService {
    @Autowired
    MediaResourcesMapper mediaResourcesMapper;

    @Override
    public MediaResources create(MediaResources mediaResources) {
        MediaResources mediaResources1 = mediaResources;
        try {
            mediaResourcesMapper.create(mediaResources);
        } catch (Exception e) {
            mediaResources1 = null;
        }
        return mediaResources;
    }

    @Override
    public MediaResources queryById(Long id) {
        return null;
    }

    @Override
    public List<MediaResources> queryListById(MediaResourcesAO mediaResourcesAO) {
        return mediaResourcesMapper.queryMediaResourcesById(mediaResourcesAO);
    }


    @Override
    public List<MediaResources> queryAll() {
        return null;
    }

    @Override
    public Page<MediaResources> pageByCondition(PageBean<MediaResourcesAO> pageBean) {
        return null;
    }

    @Override
    public int update(Long id, MediaResources obj) {
        return mediaResourcesMapper.updateMediaResourcesById(obj);
    }

    @Override
    public int deleteMediaResourcesById(Long id) {
        return mediaResourcesMapper.deleteById(id);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mediaResourcesMapper.deleteByPrimaryKey(id);
    }


    @Override
    public void deleteById(Long id) {
    }


}
