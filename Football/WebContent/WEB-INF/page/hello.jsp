<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
<s:form  action="addOrder">
<h1>Welcome To Struts 2!</h1>
<p><a href="<s:url action='hello'/>">Hello World</a></p>
code:<s:textfield name="order.code"></s:textfield>
<br>
name:<s:textfield name="order.name"></s:textfield>

<s:submit></s:submit>
</s:form>
</body>
</html>


