<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>测试七牛</title>
<link rel="stylesheet" href="static/css/qiniu/bootstrap.css">
<link rel="stylesheet" href="static/css/qiniu/main.css">
<link rel="stylesheet" href="static/css/qiniu/highlight.css">

<script type="text/javascript" src="static/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="static/js/qiniu/bootstrap.js"></script>
<script type="text/javascript"
	src="static/js/qiniu/plupload.full.min.js"></script>
<script type="text/javascript" src="static/js/qiniu/zh_CN.js"></script>
<script type="text/javascript" src="static/js/qiniu/ui.js"></script>
<script type="text/javascript" src="static/js/qiniu/qiniu.js"></script>
<script type="text/javascript" src="static/js/qiniu/highlight.js"></script>
<!-- <script type="text/javascript" src="static/js/qiniu/multiple.js"></script>
 -->
<!--[if lt IE 9]>
      <script src="js/Respond-1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<input type="hidden" id="uptoken_url" value="upload">
	<input type="hidden" id="domain" value="http://www.inernshiptour.com/">
	<div class="container">
		<div class="body">
			<div class="col-md-12">
				<div id="container">
					<a class="btn btn-default btn-lg " id="pickfiles" href="#"> <i
						class="glyphicon glyphicon-plus"></i> <span>选择文件</span>
					</a>
				</div>
				<div style="display: none" id="success" class="col-md-12">
					<div class="alert-success">队列全部文件处理完毕</div>
				</div>
				<div class="col-md-12 ">
					<table class="table table-striped table-hover text-left"
						style="margin-top: 40px; display: none">
						<thead>
							<tr>
								<th class="col-md-4">Filename</th>
								<th class="col-md-2">Size</th>
								<th class="col-md-6">Detail</th>
							</tr>
						</thead>
						<tbody id="fsUploadProgress">
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
		var Q2 = new QiniuJsSDK();
		var uploader2 = Q2.uploader({
			runtimes : 'html5,flash,html4', // 上传模式,依次退化
			browse_button : 'pickfiles', // 上传选择的点选按钮，**必需**
			// 在初始化时，uptoken, uptoken_url, uptoken_func 三个参数中必须有一个被设置
			// 切如果提供了多个，其优先级为 uptoken > uptoken_url > uptoken_func
			// 其中 uptoken 是直接提供上传凭证，uptoken_url 是提供了获取上传凭证的地址，如果需要定制获取 uptoken 的过程则可以设置 uptoken_func
			// uptoken : '', // uptoken 是上传凭证，由其他程序生成
			uptoken_url : '/springmvc-mongo/uptoken', // Ajax 请求 uptoken 的 Url，**强烈建议设置**（服务端提供）
			// uptoken_func: function(file){    // 在需要获取 uptoken 时，该方法会被调用
			//    // do something
			//    return uptoken;
			// },
			get_new_uptoken : false, // 设置上传文件的时候是否每次都重新获取新的 uptoken
			// downtoken_url: '/downtoken',
			// Ajax请求downToken的Url，私有空间时使用,JS-SDK 将向该地址POST文件的key和domain,服务端返回的JSON必须包含`url`字段，`url`值为该文件的下载地址
			 unique_names: true,              // 默认 false，key 为文件名。若开启该选项，JS-SDK 会为每个文件自动生成key（文件名）
			// save_key: true,                  // 默认 false。若在服务端生成 uptoken 的上传策略中指定了 `sava_key`，则开启，SDK在前端将不对key进行任何处理
			domain : '7xsqm8.com2.z0.glb.qiniucdn.com', // bucket 域名，下载资源时用到，**必需**
			container : 'container', // 上传区域 DOM ID，默认是 browser_button 的父元素，
			max_file_size : '100mb', // 最大文件体积限制
			flash_swf_url : '/static/js/qiniu/Moxie.swf', //引入 flash,相对路径
			max_retries : 3, // 上传失败最大重试次数
			dragdrop : false, // 开启可拖曳上传
			drop_element : 'container', // 拖曳上传区域元素的 ID，拖曳文件或文件夹后可触发上传
			chunk_size : '4mb', // 分块上传时，每块的体积
			auto_start : true, // 选择文件后自动上传，若关闭需要自己绑定事件触发上传,
			//x_vars : {
			//    自定义变量，参考http://developer.qiniu.com/docs/v6/api/overview/up/response/vars.html
			//    'time' : function(up,file) {
			//        var time = (new Date()).getTime();
			// do something with 'time'
			//        return time;
			//    },
			//    'size' : function(up,file) {
			//        var size = file.size;
			// do something with 'size'
			//        return size;
			//    }
			//},
			init : {
				'FilesAdded' : function(up, files) {
					plupload.each(files, function(file) {
						// 文件添加进队列后,处理相关的事情
					});
				},
				'BeforeUpload' : function(up, file) {
					// 每个文件上传前,处理相关的事情
					alert("上传");
				},
				'UploadProgress' : function(up, file) {
					// 每个文件上传时,处理相关的事情
				},
				'FileUploaded' : function(up, file, info) {
					// 每个文件上传成功后,处理相关的事情
					// 其中 info 是文件上传成功后，服务端返回的json，形式如
					// {
					//    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
					//    "key": "gogopher.jpg"
					//  }
					// 参考http://developer.qiniu.com/docs/v6/api/overview/up/response/simple-response.html

					var domain = up.getOption('domain');
					var res = JSON.parse(info);
					var sourceLink = "http://" + domain +"/"+ res.key; //获取上传成功后的文件的Url 
				},
				'Error' : function(up, err, errTip) {
					//上传出错时,处理相关的事情
					alert("errTip : " + errTip);
				},
				'UploadComplete' : function() {
					//队列文件处理完毕后,处理相关的事情
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
