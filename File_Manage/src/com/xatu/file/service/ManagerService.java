package com.xatu.file.service;


import javax.servlet.http.HttpServletRequest;

import com.xatu.file.bean.Manager;
import com.xatu.file.bean.Manager;
import com.xatu.file.bean.Manager;
import com.xatu.file.bean.Manager;
import com.xatu.file.dao.ManagerDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ManagerService {
	ManagerDao dao = new ManagerDao();
	/**
	 * 
	 * @param Manager
	 * @return
	 */
	public JSONObject register(Manager Manager){
		JSONObject json= new JSONObject();
		Integer result=dao.insertManager(Manager);
		json.put("result", result);
		return json;		
	}
	/**
	 * 根据id返回json对象
	 * @param Manager_number
	 * @return
	 */
	public JSONObject getManagerById(String Manager_number){
		JSONObject json= new JSONObject();
		Manager result=dao.getManagerById(Manager_number);
		if(result!=null)
		{ 
			json.put("Manager_password", result.getManager_password());
			json.put("Manager_number", result.getManager_number());
		}
		return json;
	}
	/**
	 * 
	 * @param Manager
	 * @return
	 */
	public JSONObject login(Manager Manager){
		JSONObject json= new JSONObject();
		Integer result=dao.login(Manager);
		json.put("result", result);
		return json;
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	public JSONObject login(HttpServletRequest request){
		JSONObject json = new JSONObject();
		String Manager_id= request.getParameter("userId");
		String password=request.getParameter("password");
		
		Manager Manager = new Manager();
		Manager.setManager_number(Manager_id);;
		Manager.setManager_password(password);
		
		Integer result = dao.login(Manager);
		json.put("result", result);
		
		return json;
	}
	public  JSONArray getManagerListByPage(JSONObject ManagerObj,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
		return dao.getManagerListByPage(ManagerObj, pageSize, pageIndex, orderByName, orderByRule);
	}
	
}
