<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目分类增加</title>
</head>
<body>
	<script src="../static/js/jquery-1.11.1.min.js"></script>
	<header>
		<div style="text-align: center;color: red;font-size: 20px;">项目分类增加</div>
	</header>
	<div style="padding-top: 20px;">
	<form:form modelAttribute="itemgp" method="post" action="save">
		 <div>
			<label>项目分类名称 </label>
			<input id='catetoryName' name="catetoryName" type="text" placeholder=""/>
		</div><br/>				
		<div>
			<label>项目介绍:</label><br>
			<textarea id="introduction" rows="5" cols="55" name="introduction"></textarea>
		</div><br/>
		<div>
			<label>项目分类图片:</label><br>
			小图:<input id='subSpic' name="pic.subSpic" type="text" placeholder=""/><br/><br/>
			缩略图:<input id='subPic' name="pic.subPic" type="text" placeholder=""/><br/><br/>
			大图:<input id='subTpic' name="pic.subTpic" type="text" placeholder=""/><br/><br/>
		</div>
		 <div style="padding-top: 20px;">
		 	<input type="submit" value="增加" />
		</div>
	</form:form> 

	</div>

</body>
</html>