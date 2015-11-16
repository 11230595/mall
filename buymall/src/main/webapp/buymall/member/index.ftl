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

    <title>囤货网-商户中心</title>

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
            <li class="active"><a href="${request.contextPath}/member/index">推广中产品</a></li>
            <li><a href="${request.contextPath}/member/add">推广产品</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:void(0);">欢迎您：${user.userCode!"管理员"}</a></li>
            <li><a href="${request.contextPath}/member/close/${user.userId}">关闭商户功能</a></li>
            <li><a href="javascript:void(0);" onclick="loginOut();">退出</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

	<!-- 内容start -->
	<div class="container">
			<table class="table table-bordered">
			   <caption>正在推广的商品</caption>
			   <thead>
			      <tr>
			         <th>产品名称</th>
			         <th>产品地址</th>
			         <th>操作</th>
			      </tr>
			   </thead>
			   <tbody>
			   	 <#if (page.list?size > 0)>
				   	 <#list page.list as products>
					      <tr>
					         <td>${products.title}</td>
					         <td><a target="_blank" href="${products.itemUrl}">${products.itemUrl}</a></td>
					         <td><a href="javascript:void(0);" onclick="deleteProduct('${products.id}');">删除</a></td>
					      </tr>
				     </#list>
				 <#else>
				 	<tr>
				 		<td colspan=3 style="text-align:center;">您暂未推广产品</td>
				 	</tr>
				 </#if>
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
    	//删除
    	function deleteProduct(productId){
    		$.post("${request.contextPath}/member/delete",{
    			"productId":productId
    		},function(data){
    			if(data.respCode == 0){
    				alert("删除成功");
    				window.location.reload();
    			}else{
    				alert("删除失败，请稍后重试");
    			}
    		});	
    	}
    </script>
  </body>
</html>
