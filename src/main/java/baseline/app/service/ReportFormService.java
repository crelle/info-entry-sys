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
}
