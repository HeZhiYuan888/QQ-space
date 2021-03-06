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
<img alt="img" src="<%=request.getContextPath()%>/imag/<s:property value="headImg"/>" width="30" height="30" />
<a href="MainPage.action?visitor=<s:property value="vip_id"/>"><s:property value="name"/></a>
</li>
</s:iterator>
</ul>

<h5>通知</h5>
<s:iterator value="list">
	<a href="MainPage.action?visitor=<s:property value="accmemberId"/>"><s:property value="name"/></a>申请添加你为好友，
	备注：<s:property value="ApplyFriend.getRemarks()"/> <s:property value="ApplyFriend.getDate()"/>
	

	<form  action="agree.action" method="post">
	<input type="submit" value="同意">
	<input type="hidden" name="applyId" value="<s:property value="ApplyFriend.getId()"/>">	
	</form>

	<form action ="disagree.action"  method="post">	
	<input type="submit" value="拒绝">	
	</form>

	<form  action="ignore.action" method="post">
	<input type="submit" value="忽略">
	</form>
</s:iterator>
	<br>
	
<s:iterator value="applyFriendList">
	<s:if test="stateId==1">
	<a href="MainPage.action?visitor=<s:property value="accmember.getVip_id()"/>"><s:property value="accmember.getName()"/></a>同意添加你为好友！<br>
	</s:if>
	
	<s:elseif test="stateId==2">
	<a href="MainPage.action?visitor=<s:property value="accmember.getVip_id()"/>"><s:property value="accmember.getName()"/></a>拒绝了你的好友请求！<br>
	</s:elseif>
</s:iterator>

<br><h5>最近活动记录</h5>
<s:iterator value="applyFriendList">
<s:if test="stateId==0">
申请添加<a href="MainPage.action?visitor=<s:property value="accmember.getVip_id()"/>"><s:property value="accmember.getName()"/></a>为好友，正在等待对方回应。<br>
</s:if>
</s:iterator>

<p>添加好友：</p>
<form action="AddFriend.action" method="post" >
请输入要添加的账号：<input type="text" name="member.vip_id">
添加备注：<input type="text" name="remark">
<input type="submit" value="添加">
</form>
</body>
</html>