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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
		$(function(){
			$.getJSON("ajax",{"method":"getBoard"},function(d){
				$("#borad").empty();
				$.each(d,function(i,n){
					$("#borad").append("<option value='"+n.boId+"'>"+n.boName+"</option>");
				//	alert(n.boId);
				});
			});
			$("#borad").change(function(){
				$.getJSON("ajax",{"method":"getChild","pid":$(this).val()},function(d){
					$(".tr3").empty();
					$.each(d,function(i,n){
						$("#t").after("<tr class='tr3'>"+
								"<td align='center'><input name='checkbox' type='checkbox' class='tr3' value='checkbox' /></td>"+								
								"<td>"+n.cbId+"</td>"+
								"<td>"+n.cboName+"</td>"+
								"<td>"+n.cobFlag+"</td>"+
								"<td align='center'><a href='#''>修改</a>&nbsp;<a href='#'>启用</a></td>"+
								"</tr>");
						//alert(n.cbId);
					});
				});
			});
		});
</script>
<body>
<h2 align="center">子板块管理</h2>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="25" colspan="2"><a href="#">新增子板块</a></td>
  </tr> <tr>
    <td width="400">
		<a href="list.html">上一页</a>|
		<a href="list.html">下一页</a>
	</td>
    <td align="right" style="margin-right:10px;">选择主版块
      <select name="borad" id="borad">
      <option value="-1">选择主类</option>
      </select>
    </td>
  </tr>
</table>

<table width="900" border="0" align="center" cellpadding="0" cellspacing="0"  >
<tr>
    <th colspan="8" class="h">&nbsp;</th>
  </tr>
  <tr class="tr2" id="t">
  	<th width="60"><input type="checkbox" name="checkbox2" value="checkbox" />全选</th>
    <th width="100">编号</th>
    <th width="260">板块名</th>
    <th width="80">是否启用</th>
    <th>操作</th>
  </tr>	

<!--  <c:forEach items="${requestScope.childBoards }" var="child">
  <tr class="tr3">
  	<td align="center"><input name="checkbox" type="checkbox" class="tr3" value="checkbox" /></td>
    <td>${child.cbId }</td>
    <td>${child.cboName }</td>
    <td></td>
    <td align="center">${child.cboDate }  ${child.cboTime }</td>
    <td align="center">是</td>
    <td align="center"><a href="#">修改</a>&nbsp;<a href="#">启用</a></td>
  </tr>
 </c:forEach>  -->
 </form>
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