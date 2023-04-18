package baseline.app.service.impl;

import baseline.app.pojo.entity.Communicate;
import baseline.app.pojo.entity.Employee;
import baseline.app.mapper.EmployeeMapper;
import baseline.app.pojo.entity.StatusRecord;
import baseline.app.pojo.query.EmployeeQuery;
import baseline.app.pojo.dto.reportform.EmployeeDto;
import baseline.app.pojo.vo.EmployeeVo;
import baseline.app.service.CommunicateService;
import baseline.app.service.EmployeeService;
import baseline.app.service.StatusRecordService;
import baseline.common.exception.BusinessException;
import baseline.common.util.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static baseline.common.util.FileUtil.writeDataToWorkbook;
import static java.util.stream.Collectors.toList;

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

    //工号 纯数字 六位
    public static final String jobNoPattern = "^\\d{6}$";
    //姓名校验 6-10位字母、数字、下划线  不能以数字开头
    public static final String namePattern = "^[^0-9][\\w_]{6,10}$";
    //性别校验
    public static final String genderPattern = "^[男|女]$";
    //联系电话校验
    public static final String cellPhonePattern = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    //电子邮箱校验
    public static final String emailPattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    //最高学历校验
    public static final String educationPattern = "^[专科|本科|硕士研究生|博士研究生]$";
    //毕业院校校验 中文、英文、数字包括下划线
    public static final String schoolPattern = "^[\\u4E00-\\u9FA5A-Za-z0-9_]+{0,255}$";
    //工作年限校验 [0-100]含0和100
    public static final String workingHoursPattern = "^([0-9][0-9]{0,1}|100)$";
    // 新版Excel文件后缀
    private static final String EXCEL_SUFFIX = ".xlsx";
    //表名
    private static final String fileName = "诚迈员工信息";
    //模板名
    private static final String fileNameTemplate = "诚迈员工信息(模板)";
    //导出的excle地址
    private static final String fileAddress = "D:\\360MoveData\\Users\\zhangjin98\\Desktop\\";

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
            throw new BusinessException("员工工号:" + object.getJobNo() + "已存在!");
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
                .collect(toList());

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
                .collect(toList());

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
    public String importEmployee(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        //获取文件名
        String fileName = file.getOriginalFilename();
        List<Employee> employees = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                throw new Exception("文件为空！");
            }
            if (fileName != null && !fileName.endsWith(".xlsx")) {
                throw new IllegalArgumentException("文件格式不正确！");
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
            for (int i = 1; i < totalRos; i++) {
                //得到sheet的某一行
                Row row = sheet.getRow(i);
                Employee employee = new Employee();
                //员工信息赋值
                setEmployInfo(totalCell, row, employee);
                //跳过excle中空行
                if (validNullEmploy(employee)) {
                    continue;
                }
                //校验每个员工信息
                valid(i, employee);
                employees.add(employee);
            }
            validExcleJobNo(employees);
            saveBatch(employees);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return "成功插入了" + employees.size() + "条员工信息";

    }

    @Override
    public String purchaseOrderSubExport(HttpServletRequest request, HttpServletResponse response, Employee param) throws Exception {
        // 查询需要导出的数据（业务逻辑查询）
        List<Employee> purchaseOrderSubVOList = list();
        if (CollectionUtils.isEmpty(purchaseOrderSubVOList)) {
            return null;
        }
        // 导出excel逻辑处理
        buildExcel(purchaseOrderSubVOList,fileName);
        return "导出成功! 文件存放在:"+fileAddress;
    }

    @Override
    public String downloadTemplate(HttpServletRequest request, HttpServletResponse response, Employee param) throws Exception {
        // 查询需要导出的数据（业务逻辑查询）
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();

        employees.add(employee);
        // 导出excel逻辑处理
        buildExcel(employees,fileNameTemplate);
        return "导出成功! 文件存放在:"+fileAddress;
    }

    /**
     * 导出excel逻辑处理
     *
     * @param employees response
     */
    private void buildExcel( List<Employee> employees,String fileName) throws Exception {
        List<String> headers = Arrays.asList("工号",
                "员工姓名",
                "性别",
                "出生年月",
                "年龄",
                "联系电话",
                "电子邮箱",
                "最高学历",
                "毕业院校",
                "毕业时间",
                "工作年限",
                "入职时间");
        List<Map<String, Object>> datas = new ArrayList<>();
        for (Employee employee : employees) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("getJobNo", employee.getJobNo());
            map.put("getName", employee.getName());
            map.put("getGender", employee.getGender());
            map.put("getBirthday", employee.getBirthday());
            map.put("getAge", employee.getAge());
            map.put("getCellPhone", employee.getCellPhone());
            map.put("getEmail", employee.getEmail());
            map.put("getEducation", employee.getEducation());
            map.put("getSchool", employee.getSchool());
            map.put("getSchoolTime", employee.getSchoolTime());
            map.put("getWorkingHours", employee.getWorkingHours());
            map.put("getTime", employee.getTime());
            datas.add(map);
        }
        XSSFWorkbook wb = writeDataToWorkbook(fileName, headers, datas);

        try {
            File file = new File(fileAddress + fileName + EXCEL_SUFFIX);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            wb.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }



    private void setEmployInfo(int totalCell, Row row, Employee employee) {
        for (int j = 0; j < totalCell; j++) {
            if (row.getCell(j) == null) {
                continue;
            }
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
    }

    private boolean validNullEmploy(Employee employee) {
        return StringUtils.isBlank(employee.getJobNo()) &&
                StringUtils.isBlank(employee.getName()) &&
                StringUtils.isBlank(employee.getGender()) &&
                StringUtils.isBlank(employee.getCellPhone()) &&
                StringUtils.isBlank(employee.getEmail()) &&
                StringUtils.isBlank(employee.getEducation()) &&
                StringUtils.isBlank(employee.getSchool());
    }

    private void validExcleJobNo(List<Employee> employees) {
        List<String> newJobNos = employees
                .stream()
                .map(Employee::getJobNo)
                .distinct()
                .collect(toList());
        List<String> excJobNos = employees
                .stream()
                .map(Employee::getJobNo)
                .collect(toList());
        List<String> reduce2 = excJobNos.stream().filter(item -> !newJobNos.contains(item)).collect(toList());
        if (!reduce2.isEmpty()) {
            throw new BusinessException("excle表中" + reduce2 + "工号重复!");
        }
    }

    private void valid(Integer i, Employee employee) {
        validJobNo(employee);
        if (StringUtils.isBlank(employee.getJobNo())) {
            throw new BusinessException("表中第" + (i - 1) + "员工工号不存在!");
        }
        if (StringUtils.isBlank(employee.getCellPhone())) {
            throw new BusinessException("表中第" + (i - 1) + "员工手机号不存在!");
        }
        if (StringUtils.isBlank(employee.getName())) {
            throw new BusinessException("表中第" + (i - 1) + "员工姓名不存在!");
        }
        //工号校验
        if (getMatcher(employee.getJobNo(), jobNoPattern)) {
            throw new BusinessException("表中第" + (i - 1) + "员工工号需为六位纯数字!");
        }
        //姓名校验
        if (getMatcher(employee.getName(), namePattern)) {
            throw new BusinessException("表中第" + (i - 1) + "员工工号需为六位纯数字!");
        }
        //性别校验
        if (getMatcher(employee.getGender(), genderPattern)) {
            throw new BusinessException("表中第" + (i - 1) + "员工性别格式不正确!");
        }
        //出生年月
        if (employee.getBirthday() == null || checkBirthday(employee.getBirthday())) {
            throw new BusinessException("表中第" + (i - 1) + "员工未成年!");
        }
        //年龄校验
        if (employee.getAge() < 18) {
            throw new BusinessException("表中第" + (i - 1) + "员工未成年!");
        }
        //联系电话校验
        if (getMatcher(employee.getCellPhone(), cellPhonePattern)) {
            throw new BusinessException("表中第" + (i - 1) + "员工联系电话格式不正确!");
        }
        //电子邮箱校验
        if (getMatcher(employee.getEmail(), emailPattern)) {
            throw new BusinessException("表中第" + (i - 1) + "员工电子邮箱格式不正确!");
        }
        //最高学历校验
        if (getMatcher(employee.getEducation(), educationPattern)) {
            throw new BusinessException("表中第" + (i - 1) + "员工最高学历格式不正确!");
        }
        //毕业院校校验
        if (getMatcher(employee.getSchool(), schoolPattern)) {
            throw new BusinessException("表中第" + (i - 1) + "员工毕业院校格式不正确!");
        }
        //毕业时间校验
        if (employee.getSchoolTime() == null) {
            throw new BusinessException("表中第" + (i - 1) + "员工毕业时间不正确!");
        }
        //工作年限校验
        if (getMatcher(employee.getWorkingHours().toString(), workingHoursPattern)) {
            throw new BusinessException("表中第" + (i - 1) + "员工工作年限格式不正确!");
        }
        //入职时间校验
        if (employee.getTime() == null || employee.getTime().after(new Date())) {
            throw new BusinessException("表中第" + (i - 1) + "员工入职时间不正确!");
        }
    }

    private static boolean getMatcher(String employee, String patternStr) {
        //一个Pattern对象和一个正则表达式相关联
        Pattern pattern = Pattern.compile(patternStr);
        //一个Matcher对象和一个具体的字符串相关联，表示在指定模式下与这个字符串匹配
        Matcher matcher = pattern.matcher(employee);
        // 匹配返回true
        return matcher.matches();
    }

    public static boolean checkBirthday(Date date) {
        Calendar current = Calendar.getInstance();
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTime(date);
        int year = current.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        if (year > 18) {
            return true;
        } else if (year < 18) {
            return false;
        }
        // 如果年相等，就比较月份
        int month = current.get(Calendar.MONTH) - birthDay.get(Calendar.MONTH);
        if (month > 0) {
            return true;
        } else if (month < 0) {
            return false;
        }
        // 如果月也相等，就比较天
        int day = current.get(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH);
        return day >= 0;
    }
}
