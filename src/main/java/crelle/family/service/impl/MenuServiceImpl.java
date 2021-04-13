package crelle.family.service.impl;

import crelle.family.model.PageBean;
import crelle.family.model.ao.MenuAO;
import crelle.family.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import crelle.family.dao.MenuDao;
import crelle.family.model.entity.Menu;
import crelle.family.service.MenuService;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author:crelle
 * @className:MenuServiceImpl
 * @version:1.0.0
 * @date:2021/3/22
 * @description:XX
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;


    @Override
    public Menu create(Menu role) {
        return menuDao.save(role);
    }

    @Override
    public Menu queryById(Long id) {
        return menuDao.findById(id).get();
    }

    @Override
    public List<Menu> queryAll() {
        return menuDao.findAll();
    }

    @Override
    public Page<Menu> pageByCondition(PageBean<MenuAO> pageBean) {
        Specification<Menu> specification = new Specification<Menu>() {
            @Override
            public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //条件1
                Predicate predicate1 = null;
                if (StringUtils.isNotBlank(pageBean.getCondition().getName())) {
                    predicate1 = criteriaBuilder.equal(root.get("name"), pageBean.getCondition().getName());
                }
                //条件3
                Predicate predicate2 = criteriaBuilder.equal(root.get("requireAuth"), pageBean.getCondition().isRequireAuth());
                //条件4
                Predicate predicate3 = criteriaBuilder.equal(root.get("enabled"), pageBean.getCondition().isEnabled());
                criteriaQuery.where(predicate1, predicate2, predicate3);
                return null;
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getPageNo(), pageBean.getPageSize(), Sort.by(Sort.Direction.ASC, "id"));
        Page<Menu> page = menuDao.findAll(specification, pageable);
        return page;
    }

    @Override
    public int update(Long id, Menu menu) {
        if (null == menuDao.findById(id)) {
            return 0;
        }
        menuDao.save(menu);
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        menuDao.deleteById(id);
    }
}
