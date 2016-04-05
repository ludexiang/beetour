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
<script type="text/javascript" src="static/js/qiniu/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/qiniu/plupload.full.min.js"></script>
<script type="text/javascript" src="static/js/qiniu/zh_CN.js"></script>
<script type="text/javascript" src="static/js/qiniu/ui.js"></script>
<script type="text/javascript" src="static/js/qiniu/qiniu.js"></script>
<script type="text/javascript" src="static/js/qiniu/highlight.js"></script>
<script type="text/javascript" src="static/js/qiniu/multiple.js"></script>

<!--[if lt IE 9]>
      <script src="js/Respond-1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<input type="hidden" id="domain"
		value="http://qiniu-plupload.qiniudn.com/">
	<input type="hidden" id="uptoken_url" value="/uptoken">
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
