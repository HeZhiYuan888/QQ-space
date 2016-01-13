<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ page import="org.resource.po.Member"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>QQ空间</title>
<%request.setCharacterEncoding("UTF-8");//传值编码
response.setContentType("text/html;charset=UTF-8");//设置传输编码 %>
</head>
<body onload="getTime()">
  <%Member mm=(Member)session.getAttribute("vip");
String name=mm.getName();%>
<div class="top">
<span class="img1"><img  src="<%=request.getContextPath()%>/imag/myspace.gif"></span>
<span class="img2"><img src="<%=request.getContextPath()%>/imag/User.png"></span>
<span class="img2"><img src="<%=request.getContextPath()%>/imag/homePagepng.png"></span>
<span class="img2"><img src="<%=request.getContextPath()%>/imag/friends.png"></span>
<span class="img2"><img src="<%=request.getContextPath()%>/imag/applications.png"></span>
<h5>你好，<%=name%></h5>
</div>
<div class="mid">
<span class="img3"><img src="<%=request.getContextPath()%>/imag/qq.jpg"></span><h2>好友动态</h2>
</div>
<div class="mainbody">

<%-- <p>好友列表</p>
<ul>
<s:iterator value="friends" >
<li>
<img alt="img" src="<%=request.getContextPath()%>/imag/<s:property value="headImg"/>" width="30" height="30" /><s:property value="member.getName()"/>
<s:property value="name"/>
</li>
</s:iterator>
</ul>
<br><br>
<h6><a href="templates/vip/publishSaySay.jsp">发表说说</a></h6>
<div width="500px" height="10px" border="1px" color="red">
 --%>

<table width="1000px">
<s:iterator value="listTitle">
<form action="AddComment.action"  method="post" onsubmit="return checksubmit();">
<tr><img alt="img" src="<%=request.getContextPath()%>/imag/<s:property value="member.getHeadImg()"/>" width="30" height="30" /><s:property value="member.getName()"/></tr>
<tr><s:property  value="title_content"/></tr>
<s:iterator id ="data" status="status" value="listComment">   
    <s:if test="person!=null">      
		<a href="#"><s:property value="person"/></a>:<s:property value="content"/>
		<br>
	</s:if>	
	<s:else>		
		<a href="#"><s:property value="person1"/></a>回复<a href="#"><s:property value="person2"/></a>：
		<s:property value="content"/>
		<br>
	</s:else>
</s:iterator>
<div align="left">
<input type="submit"  value="点评">
<a href="Transmit.action?title_id=<s:property value="title_id"/>&title.title_name=<s:property value="title_name"/>&title.title_content=<s:property value="title_content"/>&title_people_name=<s:property value="title_people_name"/>">转发</a>
<a href="AddZan.action?tit.title_content=<s:property value="title_content"/>&name=<s:property value="member.getName()"/>&nameid=<s:property value="member.getVip_id()"/>&tit.title_id=<s:property value="title_id"/>"><span style="color:red;">赞(<s:property value="zan"/>)</span></a>
<input type="hidden" name="comment.comment_titleId" value="<s:property value="title_host"/>">
<!-- 获取时间 -->
<div id="hide" style="width:500px;height:100px;display:block;">
<textarea name="comment.comment_content" cols="100" rows="5" id="textarea"></textarea>
</div>
</tr>
</form>
</s:iterator>
</table>
</div>
</body>
<script language="javascript">
function show()
{
	document.getElementById("hide").style.display='block';
}
function hide()

{
	document.getElementById("hide").style.display='none';
}
function getTime()
{
	
	var d = new Date();
	
var str = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
document.getElementById("time").value = str;
}
function comment()
{
	//alert("评论");
	  document.getElementById("f1").submit();
	}
function transmit()
{
	alert("转发");
	  document.getElementById("f2").submit();
	}
function checksubmit()
	{
	 var a=document.getElementById("textarea").value;		
		if(a==""||a==null)
		{
			alert("的确是空");
			 return false;
		} 			
	}
</script>
</html>