<%@ page language="java" import="java.util.*,bean.JDBCon" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>订票成功</title>
    <style type="text/css">
   		body{
   			background-image: url(../bg2.jpg);
   		}
   </style>
	
  </head>
  
  <body>
  	<h1>您的机票预订信息</h1>
  	
  	<table cellpadding="0" cellspacing="0" border="1" width="70%" >
			<tr >
				<th>姓名</th>
				<th>性别</th>
				<th>始发城市</th>
				<th>目的城市</th>
				<th>出发日期</th>
				<th>身份证</th>
			</tr>
			<!-- 使用OGNL表达式 -->
			<s:iterator value="#session.bookList" status="bk" var="book">
				<tr>
					<td><s:property value="#book.Name"/></td>
					<td><s:property value="#book.Sex"/></td>
					<td><s:property value="#book.StartCity"/></td>
					<td><s:property value="#book.EndCity"/></td>
					<td><s:property value="#book.Date"/></td>
					<td><s:property value="#book.Id"/></td>
				</tr>
			</s:iterator>
			
	</table>
  	
  </body>
</html>
