<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send an e-mail</title>
</head>
<body>
    <form action="register" method="post">
        <table border="0" width="45%" align="center">
            <caption><h2>Billing Item Information</h2></caption>
             <tr>
                <td width="50%">Email: </td>
                <td><input type="text" placeholder="email" name="contact"></td>
            </tr>
             <tr>
                <td width="50%">Address: </td>
                <td><input type="text" placeholder="address" name="address"></td>
            </tr>
            <tr>
                <td>Phone: </td>
                <td><input type="text" placeholder="user name" name="username"></td>
            </tr>
            <tr>
                <td>Credit card number: </td>
                <td><input type="text" placeholder="card Number" name="carnum"></td>
            </tr>
            <tr>
                <td>Security Code: </td>
                <td><input type="text" placeholder="Pin" name="secpin"></td>
            </tr>
            
        
			<br/>

            <tr>
            <!-- change to onlick cannot proces if not working with duplicate -->
                <td colspan="2" align="center"><input type="Submit" value="Send  Payment" formaction="EmailSendingServlet"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>