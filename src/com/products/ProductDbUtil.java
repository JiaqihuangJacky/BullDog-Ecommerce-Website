package com.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProductDbUtil {

	private DataSource dataSource;
	
	public ProductDbUtil(DataSource theDataSource){
		dataSource = theDataSource;
	}
	
	public List<product> getProducts() throws Exception{
		
		List<product> productList = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try{
			//get a connection
			myConn = dataSource.getConnection();
			//create sql statement
			String sql = "select * from products order by price";
			
	
			//execute query
			myStmt = myConn.createStatement();
			//process result set
			myRs = myStmt.executeQuery(sql);
			//chose JDBC objects
			while(myRs.next()){
				
				//read products info from the data
				//id,sku,pic,name,pict,price,delieverFee,descript,seller,categ,postDate
				int id = myRs.getInt("id");
				String sku = myRs.getString("sku");	
				String picurl = myRs.getString("pic");
				String name = myRs.getString("name");		
				String pict = myRs.getString("pict");	
				double price = myRs.getDouble("price");	
				double DelieverFee = myRs.getDouble("delieverfee");	
				String Descript = myRs.getString("descript");			
				int Seller = myRs.getInt("seller");	
				int Categ = myRs.getInt("categ");
				
				//create new product object
				product theProduct = new product(id,sku,picurl,name,pict,price,DelieverFee,Descript,Seller,Categ);
				
				//add it to the list of products
				productList.add(theProduct);
				
			}
			return productList;
		}
		
		
		finally{
			//close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try{
			if(myRs != null){
				myRs.close();
			}
			
			if(myStmt != null){
				myStmt.close();
			}
			
			if(myConn != null){
				//not really close it
				//just puts back in connection pool
				myConn.close();
			}
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
			
	}

	public void addProduct(product theProduct) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try{
			
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql for insert
			String sql = "INSERT INTO products(id,sku,pic,name,pict,price,delieverFee,descript,seller,categ) "+
					" VALUES(?,?,?,?,?,?,?,?,?,?) ";
			
			//set the param values for product
			myStmt = myConn.prepareStatement(sql);
			
			//execute sql insert
			myStmt.setInt(1, theProduct.getId());
			myStmt.setString(2,theProduct.getSku());
			myStmt.setString(3, theProduct.getPicurl());
			myStmt.setString(4, theProduct.getName());
			myStmt.setString(5, theProduct.getPict());
			myStmt.setDouble(6, theProduct.getPrice());
			myStmt.setDouble(7,theProduct.getDelieverFee());
			myStmt.setString(8, theProduct.getDescript());
			myStmt.setInt(9, theProduct.getSeller());
			myStmt.setInt(10, theProduct.getCateg());
			myStmt.executeUpdate();
			
			//execute sql insert
			myStmt.execute();
			
		}
		
		finally{
			close(myConn, myStmt, null);
		}
		
	}

	public product getProduct(String theProductId) throws Exception {
		

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int productId;
		product theProduct = null;
		
		try{
			
			//convert product id to int
			productId = Integer.parseInt(theProductId);
			
			//get connection to databse
			myConn = dataSource.getConnection();
			
			//create sql to get selected product
			String sql = "select * from products where id=?";
			
			//create preapared product
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1,productId);
			
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result set row
			if(myRs.next()){
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
				
				//create a new product object
				theProduct = new product(id,sku,picurl,name,pict,price,DelieverFee,Descript,Seller,Categ);
				
			}
			else{
				throw new Exception("Could not find product id:	" + productId);
			}
			
			return theProduct;
		}
		
		
		finally{
			//close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
	}

	public void updateProduct(product theProduct) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try{
			//get db connection
			myConn = dataSource.getConnection();
			
			//create SQL update statement
			String sql = "UPDATE products "
					+ "SET sku=?, pic=?, name=?, pict=?, price=?, delieverfee=?, descript=?, seller=?, categ=? "
					+ "WHERE id=?";

			
			//prepare the statement
			myStmt = myConn.prepareStatement(sql);
			
			
			//set the params
			myStmt.setString(1,theProduct.getSku());
			myStmt.setString(2, theProduct.getPicurl());
			myStmt.setString(3, theProduct.getName());
			myStmt.setString(4, theProduct.getPict());
			myStmt.setDouble(5, theProduct.getPrice());
			myStmt.setDouble(6,theProduct.getDelieverFee());
			myStmt.setString(7, theProduct.getDescript());
			myStmt.setInt(8, theProduct.getSeller());
			myStmt.setInt(9, theProduct.getCateg());
			myStmt.setInt(10, theProduct.getId());
			//execute SQL statement
			myStmt.execute();
		}
		
		finally{
			//close JDBC objects
			close(myConn, myStmt, null);
		}
		
	}

	public void deleteProduct(String theProductId)  throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try{
				
			//convert theProductId id to int
			int productId = Integer.parseInt(theProductId);
						
			//get connection to database
			myConn = dataSource.getConnection();
					
			//create sql to delete product
			String sql = "delete from products where id=?";		
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
					
			//set params
			myStmt.setInt(1, productId);
				
			//execute sql statement
			myStmt.execute();
			
			
		}
		
		finally{
			//close JDBC objects
			close(myConn, myStmt, null);
		}
		
	}

	public List<product> searchProducts(String theSearchName) throws SQLException {
        List<product> products = new ArrayList<>();
        
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
      
        
        try {
            
            // get connection to database
            myConn = dataSource.getConnection();
            
            //
            // only search by name if theSearchName is not empty
            //
            if (theSearchName != null && theSearchName.trim().length() > 0) {
                // create sql to search for students by name
                String sql = "select * from products where lower(name) like ?";
                // create prepared statement
                myStmt = myConn.prepareStatement(sql);
                // set params
                String theSearchNameLike = theSearchName.toLowerCase();
                myStmt.setString(1, theSearchNameLike);
            }  
            
            else {
				// create sql to get all students
				String sql = "select * from products order by name";

				// create prepared statement
				myStmt = myConn.prepareStatement(sql);
			}
            
            // execute statement
            myRs = myStmt.executeQuery();
            
            // retrieve data from result set row
            while (myRs.next()) {
                
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
				
				//create a new product object
				product theProduct = new product(id,sku,picurl,name,pict,price,DelieverFee,Descript,Seller,Categ);
                
                // add it to the list of students
				products.add(theProduct);           
            }
            
            return products;
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
	}
	
	
}
