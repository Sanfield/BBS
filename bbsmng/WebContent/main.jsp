<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<style>
	#div1{
		margin-top:15px;
		margin-left:10px;
		width:180px;
	}
	li{
		list-style-type:none;
		line-height:30px;
	}
</style>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="90">
		<DIV>
	<IMG src="image/logo.jpg" style="width:200px;height:50px" />
	<div align="right">现在是：2012-2-26 09:23:45</div>
</DIV>
<DIV class="h">
	欢迎您：${sessionScope.uname }&nbsp;&nbsp;
	| <a href="user?method=logout">安全退出</a>
</DIV>
	</td>
  </tr>
  <tr>
    <td height="5" bgcolor="#E0F0F9"></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="200" height="600" align="left" valign="top"><div id="div1">
	<h3>功能模块选择</h3>
	<ul>
		<li><a href="borads" target="main">板块管理</a></li>
		<li><a href="ChildBorad" target="main">子版块管理</a></li>
		<li><a href="blog?method=blogList" target="main">帖子管理</a></li>
		<li><a href="reply.jsp" target="main">跟贴管理</a></li>
		<li><a href="user?method=getUsers" target="main">用户管理</a></li>
		<li><a href="province.jsp" target="main">省份管理</a></li>
		<li><a href="city.jsp" target="main">市区管理</a></li>
	</ul>
</div></td>
		<td width="5" bgcolor="#E0F0F9"></td>
        <td style="padding:5px 0px 0px 5px;">
			<iframe height="580px" width="100%" frameborder="0" scrolling="no" name="main" src="borads" ></iframe>
		</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#E0F0F9" height="5px"></td>
  </tr>
</table>
</body>
</html>