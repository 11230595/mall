<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <#include "template/ico.ftl"><!-- ico文件-->

    <title>囤货网</title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- 日历 -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="${request.contextPath}/bootstrap/js/ie-emulation-modes-warning.js"></script>

    <!-- Custom styles for this template -->
    <link href="${request.contextPath}/bootstrap/css/navbar.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  	<!-- 头信息 -->
  	<#include "template/head.ftl">
    <div class="container">
      <!-- 内容 -->
      <div class="jumbotron">
        <h1>囤货网使用帮助</h1>
        <p>
        	囤货网只是一个信息传递平台，收集各大商家的优惠信息。<br>
        	囤货网购买流程如下：<br>
        	1、挑选商品<br>
        	2、点击，直接跳转至商品所对应的商家，如：该商品属于天猫卖家，则直接跳转到天猫宝贝详情页面<br>
        	3、可以和卖家沟通相关细节问题<br>
        	4、登录商家账号购买，如：登录天猫账号，购买宝贝<br>
        	5、商户中心，商户可以自行注册，开通商户，上传自己的产品进行退关，此功能完全免费，<code>注意：请不要上传没有任何折扣的商品，一经发现，立即删除！</code><br>
        </p>
      </div>
      <!-- 地脚信息 -->
  	  <#include "template/foot.ftl">

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
     <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
    <script>
    	$(function(){
    		$("#home").removeClass("active");
    		$("#about").addClass("active");
    	})
    </script>
  </body>
</html>
