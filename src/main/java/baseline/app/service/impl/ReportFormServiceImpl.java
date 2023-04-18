package baseline.app.service.impl;

import baseline.app.mapper.ReportFormMapper;
import baseline.app.pojo.dto.reportform.EmployeeAnalysisDto;
import baseline.app.pojo.query.reportform.*;
import baseline.app.pojo.vo.reportform.*;
import baseline.app.service.ReportFormService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<EmployeeAnalysisVO> employeeAnalysis(EmployeeAnalysisQuery employeeAnalysisQuery) {
        List<EmployeeAnalysisDto> employeeAnalysisDtos = reportFormMapper.employeeAnalysis(employeeAnalysisQuery);
        if (CollectionUtils.isEmpty(employeeAnalysisDtos)) {
            return null;
        }
        List<EmployeeAnalysisVO> list = new ArrayList<>(employeeAnalysisDtos.size());
        employeeAnalysisDtos.forEach(employeeAnalysisDto -> {
            EmployeeAnalysisVO employeeAnalysisVO = new EmployeeAnalysisVO();
            BeanUtils.copyProperties(employeeAnalysisDto, employeeAnalysisVO);
            List<String> value = new ArrayList<>(2);
            value.add(employeeAnalysisDto.getLongitude());
            value.add(employeeAnalysisDto.getLatitude());
            employeeAnalysisVO.setValue(value);
            list.add(employeeAnalysisVO);
        });
        return list;
    }
}
