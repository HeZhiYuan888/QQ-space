<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ page import="org.resource.po.Member"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <% Member member=(Member)session.getAttribute("vip");%>
<%int vip_id=member.getVip_id();%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>QQ空间</title>
</head>
<body>
<jsp:include page="/templates/common/head.jsp"></jsp:include>
 <br> <br> <br>
  <s:iterator value="titles">
	  <s:property value="title_content"/>		  
		  	<s:if test="visitor ==vipid">  		  	
			 	<a  href="DeleteTitle.action?titleId=<s:property value="title_id"/>" onClick="return confirm('确定删除?');">删除</a>		
			 	 <a href="#">修改</a><br><br>
	 	   	</s:if>  <br>
  </s:iterator>
</body>
</html>