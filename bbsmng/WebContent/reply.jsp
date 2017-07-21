<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<h2 align="center">跟帖管理</h2>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="50%">
		<a href="list.html">上一页</a>|
		<a href="list.html">下一页</a>
	</td>
    <td align="right">选择发帖：
      <select name="select2">
    </select></td>
  </tr>
</table>

<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" class="t">
<tr>
    <th colspan="7" class="h">&nbsp;</th>
  </tr>
  <tr class="tr2">
    <th width="60"><input type="checkbox" name="checkbox2" value="checkbox" />全选</th>
    <th width="260">内容</th>
    <th width="130">回复时间</th>
    <th width="60">跟帖人</th>
    <th width="180">所属帖子</th>
	<th width="60">是否删除</th>
    <th>操作</th>
  </tr>
  <tr class="tr3">
    <td align="center"><input name="checkbox" type="checkbox" class="tr3" value="checkbox" /></td>
    <td>15435</td>
    <td align="center">2011-11-12 12:34:34 </td>
    <td align="left">丽弟弟</td>
    <td align="center">是</td>
	<td align="center">是</td>
    <td align="center"><a href="#">删除</a></td>
  </tr>
</table>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
 <tr>
    <td>
		<a href="list.html">上一页</a>|
		<a href="list.html">下一页</a>
	</td>
  </tr>
  <tr>
    <td height="25"><a href="#">删除选中</a></td>
  </tr>
</table>
</body>
</html>