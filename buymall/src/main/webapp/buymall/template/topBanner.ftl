<!--start-home-->
<div class="top_bg" id="home">
	<div class="container">
		<div class="header_top">
			<div class="top_right">
				<ul>
					<li><a href="${request.contextPath}/help" data-intro="红包来啦！点击“帮助”按钮获取最新红包口令，红包每天10点来袭~">帮助</a></li>
					<li>
						<#if user??>
							<a href="${request.contextPath}/user/home/${user.userId!''}">您好：${user.userCode!''}</a>
						<#else>
							<a href="${request.contextPath}/user/login">登录/注册</a>
						</#if>
					</li>
					<#if user??>
					<li><a href="javascript:void(0);" onclick="loginOut();">退出</a></li>
					</#if>
					<li><a href="${request.contextPath}/member/exist">商户中心</a></li>
				</ul>
			</div>
			<div class="top_left">
				<h6><span></span> 联系我 : 18511833392</h6>
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
</div>

<!-- 提示 -->
<script type="text/javascript">
$(function(){
	if($.cookie('introJs_cookie') == null || $.cookie('introJs_cookie') == ''){
		introJs().start();
		$.cookie('introJs_cookie', 'true',{ expires: 1 }); //cookie时间 一天
	}
})
</script>
