package com.add;
import com.connection.*;
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
@WebServlet("/adding")
public class adding extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private static final String qry = "INSERT INTO products(id,sku,pic,name,pict,price,delieverFee,descript,seller,categ) "+
			" VALUES(?,?,?,?,?,?,?,?,?,?) ";
	
    private String host;
    private String port;
    private String user;
    private String pass;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adding() {
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
		request.getRequestDispatcher("/addingitem.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;

		//id,sku,pic,name,pict,price,delieverFee,descript,seller,categ,postDate
		int id = Integer.parseInt(request.getParameter("_id"));
		String sku = request.getParameter("_Sku").toString();	
		String picurl = request.getParameter("_Pictureurl").toString();
		String name = request.getParameter("_Name").toString();		
		String pict = request.getParameter("_Pict").toString();	
		double price =  Double.parseDouble(request.getParameter("_Price"));	
		double DelieverFee = Double.parseDouble(request.getParameter("_DelieverFee"));	
		String Descript = request.getParameter("_Descript").toString();			
		int Seller =Integer.parseInt( request.getParameter("_Seller").toString());	
		int Categ = Integer.parseInt(request.getParameter("_Categ").toString());	
;	
		
		try{
			con.setAutoCommit(false);
			ps = con.prepareStatement(qry);
			ps.setInt(1, id);
			ps.setString(2, sku);
			ps.setString(3, picurl);
			ps.setString(4, name);
			ps.setString(5, pict);
			ps.setDouble(6, price);
			ps.setDouble(7, DelieverFee);
			ps.setString(8, Descript);
			ps.setInt(9, Seller);
			ps.setInt(10, Categ);
			ps.executeUpdate();
			con.commit();
			
			
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
