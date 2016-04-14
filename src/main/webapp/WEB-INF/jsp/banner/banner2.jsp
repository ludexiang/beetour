<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有项目分类</title>
<link rel="stylesheet" type="text/css" href="static/css/pagination.css" />
</head>
<body>	
			<input type="hidden" id="page" value="${page}"/>
			<input type="hidden" id="totalCount" value="${totalCount}"/>
			<c:choose>
				<c:when test="${banner != null && banner.size() > 0}">
					<table width="100%" border="1" cellpadding="2" cellspacing="0">
						<tr style="text-align: center; color: #0076C8; background-color: #F4FAFF; font-weight: bold">
							<th >id</th>
							<th>图片</th>
							<th>介绍</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
							<c:forEach var="banner" items="${banner}">
								<tr style="text-align: center; color: #0076C8; background-color: #F4FAFF; font-weight: bold">
									<td><c:out value="${banner.id}" /></td>
									<td><a href="${banner.pic}">${banner.pic}</a>
									</td>
									<td><c:out value="${banner.content}" /></td>
									<td> <fmt:formatDate value="${banner.created}" pattern="yyyy/MM/dd  HH:mm:ss" /></td>
									<td><a href="/springmvc-mongo/banner/delete?id=${banner.id}">删除</a>&nbsp;<a href="/springmvc-mongo/banner/updateRedirect?id=${banner.id}">修改</a>&nbsp;</td>
									</td>
								</tr>
							</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>温馨提示：暂无分类信息！</p>
				</c:otherwise>
			</c:choose> 
</body>
</html>