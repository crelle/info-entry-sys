package baseline.app.service.impl;

import baseline.app.pojo.entity.Communicate;
import baseline.app.pojo.entity.Employee;
import baseline.app.mapper.EmployeeMapper;
import baseline.app.pojo.entity.StatusRecord;
import baseline.app.pojo.query.EmployeeQuery;
import baseline.app.pojo.vo.EmployeeVo;
import baseline.app.service.CommunicateService;
import baseline.app.service.EmployeeService;
import baseline.app.service.StatusRecordService;
import baseline.common.Interceptor.ExceptionInterceptor;
import baseline.common.enumeration.GenderEnum;
import baseline.common.exception.BusinessException;
import baseline.common.util.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-11-24 10:45:04
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StatusRecordService statusRecordService;

    @Autowired
    private CommunicateService communicateService;

    @Override
    public boolean create(Employee object) {
        validJobNo(object);
        try {
            return save(object);
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        } finally {
            return true;
        }

    }

    private boolean validJobNo(Employee object) {
        // 工号唯一
        List<Employee> employees = queryByEmpId(object.getJobNo());
        if (!employees.isEmpty()) {
            throw new BusinessException("员工工号已存在!");
        }
        return true;
    }

    @Override
    public boolean create(List<Employee> objects) {
        return saveBatch(objects);
    }

    @Transactional
    public void deleteById(String id) {
        removeById(id);
        List<StatusRecord> statusRecordList = statusRecordService
                .list()
                .stream()
                .filter(Objects::nonNull)
                .filter(statusRecord -> statusRecord.getJobNo().equals(id))
                .collect(Collectors.toList());

        if (!statusRecordList.isEmpty()) {
            for (StatusRecord statusRecord : statusRecordList) {
                statusRecordService.deleteById(statusRecord.getId());
            }
        }

        List<Communicate> communicateList = communicateService
                .list()
                .stream()
                .filter(Objects::nonNull)
                .filter(communicate -> communicate.getJobNo().equals(id))
                .collect(Collectors.toList());

        if (!communicateList.isEmpty()) {
            for (Communicate communicate : communicateList) {
                communicateService.deleteById(communicate.getId());
            }
        }
    }

    public void deleteByIds(List<String> ids) {
        removeByIds(ids);
    }

    @Override
    public boolean update(Employee object) {
        // 工号唯一
        List<Employee> employees = queryByEmpId(object.getJobNo());
        if (!object.getJobNo().equals(employees.get(0).getJobNo())) {
            return false;
        }
        return updateById(object);
    }

    @Override
    public Page<Employee> pageByCondition(Page<Employee> page) {
        Employee employee = page.getRecords().get(0);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(employee.getName()), Employee::getName, employee.getName())
                .like(StringUtils.isNotBlank(employee.getSkill()), Employee::getSkill, employee.getSkill());
        return page(page, lambdaQueryWrapper);
    }

    @Override
    public Page<EmployeeVo> manualPage(Page<EmployeeQuery> pageBean) {
        return null;
    }

    @Override
    public Employee queryById(String id) {
        return null;
    }

    public Page<EmployeeQuery> queryByCondition(@RequestBody Page<EmployeeQuery> pageBean) {
        EmployeeQuery employeeQuery = pageBean.getRecords().get(0);
        Page<EmployeeQuery> employeeQueryPage = new Page<>();
        return employeeMapper.queryByCondition(employeeQueryPage, employeeQuery);
    }

    public List<Employee> queryByEmpId(String id) {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.select().eq("job_no", id);
        return employeeMapper.selectList(wrapper);
    }

    public List<Employee> queryByIds(List<String> ids) {
        return null;
    }

    @Override
    public boolean importEmployee(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        //获取文件名
        String fileName = file.getOriginalFilename();
        try {
            if (!fileName.endsWith(".xlsx")) {
                throw new IllegalArgumentException("文件格式不正确！");
            }
            if (file.isEmpty()) {
                throw new Exception("文件为空！");
            }
            //根据路径获取这个操作excel的实例
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            //根据页面index 获取sheet页
            Sheet sheet = wb.getSheetAt(0);
            //获取sheet页共有多少行
            int totalRos = sheet.getPhysicalNumberOfRows();
            //获取第一行
            Row firstRow = sheet.getRow(0);
            //获取总列数
            int totalCell = firstRow.getLastCellNum();
            List<Employee> employees = new ArrayList<>();
            for (int i = 1; i < totalRos; i++) {
                //得到sheet的某一行
                Row row = sheet.getRow(i);
                Employee employee = new Employee();
                for (int j = 0; j < totalCell; j++) {
                    switch (j) {
                        case 0:
                            employee.setJobNo(row.getCell(j).toString());
                            break;
                        case 1:
                            employee.setName(row.getCell(j).toString());
                            break;
                        case 2:
                            employee.setGender(row.getCell(j).toString());
                            break;
                        case 3:
                            employee.setBirthday(CommonUtils.transferString2Date(row.getCell(j).toString()));
                            break;
                        case 4:
                            employee.setAge(Double.valueOf((row.getCell(j).toString())).intValue());
                            break;
                        case 5:
                            employee.setCellPhone(row.getCell(j).toString());
                            break;
                        case 6:
                            employee.setEmail(row.getCell(j).toString());
                            break;
                        case 7:
                            employee.setEducation(row.getCell(j).toString());
                            break;
                        case 8:
                            employee.setSchool(row.getCell(j).toString());
                            break;
                        case 9:
                            employee.setSchoolTime(CommonUtils.transferString2Date(row.getCell(j).toString()));
                            break;
                        case 10:
                            employee.setWorkingHours(Double.valueOf((row.getCell(j).toString())).intValue());
                            break;
                        case 11:
                            employee.setTime(CommonUtils.transferString2Date(row.getCell(j).toString()));
                            break;
                        default:
                            break;
                    }
                }
                valid(employee);
                employees.add(employee);
            }
            saveBatch(employees);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return true;
    }

    private void valid(Employee employee) {
        validJobNo(employee);
        if (StringUtils.isBlank(employee.getJobNo())) {
            throw new BusinessException("工号不存在!");
        }
        if (StringUtils.isBlank(employee.getCellPhone())) {
            throw new BusinessException("手机号不存在!");
        }
        if (StringUtils.isBlank(employee.getName())) {
            throw new BusinessException("姓名不存在!");
        }
    }
}
