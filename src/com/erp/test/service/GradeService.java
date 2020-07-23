package com.erp.test.service;

import java.util.List;
import java.util.Map;

public interface GradeService {

		Map<String,Object> insertGrade(Map<String,Object> grade);
		Map<String,Object> updateGrade(Map<String,Object> grade);
		Map<String,Object> deleteGrade(int gNo);
		Map<String,Object> selectGrade(int gNo);
		List<Map<String,Object>> selectGradeList(Map<String,Object> grade);
}
