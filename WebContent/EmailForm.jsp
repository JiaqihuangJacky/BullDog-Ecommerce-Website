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
        <table border="0" width="35%" align="center">
            <caption><h2>Register New User</h2></caption>
              <tr>
                <td width="50%">Email address: </td>
                <td><input type="text" placeholder="email" name="contact"></td>
            </tr>
            <tr>
                <td>UserName: </td>
                <td><input type="text" placeholder="user name" name="username"></td>
            </tr>
            <tr>
                <td>PassCode: </td>
                <td><input type="text" placeholder="password" name="pin"></td>
            </tr>
            
            

            <tr>
            <!-- change to onlick cannot proces if not working with duplicate -->
                <td colspan="2" align="center"><input type="submit" value="Send" formaction="EmailSendingServlet"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>