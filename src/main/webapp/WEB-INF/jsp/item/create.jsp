<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目增加</title>
</head>
<script type="text/javascript" src="/springmvc-mongo/laydate/laydate.js"></script>
<body>
	<header>
		<div style="text-align: center;color: red;font-size: 20px;">项目增加</div>
	</header>
	<div style="padding-top: 20px;">
	<form:form modelAttribute="item" method="post" action="save">
		<div>
			<label>所属分类 </label>
			<select name="itemgpId">
				<c:forEach var="itemgp" items="${itemgp}">
				<option value="<c:out value="${itemgp.id}" />"><c:out value="${itemgp.catetoryName}"/></option>
				</c:forEach>
			</select>
		</div><br/>
		 <div>
			<label>项目名称 </label>
			<input id='entityName' name="entity.entityName" type="text" placeholder=""/>
		</div><br/>				
		<div>
			<label>项目图片:</label><br>
			小图:<input id='subSpic' name="pic.subSpic" type="text" placeholder=""/><br/><br/>
			缩略图:<input id='subPic' name="pic.subPic" type="text" placeholder=""/><br/><br/>
			大图:<input id='subTpic' name="pic.subTpic" type="text" placeholder=""/><br/><br/>
		</div><br/>
		<div>
			<label>地点 </label>
			<input id='destination' name="destination" type="text" placeholder=""/>
		</div><br/>	
		<div>
			<label>项目概要:</label><br>
			<textarea id="synopsis" rows="5" cols="55" name="synopsis"></textarea>
		</div><br/>
		<div>
			<label>项目内容:</label><br>
			<textarea id="entityContext" rows="5" cols="55" name="entityContext"></textarea>
		</div><br/>
		<div>
			<label>必须:</label><br>
			<textarea id="requirement" rows="5" cols="55" name="requirement"></textarea>
		</div><br/>
		<div>
			<label>收获:</label><br>
			<textarea id="harvest" rows="5" cols="55" name="harvest"></textarea>
		</div><br/>
		<div>
		 项目开始日期： <input class="laydate-icon" onclick="laydate()"  name="time.startime" id="startime"  placeholder='请选择开始日期'/>
		 项目结束日期： <input class="laydate-icon" onclick="laydate()"  name="time.endtime" id="startime" placeholder='请选择结束日期'/>
		</div>
		<div>
			<label>价格:</label><br>
			市场价:<input id='baseTotalAmount' name="price.baseTotalAmount" type="text" placeholder=""/><br/><br/>
			优惠价:<input id='basePreferentialPrice' name="price.basePreferentialPrice" type="text" placeholder=""/><br/><br/>
			团购价:<input id='perPrice' name="price.perPrice" type="text" placeholder=""/><br/><br/>
		</div><br/>
		<div>
			<label>价格说明:</label><br>
			<input id='costInfo' name="costInfo" type="text" placeholder=""/>
		</div><br/>
		<div>
			<label>包括:</label><br>
			<textarea id="include" rows="5" cols="55" name="include"></textarea>
		</div><br/>
		<div>
			<label>不包括:</label><br>
			<textarea id="notInclude" rows="5" cols="55" name="notInclude"></textarea>
		</div><br/>
		<div>
			<label>是否置顶 </label>
			<select name="top">
				<option value="0" />否</option>
				<option value="1" />是</option>
			</select>
		</div><br/>
		
		 <div style="padding-top: 20px;">
		 	<input type="submit" value="增加" />
		</div>
	</form:form> 

	</div>

</body>
</html>