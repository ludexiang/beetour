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
<link rel="stylesheet" href="/springmvc-mongo/static/css/qiniu/bootstrap.css">
<link rel="stylesheet" href="/springmvc-mongo/static/css/qiniu/main.css">
<link rel="stylesheet" href="/springmvc-mongo/static/css/qiniu/highlight.css">
</head>
<script type="text/javascript" src="/springmvc-mongo/laydate/laydate.js"></script>
<script type="text/javascript" src="/springmvc-mongo/static/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/springmvc-mongo/static/js/qiniu/bootstrap.js"></script>
<script type="text/javascript"
	src="/springmvc-mongo/static/js/qiniu/plupload.full.min.js"></script>
<script type="text/javascript" src="/springmvc-mongo/static/js/qiniu/ui.js"></script>
<script type="text/javascript" src="/springmvc-mongo/static/js/qiniu/qiniu.js"></script>
<script type="text/javascript" src="/springmvc-mongo/static/js/qiniu/highlight.js"></script>
</head>
<body>
	<header>
		<div style="text-align: center;color: red;font-size: 20px;">项目分类修改</div>
	</header>
	<div style="padding-top: 20px; padding-left:200px;">
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
<%-- 		<div>
			<label>项目图片:</label><br>
			小图:<input id='subSpic' name="pic.subSpic" type="text" value="${item.pic.subSpic}"/><br/><br/>
			缩略图:<input id='subPic' name="pic.subPic" type="text" value="${item.pic.subPic}"/><br/><br/>
			大图:<input id='subTpic' name="pic.subTpic" type="text" value="${item.pic.subTpic}"/><br/><br/>
		</div><br/> --%>
		<div>
			<label>项目图片:</label><br>
			小图:
			<div id="container_subSpic">
					<a class="btn btn-default btn-lg" id="pickfiles_subSpic" href="#"> <i
						class="glyphicon glyphicon-plus"></i> <span>选择文件</span>
					</a>
				</div><label id='subSpicUrl'>${item.pic.subSpic}</label><br>
			<input id='subSpic' name="pic.subSpic" type="hidden" value="${item.pic.subSpic}"/><br/><br/>
			缩略图:
			<div id="container_subPic">
					<a class="btn btn-default btn-lg " id="pickfiles_subPic" href="#"> <i
						class="glyphicon glyphicon-plus"></i> <span>选择文件</span>
					</a>
				</div><label id='subPicUrl'>${item.pic.subPic}</label><br>
			<input id='subPic' name="pic.subPic" type="hidden" value="${item.pic.subPic}"/><br/><br/>
			大图:
			<div id="container_subTpic">
					<a class="btn btn-default btn-lg " id="pickfiles_subTpic" href="#"> <i
						class="glyphicon glyphicon-plus"></i> <span>选择文件</span>
					</a>
				</div><label id='subTpicUrl'>${item.pic.subTpic}</label><br>
			<input id='subTpic' name="pic.subTpic" type="hidden" value="${item.pic.subTpic}"/><br/><br/>
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
<script type="text/javascript">
var Q2 = new QiniuJsSDK();
var uploader2 = Q2.uploader({
	runtimes : 'html5,flash,html4', // 上传模式,依次退化
	browse_button : 'pickfiles_subSpic', // 上传选择的点选按钮，**必需**
	// 在初始化时，uptoken, uptoken_url, uptoken_func 三个参数中必须有一个被设置
	// 切如果提供了多个，其优先级为 uptoken > uptoken_url > uptoken_func
	// 其中 uptoken 是直接提供上传凭证，uptoken_url 是提供了获取上传凭证的地址，如果需要定制获取 uptoken 的过程则可以设置
	// uptoken_func
	// uptoken : '', // uptoken 是上传凭证，由其他程序生成
	uptoken_url : '/springmvc-mongo/uptoken', // Ajax 请求 uptoken 的
												// Url，**强烈建议设置**（服务端提供）
	// uptoken_func: function(file){ // 在需要获取 uptoken 时，该方法会被调用
	// // do something
	// return uptoken;
	// },
	get_new_uptoken : false, // 设置上传文件的时候是否每次都重新获取新的 uptoken
	// downtoken_url: '/downtoken',
	// Ajax请求downToken的Url，私有空间时使用,JS-SDK
	// 将向该地址POST文件的key和domain,服务端返回的JSON必须包含`url`字段，`url`值为该文件的下载地址
	 unique_names: true,              // 默认 false，key 为文件名。若开启该选项，JS-SDK
										// 会为每个文件自动生成key（文件名）
	// save_key: true, // 默认 false。若在服务端生成 uptoken 的上传策略中指定了
	// `sava_key`，则开启，SDK在前端将不对key进行任何处理
	domain : '7xsqm8.com2.z0.glb.qiniucdn.com', // bucket 域名，下载资源时用到，**必需**
	container : 'container_subSpic', // 上传区域 DOM ID，默认是 browser_button 的父元素，
	max_file_size : '100mb', // 最大文件体积限制
	flash_swf_url : '/static/js/qiniu/Moxie.swf', // 引入 flash,相对路径
	max_retries : 3, // 上传失败最大重试次数
	dragdrop : false, // 开启可拖曳上传
	drop_element : 'container_subSpic', // 拖曳上传区域元素的 ID，拖曳文件或文件夹后可触发上传
	chunk_size : '4mb', // 分块上传时，每块的体积
	auto_start : true, // 选择文件后自动上传，若关闭需要自己绑定事件触发上传,
	init : {
		'FilesAdded' : function(up, files) {
			plupload.each(files, function(file) {
				// 文件添加进队列后,处理相关的事情
			});
		},
		'BeforeUpload' : function(up, file) {
			// 每个文件上传前,处理相关的事情
		},
		'UploadProgress' : function(up, file) {
			// 每个文件上传时,处理相关的事情
		},
		'FileUploaded' : function(up, file, info) {
			// 每个文件上传成功后,处理相关的事情
			var domain = up.getOption('domain');
			var res = JSON.parse(info);
			var sourceLink = "http://" + domain +"/"+ res.key; // 获取上传成功后的文件的Url
			//$("#subSpicUrl").text("");
			$("#subSpicUrl").text(sourceLink);
			$("#subSpic").val(sourceLink);
		},
		'Error' : function(up, err, errTip) {
			// 上传出错时,处理相关的事情
			alert("errTip : " + errTip);
		},
		'UploadComplete' : function() {
			// 队列文件处理完毕后,处理相关的事情
		},
		'Key' : function(up, file) {
			// 若想在前端对每个文件的key进行个性化处理，可以配置该函数
			// 该配置必须要在 unique_names: false , save_key: false 时才生效

			var key = "";
			// do something with key here
			return key
		}
	}
});


