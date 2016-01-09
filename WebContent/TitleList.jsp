<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<th>
<td>标题 </td>
<td>内容</td>
</th>
<s:iterator value="list">
<tr>
<td><s:property value="title_host"/></td>
<td><s:property value="title_name"/></td>
<td><s:property value="title_content"/></td>


</tr>
</s:iterator>
</table>
</body>
</html>