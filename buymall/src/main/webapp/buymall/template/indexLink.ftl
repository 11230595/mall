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