<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<h2 align="center">用户管理</h2>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
    <td>
		<a href="list.html">添加管理员</a>
	</td>
  </tr>
  <tr>
    <td>
		<a href="list.html">上一页</a>|
		<a href="list.html">下一页</a>
	</td>
  </tr>
</table>

<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" class="t">
<tr>
    <th colspan="9" class="h">&nbsp;</th>
  </tr>
  <tr class="tr2">
    <th width="60"><input type="checkbox" name="checkbox2" value="checkbox" />全选</th>
    <th>用户名</th>
    <th width="100">所属省</th>
    <th width="100">所属市</th>
    <th width="50">性别</th>
	<th width="130">注册时间</th>
	<th width="70">管理员</th>
	<th width="60">状态</th>
    <th width="70">操作</th>
  </tr>
  <c:forEach items="${requestScope.users }" var="user">  
  <tr class="tr3">
    <td align="center"><input name="checkbox" type="checkbox" class="trs3" value="checkbox" /></td>
    <td>${user.uname }</td>
    <td align="left">${user.pname } </td>
    <td align="left">${user.cname }</td>
    <td align="center">${user.usex }</td>
	<td align="center">////</td>
	<td align="center">${user.uadmin eq '1'? '是':'否' }</td>
	<td align="center">是</td>
    <td align="center"><a href="#">屏蔽</a></td>
  </tr>
</c:forEach>
</table>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
 <tr>
    <td>
		<a href="list.html">上一页</a>|
		<a href="list.html">下一页</a>
	</td>
  </tr>
  <tr>
    <td><a href="#">屏蔽选中</a></td>
  </tr>
</table>
</body>
</html>