<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#insertbtn").click(function(){
			$.post("ajax",{"method":"insertBoard","boname":$("#newBoName").val()},function(d){
				if(d=="ok"){
					alert("录入成功!");
					window.location.reload(true);
				}else{
					alert("录入出现位置异常");
				}
			});
		});
	});
</script>
<!-- <%@include file="/city.jsp" %>
<jsp:include page="/city.jsp"/>  -->
</head>
<body>
<h2 align="center">板块管理</h2>

<fieldset style="width:60%;margin:20px;padding:10px">
<legend>新增模块</legend>
<form action="">
	<lable>模版名称:</lable>
	<input type="text" id="newBoName" size="50" name="newBoName">
	<input type="button" value="新增模块" id="insertbtn">
</form>
</fieldset>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0"> 
 <tr>
    <td>
		<a href="list.html">上一页</a>|
		<a href="list.html">下一页</a>
	</td>
  </tr>
</table>

<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" class="t">
<tr>
    <th colspan="7" class="h">&nbsp;</th>
  </tr>
  <tr class="tr2">
    <th width="60"><input type="checkbox" name="checkbox2" value="checkbox" />全选</th>
    <th width="100">编号</th>
    <th width="200">板块名</th>
    <th width="150">创建时间</th>
    <th width="80">是否启用</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${requestScope.boards }" var="board">  
  <tr class="tr3">
    <td align="center"><input name="checkbox" type="checkbox" class="tr3" value="checkbox" /></td>
    <td>${board.boId }</td>
    <td>${board.boName }</td>
    <td align="center"><b>${board.boDate }  ${board.boTime }</b></td>
    <td align="center"><c:if test="${board.boFlag eq 1 }">
					<span >是</span>
				</c:if>
				<c:if test="${board.boFlag eq 0 }">
					<span >否</span>
				</c:if>
				</td>
    <td align="center"><a href="#">修改</a>&nbsp;<a href="#">启用</a></td>
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
    <td height="25"><a href="#">禁用选中</a></td>
  </tr>
 
</table>
</body>
</html>