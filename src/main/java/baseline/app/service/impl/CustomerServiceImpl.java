package baseline.app.service.impl;

import baseline.app.mapper.ContactPersonMapper;
import baseline.app.mapper.CustomerMapper;
import baseline.app.mapper.PostMapper;
import baseline.app.pojo.entity.Customer;
import baseline.app.pojo.query.CustomerQuery;
import baseline.app.pojo.vo.CustomerVo;
import baseline.app.service.CustomerService;
import baseline.common.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ContactPersonMapper contactPersonMapper;

    @Autowired
    private PostMapper postMapper;

    @Override
    public boolean create(Customer object) {
        return save(object);
    }

    @Override
    public boolean create(List<Customer> objects) {
        return saveBatch(objects);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(String id) {
        if (CollectionUtils.isNotEmpty(contactPersonMapper.queryByCustomerId(id))) {
            throw new BusinessException("客户下面有接口人,无法删除");
        }

        if (CollectionUtils.isNotEmpty(postMapper.queryByCustomerId(id))) {
            throw new BusinessException("客户下面有岗位，无法删除");
        }
        removeById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        removeByIds(ids);
    }

    @Override
    public boolean update(Customer object) {
        return updateById(object);
    }

    @Override
    public Page<Customer> pageByCondition(Page<Customer> page) {
        Customer customer = page.getRecords().get(0);
        LambdaQueryWrapper<Customer> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNotBlank(customer.getName()), Customer::getName, customer.getName())
                .like(StringUtils.isNotBlank(customer.getRegionId()), Customer::getRegionId, customer.getRegionId())
                .like(StringUtils.isNotBlank(customer.getUserId()), Customer::getUserId, customer.getUserId())
                .orderByDesc(Customer::getUpdateTime);

        return page(page, queryWrapper);

    }

    @Override
    public Page<CustomerVo> manualPage(Page<CustomerQuery> pageBean) {
        CustomerQuery customerQuery = pageBean.getRecords().get(0);
        Page<CustomerVo> page = new Page<>();
        List<CustomerVo> list = customerMapper.manualPage(customerQuery);
        PageInfo<CustomerVo> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        page.setRecords(list);
        return page;
    }

    @Override
    public Customer queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Customer> queryByIds(List<String> ids) {
        return null;
    }
}
