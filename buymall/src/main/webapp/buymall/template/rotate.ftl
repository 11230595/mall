<!--start-轮转图片-->
	<div class="scroll-slider">
		<div class="container"> 											 
			<div class="nbs-flexisel-container"><div class="nbs-flexisel-inner">
				<ul class="flexiselDemo3 nbs-flexisel-ul" style="left: -253.6px; display: block;">					    					    					       
					<li onClick="location.href='https://www.tmall.com/';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="http://img.alicdn.com/tps/i1/TB1JCr_IpXXXXcAXFXXOK.sIXXX-190-27.png" alt=""/></li>
					<li onClick="location.href='http://www.jd.com/';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="http://misc.360buyimg.com/lib/img/e/logo-201305.png" alt=""/></li>
					<li onClick="location.href='http://www.gome.com.cn/';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="http://img.gomein.net.cn/images/ui/gomelogo.png" alt=""/></li>
				</ul>
				<div class="nbs-flexisel-nav-left" style="top: 21.5px;"></div>
				<div class="nbs-flexisel-nav-right" style="top: 21.5px;"></div>
			</div>
		</div> 
		<div class="clearfix"> </div>      
		<!--start-image-->
		<script type="text/javascript" src="${request.contextPath}/js/index/jquery.flexisel.js"></script>
		<!--//end-->
		<script type="text/javascript">
		$(window).load(function() {
			$(".flexiselDemo3").flexisel({
				visibleItems: 5,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,            
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
				responsiveBreakpoints: { 
					portrait: { 
						changePoint:480,
						visibleItems: 2
					}, 
					landscape: { 
						changePoint:640,
						visibleItems: 3
					},
					tablet: { 
						changePoint:768,
						visibleItems: 3
					}
				}
			});
		});
		</script>
		<!---->
	  </div>				
	</div>
	<!--//end-底部轮转图片-->