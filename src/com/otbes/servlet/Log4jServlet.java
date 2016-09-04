package com.otbes.servlet;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;



/**
 * Servlet implementation class Log4j
 */
public class Log4jServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log4jServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String file = getServletContext().getRealPath("/") + "src/log4j.properties";
		if(file != null)
			PropertyConfigurator.configure(file);
		    log.info("LoggerServlet started.");

		  
	}

}
