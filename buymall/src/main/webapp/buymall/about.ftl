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
        <h1>关于囤货网</h1>
        <p>1、质量保证，是我们宗旨；</p>
        <p>2、用户满意，是我们的追求；</p>
        <p>3、带个用户实实在在的优惠，是我们的追求；</p>
        <p>4、不遗余力的让每个用户满意，是我们的未来；</p>
        <p>5、所有会员资料均属于隐私，本站不会泄露任何会员资料；</p>
        <p>6、我们欢迎每一位用户为我们提出您宝贵的意见；</p>
        <p>7、联系我，email:<code>chinazhoudong@gmail.com</code>。</p>
        <p>7、联系我，手机:<code>18511833392</code>。</p>
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
