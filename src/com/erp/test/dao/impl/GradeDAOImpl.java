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
import com.sun.jdi.connect.Connector;

public class GradeDAOImpl implements GradeDAO {

	@Override
	public int insertGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "insert into grade(grd_no, grd_name, grd_desc)";
			sql += "values(seq_grade_grd_no.nextval,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, grade.get("grd_name").toString());
			ps.setString(2, grade.get("grd_desc").toString());
			result = ps.executeUpdate();
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close(rs.ps.con);
		}
		return result;
	}

	@Override
	public int updateGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "update grade";
			sql += " set grd_name=?,";
			sql += " grd_desc=?,";
			sql += " where grd_no=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, grade.get("grd_name").toString());
			ps.setString(2, grade.get("grd_desc").toString());
			ps.setInt(4, (int)grade.get("grd_no"));
			result = ps.executeUpdate();
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close(rs.ps.con);
		}
		return result;
	}

	@Override
	public int deleteGrade(int gNo) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "delete from grade where grd_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, gNo);
			result = ps.executeUpdate();
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close(rs.ps.con);
		}
		return result;
	}

	@Override
	public Map<String, Object> selectGrade(int gNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Conn.open();
			String sql = "select grd_no, grd_name, grd_desc from grade where grd_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, gNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,Object> map = new HashMap<>();
				map.put("grd_no",rs.getInt("grd_no"));
				map.put("grd_name",rs.getString("grd_name"));
				map.put("grd_desc",rs.getString("grd_desc"));
				return map;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close(rs.ps.con);
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		List<Map<String,Object>> gradeList = new ArrayList<Map<String,Object>>();
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
			con.close(rs.ps.con);
		}
		return gradeList;
	}

}
