package com.xatu.file.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xatu.file.service.StudentService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class StudentRegist
 */
@WebServlet("/StudentRegist")
public class StudentRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService StudentService = new StudentService();
		
		JSONObject json = StudentService.register(request);
		if(json.getInt("result")>0){
			request.getRequestDispatcher("/jsp/page/Login.jsp").forward(request, response);
		}else{
		PrintWriter out= response.getWriter();
		out.write("<div align='center'><font color='red'>注册失败联系管理员</font></div>");
		out.flush();
		out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
