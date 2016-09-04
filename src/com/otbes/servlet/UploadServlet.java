package com.otbes.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.otbes.service.CallDetailService;
import com.otbes.vo.CallDetailFileVO;

/**
 * Servlet implementation class FileUploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static Logger log = Logger.getLogger("otbeslogger");
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String page=null;
		String filePath=request.getRealPath("/");
		File file=null;
		String fileName=null;
		
		String req="";
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try{ 
				List fileItems = upload.parseRequest(request);
				Iterator i = fileItems.iterator();
				while (i.hasNext()) 
				{
					FileItem fi = (FileItem)i.next();
					if (!fi.isFormField())	
					{
						req+=fi.getFieldName()+"=";
						fileName = fi.getName();
						

						if( fileName.lastIndexOf("\\") >= 0 ){
							fileName=fileName.substring(fileName.lastIndexOf("\\"));
							file = new File( filePath + fileName ) ;
						}else{
							fileName= fileName.substring(fileName.lastIndexOf("\\")+1) ;
							file = new File( filePath + fileName ) ;
						}
						fileName=fileName.substring(1);
						req+=fileName+"&";
						fi.write( file ) ;
					}
				}
				page=request.getParameter("option");
				
				

					CallDetailFileVO call = new CallDetailFileVO();
					call.setRoot(request.getRealPath("/"+fileName.toString()));
					CallDetailService service = new CallDetailService();
					service.upload(call);
					RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/JSP/BTASsuccessupload.jsp");
					rd.forward(request, response);
				
			}catch(Exception e) {
				log.error(e);
			}
		}


	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}