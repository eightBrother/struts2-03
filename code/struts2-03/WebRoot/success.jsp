<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri ="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
  <a href="add.jsp">新增</a>
  	<table border="1">
  		<tr>
  			<td>id</td>
  			<td>名字</td>
  			<td>密码</td>
  			<td>操作</td>
  		</tr>
  	<s:iterator value="ulist">
  		<tr>
  			<td><s:property value="id"/></td>
  			<td><s:property value="name"/></td>
  			<td><s:property value="psw"/></td>
  			<td>
  				<input type="button" onclick="javascript:window.location.href='<%=path %>/strutsAction!Delete.action?id=<s:property value="id"/>'" value="删除"/>
  			</td>
  		</tr>
  	</s:iterator>
  	</table>
    
  </body>
</html>
