<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title >登陆页面</title>
</head>
<body>

<%Cookie[] cookies =request.getCookies();
String vipId="";
String pwd="";
for(Cookie cookie:cookies)
{
		if("vipId".equals(cookie.getName()))
		{
			 vipId=cookie.getValue();
		}
		if("pwd".equals(cookie.getName()))
		{
			 pwd=cookie.getValue();
		}
}
%>
<% %>
<br><br><br>
<div class="imag" >
<h2 class="center" style="color:yellow;">
欢迎来到QQ空间
<br>
<h3 class="center" style="color:green;">请登录</h3></h2>
<form action="login.action" method="post" class="table">
<table>
<tr>
<td height="50px" width="150">账号</td>
<td height="50px" width="150"><input  name="member.vip_id" type="text" value=<%=vipId%>></td>
</tr>
<tr>
<td height="50px" width="150" >密码</td>
<td height="50px" width="150"><input name="member.password" type="text" value=<%=pwd%>></td>
</tr>
</table>
<br>
<div class="center">
<input class="center" type="checkbox" name="ifSave" value="save"/>记住账号和密码
</div>
<table height="100px" width="300px">
<tr>
<td height="50px" width="150">
<input type="submit"  value="登陆" >
</td>
<td height="50px" width="150">
<input type="button"   value="注册" >
</td>
</tr>
</table>
</form>
</div>
</body>
</html>