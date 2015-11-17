<!--start-home-->
<div class="top_bg" id="home">
	<div class="container">
		<div class="header_top">
			<div class="top_right">
				<ul>
					<li><a href="${request.contextPath}/help">帮助</a></li>
					<li>
						<#if user??>
							<a href="${request.contextPath}/user/userHome/${user.userId!''}">您好：${user.userCode!''}</a>
						<#else>
							<a href="${request.contextPath}/user/login">登录/注册</a>
						</#if>
					</li>
					<#if user??>
					<li><a href="javascript:void(0);" onclick="loginOut();">退出</a></li>
					</#if>
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
