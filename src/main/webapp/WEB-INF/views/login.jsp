<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head><title>Login</title></head>
<body>
 <div align="center">
	<form method="POST" action="login">	
		<div id="login-box">
			
			<H3>Student Books Checked-Out</H3>
				Please Enter Your Login Details.
			<br />
			<br />
			<div id="login-box-name" style="margin-top:20px;">User Name:</div>
			<div id="login-box-field" style="margin-top:20px;">
				<input id="userName" name="userName" class="form-login" title="Username" value="" size="30" maxlength="2048"/>				
			</div>
			<div id="login-box-name">Password:</div>
			<div id="login-box-field">
				<input id="password" name="password" type="password" class="form-login" title="Password" value="" size="30" maxlength="2048" />
			</div>		
			<br/>	
			<INPUT TYPE="submit" value="LogIn">
			<br/><label style="color: red;">${LoginFailed}</label>
		</div>	
	</form>
</div>
</body>
</html>