<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.getJSON("ajax",{"method":"getChild"},function(d){
			$("#cbid").empty();
			$.each(d,function(i,n){
				$("#cbid").append("<option value='"+n.cbId+"'>"+n.cboName+"</option>");
			});
			$("#cbid").val('${cbid}');
		});
		$("#selectAll").click(function(){
			var a = $(this).get(0).checked;
			if(a){
				$(":checkbox").prop("checked",true);
			}else{
				$(":checkbox").prop("checked",false);
			}
		});
		$("#delAll").click(function(){
			if($("input:checked").size()==0){
				alert("最少一个被选中");
				return false;
			}
			if(confirm("确定删除选中帖子吗？")){
				$("form[name=blogsForm]").get(0).submit();
			}
			return false;
		});
	});
	function a(){
		var form1 = $("#childForm").get(0);
		form1.submit();
	}
</script>
</head>

<body>
<div style="text-align: center; font-weight: bold;">发帖管理</div>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="50%">
		<a href="blog?method=blogList&pn=${requestScope.pageNow-1 }">上一页</a>|
		<a href="blog?method=blogList&pn=${requestScope.pageNow+1 }">下一页</a>
	</td>
    <td align="right">
    <form id="childForm" action="blog" method="post">
    <input type="hidden" name="method" value="blogList">
    子版块：
    <select name="cbid" id="cbid" onchange="a()">
    <option value="-1">选择板块</option>
    </select>
    </form>
    </td>
  </tr>
</table>

<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="t">
<tr>
    <th colspan="7" class="h">&nbsp;</th>
  </tr>
  <tr class="tr2">
    <th width="60"><input type="checkbox" id="selectAll" name="checkbox2" value="checkbox" />全选</th>
    <th>标题</th>
    <th width="150">录入时间</th>
    <th width="80">发帖人</th>
    <th width="200">所属板块</th>
	<th width="60">是否删除</th>
    <th width="60">操作</th>
  </tr>
  <form name="blogsForm" action="blog" method="post">
  <input type="hidden" name="method" value="delete">
  <c:forEach items="${requestScope.blogs }" var="blog">
  <tr class="tr3">
    <td align="center">
    	<input name="blids" type="checkbox" class="tr3" value="${blog.blId }" />
    </td>
    <td title="${blog.blTitle }">${blog.blTitle }</td>
    <td align="center">${blog.blDate }&nbsp;${blog.blTime }</td>
    <td align="left">${blog.uname }</td>
    <td align="center">${blog.childName }</td>
	<td align="center">${blog.blDelete eq '0'?'否':'是' }</td>
    <td align="center">
    	<c:if test="${blog.blDelete eq '0' }">
    	<a href="blog?method=delete&blids=${blog.blId }" onclick="return confirm('确定删除吗？')">删除</a>
    	</c:if>
    	<c:if test="${not (blog.blDelete eq '0') }">删除</c:if>
    </td>
  </tr>
  </c:forEach>
  </form>
</table>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
 <tr>
    <td>
		<a href="blog?method=blogList&pn=${requestScope.pageNow-1 }">上一页</a>|
		<a href="blog?method=blogList&pn=${requestScope.pageNow+1 }">下一页</a>
	</td>
  </tr>
  <tr>
    <td height="25"><a href="#" id="delAll">删除选中</a></td>
  </tr>
</table>
</body>
</html>