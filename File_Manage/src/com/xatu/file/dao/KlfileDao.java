package com.xatu.file.dao;

import java.sql.Connection;
import java.util.Date; 
import java.util.Calendar; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.xatu.file.bean.KlFile;
import com.xatu.file.bean.Student;
import com.xatu.file.common.db.DB;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class KlfileDao {
	/**分类查询
	 * @param FileObj
	 * @param file_class
	 * @param pageSize
	 * @param pageIndex
	 * @param orderByName
	 * @param orderByRule
	 * @return
	 */
	public static JSONArray getFileListByPageC(JSONObject FileObj,String file_class,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
	//	List<Role> list= new ArrayList();
		
		JSONArray jsonArray = new JSONArray();
		StringBuffer sql=new StringBuffer("SELECT *FROM klfile where 1=1 ");
		sql.append(file_class);
		sql.append(" order by "+orderByName+" "+orderByRule);
		//如果用户姓名不为空增加过滤条件
		if(FileObj.get("klfile_fileName")!=null){
		sql.append("and klfile_fileName like ?");//模糊匹配
		}
		//如果用过户性别不为空增加过滤条件
		if(FileObj.get("klfile_author")!=null){
		sql.append("and klfile_author=?");
		}
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
		json.put("klfile_fileName", rs.getString("klfile_fileName"));
		json.put("klfile_author", rs.getString("klfile_author"));
		json.put("klfile_describtion", rs.getString("klfile_describtion"));
		json.put("klfile_uploadingTime", rs.getTimestamp("klfile_uploadingTime").toString().substring(0,19));
		json.put("klfile_fileSize", rs.getString("klfile_fileSize"));
		json.put("klfile_downloads", rs.getInt("klfile_downloads"));
		json.put("klfile_uuid", rs.getString("klfile_uuid"));
		jsonArray.add(json);
		}
		}catch(SQLException e){
		e.printStackTrace();
		}
		return jsonArray;
		
		}
	/**
	 * 分类分文件类型查询
	 * @param FileObj
	 * @param file_class
	 * @param file_type
	 * @param pageSize
	 * @param pageIndex
	 * @param orderByName
	 * @param orderByRule
	 * @return
	 */
	public static JSONArray getFileListByPageCT(JSONObject FileObj,String file_class,String file_type,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
	//	List<Role> list= new ArrayList();
		
		JSONArray jsonArray = new JSONArray();
		StringBuffer sql=new StringBuffer("SELECT *FROM klfile where 1=1 ");
		sql.append( "AND klfile_documentClassification LIKE'%"+file_class+"%'");
		sql.append(file_type);
		sql.append(" order by "+orderByName+" "+orderByRule);
		//如果用户姓名不为空增加过滤条件
		if(FileObj.get("klfile_fileName")!=null){
		sql.append("and klfile_fileName like ?");//模糊匹配
		}
		//如果用过户性别不为空增加过滤条件
		if(FileObj.get("klfile_author")!=null){
		sql.append("and klfile_author=?");
		}
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
		json.put("klfile_fileName", rs.getString("klfile_fileName"));
		json.put("klfile_author", rs.getString("klfile_author"));
		json.put("klfile_describtion", rs.getString("klfile_describtion"));
		json.put("klfile_uploadingTime", rs.getTimestamp("klfile_uploadingTime").toString().substring(0,19));
		json.put("klfile_fileSize", rs.getString("klfile_fileSize"));
		json.put("klfile_downloads", rs.getInt("klfile_downloads"));
		json.put("klfile_uuid", rs.getString("klfile_uuid"));
		jsonArray.add(json);
		}
		}catch(SQLException e){
		e.printStackTrace();
		}
		return jsonArray;
		
		}	
	/**
	 * 
	 * @param FileObj
	 * @param pageSize
	 * @param pageIndex
	 * @param orderByName
	 * @param orderByRule
	 * @return
	 */
	public static JSONArray getFileListByPage(JSONObject FileObj,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
	//	List<Role> list= new ArrayList();
		
		JSONArray jsonArray = new JSONArray();
		StringBuffer sql=new StringBuffer("SELECT *FROM klfile where 1=1 ");
	//	sql.append( "AND klfile_documentClassification LIKE'%"+file_class+"%'");
		sql.append("order by "+orderByName+" "+orderByRule);
		//如果用户姓名不为空增加过滤条件
		if(FileObj.get("klfile_fileName")!=null){
		sql.append("and klfile_fileName like ?");//模糊匹配
		}
		//如果用过户性别不为空增加过滤条件
		if(FileObj.get("klfile_author")!=null){
		sql.append("and klfile_author=?");
		}
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
		json.put("klfile_fileName", rs.getString("klfile_fileName"));
		json.put("klfile_author", rs.getString("klfile_author"));
		json.put("klfile_describtion", rs.getString("klfile_describtion"));
		json.put("klfile_uploadingTime", rs.getTimestamp("klfile_uploadingTime").toString().substring(0,19));
		json.put("klfile_fileSize", rs.getString("klfile_fileSize"));
		json.put("klfile_downloads", rs.getInt("klfile_downloads"));
		json.put("klfile_uuid", rs.getString("klfile_uuid"));
		jsonArray.add(json);
		}
		}catch(SQLException e){
		e.printStackTrace();
		}
		return jsonArray;
		
		}	
	//增加文件
	public  Integer addFile(KlFile flfile){
		Integer result=null;
		String insertsql="insert into klfile(klfile_fileName,klfile_author,klfile_visitTime,klfile_downloads,klfile_fileType,klfile_fileSize,klfile_documentClassification,klfile_savepath,klfile_describtion,klfile_uuid,klfile_uploadingTime)"+
		"values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DB.getconn();
		PreparedStatement stmt= DB.getStatement(conn, insertsql);
		try{
			stmt.setString(1, flfile.getKlFile_fileName());
			stmt.setString(2, flfile.getKlFile_author()==null?"":flfile.getKlFile_author());
	//		stmt.setString(3, flfile.getKlFile_uploadingTime()==null?"":flfile.getKlFile_uploadingTime());
			stmt.setLong(3, flfile.getKlFile_visitTimes()==0?0:flfile.getKlFile_visitTimes());
			stmt.setInt(4, flfile.getKlFile_downloads()==0?0:flfile.getKlFile_downloads());
			stmt.setString(5, flfile.getKlFile_fileType());
			stmt.setDouble(6, flfile.getKlFile_fileSize()==0?0:flfile.getKlFile_fileSize());
			stmt.setString(7, flfile.getKlFile_documentClassification());
			stmt.setString(8, flfile.getKlfile_savepath());
			stmt.setString(9, flfile.getKlfile_describtion());
			stmt.setString(10, flfile.getKlfile_uuid());
			java.util.Date ud= new java.util.Date();
			Timestamp datetime = new Timestamp(ud.getTime());//java.util.sql转java.sql.datetime
			stmt.setTimestamp(11,datetime);
			result=stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
		return result;
	}
//	public  List<KlFile> getAll(){
//		try{
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	//通过文件名,文件描述模糊查找
	public KlFile getfileByName(String Name,String description){
		String sql="select*from klfile where klfile_fileName like ? or klfile_describtion kile '%a%'";
		Connection conn = DB.getconn();
		PreparedStatement stmt  = DB.getStatement(conn, sql);
		ResultSet rs=null;
		KlFile klfile=null;
		try{
			stmt.setString(1, "%"+Name+"%");
			stmt.setString(2, "%"+description+"%");
			rs=stmt.executeQuery();
			while(rs.next()){
				klfile = new KlFile();
				getFileFromRs(klfile,rs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return klfile;
	}
	private void getFileFromRs(KlFile KlFile,ResultSet rs) throws SQLException{
		KlFile.setKlFile_fileName(rs.getString("Klfile_fileName"));
		KlFile.setKlFile_author(rs.getString("klfile_author"));
	//	KlFile.setKlFile_uploadingTime(rs.getString("klfile_uploadingTime"));
		KlFile.setKlFile_visitTimes(rs.getInt("klfile_visitTime"));
		KlFile.setKlFile_downloads(rs.getInt("klfile_downloads"));
		KlFile.setKlFile_fileType(rs.getString("klfile_fileType"));
		KlFile.setKlFile_fileSize(rs.getDouble("klfile_fileSize"));
		KlFile.setKlFile_documentClassification(rs.getString("klfile_documentClassification"));
		KlFile.setKlfile_savepath(rs.getString("klfile_savepath"));
		KlFile.setKlfile_uuid(rs.getString("klfile_uuid"));
		KlFile.setKlfile_uploadingTime(rs.getTimestamp("klfile_uploadingTime"));
		//rs.getTimestamp(columnIndex)
	}
	//通过uuid文件名删除
	public Integer deleteFile(String klfile_uuid){
		Integer result=0;
		String deleteSQL="delete klfile where klfile_uuid=?";
		//打开数据库
	 Connection conn = DB.getconn();
	 PreparedStatement stmt= DB.getStatement(conn, deleteSQL);

	 try{
		//给stmt对象赋值
		stmt.setString(1, klfile_uuid);
		//返回操作条数
		result=stmt.executeUpdate();
		
	}catch(SQLException  e){
		e.printStackTrace();
	}
	return result;
	}
/***
 * 通过uuid更新文件的分类
 * *
 * 
 */
	public Integer updateFile(KlFile klfile){
		Integer result=0;
		String updateSQL="update klfile set klfile_documentClassification=?where klfile_uuid=?";
		Connection conn = DB.getconn();
		PreparedStatement stmt= DB.getStatement(conn, updateSQL);
	 try{
		 stmt.setString(1, klfile.getKlFile_documentClassification());
		 
		 stmt.setString(2, klfile.getKlfile_uuid());
		 
		 result=stmt.executeUpdate();
		 ResultSet RS=stmt.executeQuery();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 	return result;
	 }
	/**
	 * 
	 * @param klfile
	 */
	public void updateDowns(Integer i,String klfile_uuid){
		Integer result=0;
		String updateSQL="update klfile set klfile_downloads=?where klfile_uuid=?";
		Connection conn = DB.getconn();
		PreparedStatement stmt= DB.getStatement(conn, updateSQL);
	//	ResultSet rs=null;
	 try{
		 stmt.setInt(1,i);	 
		 stmt.setString(2,klfile_uuid);
		// System.out.println(updateSQL);
		 result= stmt.executeUpdate();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	// 得到所有上传文件的信息，需要分页
    public List<KlFile> getAll() {
    	List<KlFile> list= new ArrayList();
        try {
            
            String sql = "select*from klfile order by klfile_ID desc";
    		Connection conn= DB.getconn();
    		PreparedStatement stmt=  DB.getStatement(conn, sql.toString());
    		ResultSet rs=null;
    		KlFile klfile=null;
    		rs=stmt.executeQuery();
			while(rs.next()){
				klfile= new KlFile();
				getFileFromRs(klfile,rs);
				list.add(klfile);
			}
			
         
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }
	public KlFile getFileByUuid(String klfile_uuid){
			String sql="select*from klfile where klfile_uuid=?";
			Connection conn = DB.getconn();
			PreparedStatement stmt  = DB.getStatement(conn, sql);
			ResultSet rs=null;
			KlFile  file=null;
			try{
				stmt.setString(1, klfile_uuid);
				rs=stmt.executeQuery();
				while(rs.next()){
					file= new KlFile();
					getFileFromRs(file,rs);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return file;
	}
	public  JSONArray getFileListByPageND(JSONObject FileObj,String file_name,Integer pageSize,Integer pageIndex,String orderByName,
			String orderByRule){
	//	List<Role> list= new ArrayList();
		
		JSONArray jsonArray = new JSONArray();
		StringBuffer sql=new StringBuffer("SELECT *FROM klfile where 1=1 ");
		sql.append( "AND klfile_fileName LIKE'%"+file_name+"%'");
		sql.append(" OR klfile_describtion LIKE'%"+file_name+"%'");
		sql.append(" order by "+orderByName+" "+orderByRule);
		//如果用户姓名不为空增加过滤条件
		if(FileObj.get("klfile_fileName")!=null){
		sql.append("and klfile_fileName like ?");//模糊匹配
		}
		//如果用过户性别不为空增加过滤条件
		if(FileObj.get("klfile_author")!=null){
		sql.append("and klfile_author=?");
		}
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
		json.put("klfile_fileName", rs.getString("klfile_fileName"));
		json.put("klfile_author", rs.getString("klfile_author"));
		json.put("klfile_describtion", rs.getString("klfile_describtion"));
		json.put("klfile_uploadingTime", rs.getTimestamp("klfile_uploadingTime").toString().substring(0,19));
		json.put("klfile_fileSize", rs.getString("klfile_fileSize"));
		json.put("klfile_downloads", rs.getInt("klfile_downloads"));
		json.put("klfile_uuid", rs.getString("klfile_uuid"));
		jsonArray.add(json);
		}
		}catch(SQLException e){
		e.printStackTrace();
		}
		return jsonArray;
		
		}	
		
}
