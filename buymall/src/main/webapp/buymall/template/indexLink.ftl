<script type="applijegleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="${request.contextPath}/css/index/style.css" rel='stylesheet' type='text/css' />	
<script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
<script src="${request.contextPath}/js/jquery/jquery.lazyload.min.js"></script><!-- jquery 延迟加载 -->
<script src="${request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
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
<script type="text/javascript" src="${request.contextPath}/js/search.js"></script><!-- 搜索 -->
<script src="${request.contextPath}/js/common/common.js"></script><!-- 公共js，有退出等方法 -->
<script src="${request.contextPath}/js/count.js"></script><!-- 流量统计 -->
<script src="${request.contextPath}/js/share.js"></script><!-- 分享 -->
<script src="${request.contextPath}/js/buymall/index/index.js"></script><!-- 首页 -->

<!--/script-->
<script type="text/javascript">
	var type = "${type!''}";
	var userType = "${userType!''}";
	var keyword = "${keyword!''}";
	
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
		});
	});
</script>
<!-- 延迟加载 -->
<script type="text/javascript" charset="utf-8">
  $(function() {
      $("img").lazyload();
  });
</script>