<!DOCTYPE HTML>
<html>
<head>
<title>囤货网</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Nuevo Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<link rel="icon" href="${request.contextPath}/ico/mall_favicon.ico">
<script type="applijegleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="${request.contextPath}/css/index/style.css" rel='stylesheet' type='text/css' />	
<script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
<!-- start menu -->
<link href="${request.contextPath}/css/index/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${request.contextPath}/js/index/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="${request.contextPath}/js/index/menu_jquery.js"></script>
<script src="${request.contextPath}/js/index/simpleCart.min.js"> </script>

<!--//web-fonts-->
<script src="${request.contextPath}/js/index/scripts.js" type="text/javascript"></script>
<script type="text/javascript" src="${request.contextPath}/js/index/move-top.js"></script>
<script type="text/javascript" src="${request.contextPath}/js/index/easing.js"></script>
<script type="text/javascript" src="${request.contextPath}/js/jquery.page.js"></script><!-- 分页 -->
<!--/script-->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
		});
	});
</script>
</head>
<body>
<!--start-home-->
<div class="top_bg" id="home">
	<div class="container">
		<div class="header_top">
			<div class="top_right">
				<ul>
					<li><a href="#">帮助</a></li>
					<li>
						<#if user??>
							<a href="${request.contextPath}/user/userHome/${user.userId!''}">您好：${user.userCode!''}</a>
						<#else>
							<a href="${request.contextPath}/user/login">登录/注册</a>
						</#if>
					</li>
					<li><a href="#">签到</a></li>
				</ul>
			</div>
			<div class="top_left">
				<h6><span></span> 联系我 : 18511833392</h6>
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
</div>

		<#include "template/header.ftl"><!-- 导航模板 -->

 <!--start-content-->
		<#include "template/banner.ftl"><!-- banner模板 -->
		
        <!--/start-中部产品-fashion-->
		<div class="fashion-section">
		 <div class="container"> 
		     <h3 class="tittle">精选频道</h3>

		   <div class="fashion-info">
		   		<#list bPage.list as bPage>
					<div class="col-md-4 fashion-grids">
						<figure class="effect-bubba">
							<img src="${bPage.imgUrl!''}" alt="" style="width:100%;height:300px;"/>
							<figcaption>
								<h4>${bPage.title!''}</h4>
								<p class="cart"><a href="${bPage.itemUrl!''}">去看看</a></p>				
							</figcaption>			
						</figure>		
					</div>
				</#list>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
       <!--//end-中部产品-fashion-->
	   
	 <!-- /start-产品 -->
	 <div class="container">
			<div class="recommand-section">
				<div class="recommand-section-head text-center">
					<h3 class="tittle fea">特惠购</h3>
				</div>
				<!-- recommand -->
				<div class="recommand-section-grids">

				<div class="standards">
				   <h5>Tags<i class="glyphicon glyphicon-tag"></i></h5>
					<ul class="selectors_wrapper">
							<li class="selector active" id="platformAll" onclick="selectPlatform(0);">全部</li>
							<li class="selector" id="platformTM" onclick="selectPlatform(1);">天猫</li>
					</ul>
					<!-- 内容 -->
					<div class="standard_content">
						<div class="standard active">
							<#list page.list as page>
								<div class="tag-grid">
									<div class="tag-wrapper">		
										<a target="_blank" href="${page.itemUrl!''}"><img src="${page.imgUrl!''}" class="img-responsive" style="width:100%;height: 218px"/></a>
										<div class="r-title">
											<h3>${page.title!''}</h3>
											<h4>
												￥${page.zkFinalPrice!'99.00'}&nbsp;&nbsp;
												<span style="color:red;">${page.sale!''}折</spa>
											</h4>
										</div>
									</div>
									<div class="atc"><a target="_blank" href="${page.itemUrl!''}">去看看</a></div>
							   </div>
						   </#list>
							<div class="clearfix"></div>
							<div style="width:100%;text-align:center;margin-top:20px;">
								<#include "template/page.ftl"><!-- 导航模板 -->
							</div>
						</div>
					</div>
					<!-- 内容end -->
				</div>
				<!-- recommand end -->
			</div>
		</div>
	</div>
		<!-- //end-产品 -->
	  <!-- /start-底图图片 -->
	  
	  <!--
	  <div class="mid-content"> 
		<div class="container"> 
		  <div class="middle">
			<div class="mid-top"> 
			  <h3>Discover a huge assortment of</h3>
			  <p>women`s handbags at the lowest prices</p>
			</div>
		 </div>
	   </div>
	 </div>
	 -->
	 <!-- //end-底图图片 -->
	 
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
		
		//进入页面后滚动到页面中部
		$(function(){
			var pageNo = ${page.pageNo};
			var s_type = "${type!''}";
			var platformType = "${userType!''}";
			if(pageNo != 1 || s_type != '' || platformType != ''){
				window.scrollTo(100,1400);
			}
			
			//选定tag
			switch(platformType){
			case "1":
				$("#platformTM").parent().find("li").removeClass("active");
				$("#platformTM").addClass("active");
			  	break;
			}
		})
		//跳转平台
		function selectPlatform(flag){
			if(flag != 0){
				window.location.href = "${request.contextPath}/index/1?userType="+flag 
			}else{
				window.location.href = "${request.contextPath}";
			}
		}
		
	</script>
	<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>