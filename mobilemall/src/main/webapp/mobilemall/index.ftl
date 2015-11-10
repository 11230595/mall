<!doctype html>
<html lang="en">
<head>
<#include "template/meta.ftl" > <#include "template/ico.ftl" >

<link href="${request.contextPath}/css/wap/global.css" rel="stylesheet"
	type="text/css" />
<title>囤货网</title>

<script src="${request.contextPath}/js/wap/zepto.js"></script>
<script src="${request.contextPath}/js/wap/underscore.js"></script>

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
						<i class="ico10">
							<img src="${request.contextPath}/images/jd1.png" width="20px" style="float: left;" />签到</i>
						</i>
					</span>
				</div>
				<ul class="head-nav">
					<a href="#"><li class="active">首页</li></a>
					<a href="#"><li>明日预告</li></a>
					<a href="#"><li>热卖专场</li></a>
					<a href="#"><li>卷皮折扣</li></a>
				</ul>
				<div id="nav" class="view currents out">

					<div id="search-box">
						<div id="search-form" method="get">
							<div class="box-search">
								<span class="icon-search icon"></span> 
									<input id="keyword"	x-webkit-speech type="text" name="key" placeholder="请输入商品关键字" autocomplete="off" value="">
									<span id="delete-search" class="delete-button" style="display: none;">
										<i class="ico20">
											<img src="${request.contextPath}/images/X.png" width="18px" />
										</i>
									</span>
							</div>
							<button type="submit" id="search-submit">
								<i class="ico01"> 
									<img src="${request.contextPath}/images/search-w.png" /> 
									<img class="active" src="${request.contextPath}/images/search-o.png" style="display: none;" />
								</i>
							</button>
						</div>
					</div>

					<ul class="nav-list">
						<a href="${request.contextPath}"><li>全部</li></a>
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
					<li>
						<a target="_blank" href="#">
							<img src="http://s1.juancdn.com/bao/140305/8/f/53171e5bdfe40_580x380.jpg_290x190.jpg" />
						</a> 
						<a target="_blank" href="jump/67939165">
							<h1>
								<i class="ico13">
									<img src="${request.contextPath}/images/sdj.png">
								</i>可爱时尚实用迷你照明电筒【包邮】
							</h1>
							<div class="list-price buy">
								<i>￥</i><span class="price-new">9.9</span><i class="del">/￥19</i>
								<span class="good-btn"> 
									<i class="ico15">
										<img src="images/sts.png" />
									</i> 去抢购
								</span>
							</div>
						</a>
					</li>
					<li>
						<a target="_blank" href="#"> 
							<img src="http://s1.juancdn.com/bao/140307/e/4/53198186beb1a_580x380.jpg_290x190.jpg" />
							
						</a> 
						<a target="_blank" href="jump/66939495">
							<h1>
								<i class="ico13">
									<img src="images/sdj.png">
								</i>男士全棉中筒运动袜（5双）【包邮】
							</h1>
							<div class="list-price end">
								<i>￥</i>
								<span class="price-new">9.9</span>
								<i class="del">/￥98</i>
								<span class="good-btn">抢光了</span>
							</div>
						</a>
					</li>
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
					<a href="default.htm">首页</a>
					<i>
						</i>
							<a href="app">客户端</a>
						<i>
					</i>
					<a	href="${pc_url!''}">电脑版</a>
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
								<input id="s-keyword" type="text" placeholder="请输入商品关键字" autocomplete="off" value="">
								<span id="p-delete-search" class="delete-button" style="display: none;"> </span>
						</div>
						<input type="hidden" id="p-page" value="">
						<button type="submit" id="p-search-submit">
							<i class="ico01"> 
								<img src="${request.contextPath}/images/search-w.png" /> 
								<img class="active" src="${request.contextPath}/images/search-o.png" style="display: none;" />
							</i>
						</button>
					</div>
				</div>

				<div id="p-goods" class="clear">
					<ul id="element" class="goods-list clear">
					</ul>
				</div>

				<div id="foot">
					<div class="foot-nav">
						<a href="#">首页</a>
						<i></i>
						<a href="app">客户端</a>
						<i></i>
						<a href="${pc_url!''}">电脑版</a>
					</div>
					<div class="foot-copyright"></div>
					<h2>©2015囤货网</h2>
				</div>
			</div>

			<div id="alert_wrap" class="alert_black_bg">
				<div class="alert_box">
					<div class="alert_content">
						<div class="message">
							<i class="close"></i> 
							<img class="icon" src="${request.contextPath}/images/cus_jqy.png">
							<div class="jky_des">
								<p class="f14">使用九块邮客户端</p>
								<p class="f12 yellow">全场九块九包邮，</p>
								<p class="f12 yellow">体验掌上的小幸福</p>
							</div>
						</div>
						<a href="app" class="sub">立即使用</a>
					</div>
				</div>
			</div>

			<div class="alert_fullbg"></div>

			<!-- /*Download alert*/ -->
			<div id="alert_exchange_new" class="alert_bg"
				style="left: 50%; margin-left: -130px; top: 35px; position: fixed;">
				<div class="alert_box">
					<div class="alert_top">
						<i id="close_box" class="close"></i>
					</div>
					<a href="app">
						<div class="alert_content">
							<div class="message">
								<img class="icon" src="${request.contextPath}/images/cus_jqy.png" />
								<p class="fontL">九块邮客户端</p>
								<p class="fontS">体验更好，功能更全！</p>
							</div>
							<button class="sub" value="">马上下载</button>
						</div>
					</a>
				</div>

			</div>

		</div>
	</div>
	<!-- 定义模板，将模板内容放到一个script标签中 -->
	<script type="text/template" id="tpl">
        <% for(var i = 0; i < list.length; i++) { %>
            <% var goods = list[i] %>
            <li>
                <img src="<%= goods.picurl %>" />
                <% if(goods.tag == "1") { %>
                    <i class="ico05"><img src="${request.contextPath}/images/yugao1.png"><em>品牌</em> </i>
                <% } %>
                <% if(goods.tag == "2") { %>
                    <i class="ico05"><img src="${request.contextPath}/images/yugao2.png"><em>专场</em> </i>
                <% } %>
                <h1>
                    <% if(goods.hottag == "1") { %>
                        <i class="ico13"><img src="${request.contextPath}/images/sdj.png"></i>
                    <% } %>
                    <%=goods.title%>
                    <% if(goods.ismail != "0") { %> 包邮 <% } %>
                </h1>
                 <% if(goods.status == "1") { %>
						 <div class="list-price start">
                    		<i>￥</i><span class="price-new"><%=goods.cprice%></span><i class="del">/￥<%=goods.oprice%></i>
                        	<span class="good-btn start"><i class="ico15"></i>10点开始</span>
 						</div>
                    <% } %>
                    <% if(goods.status == "2") { %>
 						<div class="list-price buy">
                    		<i>￥</i><span class="price-new"><%=goods.cprice%></span><i class="del">/￥<%=goods.oprice%></i>
                        	
                        	<span class="good-btn"> 
                       			 <% if(goods.taobao_flag == "1") { %>
                            		<i class="ico15"><img src="${request.contextPath}/images/sts.png"/></i>
                       			 <% } else {%>
                           			 <i class="ico15"><img src="${request.contextPath}/images/sbs.png"/></i>
                        		<% } %>
                        		去抢购</span>
						</div>
                    <% } %>
                    <% if(goods.status == "3") { %>
						<div class="list-price end">
                    		<i>￥</i><span class="price-new"><%=goods.cprice%></span><i class="del">/￥<%=goods.oprice%></i>
                        	<span class="good-btn end"><i class="ico15"></i>抢光了</span>
 						</div>
                    <% } %>
                    <% if(goods.status == "4") { %>
						<div class="list-price end">
                    		<i>￥</i><span class="price-new"><%=goods.cprice%></span><i class="del">/￥<%=goods.oprice%></i>
                        	<span class="good-btn end"><i class="ico15"></i>已结束</span>
 						</div>
                    <% } %>
            </li>
        <% } %>
    </script>
	<script type="text/javascript">
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
    </script>
	<script type="text/javascript" src="${request.contextPath}/js/wap/mjky.js"></script>
</body>
</html>