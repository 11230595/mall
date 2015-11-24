<!-- QQ登录 -->
<p>
  	<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="101267617" charset="utf-8" ></script>

	<span id="qqLoginBtn" ></span>
	
	<script type="text/javascript">
	
	var userCode = "";
	
	QC.Login({
	    	btnId:"qqLoginBtn",    //插入按钮的节点id
	    	size : "B_M",//按钮尺寸
			scope:"all"    //用户需要确认的scope授权项，可选，默认all
		 },
		 
		 function(reqData,opts){
			 var paras = {};
			 QC.api("get_user_info", paras)
				//指定接口访问成功的接收函数，s为成功返回Response对象
				.success(function(s){
					//成功回调，通过s.data获取OpenAPI的返回数据
					//alert("获取用户信息成功！当前用户昵称为："+s.data.nickname);
					userCode = s.data.nickname;
				})
				//指定接口访问失败的接收函数，f为失败返回Response对象
				.error(function(f){
					//失败回调
					alert("获取用户信息失败！");
				})
				//指定接口完成请求后的接收函数，c为完成请求返回Response对象
				.complete(function(c){
					//完成请求回调
					//alert("获取用户信息完成！");
					if(QC.Login.check()){//如果已登录
				    	QC.Login.getMe(function(openId, accessToken){
				    		//alert(["当前登录用户的", "openId为："+openId, "accessToken为："+accessToken].join("\n"));
				    		window.location.href = "${request.contextPath}/user/otherSignin?userCode=" + encodeURI(encodeURI(userCode)) + "&openId=" + openId + "&accessToken=" + accessToken;
				    	});
				    	//这里可以调用自己的保存接口
				    	//调用保存接口
				    } 
				});
		 },
		 function(opts){
			 alert(opts);
			alert("QQ注销成功");
		 }
		);
	</script>
</p>