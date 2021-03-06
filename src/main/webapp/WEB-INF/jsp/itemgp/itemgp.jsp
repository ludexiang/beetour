<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目分类</title>
<link rel="stylesheet" type="text/css" href="/springmvc-mongo/static/css/pagination.css" />
</head>
<body>
	<script src="/springmvc-mongo/static/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="/springmvc-mongo/static/js/jquery.pagination.js"></script>	
	<script type="text/javascript" src="/springmvc-mongo/static/js/web/itemgp.js"></script>	
	<section>
	<script>
		$(document).ready(function(){		
			initPagination();			
		});
	</script>
	<header>
		<div style="text-align: center;color: red;font-size: 20px;">所有项目分类</div>
	</header>
	<div style="padding-top: 20px;">
		<section>
		<div style="text-align: center;">
		<a style="width:150px;height:50px;font-size:35px;" href="/springmvc-mongo/itemgp/create">增加</a>
		</div>		
		<div id="ajaxData">
			<input type="hidden" id="page" value="${page}"/>
			<input type="hidden" id="totalCount" value="${totalCount}"/>
			<c:choose>
				<c:when test="${itemgp != null && itemgp.size() > 0}">
					<table width="100%" border="1" cellpadding="2" cellspacing="0">
						<tr style="text-align: center; color: #0076C8; background-color: #F4FAFF; font-weight: bold">
							<th >id</th>
							<th>项目分类名称</th>
							<th>项目分类图片</th>
							<th>项目介绍</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
							<c:forEach var="itemgp" items="${itemgp}">
								<tr style="text-align: center; color: #0076C8; background-color: #F4FAFF; font-weight: bold">
									<td><c:out value="${itemgp.id}" /></td>
									<td><c:out value="${itemgp.catetoryName}" /></td>
									<td>
									小图：<a href="<c:out value="${itemgp.pic.subSpic}" />"><c:out value="${itemgp.pic.subSpic}" /></a><br>
									缩略图：<a href="<c:out value="${itemgp.pic.subPic}" />"><c:out value="${itemgp.pic.subPic}" /></a><br>
									大图：<a href="<c:out value="${itemgp.pic.subTpic}" />"><c:out value="${itemgp.pic.subTpic}" /></a><br>
									</td>
									<td><c:out value="${itemgp.introduction}" /></td>
									<td> <fmt:formatDate value="${itemgp.created}" pattern="yyyy/MM/dd  HH:mm:ss" /></td>
									<td><a href="/springmvc-mongo/itemgp/delete?id=${itemgp.id}">删除</a>&nbsp;<a href="/springmvc-mongo/itemgp/updateRedirect?id=${itemgp.id}">修改</a>&nbsp;</td>
									</td>
								</tr>
							</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>温馨提示：暂无分类信息！</p>
				</c:otherwise>
			</c:choose> 
		</div>
		<div id="Pagination" class="flickr" style="padding-top: 30px;"></div>
	</section>

	</div>
	</section>
</body>
</html>