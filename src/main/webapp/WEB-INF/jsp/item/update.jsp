<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目分类修改</title>
<script type="text/javascript" src="/springmvc-mongo/laydate/laydate.js"></script>
</head>
<body>
	<header>
		<div style="text-align: center;color: red;font-size: 20px;">项目分类修改</div>
	</header>
	<div style="padding-top: 20px;">
	<form:form modelAttribute="item" method="post" action="update">
	<input type="hidden" name="id" value="${item.id}"/>
		<div>
			<label>所属分类 </label>
			<select name="itemgpId">
				<c:forEach var="itemgp" items="${itemgp}">
				<c:if test= "${itemgp.id == item.itemgpId}">否</c:if>
				<option value="<c:out value="${itemgp.id}" />" <c:if test= "${itemgp.id == item.itemgpId}">selected = "selected"</c:if> ><c:out value="${itemgp.catetoryName}"/></option>
				</c:forEach>
			</select>
		</div><br/>
		 <div>
			<label>项目名称 </label>
			<input id='entityName' name="entity.entityName" type="text" value="${item.entity.entityName}"/>
		</div><br/>				
		<div>
			<label>项目图片:</label><br>
			小图:<input id='subSpic' name="pic.subSpic" type="text" value="${item.pic.subSpic}"/><br/><br/>
			缩略图:<input id='subPic' name="pic.subPic" type="text" value="${item.pic.subPic}"/><br/><br/>
			大图:<input id='subTpic' name="pic.subTpic" type="text" value="${item.pic.subTpic}"/><br/><br/>
		</div><br/>
		<div>
			<label>地点 </label>
			<input id='destination' name="destination" type="text" value="${item.destination}"/>
		</div><br/>	
		<div>
			<label>项目概要:</label><br>
			<textarea id="synopsis" rows="5" cols="55" name="synopsis">${item.synopsis}</textarea>
		</div><br/>
		<div>
			<label>项目内容:</label><br>
			<textarea id="entityContext" rows="5" cols="55" name="entityContext">${item.entityContext}</textarea>
		</div><br/>
		<div>
			<label>必须:</label><br>
			<textarea id="requirement" rows="5" cols="55" name="requirement">${item.requirement}</textarea>
		</div><br/>
		<div>
			<label>收获:</label><br>
			<textarea id="harvest" rows="5" cols="55" name="harvest">${item.harvest}</textarea>
		</div><br/>
		<div>
		 项目开始日期： <input class="laydate-icon" onclick="laydate()" name="time.startime" id="startime"  placeholder='请选择开始日期' value="<fmt:formatDate value="${item.time.startime}" pattern="yyyy-MM-dd" />"/>
		 项目结束日期： <input class="laydate-icon" onclick="laydate()" name="time.endtime" id="startime" placeholder='请选择结束日期' value="<fmt:formatDate value="${item.time.endtime}" pattern="yyyy-MM-dd" />"/>
		</div>
		<div>
			<label>价格:</label><br>
			市场价:<input id='baseTotalAmount' name="price.baseTotalAmount" type="text" value="${item.price.baseTotalAmount}"/><br/><br/>
			优惠价:<input id='basePreferentialPrice' name="price.basePreferentialPrice" type="text" value="${item.price.basePreferentialPrice}"/><br/><br/>
			团购价:<input id='perPrice' name="price.perPrice" type="text" value="${item.price.perPrice}"/><br/><br/>
		</div><br/>
		<div>
			<label>价格说明:</label><br>
			<input id='costInfo' name="costInfo" type="text" placeholder="" value="${item.costInfo}"/>
		</div><br/>
		<div>
			<label>包括:</label><br>
			<textarea id="include" rows="5" cols="55" name="include">${item.include}</textarea>
		</div><br/>
		<div>
			<label>不包括:</label><br>
			<textarea id="notInclude" rows="5" cols="55" name="notInclude">${item.notInclude}</textarea>
		</div><br/>
		<div>
			<label>是否置顶 </label>
			<select name="top">
				<option value="0" <c:if test= "${item.top == 0}">selected</c:if> >否</option>
				<option value="1" <c:if test= "${item.top == 1}">selected</c:if> >是</option>
			</select> 
		</div><br/>
		
		 <div style="padding-top: 20px;">
		 	<input type="submit" value="修改" />
		</div>
	</form:form> 

	</div>

</body>
</html>