<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <#include "template/ico.ftl"><!-- ico文件-->

    <title>囤货网-用户中心</title>

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
            <li class="active"><a href="${request.contextPath}/user/home/${user.userId}">浏览过的商品</a></li>
            <li><a href="${request.contextPath}/user/toUpdate">修改密码</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:void(0);">欢迎您：${user.userCode!"管理员"}</a></li>
            <li><a href="javascript:void(0);" onclick="loginOut();">退出</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

	<!-- 内容start -->
	<div class="container">
		<table class="table table-bordered">
		   <caption>浏览过的商品，保留最近100件</caption>
		   <thead>
		      <tr>
		         <th width="35%">商品名称</th>
		         <th width="65%">商品地址</th>
		      </tr>
		   </thead>
		   <tbody id="tbody">
		   </tbody>
		</table>
	</div>
	<!-- 内容end -->
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${request.contextPath}/bootstrap/js/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
    
    <script>
    	//分页获取数据
    	$(function(){
    		$.post("../../product/findBrowseHistory/" + '${user.userId}' + "/100/1",function(data){
    			$("#tbody").empty();
    			$.each(data.page.list,function(i,product){
    				var trStr = '<tr> \
							         <td>'+product.title+'</td>\
							         <td style="word-break:break-all;width:200px; overflow:auto;"><a target="_blank" href="'+product.itemUrl+'">'+product.itemUrl+'</a></td>\
							      </tr>';
					$("#tbody").append(trStr);
    			});
    		})
    	});
    </script>
  </body>
</html>
