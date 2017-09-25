package com.connection;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.sql.*;

public class registerCon {
	
	private static final String ckqry = "SELECT * FROM users where contact = ? OR name = ? ";
	
	public static boolean check(Connection con, String email, String name){
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean sucess = true;
		try{
			ps = con.prepareStatement(ckqry);
			ps.setString(1, email);
			ps.setString(2, name);
			rs = ps.executeQuery();
			if(rs.isBeforeFirst())	sucess = false;
			
		}catch(Exception ex){
			ex.printStackTrace();
			sucess = false;
		}finally{
			try{
				if(ps != null)	ps.close();
				if(rs != null)	rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sucess;

	}

}
