<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<link rel="stylesheet" type="text/css" href="../static/css/pagination.css" />
</head>
<body>
	<script src="../static/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="../static/js/jquery.pagination.js"></script>	
	<script type="text/javascript" src="../static/js/page.js"></script>	
	<section>
	<script>
		$(document).ready(function(){		
			initPagination();			
		});
	</script>
	<div >
		<section>
		<div id="ajaxData">
			<input type="hidden" id="page" value="${page}"/>
			<input type="hidden" id="totalCount" value="${totalCount}"/>
			<c:choose>
				<c:when test="${customer != null && customer.size() > 0}">
					<table class="table">
						<tr>
							<th>项目1</th>
							<th>项目2</th>
							<th>项目3</th>
						</tr>
							<c:forEach var="customer" items="${customer}">
								<tr>
									<td><c:out value="${customer.id}" /></td>
									<td><c:out value="${customer.firstName}" /></td>
									<td><c:out value="${customer.lastName}" /></td>
									</td>
								</tr>
							</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>温馨提示：暂无订单信息！</p>
				</c:otherwise>
			</c:choose> 
		</div>
		<div id="Pagination" class="flickr"></div>
	</section>

	</div>
	</section>

</body>
</html>