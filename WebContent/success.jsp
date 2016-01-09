<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QQ个人信息页面</title>
</head>
<body>
成功页面
<table>
<th>
<td>姓名 </td>
<td>密码</td>
<td>性别</td>
<td>编号</td>
</th>
<s:iterator value="list">
<tr>
<td><s:property value="name"/></td>
<td><s:property value="password"/></td>
<td><s:if test="1">男</s:if><s:if test="0">女</s:if>
<td><s:property value="vip_id"/></td>
</tr>
</s:iterator>
</table>
</body>
</html>