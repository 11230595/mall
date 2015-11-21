<!DOCTYPE HTML>
<html>
<head>
<title>囤货网</title>
<#include "template/meta.ftl"><!-- meta -->
<#include "template/ico.ftl"><!-- ico文件-->
<#include "template/indexLink.ftl"><!-- 引入的css,js文件 -->
</head>
<body>
		<#include "template/topBanner.ftl"><!-- 顶部条 -->
		<#include "template/header.ftl"><!-- 导航模板 -->
		<#include "template/hot_temp.ftl"><!-- 竖条橱窗模板 -->
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
						<li class="selector active" id="platformAll" onclick="selectPlatform(-1);">全部</li>
						<li class="selector" id="platformTB" onclick="selectPlatform(0);">淘宝</li>
						<li class="selector" id="platformTM" onclick="selectPlatform(1);">天猫</li>
						<li class="selector" id="platformITB" onclick="selectPlatform(2);">爱淘宝</li>
						<#include "template/showcase.ftl"><!-- 橱窗推荐 -->
					</ul>
					
					<!-- 内容 -->
					<div class="standard_content">
						<div class="standard active">
							<#list page.list as page>
								<div class="tag-grid">
									<div class="tag-wrapper">		
										<a target="_blank" href="${request.contextPath}/product/out/${page.id!''}">
											<img src="${page.imgUrl!''}" class="img-responsive" style="width:100%;height: 218px"/>
										</a>
										<div class="r-title">
											<h3>${page.title!''}</h3>
											<h4>
												￥${page.zkFinalPrice!'19.00'}&nbsp;&nbsp;
												<span style="color:red;">${page.sale!''}折</spa>
											</h4>
										</div>
									</div>
									<div class="atc"><a target="_blank" href="${request.contextPath}/product/out/${page.id!''}">去看看</a></div>
							   </div>
						   </#list>
							<div class="clearfix"></div>
							<div style="width:100%;text-align:center;margin-top:20px;">
								<#include "template/page.ftl"><!-- 分页模板 -->
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
	<div class="mid-content"> 
	   <div class="container"> 
			<!-- 橱窗推荐start -->
			<div style="margin-left:8%;">
				<script type="text/javascript">var jd_union_unid="76994695",jd_ad_ids="505:6",jd_union_pid="CJykyZ+RKhCHsdskGgAgteOVrQEqAA==";var jd_width=960;var jd_height=90;var jd_union_euid="";var p="ABUFVRxeFAsTNwpfBkgyTUMIRmtKRk9aZV8ETVxNNwpfBkgyYXNXRkVqUm9nB186ZX9zUFdEM2cCRAtZK1kSAhEFUB1YHTIUAF0TXhIKFjdlRB9IXyJMOxprSkZPWmUbXhAEFAVcHFgSBhoPZRo%3D";</script><script type="text/javascript" charset="utf-8" src="http://u.x.jd.com/static/js/auto.js"></script>
			</div>
			<!-- 橱窗推荐end -->
	   </div>
	 </div>
	 <!-- //end-底图图片 -->
	 
   <!-- 图片旋转start -->
   <#include "template/rotate.ftl"><!-- 图片旋转模板 -->
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
				<div class="col-md-2 footer-left">
					<h3>商户中心</h3>
					<ul>
						<li><a href="${request.contextPath}/member/exist">登录商户中心</a></li>
						<li><a href="">&nbsp;</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-left">
					<h3>移动版</h3>
					<ul>
						<li><a href="${mobileUrl!''}">查看手机版</a></li>
						<li><a href="">&nbsp;</a></li>
					</ul>
				</div>
			</div>
			
		</div>
	</div>
	
	<#include "template/foot.ftl"><!-- 脚信息 -->
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
				window.scrollTo(100,1390); //pageNo不等于1的时候，页面定位到商品位置
			}
			
			//选定tag
			switch(platformType){
			case "0":
				$("#platformTB").parent().find("li").removeClass("active");
				$("#platformTB").addClass("active");
			  	break;
			case "1":
				$("#platformTM").parent().find("li").removeClass("active");
				$("#platformTM").addClass("active");
			  	break;
			case "2":
				$("#platformITB").parent().find("li").removeClass("active");
				$("#platformITB").addClass("active");
			  	break;
			}
		})
		//跳转平台
		function selectPlatform(flag){
			if(flag != -1){
				window.location.href = "${request.contextPath}/index/1?userType="+flag 
			}else{
				window.location.href = "${url}";
			}
		}
		
	</script>
	<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>