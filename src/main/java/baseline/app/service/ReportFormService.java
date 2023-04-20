package baseline.app.service;

import baseline.app.pojo.query.reportform.*;
import baseline.app.pojo.vo.reportform.*;

import java.util.List;

/**
 * 报表服务
 */
public interface ReportFormService {

    List<DepartmentAnalysisVO> departmentAnalysis(DepartmentAnalysisQuery departmentAnalysisQuery);

    List<ProjectGapAnalysisVO> projectGapAnalysis(ProjectGapAnalysisQuery projectGapAnalysisQuery);

    List<ProjectNumberAnalysisVO> projectNumberAnalysis(ProjectNumberAnalysisQuery projectNumberAnalysisQuery);

    List<RegionAnalysisVO> regionAnalysis(RegionAnalysisQuery regionAnalysisQuery);

    List<SkillAnalysisVO> skillAnalysis(SkillAnalysisQuery skillAnalysisQuery);

    List<EmployeeAnalysisVO> employeeAnalysis(EmployeeAnalysisQuery employeeAnalysisQuery);

    /**
     * 员工工龄分布
     * @param employeeSeniorityQuery
     * @return
     */
    List<EmployeeSeniorityVO>  employeeSeniority( EmployeeSeniorityQuery employeeSeniorityQuery);

    /**
     * 员工年龄分布
     * @param employeeAgeQuery
     * @return
     */
    List<EmployeeAgeVO> employeeAge(EmployeeAgeQuery employeeAgeQuery);
}
