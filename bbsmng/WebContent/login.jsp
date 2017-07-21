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
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<form id="form1" name="form1" method="post" action="user">
	<input type="hidden" name="method" value="login">
  <table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <th height="45" colspan="2"><font size="+1">尚学堂论坛管理登录</font></th>
    </tr>
    <tr>
      <td width="150" height="35" align="right">用户名：</td>
      <td align="left"><input name="uname" type="text" value="${requestScope.uname }" class="input" style="width:130px;" /></td>
    </tr>
    <tr>
      <td height="35" align="right">密码：</td>
      <td align="left"><input name="upass" value="${requestScope.upass }" type="password" class="input" style="width:130px;" /></td>
    </tr>
    <tr>
      <td height="35" colspan="2" align="center"><input name="Submit" type="submit" class="btn" value=" 登 录 " /></td>
    </tr>
  </table>
  <div style="text-align: center;color: red;">${requestScope.msg }</div>
</form>
</body>
</html>