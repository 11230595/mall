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
  	
  	<script>
  		$(function(){
  			$(".navbar-nav").find("li").removeClass("active");
  			$("#jd").addClass("active");
  		});
  	</script>
  </head>

  <body>

    <#include "template/nav.ftl"><!-- 导航信息 -->

    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
		    <h3>京东导入数据</h3>
		    <!-- form start -->
		    <form role="form" id="f">
			   <div class="form-group">
			      <select class="form-control" id="type" name="type">
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
				    <textarea class="form-control" rows="3" id="catchUrl" placeholder="用于抓数据"></textarea>
				  </div>
			   </div>
			   
			   <div class="form-group">
			      <div class="form-group">
				    <label for="name">商品推广地址</label>
				    <textarea class="form-control" rows="3" id="itemUrl" name="itemUrl" placeholder="用于跳转"></textarea>
				  </div>
			   </div>
			   
			   <div class="form-group">
			      <div class="form-group">
				    <label for="name">原价</label>
				    <input type="text" class="form-control" id="reservePrice" name="reservePrice" placeholder="请输入原价">
				  </div>
			   </div>
			   
			   <div class="form-group">
			      <div class="form-group">
				    <label for="name">现价</label>
				    <input type="text" class="form-control" id="zkFinalPrice" name="zkFinalPrice" placeholder="请输入现价">
				  </div>
			   </div>
			   
			   <button type="button" class="btn btn-primary" onclick="submit_jd();" style="width:100%;">提交</button>
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
    
  </body>
</html>
