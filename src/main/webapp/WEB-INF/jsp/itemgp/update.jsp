<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目分类修改</title>
</head>
<body>
	<header>
		<div style="text-align: center;color: red;font-size: 20px;">项目分类修改</div>
	</header>
	<div style="padding-top: 20px;">
	<form:form modelAttribute="itemgp" method="post" action="update">
		<input type="hidden" name="id" value="${itemgp.id}"/>
		 <div>
			<label>项目分类名称 </label>
			<input id='catetoryName' name="catetoryName" type="text" value="${itemgp.catetoryName}"/>
		</div><br/>				
		<div>
			<label>项目介绍:</label><br>
			<textarea id="introduction" rows="5" cols="55" name="introduction">${itemgp.introduction}</textarea>
		</div><br/>
		<div>
			<label>项目分类图片:</label><br>
			小图:<label>${itemgp.pic.subSpic}</label><br><br/>
			缩略图:<label>${itemgp.pic.subPic}</label><br><br/>
			大图:<label>${itemgp.pic.subTpic}</label><br><br/>
		</div>
		<div style="padding-top: 20px;">
		 	<input type="submit" value="修改" />
		</div>
	</form:form> 

	</div>

</body>
</html>