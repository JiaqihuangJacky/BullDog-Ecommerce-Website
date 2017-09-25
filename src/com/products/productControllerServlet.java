package com.products;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class productControllerServlet
 */
@WebServlet("/productControllerServlet")
public class productControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductDbUtil productDbUtil;
	
	@Resource(name="jdbc/shoppingAppDB")
	private DataSource dataSource;
	
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create out product db util ... and pss in the conn pool /datasource
		
		try{
			productDbUtil = new ProductDbUtil(dataSource);
		}
		catch(Exception exc){
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//route to the appropriate method
			if(theCommand ==null){
				theCommand = "LIST";
			}
			
			switch(theCommand){
			
			case "LIST":
				listProducts(request, response);
				break;
	
			case "ADD":
				addProducts(request, response);
				break;
				
			case "LOAD":
				loadProduct(request, response);
				break;
				
			case "UPDATE":
				updateProduct(request, response);
				break;
				
			case "DELETE":
				deleteProduct(request, response);
				break;
				
				
			case "SEARCH":
                searchStudents(request, response);
                break;

				
			default:
				listProducts(request,response);
			
			}
			
			
			
			//list the products .. in MVC fashion
			//listProducts(request,response);
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
			throw new ServletException(exc);
		}
		
	}


	
	private void searchStudents(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		 // read search name from form data
        String theSearchName = request.getParameter("theSearchName");
        
        // search students from db util
        List<product> products = productDbUtil.searchProducts(theSearchName);
        
		//add product to the request
		request.setAttribute("PRODUCT_LIST", products);
		
		//send to the JSP page (view)
		request.getRequestDispatcher("/list-items.jsp").forward(request, response);

		
	}



	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//read id from the databse
		String theProductId = request.getParameter("productId");
		
		//delete product from the database
		productDbUtil.deleteProduct(theProductId);
		
		
		//send then to server
		listProducts(request,response);
	}



	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {

			//read theProductId info from the data
			int id = Integer.parseInt(request.getParameter("productId"));
			String sku = request.getParameter("_Sku").toString();	
			String picurl = request.getParameter("_Pictureurl").toString();
			String name = request.getParameter("_Name").toString();		
			String pict = request.getParameter("_Pict").toString();	
			double price =  Double.parseDouble(request.getParameter("_Price"));	
			double DelieverFee = Double.parseDouble(request.getParameter("_DelieverFee"));	
			String Descript = request.getParameter("_Descript").toString();			
			int Seller =Integer.parseInt( request.getParameter("_Seller").toString());	
			int Categ = Integer.parseInt(request.getParameter("_Categ").toString());	
			
			//create a new theProductId object
			product theProduct = new product(id,sku,picurl,name,pict,price,DelieverFee,Descript,Seller,Categ);
			
			//perform update on database
			productDbUtil.updateProduct(theProduct);
		
			//send them back to the list theProductId page
			listProducts(request,response);
		
	}



	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		//reading theProductId id
		String theProductId = request.getParameter("productId");
		
		//get productId from databse (db util)
		product theProduct = productDbUtil.getProduct(theProductId);
		
		//place product in the request attribute
		request.setAttribute("THE_PRODUCT", theProduct);
		
		//send to jsp page: update-product-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-product-form.jsp");
		dispatcher.forward(request, response);
	}



	private void addProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read products info from the data
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
				
		//create a new product object
		product theProduct = new product(id,sku,picurl,name,pict,price,DelieverFee,Descript,Seller,Categ);
		
		//add the product to the database
		productDbUtil.addProduct(theProduct);
		
		//send back to main page(the product list)
		listProducts(request,response);
	}



	private void listProducts(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
			//get products from the db util
			List<product> products = productDbUtil.getProducts();
			
			//add product to the request
			request.setAttribute("PRODUCT_LIST", products);
			
			//send to the JSP page (view)
			request.getRequestDispatcher("/list-items.jsp").forward(request, response);

	}

}
