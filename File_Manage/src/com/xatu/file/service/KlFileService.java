package com.xatu.file.service;

import java.sql.SQLException;

import com.xatu.file.bean.KlFile;
import com.xatu.file.dao.KlfileDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class KlFileService {
	 KlfileDao dao= new KlfileDao();
	/**
	 * 文件上传
	 * @throws SQLException 
	 * 
	 * */
	 
	public JSONObject addFile(KlFile flfile){
		JSONObject json= new JSONObject();
		Integer result = dao.addFile(flfile);
		json.put("result", result);
		return json;
	}
	/**
	 * 通过uuid删除文件
	 * 要先删数据库，再删文件(此功能没写完！)
	 * **/
	public JSONObject deleteFile(String klfile_uuid){
		JSONObject json= new JSONObject();
		Integer result = dao.deleteFile(klfile_uuid);
		json.put("result", result);
		return json;
	}
	/**
	 * 通过uuid更新文件的描述
	 * **/
	public JSONObject updateFile(KlFile klfile){
		JSONObject json= new JSONObject();
		Integer result = dao.updateFile(klfile);
		json.put("result", result);
		return json;	
	}
	/***
	 * 通过文件名，文件描述模糊查找；
	 * **/
	public JSONObject getfileByName(String Name,String description){
		JSONObject json = new JSONObject();
		KlFile  result = dao.getfileByName(Name, description);
		if(result!=null) {
			json.put("name", result.getKlFile_fileName());
			json.put("author", result.getKlFile_author());
			json.put("descript", result.getKlfile_describtion());
		}
		return json;
	}
	public void updateDowns(Integer i,String klfile_uuid){
		dao.updateDowns(i, klfile_uuid);
	}	
	/**
	 * 分类查询
	 * @param FileObj
	 * @param file_class
	 * @param pageSize
	 * @param pageIndex
	 * @param orderByName
	 * @param orderByRule
	 * @return
	 */
	public JSONArray getFileListByPageC(JSONObject FileObj,String file_class,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
		return dao.getFileListByPageC(FileObj, file_class, pageSize, pageIndex, orderByName, orderByRule);
	}
//分类分类型查询
	public JSONArray getFileListByPageCT(JSONObject FileObj,String file_class,String file_type,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
		return dao.getFileListByPageCT(FileObj, file_class,file_type, pageSize, pageIndex, orderByName, orderByRule);
	}
	//全部查询
	public  JSONArray getFileListByPage(JSONObject FileObj,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
		return dao.getFileListByPage(FileObj, pageSize, pageIndex, orderByName, orderByRule);
	}
	public  JSONArray getFileListByPageND(JSONObject FileObj,String file_name,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
		return dao.getFileListByPageND(FileObj, file_name, pageSize, pageIndex, orderByName, orderByRule);
	}
	public JSONObject getFileByUuid(String klfile_uuid){
		JSONObject json= new JSONObject();
		KlFile result=dao.getFileByUuid(klfile_uuid);
		if(result!=null) json.put("klfile_savepath", result.getKlfile_savepath());
		return json;
	}
	 
}
