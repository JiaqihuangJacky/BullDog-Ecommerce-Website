package com.server;

import com.connection.*;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	private static String logqry = "select * from users where (name = ? or contact = ?) AND password = ? ";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
		con = ConnectionManager.getConnection();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String e_name = request.getParameter("e_name");
		String pin = request.getParameter("pin");
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			ps = con.prepareStatement(logqry);
			ps.setString(1, e_name);
			ps.setString(2, e_name);
			ps.setString(3, pin);
			rs = ps.executeQuery();
			
			if(rs.isBeforeFirst()){
				request.getSession().setAttribute("login_err", "hello xxx");

				while(rs.next()){
					
				}
			}else{
				request.getSession().setAttribute("login_err", "pass word and user not match");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
				try{
					con.setAutoCommit(true);
					ps.close();
				}catch(Exception ex){
					System.out.println(ex.getMessage());

				}
			response.sendRedirect("http://localhost:8080/bulldog/login");
		}
		
		
	}

}
