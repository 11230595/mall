<!doctype html>
<html lang="en">
<head>
<#include "template/meta.ftl" > <#include "template/ico.ftl" >

<link href="${request.contextPath}/css/wap/global.css" rel="stylesheet"	type="text/css" />
<title>手机囤货网</title>
<script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
<script src="${request.contextPath}/js/jquery/jquery.lazyload.min.js"></script><!-- 延迟加载 -->
<script src="${request.contextPath}/js/wap/zepto.js"></script>
<script src="${request.contextPath}/js/wap/underscore.js"></script>
<script src="${request.contextPath}/js/count.js"></script>
<script src="${request.contextPath}/js/share.js"></script>
<!-- 延迟加载 -->
<script type="text/javascript" charset="utf-8">
  $(function() {
      $("img").lazyload({
      	effect : "fadeIn",
      });
  });
</script>
</head>

<body>
	<div class="main">
		<div class="app">
			<div id="head">
				<div class="fixtop">
					<span id="find">
						<i class="ico08">
							<img src="${request.contextPath}/images/ss1.png" width="29px" />
						</i>
					</span> 
					<span id="index">
						<i class="ico07">
							<img src="${request.contextPath}/images/111.png" width="78px" />
						</i>
					</span> 
					<span id="user">
						<#if user??>
							<a href="${pc_url}/user/home/${user.userId!''}"><i class="ico10">${user.userCode!''}</i></a>
						<#else>
							<a href="${request.contextPath}/user/login"><i class="ico10">登录</i></a>
						</#if>
					</span>
				</div>
				<ul class="head-nav">
					<a href="${url!''}"><li class="active" id="li0">全部</li></a>
					<a href="${request.contextPath}/index/1?userType=1"><li id="li1">天猫</li></a>
					<a href="${request.contextPath}/index/1?userType=0"><li id="li2">淘宝</li></a>
					<a href="${request.contextPath}/index/1?userType=2"><li id="li3">爱淘宝</li></a>
					<a href="${request.contextPath}/index/1?userType=3"><li id="li4">京东</li></a>
					<a href="${request.contextPath}/index/1?userType=10"><li id="li10" style="color:red">九块九</li></a>
				</ul>
				<div id="nav" class="view currents out">

					<div id="search-box">
						<div id="search-form" method="get">
							<div class="box-search">
								<span class="icon-search icon"></span> 
									<input id="keyword"	x-webkit-speech type="text" name="key" placeholder="请输入商品关键字" autocomplete="off" value="" />
									<span id="delete-search" class="delete-button" style="display: none;">
										<i class="ico20">
											<img src="${request.contextPath}/images/X.png" width="18px" />
										</i>
									</span>
							</div>
							<button type="submit" id="search-submit" onclick="searchProduct();">
								<i class="ico01"> 
									<img src="${request.contextPath}/images/search-w.png" /> 
									<img class="active" src="${request.contextPath}/images/search-o.png" style="display: none;" />
								</i>
							</button>
						</div>
					</div>

					<ul class="nav-list">
						<a href="${url!''}"><li>全部</li></a>
						<a href="${request.contextPath}?type=1&userType=${userType!''}"><li>女装</li></a>
						<a href="${request.contextPath}?type=2&userType=${userType!''}"><li>男装</li></a>
						<a href="${request.contextPath}?type=3&userType=${userType!''}"><li>内衣</li></a>
						<a href="${request.contextPath}?type=4&userType=${userType!''}"><li>鞋品</li></a>
						<a href="${request.contextPath}?type=7&userType=${userType!''}"><li>家居</li></a>
						<a href="${request.contextPath}?type=8&userType=${userType!''}"><li>食品</li></a>
						<a href="${request.contextPath}?type=10&userType=${userType!''}"><li>箱包</li></a>
						<a href="${request.contextPath}?type=11&userType=${userType!''}"><li>美妆</li></a>
						<a href="${request.contextPath}?type=5&userType=${userType!''}"><li>儿童</li></a>
						<a href="${request.contextPath}?type=6&userType=${userType!''}"><li>母婴</li></a>
						<a href="${request.contextPath}?type=9&userType=${userType!''}"><li>数码</li></a>
					</ul>

				</div>
			</div>
			<div id="goods">
				<div id="cover"></div>
				<div id="dwon"></div>

				<ul class="goods-list clear">
					<#list page.list as page>
						<li>
							<a target="_blank" href="${pc_url}/product/out/${page.id!''}">
								<img class="goodsImg" data-original="${page.imgUrl!''}" src="${request.contextPath}/images/tunhuowang.png"/>
							</a> 
							<a target="_blank" href="${pc_url}/product/out/${page.id!''}">
								<h1>
									<!--独家标记<i class="ico13">
										<img src="${request.contextPath}/images/sdj.png">
									</i>-->${page.title!''}
								</h1>
								<div class="list-price buy">
									<i>￥</i><span class="price-new">${page.zkFinalPrice!'9.00'}</span>
									<i class="del">${page.sale!''}折</i>
									<span class="good-btn"> 
										<i class="ico15">
											<img src="${request.contextPath}/images/sts.png" />
										</i> 去抢购
									</span>
								</div>
							</a>
						</li>
					</#list>
				</ul>
				
				<div class="paging">
					<div class="paging-nav">
						<#include "template/page.ftl"><!-- 分页模板 -->
					</div>
					<div class="paging-totop">
						<a href="#"><i class="ico14"></i>回到顶部</a>
					</div>
				</div>
			</div>


			<div id="foot">
				<div class="foot-nav">
					<a href="${url!''}">首页</a>
					<i></i>
					<a href="app">客户端</a>
					<i></i>
					<a href="${pc_url!''}?client=PC">电脑版</a>
				</div>
				<div class="foot-copyright"></div>
				<h2>©2015囤货网</h2>
			</div>
			<div id="seach-page" class="view current out">
				<div id="p-head">
					<div class="fixtop">
						<span id="p-find">
							<i class="ico18">
								<img src="${request.contextPath}/images/left.png" width="16px;" />
							</i>
						</span> 
						<span id="p-index">搜索结果</span>
						<span id="p-user"></span>
					</div>
				</div>

				<div id="p-search-box">
					<div id="p-search-form">
						<div class="box-search">
							<span class="icon-search icon"></span> 
							<input id="s-keyword" type="text" placeholder="请输入商品关键字" autocomplete="off" value="" />
							<span id="p-delete-search" class="delete-button" style="display: none;"> </span>
						</div>
						<input type="hidden" id="p-page" value="" />
						<button type="submit" id="p-search-submit">
							<i class="ico01"> 
								<img src="${request.contextPath}/images/search-w.png" /> 
								<img class="active" src="${request.contextPath}/images/search-o.png" style="display: none;" />
							</i>
						</button>
					</div>
				</div>

				<div id="p-goods" class="clear">
					<ul id="element" class="goods-list clear"></ul>
				</div>
			</div>
			
			<div id="alert_wrap" style="display:none;" class="alert_black_bg">
                <div class="alert_box">
                    <div class="alert_content">
                        <div class="message">
                            <i  class="close"></i>
                            <img class="icon" src="${request.contextPath}/images/weixin_code.jpg">
                            <div class="jky_des">
                                <p class="f14">关注囤货网公众号</p>
                                <p class="f12 yellow">全场九块九包邮，</p>
                                <p class="f12 yellow">优惠快人一步！</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			
			<div class="alert_fullbg"></div>
		</div>
	</div>
	
	<script type="text/javascript">
	var BASE_URL = "${url!''}";
    function addLoadEvent(func) {
        var oldOnload = window.onload;
        if (typeof window.onload != 'function') {
            window.onload = func;
        }
        else {
            window.onload = function() {
                oldOnload();
                func();
            }
        }
    }
    // 添加Load事件处理
    addLoadEvent(hideMenu);
    function hideMenu() {
        setTimeout("window.scrollTo(0, 0)", 1);
    }
    
    $(function(){
    	is_show_alert_wrap();//是否显示关注微信选项
    	
    	var userType = ${userType!-1};
    	if(userType != -1){
    		$("#li0").removeClass("active");
    		switch(userType){
				case 1:
				  $("#li1").addClass("active");
				  break;
				case 0:
				  $("#li2").addClass("active");
				  break;
				case 2:
				  $("#li3").addClass("active");
				  break;
			    case 3:
				  $("#li4").addClass("active");
				  break;
				case 10:
				  $("#li10").addClass("active");
				  break;
			}
    	}
    	changeHeight();
    })
    
    function searchProduct(){
    	var searchInput = $("#keyword").val();
    	if($.trim(searchInput) == ""){
    		alert("请输入关键字搜索");
    		return;
    	}
    	
    	window.location.href = "${url!''}?keyword=" + searchInput;
    }
	//固定每一个图片的高度
    function changeHeight(){
    	var imgHeight = $(".goodsImg:first").height();
    	$(".goodsImg").css("height",imgHeight + "px");
    }
    //是否显示关注微信选项，如果是微信登录，则不显示
    function is_show_alert_wrap(){
    	if(!is_weixin()){
    		$("#alert_wrap").show();
    	}
    }
    //是不是微信访问
    function is_weixin(){
		var ua = navigator.userAgent.toLowerCase();
		if(ua.match(/MicroMessenger/i)=="micromessenger") {
			return true;
	 	} else {
			return false;
		}
	}
    </script>
	<script type="text/javascript" src="${request.contextPath}/js/wap/mjky.js"></script>
</body>
</html>