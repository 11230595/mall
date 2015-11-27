	<style type="text/css">
	a{text-decoration: none;}
	img{max-width: 100%; height: auto;}
	.weixin-tip{display: none; position: fixed; left:0; top:0; bottom:0; background: rgba(0,0,0,0.8); filter:alpha(opacity=80);  height: 100%; width: 100%; z-index: 999999;}
	.weixin-tip p{text-align: center; margin-top: 10%; padding:0 5%;}
	</style>
<div class="weixin-tip">
		<p>
			<img src="${request.contextPath}/images/live_weixin.png" alt="微信打开"/>
		</p>
	</div>
	<script type="text/javascript">
        $(function(){
	        var winHeight = $(window).height();
			if(is_weixin()){
				$(".weixin-tip").css("height",winHeight);
	            $(".weixin-tip").show();
			}
        })
	</script>