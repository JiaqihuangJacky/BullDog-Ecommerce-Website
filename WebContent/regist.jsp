<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% if( session.getAttribute("err") != null){
		%> <p style="color:red;"> <%=session.getAttribute("err")%></p> <%} %>
		
<form action="register" method="post" name="signform">

email:  <input id="email" type="text" placeholder="email" name="contact" onKeyup="checkform()"><br>
user name:  <input id="user_name" type="text" placeholder="user name" name="username" onKeyup="checkform()"><br>
password: <input type="text" placeholder="password" name="pin" onKeyup="checkform()"><br>

<input type="submit" id="registerbtn" disabled="disabled" value="sign up">

</form>


</body>
</html>

<script type="text/javascript" language="javascript">

function checkform(){
	var fm = document.forms["signform"].elements;
	var can_submit = (fm[0].value.length > 0) && (fm[1].value.length >= 3 && fm[1].value.length <= 30) && (fm[2].value.length >= 5 && fm[2].value.length <= 15);
	document.getElementById("registerbtn").disabled = !can_submit;
	
}
</script>