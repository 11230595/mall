<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <#include "../template/ico.ftl"><!-- ico文件-->

    <title>囤货网-后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${request.contextPath}/bootstrap/css/navbar-fixed-top.css" rel="stylesheet">

    <script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/bootstrap/js/ie-emulation-modes-warning.js"></script>
  	<script src="${request.contextPath}/js/common/common.js"></script>
  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${url}">囤货网首页</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="${request.contextPath}/admin">导入数据</a></li>
            <li><a href="#about">模板管理</a></li>
            <li><a href="${request.contextPath}/banner/admin/toAdd">Banner管理</a></li>
            <li class="active"><a href="${request.contextPath}/hd/admin/add">平台活动管理</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">欢迎您：${user.userCode!"管理员"}</a></li>
            <li><a href="javascript:void(0);" onclick="loginOut();">退出</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
		<div class="jumbotron">
		    <h3>平台活动导入</h3>
		    <!-- form start -->
		    <form role="form" id="f">
			   <div class="form-group">
			      <select class="form-control" name="platform" id="platform">
			         <option value="-1">请选择活动的平台</option>
			         <option value="0">淘宝</option>
			         <option value="1">天猫</option>
			         <option value="2">爱淘宝</option>
			         <option value="3">京东</option>
			         <option value="4">苏宁</option>
			      </select>
			   </div>
			
			   <div class="form-group">
			      <select class="form-control" name="clientType" id="clientType">
			         <option value="-1">请选择展示终端</option>
			         <option value="0">PC</option>
			         <option value="1">Mobile</option>
			      </select>
			   </div>
			   
			   <div class="form-group">
			      <div class="form-group">
				    <label for="name">活动标题</label>
				    <input class="form-control" type="text" id="title" name="title" placeholder="请输入活动标题">
				  </div>
			   </div>
			
			   <div class="form-group">
			      <div class="form-group">
				    <label for="name">活动地址</label>
				    <textarea class="form-control" rows="3" name="itemUrl" id="itemUrl"></textarea>
				  </div>
			   </div>
			   
			   <div class="form-group">
			      <div class="form-group">
				    <label for="name">活动开始时间</label>
				    <input class="form-control" type="date" id="startTime" name="startTime" placeholder="yyyy-MM-dd">
				  </div>
			   </div>
			   
			   <div class="form-group">
			      <div class="form-group">
				    <label for="name">活动结束时间</label>
				    <input class="form-control" type="date" id="expireTime" name="expireTime" placeholder="yyyy-MM-dd">
				  </div>
			   </div>
			   
			   <button type="button" class="btn btn-primary" onclick="doSubmit();" style="width:100%;">提交</button>
			</form>
			<!-- form end -->
		</div>
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${request.contextPath}/bootstrap/js/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
    <!-- index.js -->
    <script src="${request.contextPath}/js/admin/index.js"></script>
 	<script>
 		//提交保存
 		function doSubmit(){
 			if($("#platform").val() == "-1"){
 				alert("请选择活动平台");
 				return;
 			}
 			if($("#clientType").val() == "-1"){
 				alert("请选择展示终端");
 				return;
 			}
 			if($.trim($("#title").val()) == ""){
 				alert("请输入活动地址");
 				return;
 			}
 			if($.trim($("#itemUrl").val()) == ""){
 				alert("请输入活动地址");
 				return;
 			}
 			if($.trim($("#startTime").val()) == ""){
 				alert("请输入开始时间");
 				return;
 			}
 			if($.trim($("#expireTime").val()) == ""){
 				alert("请输入结束时间");
 				return;
 			}
			 			
 			$.post("${request.contextPath}/hd/admin/save",$("#f").serialize(),function(data){
 				if(data.respCode == 0){
 					window.location.reload(true);
 				}else{
 					alert("保存失败，请稍后再试");
 					return;
 				}
 			})
 		}
 	</script>   
  </body>
</html>
