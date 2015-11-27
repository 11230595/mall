<!--header-->
<div class="header_bg">
   <div class="container">
	<div class="header">
	  <div class="head-t">
		 <div class="logo">
			  <!-- <a href="${request.contextPath}"><h1>囤货 <span>网</span></h1> </a> -->
			  <a href="${url!'${request.contextPath}'}"><img src="${request.contextPath}/images/logo.png" style="width:290px;height:110px;"/></a>
		  </div>
		  
		  <div style="margin: 2.5em 0;float:right;">
			<#include "search.ftl">
		  </div>
		<div class="clearfix"></div>	
	    </div>
		<!-- 导航start -->
		<ul class="megamenu skyblue">
			<li class="active grid"><a class="color1" href="${url!'${request.contextPath}'}">首页</a></li>
			<li class="grid"><a class="color2" href="javascript:void(0)">分类</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>穿着</h4>
								<ul>
									<li><a href="${url!''}?type=1&userType=${userType!''}">女装</a></li>
									<li><a href="${url!''}?type=2&userType=${userType!''}">男装</a></li>
									<li><a href="${url!''}?type=3&userType=${userType!''}">内衣</a></li>
									<li><a href="${url!''}?type=4&userType=${userType!''}">鞋品</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>居家</h4>
								<ul>
									<li><a href="${url!''}?type=7&userType=${userType!''}">家居</a></li>
									<li><a href="${url!''}?type=8&userType=${userType!''}">食品</a></li>
									<li><a href="${url!''}?type=10&userType=${userType!''}">箱包</a></li>
									<li><a href="${url!''}?type=11&userType=${userType!''}">美妆</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>母婴</h4>
								<ul>
									<li><a href="${url!''}?type=5&userType=${userType!''}">儿童</a></li>
									<li><a href="${url!''}?type=6&userType=${userType!''}">母婴</a></li>
								</ul>	
							</div>												
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>数码</h4>
								<ul>
									<li><a href="${url!''}?type=9&userType=${userType!''}">数码</a></li>
								</ul>	
							</div>												
						</div>
				</div>
			</li>
			<!-- 导航end -->
			<!-- 导航start -->
			<li><a class="color4" href="#">专区优惠</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>专区优惠</h4>
								<ul>
									<li><a href="${url!''}/pre/index/0/1">天天特价</a></li>
									<li><a href="${url!''}/pre/index/1/1">9块9专区</a></li>
									<li><a href="${url!''}/pre/index/2/1">20封顶</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>专区特卖</h4>
								<ul>
									<li><a href="${url!''}/pre/index/3/1">50元好货</a></li>
									<li><a href="${url!''}/pre/index/4/1">一折清仓</a></li>
									<li><a href="${url!''}/pre/index/5/1">全场半价</a></li>
								</ul>	
							</div>							
						</div>
					</div>
				</div>
			</li>
			<!-- 导航end -->
		 </ul> 
 	</div>
</div>
</div>