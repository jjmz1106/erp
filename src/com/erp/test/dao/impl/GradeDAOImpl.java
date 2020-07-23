package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Conn;
import com.erp.test.dao.GradeDAO;

public class GradeDAOImpl implements GradeDAO {

	@Override
	public int insertGrade(Map<String, Object> grade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGrade(Map<String, Object> grade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGrade(Map<String, Object> grade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectGrade(Map<String, Object> grade) {

		return null;
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		List<Map<String,Object>> gradeList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Conn.open();
			String sql = "select grd_no, grd_name, grd_desc from grade";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<>();
				map.put("grd_no",rs.getInt("grd_no"));
				map.put("grd_name",rs.getString("grd_name"));
				map.put("grd_desc",rs.getString("grd_desc"));
				gradeList.add(map);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close(rs.ps.con);
		}
		return gradeList;
	}

}
