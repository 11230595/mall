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

    <title>囤货网-后台管理</title>

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
          <a class="navbar-brand" href="${request.contextPath}/admin">后台管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="${request.contextPath}/admin">导入数据</a></li>
            <li><a href="#about">模板管理</a></li>
            <li><a href="javascript:void(0);" onclick="toBannerPage(this);">Banner管理</a></li>
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
      <#include "template/data.ftl"><!-- 导入数据 -->
      <#include "template/template.ftl"><!-- 模板管理 -->
      <#include "template/banner_insert.ftl"><!-- Banner管理 -->

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
    <script src="${request.contextPath}/buymall/admin/js/index.js"></script>
    
  </body>
</html>
