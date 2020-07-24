package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.EmployeeDAO;
import com.erp.test.dao.impl.EmployeeDAOImpl;
import com.erp.test.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	@Override
	public Map<String, Object> insertEmployee(Map<String, Object> employee) {
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg", employeeDAO.insertEmployee(employee)==1?"입력성공":"입력실패");
		return rMap;
	}

	@Override
	public Map<String, Object> updateEmployee(Map<String, Object> employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteEmployee(Map<String, Object> employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> employee) {
		return employeeDAO.selectEmployee(employee);
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> employee) {
		return employeeDAO.selectEmployeeList(employee);
	}

}
