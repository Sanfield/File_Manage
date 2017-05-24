package com.xatu.file.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListFileServlet
 */
@WebServlet("/ListFileServlet")
public class ListFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取文件上传目录
		String uploadFilePath =this.getServletContext().getRealPath("/WEB-INF/upload");
		//存储要下载的文件名
		Map<String,String> fileNameMap = new HashMap<String,String>();
		//递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合里
		listfile(new File(uploadFilePath),fileNameMap);
		//将Map集合发送到listfile.jsp页面进行展示
		request.setAttribute("fileNameMap", fileNameMap);
		request.getRequestDispatcher("/ListFile.jsp").forward(request, response);
		
	}
	public void listfile(File file,Map<String,String> map){
		//如果file代表的不是一个文件，而是一个目录
		if(!file.isFile()){
			//列出改目录下的所有文件和目录
			File files[]=file.listFiles();
			//遍历files[]
			for(File f:files){
				//递归
				listfile(f, map);
			}
		}else{
			String realName=file.getName().substring(file.getName().indexOf("__")+1);
			//file.getName()得到的文件的原始名称，这个文件名是唯一的可以作为key，realName是处理过的，可能重复
			map.put(file.getName(), realName);
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