var Q3 = new QiniuJsSDK();
var uploader3 = Q3.uploader({
	runtimes : 'html5,flash,html4', // 上传模式,依次退化
	browse_button : 'pickfiles_subPic', // 上传选择的点选按钮，**必需**
	// 在初始化时，uptoken, uptoken_url, uptoken_func 三个参数中必须有一个被设置
	// 切如果提供了多个，其优先级为 uptoken > uptoken_url > uptoken_func
	// 其中 uptoken 是直接提供上传凭证，uptoken_url 是提供了获取上传凭证的地址，如果需要定制获取 uptoken 的过程则可以设置
	// uptoken_func
	// uptoken : '', // uptoken 是上传凭证，由其他程序生成
	uptoken_url : '/springmvc-mongo/uptoken', // Ajax 请求 uptoken 的
												// Url，**强烈建议设置**（服务端提供）
	// uptoken_func: function(file){ // 在需要获取 uptoken 时，该方法会被调用
	// // do something
	// return uptoken;
	// },
	get_new_uptoken : false, // 设置上传文件的时候是否每次都重新获取新的 uptoken
	// downtoken_url: '/downtoken',
	// Ajax请求downToken的Url，私有空间时使用,JS-SDK
	// 将向该地址POST文件的key和domain,服务端返回的JSON必须包含`url`字段，`url`值为该文件的下载地址
	 unique_names: true,              // 默认 false，key 为文件名。若开启该选项，JS-SDK
										// 会为每个文件自动生成key（文件名）
	// save_key: true, // 默认 false。若在服务端生成 uptoken 的上传策略中指定了
	// `sava_key`，则开启，SDK在前端将不对key进行任何处理
	domain : '7xsqm8.com2.z0.glb.qiniucdn.com', // bucket 域名，下载资源时用到，**必需**
	container : 'container_subPic', // 上传区域 DOM ID，默认是 browser_button 的父元素，
	max_file_size : '100mb', // 最大文件体积限制
	flash_swf_url : '/static/js/qiniu/Moxie.swf', // 引入 flash,相对路径
	max_retries : 3, // 上传失败最大重试次数
	dragdrop : false, // 开启可拖曳上传
	drop_element : 'container_subPic', // 拖曳上传区域元素的 ID，拖曳文件或文件夹后可触发上传
	chunk_size : '4mb', // 分块上传时，每块的体积
	auto_start : true, // 选择文件后自动上传，若关闭需要自己绑定事件触发上传,
	// x_vars : {
	// 自定义变量，参考http://developer.qiniu.com/docs/v6/api/overview/up/response/vars.html
	// 'time' : function(up,file) {
	// var time = (new Date()).getTime();
	// do something with 'time'
	// return time;
	// },
	// 'size' : function(up,file) {
	// var size = file.size;
	// do something with 'size'
	// return size;
	// }
	// },
	init : {
		'FilesAdded' : function(up, files) {
			plupload.each(files, function(file) {
				// 文件添加进队列后,处理相关的事情
			});
		},
		'BeforeUpload' : function(up, file) {
			// 每个文件上传前,处理相关的事情
		},
		'UploadProgress' : function(up, file) {
			// 每个文件上传时,处理相关的事情
		},
		'FileUploaded' : function(up, file, info) {
			// 每个文件上传成功后,处理相关的事情
			// 其中 info 是文件上传成功后，服务端返回的json，形式如
			// {
			// "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
			// "key": "gogopher.jpg"
			// }
			// 参考http://developer.qiniu.com/docs/v6/api/overview/up/response/simple-response.html

			var domain = up.getOption('domain');
			var res = JSON.parse(info);
			var sourceLink = "http://" + domain +"/"+ res.key; // 获取上传成功后的文件的Url
			$("#subPicUrl").text("");
			$("#subPicUrl").text(sourceLink);
			$("#subPic").val(sourceLink);
		},
		'Error' : function(up, err, errTip) {
			// 上传出错时,处理相关的事情
			alert("errTip : " + errTip);
		},
		'UploadComplete' : function() {
			// 队列文件处理完毕后,处理相关的事情
		},
		'Key' : function(up, file) {
			// 若想在前端对每个文件的key进行个性化处理，可以配置该函数
			// 该配置必须要在 unique_names: false , save_key: false 时才生效

			var key = "";
			// do something with key here
			return key
		}
	}
});


