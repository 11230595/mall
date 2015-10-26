<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${request.contextPath}/ico/favicon.ico">

    <title>后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${request.contextPath}/bootstrap/css/navbar-fixed-top.css" rel="stylesheet">

    <script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/bootstrap/js/ie-emulation-modes-warning.js"></script>
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
          <a class="navbar-brand" href="#">后台管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">导入数据</a></li>
            <li><a href="#about">导入模板</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">欢迎您：${user.userCode!"管理员"}</a></li>
            <li><a href="javascript:void(0);" onclick="loginOut();">退出</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h3>导入数据</h3>
        <!-- form start -->
        <form role="form" id="f">
		   <div class="form-group">
		      <select class="form-control" id="type">
		         <option value="0">请选择分类</option>
		         <option value="1">女装</option>
		         <option value="2">男装</option>
		         <option value="3">内衣</option>
		         <option value="4">鞋品</option>
		         <option value="5">儿童</option>
		         <option value="6">母婴</option>
		         <option value="7">居家</option>
		         <option value="8">食品</option>
		         <option value="9">数码</option>
		         <option value="10">箱包</option>
		         <option value="11">美妆</option>
		      </select>
		   </div>
		
		   <div class="form-group">
		      <div class="form-group">
			    <label for="name">商品地址</label>
			    <textarea class="form-control" rows="3" id="url"></textarea>
			  </div>
		   </div>
		   
		   <button type="button" class="btn btn-primary" onclick="doSubmit();" style="width:100%;">提交</button>
		</form>
		<!-- form end -->
		
      </div>

    </div> <!-- /container -->

	<#include "../template/foot.ftl"><!-- 脚信息 -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${request.contextPath}/bootstrap/js/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
    
    <script>
    	//退出登录
    	function loginOut(){
    		$.post("user/loginOut",function(data){
    			if(data.respCode == 0){
    				window.location.href=data.baseUrl;
    			}
    		});
    	}
    	
    	//绑定回车事件
		$(function(){
		    document.onkeydown = function(e){ 
			    var ev = document.all ? window.event : e;
			    if(ev.keyCode==13) {
			         doSubmit();
			    }
			} 
		});
    	
    	function doSubmit(){
    		var type = $("#type").val();
    		var url = $("#url").val();
    		
    		if(type == ""){
    			alert("请选择类型");
    			return;
    		}
    		
    		if($.trim(url) == ""){
    			alert("请输入商品地址");
    			return;
    		}
    		
    		$.post("product/add",{
    			"type": type,
    			"url":url
    		},function(data){
    			if(data.respCode == 0){
    				window.location.reload(true);
    			}else{
    				alert("网络繁忙，请稍后再试..");
    			}
    		});
    	}
    	
    </script>
    
  </body>
</html>
