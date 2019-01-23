<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="post" commandName="registerRef">
Name : 
<form:input path="name"/> <br><br>
Address : 
<form:input path="address"/> <br><br>
Contact Number : 
<form:input path="conntactNumber"/> <br><br>
EMail : 
<form:input path="EMail"/> <br><br>
User Id : 
<form:input path="userId"/> <br><br>
Password : 
<form:input path="password"/> <br><br>

<button type="submit"> Submit </button>

</form:form>	
	
	
</body>
</html>