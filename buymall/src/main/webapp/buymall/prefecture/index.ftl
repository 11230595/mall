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
	 <div class="container">
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
	 
   <!--start-轮转图片-->
	<div class="scroll-slider">
		<div class="container"> 											 
			<div class="nbs-flexisel-container"><div class="nbs-flexisel-inner">
				<ul class="flexiselDemo3 nbs-flexisel-ul" style="left: -253.6px; display: block;">					    					    					       
					<li onClick="location.href='https://www.tmall.com/';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="http://img.alicdn.com/tps/i1/TB1JCr_IpXXXXcAXFXXOK.sIXXX-190-27.png" alt=""/></li>
					<li onClick="location.href='http://www.jd.com/';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="http://misc.360buyimg.com/lib/img/e/logo-201305.png" alt=""/></li>
					<li onClick="location.href='http://www.gome.com.cn/';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="http://img.gomein.net.cn/images/ui/gomelogo.png" alt=""/></li>
				</ul>
				<div class="nbs-flexisel-nav-left" style="top: 21.5px;"></div>
				<div class="nbs-flexisel-nav-right" style="top: 21.5px;"></div>
			</div>
		</div> 
		<div class="clearfix"> </div>      
		<!--start-image-->
		<script type="text/javascript" src="${request.contextPath}/js/index/jquery.flexisel.js"></script>
		<!--//end-->
		<script type="text/javascript">
		$(window).load(function() {
			$(".flexiselDemo3").flexisel({
				visibleItems: 5,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,            
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
				responsiveBreakpoints: { 
					portrait: { 
						changePoint:480,
						visibleItems: 2
					}, 
					landscape: { 
						changePoint:640,
						visibleItems: 3
					},
					tablet: { 
						changePoint:768,
						visibleItems: 3
					}
				}
			});
		});
		</script>
		<!---->
	  </div>				
	</div>
	<!--//end-底部轮转图片-->
	
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