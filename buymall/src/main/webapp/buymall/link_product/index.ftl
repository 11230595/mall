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

				<div class="standards" style="margin: -90px -107px 0 -500px;">
					<!-- 内容 -->
					<div class="standard_content">
						<div class="standard active">
							<#list page.list as page>
								<div class="tag-grid" style="width:21%;margin:10px 1% 0;">
									<div class="tag-wrapper">		
										<a target="_blank" href="${request.contextPath}/pre/out/${page.id!''}">
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
												￥<span style="font-size:28px;font-weight:bold;">${page.zkFinalPrice!'19.00'}</span>&nbsp;&nbsp;
												<span style="color:#999999;">${page.sale!''}折</spa>
												<#if user?? && user.userLevel == 8><!-- 如果是管理员，显示删除选项 -->
													<span style="color:red;">
														<a href="javascript:void(0)" onclick="deleteLinkProduct('${page.id}')">删除</a>
													</spa>
												</#if>
											</h4>
										</div>
									</div>
									<div class="atc"><a target="_blank" href="${request.contextPath}/pre/out/${page.id!''}">去看看</a></div>
							   </div>
						   </#list>
							<div class="clearfix"></div>
							<div style="width:100%;text-align:center;margin-top:20px;">
								<#include "../template/page.ftl"><!-- 分页模板 -->
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
	 
	<#include "../template/jd_ad.ftl"><!-- 京东广告 -->
	 
   <!-- 图片旋转start -->
   <#include "../template/rotate.ftl"><!-- 导航模板 -->
   <!-- 图片旋转end -->
	
	<#include "../template/bottom.ftl"><!-- 底部信息 -->
	<#include "../template/foot.ftl"><!-- 脚信息 -->
	 
	<!--start-smooth-scrolling-->
	<script type="text/javascript">
		//滚动到页顶
		$(document).ready(function() {
			$().UItoTop({ easingType: 'easeOutQuart' });
		});
		//删除商品
		function deleteLinkProduct(productId){
			$.post("${url}/pre/delete/"+ productId, function(data){
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