<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <tr>
    	Welcome,${user.username } !
    </tr>
    <table>
    	<tr>
    	<td>R1</td>
    	<td>R2</td>
    	<td>R3</td>
    	<td>R4</td>
    	<td>R5</td>
    	</tr>
    	<c:forEach var="x" begin="0" end="20">
    		<tr>
	    		<td><input type="text" name="R1"/></td>
	    		<td><input type="text" name="R2"/></td>
	    		<td><input type="text" name="R3"/></td>
	    		<td><input type="text" name="R4"/></td>
	    		<td><input type="text" name="R5"/></td>
	    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
