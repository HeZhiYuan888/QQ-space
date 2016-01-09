<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>我的说说</title>
</head>
<body>
<h3>发表说说</h3>
<form action="publish.action" method="post" >
标题：<input type="text" name="title.title_name"/>
<div width="500px">
</br>
</br>
正文：
<textarea rows="10" cols="100" name="title.title_content" align="center"></textarea>
</div>
<div align="center" width="200px">
<input type="submit"  value="发表">
</div>
</form>
</body>
</html>