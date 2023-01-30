package baseline.app.service.impl;

import baseline.app.mapper.ReportFormMapper;
import baseline.app.pojo.query.reportform.*;
import baseline.app.pojo.vo.reportform.*;
import baseline.app.service.ReportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportFormServiceImpl implements ReportFormService {

    @Autowired
    private ReportFormMapper reportFormMapper;

    @Override
    public List<DepartmentAnalysisVO> departmentAnalysis(DepartmentAnalysisQuery departmentAnalysisQuery) {
        return null;
    }

    @Override
    public List<ProjectGapAnalysisVO> projectGapAnalysis(ProjectGapAnalysisQuery projectGapAnalysisQuery) {
        return null;
    }

    @Override
    public List<ProjectNumberAnalysisVO> projectNumberAnalysis(ProjectNumberAnalysisQuery projectNumberAnalysisQuery) {
        return null;
    }

    @Override
    public List<RegionAnalysisVO> regionAnalysis(RegionAnalysisQuery regionAnalysisQuery) {
        return null;
    }

    @Override
    public List<SkillAnalysisVO> skillAnalysis(SkillAnalysisQuery skillAnalysisQuery) {
        return null;
    }
}
