package crelle.family.service.impl;

import crelle.family.model.PageBean;
import crelle.family.model.ao.MenuAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

                Predicate predicate = criteriaBuilder.conjunction();
                //条件1
                if (StringUtils.isNotBlank(pageBean.getCondition().getName())) {
                    Predicate predicate1 = criteriaBuilder.equal(root.get("name"), pageBean.getCondition().getName());
                    predicate.getExpressions().add(predicate1);
                }
                //条件2
                Predicate predicate2 = criteriaBuilder.equal(root.get("requireAuth"), pageBean.getCondition().isRequireAuth());
                predicate.getExpressions().add(predicate2);
                //条件3
                Predicate predicate3 = criteriaBuilder.equal(root.get("enabled"), pageBean.getCondition().isEnabled());
                predicate.getExpressions().add(predicate3);

                return predicate;
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getPageNo()-1, pageBean.getPageSize(), Sort.by(Sort.Direction.ASC, "id"));
        Page<Menu> page = menuDao.findAll(specification, pageable);
        return page;
    }

    @Override
    public int update(Long id, Menu menu) {
        Optional<Menu> menuOpt = menuDao.findById(id);
        if (!menuOpt.isPresent()) {
            return 0;
        }
        Menu oldMenu = menuOpt.get();
        BeanUtils.copyProperties(menu, oldMenu, "id", "parentId", "childrenMenus", "parentMenu", "roles");
        menuDao.save(oldMenu);
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        menuDao.deleteById(id);
    }

    @Override
    public List<Menu> findMenusByName(String name) {
        return menuDao.findMenusByName(name);
    }
}
