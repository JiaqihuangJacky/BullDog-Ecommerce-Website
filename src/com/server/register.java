package com.server;
import com.connection.*;
import com.connection.EmailUtility;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import net.codejava.email.*;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private static final String qry = "INSERT INTO users(name,contact,password) "+
			" VALUES(?,?,?) ";
	
    private String host;
    private String port;
    private String user;
    private String pass;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
		con = ConnectionManager.getConnection();

    }
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/signup.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String contact = request.getParameter("contact");
		String pin = request.getParameter("pin");
		String uname = request.getParameter("username");
		
		try{
			con.setAutoCommit(false);
			ps = con.prepareStatement(qry);
			ps.setString(1, uname);
			ps.setString(2, contact);
			ps.setString(3, pin);
			ps.executeUpdate();
			con.commit();
			
			// send email
	        String recipient = request.getParameter("contact");
	        String subject = request.getParameter("username");
	        String content = request.getParameter("pin");
	        
	        String thank = null;
	        if(content != null)
	        	thank = "3Q you for register";
	        String resultMessage = "";
	        
	        EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    thank);
            resultMessage = "The e-mail was sent successfully";
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			try{
				con.setAutoCommit(true);
				ps.close();
			}catch(Exception ex){
				System.out.println(ex.getMessage());

			}
		}
	}

}
