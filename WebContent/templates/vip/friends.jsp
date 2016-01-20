<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>好友列表</title>
</head>
<body>
 <%@include file="/templates/common/head.jsp"%>
 <p>好友列表</p>
<ul>
<s:iterator value="friends" >
<li>
<img alt="img" src="<%=request.getContextPath()%>/imag/<s:property value="headImg"/>" width="30" height="30" /><s:property value="member.getName()"/>
<s:property value="name"/>
</li>
</s:iterator>
</ul>
</body>
</html>