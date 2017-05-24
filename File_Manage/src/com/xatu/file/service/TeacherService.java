package com.xatu.file.service;



import javax.servlet.http.HttpServletRequest;

import com.xatu.file.bean.Teacher;
import com.xatu.file.bean.Teacher;
import com.xatu.file.common.db.DB;
import com.xatu.file.dao.TeacherDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TeacherService {
	TeacherDao dao= new TeacherDao();
	/**
	 * 老师登录
	 * @param Teahcer;
	 * @return json;
	 * 
	 * */
	public JSONObject login(Teacher Teacher){
		JSONObject json=null;
		Integer result = dao.login(Teacher);
		json.put("result", result);
		return json;
	}
	/**
	 * 老师注册
	 * @param Teahcer;
	 * @return json;
	 * 
	 * */
	public JSONObject regist(Teacher Teacher){
		JSONObject json=null;
		Integer result = dao.insertTeacher(Teacher);
		json.put("result", result);
		return json;
	}
	/**
	 * 更新老师
	 * @param Teacher
	 * */

	public JSONObject updateTeacher(Teacher Teacher){
		JSONObject json= new JSONObject();
		Integer result=dao.updateTeacher(Teacher);
		json.put("result", result);
		return json;		
	}
	/**
	 * 删除老师
	 * @param teacher_number
	 * */
	public JSONObject deleteTeacher(String teacher_number){
		JSONObject json = new JSONObject();
		Integer result = dao.deleteTeacher(teacher_number);
		json.put("result", result);
		return json;
	}
	/**
	 * 通过id获取Teacher对象
	 * @param  Teacher_number
	 * @return json
	 * */
	public JSONObject getTeacherById(String Teacher_number){
		JSONObject json= new JSONObject();
		Teacher result=dao.getTeacherById(Teacher_number);
		if(result!=null) json.put("result", result.getTeacher_number());
		return json;
	}
	/**
	 * 老师登陆验证
	 * @param request
	 * @return json
	 * 
	 * */
	public JSONObject login(HttpServletRequest request){
		JSONObject json = new JSONObject();
		String teacher_number= request.getParameter("userId");
		String password=request.getParameter("password");
		
		Teacher Teacher = new Teacher();
		Teacher.setTeacher_number(teacher_number);
		Teacher.setTeacher_password(password);
		Integer result = dao.login(Teacher);
		json.put("result", result);
		
		return json;
	}
	/**
	 * 用户注册
	 * @param request
	 * @return json
	 *
	 * */
	public JSONObject register(HttpServletRequest request){
		String  teacher_number= request.getParameter("tnumber");
		String teacher_password=request.getParameter("tpassword1");
		String teacher_name=request.getParameter("tname");
		String teacher_title=request.getParameter("ttile");
//		String teacher_duty=request.getParameter("tduty");
		String teacher_department=request.getParameter("tdepartment");
		String teacher_office=request.getParameter("toffice");
		String teacher_phone=request.getParameter("tphone");
		String teacher_telephone=request.getParameter("ttelephone");
		String teacher_email=request.getParameter("temail");
		String teacher_academy=request.getParameter("tacademy");
		
		Teacher Teacher = new Teacher();
		Teacher.setTeacher_number(teacher_number);
		Teacher.setTeacher_password(teacher_password);
		Teacher.setTeacher_name(teacher_name);
		Teacher.setTeacher_title(teacher_title);
//		Teacher.setTeacher_duty(teacher_duty);
		Teacher.setTeacher_department(teacher_department);
		Teacher.setTeacher_office(teacher_office);
		Teacher.setTeacher_phone(teacher_phone);
		Teacher.setTeacher_telephone(teacher_telephone);
		Teacher.setTeacher_email(teacher_email);
		Teacher.setTeacher_academy(teacher_academy);
		

		int result = dao.insertTeacher(Teacher);
		JSONObject json= new JSONObject();
		json.put("result", result);

		return json;
	}
	/**
	 * 分页查询老师
	 * @param TeacherObj
	 * @param pageSize
	 * @param pageIndex
	 * @param orderByName
	 * @param orderByRule
	 * @return
	 */
	public JSONArray getTeacherListByPage(JSONObject TeacherObj,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
		return dao.getTeacherListByPage(TeacherObj, pageSize, pageIndex, orderByName, orderByRule);
	}
	/**
	 * 后台添加teacher
	 * @param Teacher
	 * @return
	 */
	public JSONObject addTeacher(Teacher Teacher){
		JSONObject json= new JSONObject();
		Integer result=dao.insertTeacher(Teacher);
		json.put("result", result);
		return json;		
	}
	
}
