<!DOCTYPE HTML>
<html>
<head>
<title>囤货网</title>
<#include "../template/meta.ftl"><!-- meta -->
<#include "../template/ico.ftl"><!-- ico文件-->
<#include "../template/indexLink.ftl"><!-- 引入的css,js文件 -->
</head>
<body>
		<#include "../template/topBanner.ftl"><!-- 顶部条 -->
		<#include "../template/header.ftl"><!-- 导航模板 -->

 <!--start-content-->
	   
	 <!-- /start-产品 -->
	 <div class="container" style="margin-top: 50px;">
			<div class="recommand-section">
				<!-- recommand -->
				<div class="recommand-section-grids">

				<div class="standards" style="margin: -90px 0 0 -400px;">
					<!-- 内容 -->
					<div class="standard_content">
						<div class="standard active">
							<#if frameUrls ??>
					      		<#if '${frameUrls?size}'== '0'>
					  				<h2>暂无数据....</h2>
					  			</#if>
					      		<#list frameUrls as url>
							      	<p>${url.tName!''}：</p>
							        <iframe width="100%" align="center" height="${url.height!1750}" id="mainFrame" name="mainFrame" frameborder="0" scrolling="no" src="${url.tUrl!''}"></iframe> 
							        <h3>&nbsp;</h3>
						        </#list>
						    <#else>
						    	<h2>暂无数据....</h2>
					        </#if>
							<div class="clearfix"></div>
						</div>
					</div>
					<!-- 内容end -->
				</div>
				<!-- recommand end -->
			</div>
		</div>
	</div>
		<!-- //end-产品 -->
	 
   <!-- 图片旋转start -->
   <#include "../template/rotate.ftl"><!-- 导航模板 -->
   <!-- 图片旋转end -->
	
	<!--start-footer-->
	<div class="footer">
	   <div class="container">
			<div class="footer-top">
				<div class="col-md-2 footer-left">
					<h3>关于囤货网</h3>
					<ul>
						<li><a href="${request.contextPath}/about">我们的宗旨</a></li>
						<li><a href="">&nbsp;</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-left">
					<h3>联系我们</h3>
					<ul>
						<li><a href="javascript:void(0);">邮箱</a></li>
						<li><a href="javascript:void(0);">zhoudong611@163.com</a></li>
					</ul>
				</div>
			</div>
			
		</div>
	</div>
	<!-- /start 底部分享 -->
	<ul class="socials">
		<li><a class="soc1" href="#"></a></li>
		<li><a class="soc2" href="#"></a></li>
		<li><a class="soc3" href="#"></a></li>
	</ul>
	<!-- /end 底部分享 -->
	 <!--/start-copyright-->
	 <div class="copy">
		<div class="container">
			<p>Copyright &copy; 2015.一周科技 All rights reserved.</p>
		</div>
	</div>
	 <!--//end-copyright-->
	<!--end-footer-->
 <!--//end-content-->
 
	<!--start-smooth-scrolling-->
	<script type="text/javascript">
		//滚动到页顶
		$(document).ready(function() {
			$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
	<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>