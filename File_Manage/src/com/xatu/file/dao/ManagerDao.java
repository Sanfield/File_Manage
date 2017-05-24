package com.xatu.file.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xatu.file.bean.Manager;
import com.xatu.file.bean.Student;
import com.xatu.file.common.db.DB;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ManagerDao {
/**
 * 根据id获取Manager
 * @param Manager_number
 * @return
 */
	public Manager getManagerById(String Manager_number){
		String sql="select*from Manager where Manager_number=?";
		Connection conn = DB.getconn();
		PreparedStatement stmt  = DB.getStatement(conn, sql);
		ResultSet rs=null;
		Manager  Manager=null;
		try{
			stmt.setString(1, Manager_number);
			rs=stmt.executeQuery();
			while(rs.next()){
				Manager= new Manager();
				getmanagerFromRs(Manager,rs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return Manager;
	}
/**
 * 
 * @param manager
 * @param rs
 * @throws SQLException
 */
	private void getmanagerFromRs(Manager manager,ResultSet rs) throws SQLException{
		manager.setManager_number(rs.getString("manager_number"));
		manager.setManager_password(rs.getString("manager_password"));
	}
	/**
	 * 用户登录校验
	 * @param Student_number
	 * */
	public Integer login(Manager manager){
		Integer result=0;//登陆变量(0:异常;1:成功;-1：用户不存在;-2:密码错误)
		String sql="select*from manager where manager_number=? and manager_password=?";
		Connection conn = DB.getconn();
		PreparedStatement stmt  = DB.getStatement(conn, sql);
		ResultSet rs=null;

		List<Manager> list= new ArrayList<Manager>();
		try{
			stmt.setString(1,manager.getManager_number());
			stmt.setString(2,manager.getManager_password());
			rs=stmt.executeQuery();
			while(rs.next()){
				manager= new Manager();
				getmanagerFromRs(manager,rs);
				list.add(manager);
			}
			if(list.size()==1){
				result=1;//用户名和密码校验成功
			}else{
				Manager  isStudent= getManagerById(manager.getManager_number());
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
	 * 增加管理员
	 * 
	 * */
	public Integer insertManager(Manager manager){

		String insertSQL="insert into manager(manager_number,manager_password)values"
				+ "(?,?)";
	 Connection conn = DB.getconn();
	PreparedStatement stmt= DB.getStatement(conn, insertSQL);
	Integer result=null;
	try{
		
		stmt.setString(1,manager.getManager_number());
		stmt.setString(2,manager.getManager_password());
		
		result=stmt.executeUpdate();
		
	}catch(SQLException  e){
		e.printStackTrace();
	}
	return result;
	}
/**
 * 得到管理员列表
 * @param ManagerObj
 * @param pageSize
 * @param pageIndex
 * @param orderByName
 * @param orderByRule
 * @return
 */
	public static JSONArray getManagerListByPage(JSONObject ManagerObj,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
	//	List<Role> list= new ArrayList();
		
		JSONArray jsonArray = new JSONArray();
		StringBuffer sql=new StringBuffer("SELECT *FROM manager where 1=1 ");
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
		json.put("manager_number", rs.getString("manager_number"));
		json.put("manager_password", rs.getString("manager_password"));
		jsonArray.add(json);
		}
		}catch(SQLException e){
		e.printStackTrace();
		}
		return jsonArray;
		
		}
}
