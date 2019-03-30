<%@ page language="java" import="java.util.*,action.LogAction" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>系统登录</title>
   <style type="text/css">
   		body{
   			background-image: url(bg2.jpg);
   		}
   </style>

  </head>
  
  <body>
  <div id="id1" style="margin:0px auto;width:300px;height:500px;margin-top:160px;">
  	<h3 style="text-align:center;">用户登录</h3>
  	<s:property value="errorMessage" />
    <s:form method="post" action="loginAction" cssStyle="text-align:center;">
    	<s:textfield name="users.UserName" label="用户名"/>
    	<s:password name="users.Password" label="密码"/>
    	<s:submit name="lsubmit" value="登录" />
    	<!--<s:reset value="重置"></s:reset>-->	
    </s:form>
    <hr align="center" width="100%" color="RED"/><br>
    <s:form  method="post" action="regLoginAction" cssStyle="text-align:center;">
	    <s:textfield name="registUser.UserName" label="用户名"/>
	    <s:password name="registUser.Password" label="密码"/>
	    <s:password name="registUser.rePassword" label="确认密码"/>
		<s:submit name="rsubmit" value="注册"/>
		<!--<s:reset value="重置"></s:reset>	-->	    
	</s:form>
  </div>  
  </body>
</html>
