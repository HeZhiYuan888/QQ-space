<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
  
    <%-- <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ page import="org.resource.po.Member"%> --%>
    <%@ page import="org.resource.po.Member"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%Member mm=(Member)session.getAttribute("vip");%>
<%int visitor=mm.getVip_id(); %>
<%String name=mm.getName(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QQ空间</title>
<%request.setCharacterEncoding("UTF-8");//传值编码
response.setContentType("text/html;charset=UTF-8");//设置传输编码 %>
</head>
<body onload="getTime()">
<div class="top">
<span class="img1"><img src="<%=request.getContextPath()%>/imag/myspace.gif"></span>
<span class="img2"><a href="PersonCenter.action">个人中心<img src="<%=request.getContextPath()%>/imag/User.png"></a></span>
<span class="img2"><a href="MainPage.action?visitor=<%=visitor%>"><img src="<%=request.getContextPath()%>/imag/homePagepng.png">我的主页</a></span>
<span class="img2"><a href="ListFriends.action"><img src="<%=request.getContextPath()%>/imag/friends.png">好友</a></span>
<span class="img2"><a href="http://game.qq.com/index.shtml"><img src="<%=request.getContextPath()%>/imag/applications.png">应用</a></span>
 <h5>你好，<%=name%></h5>
</div>
</body>
</html>