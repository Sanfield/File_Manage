package com.xatu.file.common.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class DB {
	public static Connection getconn(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/file_manage?user=root&password=ROOT");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	public static Statement getstmt(Connection conn){
		Statement stmt=null;
		try{
			stmt=conn.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return stmt;
	}
	public static PreparedStatement getStatement(Connection conn,String sql)
	{
		PreparedStatement stmt=null;
		try{
			if(conn!=null)
				stmt= conn.prepareStatement(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return stmt;
	}
	public static ResultSet getRS(Statement stmt,String sql){
		ResultSet rs=null;
		try{
			rs=stmt.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeRS(ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
				rs=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void closestmt(Statement stmt){
		try{
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
		}catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	public static void closeconn(Connection conn){
		try{
			if(conn!=null){
				conn.close();
				conn=null;
			}
		}catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	public static void closeDB(Connection conn,Statement stmt,ResultSet rs){
		closeRS(rs);
		closestmt(stmt);
		closeconn(conn);
	}


}


