package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.GradeDAO;
import com.erp.test.dao.impl.GradeDAOImpl;
import com.erp.test.service.GradeService;

public class GradeServiceImpl implements GradeService {
	private GradeDAO gradeDAO = new GradeDAOImpl();
	@Override
	public Map<String, Object> insertGrade(Map<String, Object> grade) {
		int result = gradeDAO.insertGrade(grade);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "직급등록 완료~");
		if(result!=1) {
			rMap.put("msg", "직급등록 오류!");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateGrade(Map<String, Object> grade) {
		int result = gradeDAO.updateGrade(grade);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "직급수정 완료~");
		if(result!=1) {
			rMap.put("msg", "직급수정 오류!");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteGrade(int gNo) {
		int result = gradeDAO.deleteGrade(gNo);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "직급삭제 완료~");
		if(result!=1) {
			rMap.put("msg", "직급삭제 오류!");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> selectGrade(int gNo) {
		return gradeDAO.selectGrade(gNo);
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		return gradeDAO.selectGradeList(grade);
	}


}
