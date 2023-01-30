package baseline.app.mapper;

import baseline.app.pojo.query.reportform.*;
import baseline.app.pojo.vo.reportform.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportFormMapper {


    DepartmentAnalysisVO departmentAnalysis(DepartmentAnalysisQuery departmentAnalysisQuery);

    ProjectGapAnalysisVO projectGapAnalysis(ProjectGapAnalysisQuery projectGapAnalysisQuery);

    ProjectNumberAnalysisVO projectNumberAnalysis(ProjectNumberAnalysisQuery projectNumberAnalysisQuery);

    RegionAnalysisVO regionAnalysis(RegionAnalysisQuery regionAnalysisQuery);

    SkillAnalysisVO skillAnalysis(SkillAnalysisQuery skillAnalysisQuery);
}
