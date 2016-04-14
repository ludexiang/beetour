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
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.pagination.js"></script>	
	<script type="text/javascript" src="static/js/page.js"></script>	
			<input type="hidden" id="page" value="${page}"/>
			<input type="hidden" id="totalCount" value="${totalCount}"/>
			<c:choose>
				<c:when test="${item != null && item.size() > 0}">
					<table border="1" cellpadding="2" cellspacing="0">
						<tr style="text-align: center; color: #0076C8; background-color: #F4FAFF; font-weight: bold">
							<th >id</th>
							<th>项目名称</th>
							<th>所属分类</th>
							<th>项目图片</th>
							<th>项目地点</th>
							<th>项目概要</th>
							<th>项目内容</th>
							<th>必须</th>
							<th>收获</th>							
							<th>时间</th>							
							<th>费用</th>							
							<th>费用说明</th>							
							<th>包括</th>							
							<th>不包括</th>							
							<th>是否置顶</th>
							<th>操作</th>
						</tr>
							<c:forEach var="item" items="${item}">
								<tr style="text-align: center; color: #0076C8; background-color: #F4FAFF; font-weight: bold">
									<td style="height: 200px;"><c:out value="${item.id}" /></td>
									<td><c:out value="${item.entity.entityName}" /></td>
									<td><c:out value="${item.entity.entityName}" /></td>
									<td>
									小图：<a href="<c:out value="${item.pic.subSpic}" />"><c:out value="${item.pic.subSpic}" /></a><br>
									缩略图：<a href="<c:out value="${item.pic.subPic}" />"><c:out value="${item.pic.subPic}" /></a><br>
									大图：<a href="<c:out value="${item.pic.subTpic}" />"><c:out value="${item.pic.subTpic}" /></a><br>
									</td>
									<td><c:out value="${item.destination}" /></td>
									<td><c:out value="${item.synopsis}" /></td>
									<td><c:out value="${item.entityContext}" /></td>
									<td><c:out value="${item.requirement}" /></td>
									<td><c:out value="${item.harvest}" /></td>
									<td><fmt:formatDate value="${item.time.startime}" pattern="yyyy/MM/dd" />
									--
									<fmt:formatDate value="${item.time.endtime}" pattern="yyyy/MM/dd" />
									<td style="width: 70px;">市场价：<c:out value="${item.price.baseTotalAmount}" /><br>
										优惠价：<c:out value="${item.price.basePreferentialPrice}" /><br>
										团购价：<c:out value="${item.price.perPrice}" /><br>
									</td>
									<td><c:out value="${item.costInfo}" /></td>
									<td><c:out value="${item.include}" /></td>
									<td><c:out value="${item.notInclude}" /></td>
									<td>
									<c:if test= "${item.top == 0}">否</c:if>
									<c:if test= "${item.top == 1}">是</c:if></td> 
									<td  style="width: 40px;"><a href="/springmvc-mongo/item/delete?id=${item.id}">删除</a><br/><a href="/springmvc-mongo/item/updateRedirect?id=${item.id}">修改</a></td>
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