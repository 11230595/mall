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
		 	<div class="title-line"></div>
		     <h3 class="tittle"><div class="title-line-div">精选频道</div></h3>

		   <div class="fashion-info">
		   		<#list bPage.list as bPage>
					<div class="col-md-4 fashion-grids">
						<figure class="effect-bubba">
							<img src="${bPage.imgUrl!''}" alt="" style="width:100%;height:230px;"/>
							<figcaption>
								<h4>&nbsp;</h4>
								<p class="cart"><a target="_blank" href="${bPage.itemUrl!''}">去逛${bPage.title!''}</a></p>				
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
					<div class="title-line"></div>
					<h3 class="tittle fea"><div class="title-line-div">特惠购</div></h3>
				</div>
				<!-- recommand -->
				<div class="recommand-section-grids">

				<div class="standards" style="margin: 0 0 0px -38%;">
				   <!--
				   <h5>Tags<i class="glyphicon glyphicon-tag"></i></h5>
					<ul class="selectors_wrapper">
						<li class="selector active" id="platformAll" onclick="selectPlatform(-1);">全部</li>
						<li class="selector" id="platformTB" onclick="selectPlatform(0);">淘宝</li>
						<li class="selector" id="platformTM" onclick="selectPlatform(1);">天猫</li>
						<li class="selector" id="platformITB" onclick="selectPlatform(2);">爱淘宝</li>
						<li class="selector" id="platformJD" onclick="selectPlatform(3);">京东</li>
						<li class="selector" id="platform99" onclick="selectPlatform(10);" style="color:red">九块九专区</li>
						<#--<#include "template/showcase.ftl">--><!-- 橱窗推荐 
					</ul>
					-->
										
					<!-- 内容 -->
					<div class="standard_content">
						<div class="standard active">
							<#list page.list as page>
								<div class="tag-grid">
									<div class="tag-wrapper">		
										<a target="_blank" href="${request.contextPath}/product/out/${page.id!''}">
											<img data-original="${page.imgUrl!''}" src="${request.contextPath}/images/tunhuowang.png" class="img-responsive" style="width:100%;height: 218px"/>
											<#if .now?string("yyyyMMdd") == page.createTime?string("yyyyMMdd")>
												<span class="new-icon">新品</span>
											</#if>
										</a>
										<div class="r-title">
											<h3 title="${page.title}">
												<#if page.title?length gt 46>${page.title?substring(0,46)}...<#else>${page.title}</#if>
											</h3>
											<h4>
												￥<span style="font-size:28px;font-weight:bold;">${page.zkFinalPrice!'19.00'}</span>&nbsp;
												<span style="color:#999999;">${page.sale!''}折</spa>
												<#if user?? && user.userLevel == 8><!-- 如果是管理员，显示删除选项 -->
													<span style="color:red;">
														<a href="javascript:void(0)" onclick="deleteProduct('${page.id}')">删除</a>
													</spa>
												</#if>
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
	 
	<#include "template/jd_ad.ftl"><!-- 京东广告 -->
	 
   <!-- 图片旋转start -->
   <#include "template/rotate.ftl"><!-- 图片旋转模板 -->
   <!-- 图片旋转end -->
	
	<#include "template/bottom.ftl"><!-- 底部信息 -->
	<#include "template/foot.ftl"><!-- 脚信息 -->
 
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
				$("html,body").animate({scrollTop:1290},1000);//pageNo不等于1的时候，页面定位到商品位置
			}
			/* 已经废弃
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
			case "3":
				$("#platformJD").parent().find("li").removeClass("active");
				$("#platformJD").addClass("active");
			  	break;
			case "10":
				$("#platform99").parent().find("li").removeClass("active");
				$("#platform99").addClass("active");
			  	break;
			}
			*/
		})
		//跳转平台
		function selectPlatform(flag){
			if(flag != -1){
				window.location.href = "${request.contextPath}/index/1?userType="+flag 
			}else{
				window.location.href = "${url}";
			}
		}
		//删除商品
		function deleteProduct(productId){
			$.post("${url}/product/delete/"+ productId, function(data){
				if(data.respCode == 0){
					alert("删除成功");
					window.location.reload(true);
				}else{
					alert("删除失败，请稍后再试！");
				}
			})
		}
	</script>
	<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>