var Q4 = new QiniuJsSDK();
var uploader4 = Q4.uploader({
	runtimes : 'html5,flash,html4', // 上传模式,依次退化
	browse_button : 'pickfiles_subTpic', // 上传选择的点选按钮，**必需**
	// 在初始化时，uptoken, uptoken_url, uptoken_func 三个参数中必须有一个被设置
	// 切如果提供了多个，其优先级为 uptoken > uptoken_url > uptoken_func
	// 其中 uptoken 是直接提供上传凭证，uptoken_url 是提供了获取上传凭证的地址，如果需要定制获取 uptoken 的过程则可以设置
	// uptoken_func
	// uptoken : '', // uptoken 是上传凭证，由其他程序生成
	uptoken_url : '/springmvc-mongo/uptoken', // Ajax 请求 uptoken 的
												// Url，**强烈建议设置**（服务端提供）
	// uptoken_func: function(file){ // 在需要获取 uptoken 时，该方法会被调用
	// // do something
	// return uptoken;
	// },
	get_new_uptoken : false, // 设置上传文件的时候是否每次都重新获取新的 uptoken
	// downtoken_url: '/downtoken',
	// Ajax请求downToken的Url，私有空间时使用,JS-SDK
	// 将向该地址POST文件的key和domain,服务端返回的JSON必须包含`url`字段，`url`值为该文件的下载地址
	 unique_names: true,              // 默认 false，key 为文件名。若开启该选项，JS-SDK
										// 会为每个文件自动生成key（文件名）
	// save_key: true, // 默认 false。若在服务端生成 uptoken 的上传策略中指定了
	// `sava_key`，则开启，SDK在前端将不对key进行任何处理
	domain : '7xsqm8.com2.z0.glb.qiniucdn.com', // bucket 域名，下载资源时用到，**必需**
	container : 'container_subTpic', // 上传区域 DOM ID，默认是 browser_button 的父元素，
	max_file_size : '100mb', // 最大文件体积限制
	flash_swf_url : '/static/js/qiniu/Moxie.swf', // 引入 flash,相对路径
	max_retries : 3, // 上传失败最大重试次数
	dragdrop : false, // 开启可拖曳上传
	drop_element : 'container_subTpic', // 拖曳上传区域元素的 ID，拖曳文件或文件夹后可触发上传
	chunk_size : '4mb', // 分块上传时，每块的体积
	auto_start : true, // 选择文件后自动上传，若关闭需要自己绑定事件触发上传,
	// x_vars : {
	// 自定义变量，参考http://developer.qiniu.com/docs/v6/api/overview/up/response/vars.html
	// 'time' : function(up,file) {
	// var time = (new Date()).getTime();
	// do something with 'time'
	// return time;
	// },
	// 'size' : function(up,file) {
	// var size = file.size;
	// do something with 'size'
	// return size;
	// }
	// },
	init : {
		'FilesAdded' : function(up, files) {
			plupload.each(files, function(file) {
				// 文件添加进队列后,处理相关的事情
			});
		},
		'BeforeUpload' : function(up, file) {
			// 每个文件上传前,处理相关的事情
		},
		'UploadProgress' : function(up, file) {
			// 每个文件上传时,处理相关的事情
		},
		'FileUploaded' : function(up, file, info) {
			// 每个文件上传成功后,处理相关的事情
			// 其中 info 是文件上传成功后，服务端返回的json，形式如
			// {
			// "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
			// "key": "gogopher.jpg"
			// }
			// 参考http://developer.qiniu.com/docs/v6/api/overview/up/response/simple-response.html

			var domain = up.getOption('domain');
			var res = JSON.parse(info);
			var sourceLink = "http://" + domain +"/"+ res.key; // 获取上传成功后的文件的Url
			$("#subTpicUrl").text("");
			$("#subTpicUrl").text(sourceLink);
			$("#subTpic").val(sourceLink);
		},
		'Error' : function(up, err, errTip) {
			// 上传出错时,处理相关的事情
			alert("errTip : " + errTip);
		},
		'UploadComplete' : function() {
			// 队列文件处理完毕后,处理相关的事情
		},
		'Key' : function(up, file) {
			// 若想在前端对每个文件的key进行个性化处理，可以配置该函数
			// 该配置必须要在 unique_names: false , save_key: false 时才生效

			var key = "";
			// do something with key here
			return key
		}
	}
});

</script>
</html>