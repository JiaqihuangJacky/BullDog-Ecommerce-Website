package com.products;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Define datasource/connection pool for Resource Injection
	@Resource(name="jdbc/shoppingAppDB")
	private DataSource dataSource;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Step 1:  Set up the printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		// Step 2:  Get a connection to the database
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			// Step 3:  Create a SQL statements
			String sql = "select * from products";
			myStmt = myConn.createStatement();
			
			// Step 4:  Execute SQL query
			myRs = myStmt.executeQuery(sql);
			
			// Step 5:  Process the result set
			while (myRs.next()) {
				//read products info from the data
				//read products info from the data
				int id = myRs.getInt("id");
				String sku = myRs.getString("sku");	
				String picurl = myRs.getString("pic");
				String name = myRs.getString("name");		
				String pict = myRs.getString("pict");	
				double price = myRs.getDouble("price");	
				double DelieverFee = myRs.getDouble("delieverFee");	
				String Descript = myRs.getString("descript");			
				int Seller = myRs.getInt("seller");	
				int Categ = myRs.getInt("categ");
			
				//printing
				out.println(id);
				out.println(sku);
				out.println(picurl);
				out.println(name);
				out.println(pict);
				out.println(price);
				out.println(DelieverFee);
				out.println(Descript);
				out.println(Seller);
				out.println(Categ);
				out.println("----------------------------");
			}
		}
		catch (Exception exc) {
			out.println("fail");
			exc.printStackTrace();
		}
	}

}







