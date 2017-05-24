package com.xatu.file.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xatu.file.service.KlFileService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DownServlet
 */
@WebServlet("/DownServlet")
public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到要下载的文件名
		//response.setContentType("application/x-download");
	     if(request.getSession().getAttribute("username")==null){
		      request.setAttribute("message", "请先你登陆");
		      request.getRequestDispatcher("/jsp/page/Message.jsp").forward(request, response);  
		      return;
	     }
		String fileName=request.getParameter("filename");
		//得到存取路
		KlFileService kService= new KlFileService();
		JSONObject json = kService.getFileByUuid(fileName);
		
		fileName = new String(fileName.getBytes("iso8859-1"),"utf-8");
		String path=json.getString("klfile_savepath");
		//得到要下载的文件
   		File file=new File(path+"\\"+fileName);
		//如果文件不在
		if(!file.exists()){
			request.setAttribute("message", "你要下载的资料已经过期");
			request.getRequestDispatcher("/jsp/page/Message.jsp").forward(request, response);
			return;
		}
		//处理文件名
		String realName=fileName.substring(fileName.indexOf("_")+1);
		//设置响应头。控制下载浏览器下载该文件
		response.setHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode(realName, "UTF-8"));
		//读取要下载的文件,保存到输入流
		FileInputStream in = new FileInputStream(path+"\\"+fileName);
		//创建输出流
		OutputStream out = response.getOutputStream();
		//创建缓冲区
		byte buffer[]= new byte[1024];
		int len=0;
		//循环将输入流中的内容读取到缓冲区当中
		while((len=in.read(buffer))>0){
			//输出缓冲区的内容到浏览器，实现文件下载
			out.write(buffer,0,len);
		}
	//	out.flush();
		in.close();
		out.close();
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
