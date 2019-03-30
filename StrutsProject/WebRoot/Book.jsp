<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>机票预订</title>
    <style type="text/css">
   		body{
   			background-image: url(bg2.jpg);
   		}
   </style>


  </head>
  
  <body>
  	<div style="margin:0px auto;width:300px;height:500px;margin-top:160px;">
    <h3 style="text-align:center;">在线机票预订</h3>
    <s:form method="post" action="bookAction">
    	<s:textfield name="book.Name" label="用户名"/>
    	<s:fielderror><s:param>Name</s:param><s:param>NameError</s:param></s:fielderror>
    	
    	<s:radio name="book.Sex" list="%{#{'男':'男','女':'女'}}" label="性别"/> 
    	<s:fielderror><s:param>Sex</s:param></s:fielderror>
    	
    	<s:textfield name="book.StartCity" label="始发城市"/>
    	<s:fielderror><s:param>StartCity</s:param></s:fielderror>
    	
    	<s:textfield name="book.EndCity" label="目的城市"/>
    	<s:fielderror><s:param>EndCity</s:param></s:fielderror>
    	
    	<s:textfield name="book.Date" label="出发时间"/>
    	<s:fielderror><s:param>Date</s:param></s:fielderror>
    	
    	<s:textfield name="book.Id" label="身份证"/>
    	<s:fielderror><s:param>Id</s:param><s:param>IdError</s:param></s:fielderror>
    	
    	<s:submit name="lsubmit" value="预定" />
    </s:form>
  </div>
  </body>
</html>
