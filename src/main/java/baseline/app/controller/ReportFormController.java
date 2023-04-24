package baseline.app.controller;

import baseline.app.pojo.dto.reportform.EmployeeAgeDto;
import baseline.app.pojo.query.reportform.*;
import baseline.app.pojo.vo.reportform.*;
import baseline.app.service.ReportFormService;
import baseline.common.pojo.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "报表服务")
@RestController
@RequestMapping("/app/reportForm")
public class ReportFormController {

    @Autowired
    private ReportFormService reportFormService;

    @ApiOperation(value = "部门分析")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/departmentAnalysis", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<List<DepartmentAnalysisVO>> departmentAnalysis(@RequestBody DepartmentAnalysisQuery departmentAnalysisQuery) {
        ResponseResult responseResult = new ResponseResult<>();
        try {
            responseResult.setData(reportFormService.departmentAnalysis(departmentAnalysisQuery));
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }

    @ApiOperation(value = "项目缺口分析")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/projectGapAnalysis", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<List<ProjectGapAnalysisVO>> projectGapAnalysis(@RequestBody ProjectGapAnalysisQuery projectGapAnalysisQuery) {
        ResponseResult responseResult = new ResponseResult<>();
        try {
            responseResult.setData(reportFormService.projectGapAnalysis(projectGapAnalysisQuery));
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }

    @ApiOperation(value = "部门数量分析")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/projectNumberAnalysis", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<List<ProjectNumberAnalysisVO>> projectNumberAnalysis(@RequestBody ProjectNumberAnalysisQuery projectNumberAnalysisQuery) {
        ResponseResult responseResult = new ResponseResult<>();
        responseResult.setData(reportFormService.projectNumberAnalysis(projectNumberAnalysisQuery));
        return responseResult;
    }

    @ApiOperation(value = "区域分析")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/regionAnalysis", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<List<RegionAnalysisVO>> regionAnalysis(@RequestBody RegionAnalysisQuery regionAnalysisQuery) {
        ResponseResult responseResult = new ResponseResult<>();
        responseResult.setData(reportFormService.regionAnalysis(regionAnalysisQuery));
        return responseResult;
    }

    @ApiOperation(value = "技能分析")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/skillAnalysis", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<List<SkillAnalysisVO>> skillAnalysis(@RequestBody SkillAnalysisQuery skillAnalysisQuery) {
        ResponseResult responseResult = new ResponseResult<>();
        responseResult.setData(reportFormService.skillAnalysis(skillAnalysisQuery));
        return responseResult;
    }

    @ApiOperation(value = "员工分析")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/employeeAnalysis", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<List<SkillAnalysisVO>> employeeAnalysis(@RequestBody EmployeeAnalysisQuery employeeAnalysisQuery) {
        ResponseResult responseResult = new ResponseResult<>();
        try {
            responseResult.setData(reportFormService.employeeAnalysis(employeeAnalysisQuery));
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }

    @ApiOperation(value = "工龄分布")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/employeeSeniority", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<List<EmployeeSeniorityVO>> employeeSeniority(@RequestBody EmployeeSeniorityQuery employeeSeniorityQuery) {
        ResponseResult responseResult = new ResponseResult<>();
        try {
            List<EmployeeSeniorityVO> employeeSeniorityVOS = reportFormService.employeeSeniority(employeeSeniorityQuery);
            responseResult.setData(employeeSeniorityVOS);
            if (CollectionUtils.isNotEmpty(employeeSeniorityVOS)) {
                responseResult.setTotal(employeeSeniorityVOS.stream().map(EmployeeSeniorityVO::getNum).count());
            }
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }

    @ApiOperation(value = "年龄分布")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/employeeAge", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<List<EmployeeAgeVO>> employeeAge(@RequestBody EmployeeAgeQuery employeeAgeQuery) {
        ResponseResult responseResult = new ResponseResult<>();
        try {
            List<EmployeeAgeVO> employeeAgeVOS = reportFormService.employeeAge(employeeAgeQuery);
            responseResult.setData(employeeAgeVOS);
            if (CollectionUtils.isNotEmpty(employeeAgeVOS)) {
                responseResult.setTotal(employeeAgeVOS.stream().map(EmployeeAgeVO::getNum).count());
            }
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }

    @ApiOperation(value = "客户分布")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/employeeCustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<List<EmployeeCustomerVO>> employeeCustomer(@RequestBody EmployeeCustomerQuery employeeCustomerQuery) {
        ResponseResult responseResult = new ResponseResult<>();
        try {
            List<EmployeeCustomerVO> employeeCustomerVOS = reportFormService.employeeCustomer(employeeCustomerQuery);
            responseResult.setData(employeeCustomerVOS);
            if (CollectionUtils.isNotEmpty(employeeCustomerVOS)) {
                responseResult.setTotal(employeeCustomerVOS.stream().map(EmployeeCustomerVO::getEmployeeNum).count());
            }
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }

    @ApiOperation(value = "婚育和性别分布")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/employeeMarriageAndChildbirthAndSex", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<EmployeeMarriageAndChildbirthAndSexVO> employeeMarriageAndChildbirthAndSex(EmployeeMarriageAndChildbirthAndSexQuery employeeMarriageAndChildbirthAndSexQuery) {
        ResponseResult responseResult = ResponseResult.ok();
        try {
            EmployeeMarriageAndChildbirthAndSexVO employeeMarriageAndChildbirthAndSexVO = reportFormService.employeeMarriageAndChildbirth(employeeMarriageAndChildbirthAndSexQuery);
            responseResult.setData(employeeMarriageAndChildbirthAndSexVO);
            responseResult.setTotal(employeeMarriageAndChildbirthAndSexVO.getTotal());
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }
}
