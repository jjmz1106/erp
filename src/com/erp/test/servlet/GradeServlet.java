package com.erp.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.GradeService;
import com.erp.test.service.impl.GradeServiceImpl;

public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
	private GradeService gradeService = new GradeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/grade/grade-list".equals(uri)) {
			request.setAttribute("gradeList", gradeService.selectGradeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade-list");
			rd.forward(request, response);
			return;
		}
		if("/grade/grade-view".equals(uri)) {
			int gNo = Integer.parseInt(request.getParameter("ged_no"));
			request.setAttribute("grade", gradeService.selectGrade(gNo));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade-view");
			rd.forward(request, response);
			return;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if("/grade/grade-insert".equals(uri)) {
			String gName = request.getParameter("grd_name");
			String gDesc = request.getParameter("grd_desc");
			int gNo = Integer.parseInt(request.getParameter("grd_no"));
			Map<String,Object> grade = new HashMap<>();
			grade.put("grd_name",gName);
			grade.put("grd_desc",gDesc);
			grade.put("grd_no",gNo);
			doProcess(response,gradeService.updateGrade(grade).toString());
			return;
		}
	}
	private void doProcess(HttpServletResponse response, String str) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(str);
	}

}
