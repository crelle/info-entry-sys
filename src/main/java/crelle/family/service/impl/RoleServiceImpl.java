package crelle.family.service.impl;

import crelle.family.dao.RoleDao;
import crelle.family.model.PageBean;
import crelle.family.model.ao.RoleAO;
import crelle.family.model.entity.Menu;
import crelle.family.model.entity.Role;
import crelle.family.service.BaseService;
import crelle.family.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author:crelle
 * @className:RoleServiceImpl
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role create(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role queryById(Long id) {
        return roleDao.findById(id).get();
    }


    @Override
    public List<Role> queryAll() {
        return roleDao.findAll();
    }

    @Override
    public Page<Role> pageByCondition(PageBean<RoleAO> pageBean) {
        Specification<Role> specification = new Specification<Role>() {
            @Override
            public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Predicate predicate = criteriaBuilder.conjunction();
                //条件1
                if (StringUtils.isNotBlank(pageBean.getCondition().getName())) {
                    Predicate predicate1 = criteriaBuilder.equal(root.get("name"), pageBean.getCondition().getName());
                    predicate.getExpressions().add(predicate1);
                }
                //条件2
                if (StringUtils.isNotBlank(pageBean.getCondition().getNameZh())) {
                    Predicate predicate2 = criteriaBuilder.equal(root.get("nameZh"), pageBean.getCondition().getNameZh());
                    predicate.getExpressions().add(predicate2);
                }
                return predicate;
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getPageNo(), pageBean.getPageSize(), Sort.by(Sort.Direction.ASC, "id"));
        Page<Role> page = roleDao.findAll(specification, pageable);
        return page;
    }

    @Override
    public int update(Long id, Role role) {
        try {
            roleDao.save(role);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        roleDao.deleteById(id);
    }

    @Override
    public Set<Role> findRolesByName(String name) {
        return roleDao.findRolesByName(name);
    }

}
