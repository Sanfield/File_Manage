package com.xatu.file.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xatu.file.bean.Student;
import com.xatu.file.bean.Student;
import com.xatu.file.common.db.DB;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class StudentDao {
	/**
	 * 根据用户ID获取用户信息
	 * @param Student_number
	 * */
	public Student getStudentById(String Student_number){
		String sql="select*from student where student_number=?";
		Connection conn = DB.getconn();
		PreparedStatement stmt  = DB.getStatement(conn, sql);
		ResultSet rs=null;
		Student  Student=null;
		try{
			stmt.setString(1, Student_number);
			rs=stmt.executeQuery();
			while(rs.next()){
				Student= new Student();
				getStudentFromRs(Student,rs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return Student;
	}
	/**
	 * 从rs获取student对象
	 * @param  student rs
	 * 
	 * */
	private void getStudentFromRs(Student Student,ResultSet rs) throws SQLException{
		Student.setStudent_number(rs.getString("student_number"));
		Student.setStudent_password(rs.getString("student_password"));
		Student.setStudent_name(rs.getString("student_name"));
		Student.setStudent_phone(rs.getString("student_phone"));
		Student.setStudent_email(rs.getString("student_email"));
		Student.setStudent_QQ(rs.getString("student_QQ"));
		Student.setStudent_weChat(rs.getString("student_weChat"));
	//	Student.setStudent_birthday(rs.getDate("student_brithday"));
		Student.setStudent_class(rs.getString("student_class"));
		Student.setStudent_academy(rs.getString("student_academy"));
	}
	/**
	 * 用户登录校验
	 * @param Student_number
	 * */
	public Integer login(Student Student){
		Integer result=0;//登陆变量(0:异常;1:成功;-1：用户不存在;-2:密码错误)
		String sql="select*from student where student_number=? and student_password=?";
		Connection conn = DB.getconn();
		PreparedStatement stmt  = DB.getStatement(conn, sql);
		ResultSet rs=null;

		List<Student> list= new ArrayList<Student>();
		try{
			stmt.setString(1, Student.getStudent_number());
			stmt.setString(2, Student.getStudent_password());
			rs=stmt.executeQuery();
			while(rs.next()){
				Student= new Student();
				getStudentFromRs(Student,rs);
				list.add(Student);
			}
			if(list.size()==1){
				result=1;//用户名和密码校验成功
			}else{
				Student  isStudent= getStudentById(Student.getStudent_number());
				if(isStudent==null){ 
					result=-1;//用户不存在
				}else{
					result=-2;//用户存在密码错误
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 增加用户
	 * 
	 * */
	public Integer insertStudent(Student Student){

		String insertSQL="insert into student(student_number,student_password,student_name,student_phone,student_email,student_QQ,student_weChat,student_brithday,student_class,student_academy,student_strongPoint,student_loginTime,student_lastTime,role)values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 Connection conn = DB.getconn();
	PreparedStatement stmt= DB.getStatement(conn, insertSQL);
	Integer result=null;
	try{
		
		stmt.setString(1, Student.getStudent_number());
		stmt.setString(2, Student.getStudent_password());
		stmt.setString(3,Student.getStudent_name());
		stmt.setString(4, Student.getStudent_phone());
		stmt.setString(5, Student.getStudent_email());
		stmt.setString(6, Student.getStudent_QQ()==null?" ":Student.getStudent_QQ());
		stmt.setString(7, Student.getStudent_weChat()==null?"":Student.getStudent_weChat());
		stmt.setDate(8, Student.getStudent_birthday()==null?new Date(0):Student.getStudent_birthday());
		stmt.setString(9, Student.getStudent_class()==null?"000":Student.getStudent_class());
		stmt.setString(10, Student.getStudent_academy()==null?"计算机学院":Student.getStudent_academy());
		stmt.setString(11, Student.getStudent_strongPoint()==null?"000":Student.getStudent_strongPoint());	
		stmt.setInt(12, Student.getStudent_loginTime()==0?0:Student.getStudent_loginTime());
		stmt.setDate(13, new Date(0));
		stmt.setString(14, Student.getRole()==null?"1":Student.getRole());
		
		result=stmt.executeUpdate();
		
	}catch(SQLException  e){
		e.printStackTrace();
	}
	return result;
	}
	/**
	 * 更新学生
	 * 
	 * 
	 * */
	public Integer updateStudent(Student Student){
		Integer result=0;
		String updateSQL="update student set student_name=?student_phone=?,student_email=?,student_QQ=?,student_weChat=?,student_brithday=?,student_class=?,student_academy=?,student_strongPoint=? where student_number=?";
	 Connection conn = DB.getconn();
	PreparedStatement stmt= DB.getStatement(conn, updateSQL);

	try{
		stmt.setString(1, Student.getStudent_name()==null?"":Student.getStudent_name());
		stmt.setString(2, Student.getStudent_phone()==null?"":Student.getStudent_phone());
		stmt.setString(3, Student.getStudent_email()==null?"":Student.getStudent_email());
		stmt.setString(4, Student.getStudent_QQ()==null?"":Student.getStudent_QQ());
		stmt.setString(5, Student.getStudent_weChat()==null?"":Student.getStudent_weChat());
		stmt.setDate(6, Student.getStudent_birthday()==null?new Date(0):Student.getStudent_birthday());
		stmt.setString(7, Student.getStudent_class()==null?"":Student.getStudent_class());
		stmt.setString(8, Student.getStudent_academy()==null?"":Student.getStudent_academy());
		stmt.setString(9, Student.getStudent_strongPoint()==null?"":Student.getStudent_strongPoint());
		
		stmt.setString(10, Student.getStudent_number());
		
		result=stmt.executeUpdate();
		
	}catch(SQLException  e){
		e.printStackTrace();
	}
	return result;
	}
	/**
	 * 删除用户
	 * @param student_number 用户id
	 * @return 操作对象
	 * */
	public Integer deleteStudent(String student_number){
		Integer result=0;
		String deleteSQL="delete student where student_number=?";
		//打开数据库
	 Connection conn = DB.getconn();
	 PreparedStatement stmt= DB.getStatement(conn, deleteSQL);

	 try{
		//给stmt对象赋值
		stmt.setString(1, student_number);
		//返回操作条数
		result=stmt.executeUpdate();
		
	}catch(SQLException  e){
		e.printStackTrace();
	}
	return result;
	}
	/**
	 * 分页查询学生
	 * @param StudentObj
	 * @param pageSize
	 * @param pageIndex
	 * @param orderByName
	 * @param orderByRule
	 * @return
	 */
	public static JSONArray getStudentListByPage(JSONObject StudentObj,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
	//	List<Role> list= new ArrayList();
		
		JSONArray jsonArray = new JSONArray();
		StringBuffer sql=new StringBuffer("SELECT *FROM student where 1=1 ");
	//	sql.append( "AND klfile_documentClassification LIKE'%"+file_class+"%'");
		sql.append("order by "+orderByName+" "+orderByRule);

		//根据传入的分页索引和分页显示数进行分页查询
		if(pageSize>0){
		Integer countFrom = pageSize*(pageIndex-1);
		Integer countTo=pageSize*pageIndex;
		sql.append(" limit "+countFrom+","+countTo);//指定数据段的数据
		}
		//按照指定排序规则进行排序查询
		
		//System.out.println(sql);
		Connection conn= DB.getconn();
		PreparedStatement stmt=  DB.getStatement(conn, sql.toString());
		ResultSet rs=null;		
		//Role Role;
		System.out.println(sql);
		try{
		rs=stmt.executeQuery();
		while(rs.next()){
		JSONObject json= new JSONObject();
		/**
		* 返回json格式
		*/
		json.put("student_number", rs.getString("student_number"));
		json.put("student_name", rs.getString("student_name"));
		json.put("student_email", rs.getString("student_email"));
		json.put("student_phone", rs.getString("student_phone"));
		jsonArray.add(json);
		}
		}catch(SQLException e){
		e.printStackTrace();
		}
		return jsonArray;
		
		}

}
