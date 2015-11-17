<!-- 热门商城活动专区start -->
<div class="hotTmp">
	<div style="padding:15px 0 10px 5px;color:red;">热门活动</div>
	<div class="hotTempDiv" id="i_index" onmouseover="showColor(this);" onmouseout="hideColor(this);" onclick="window.open('http://sucs.suning.com/visitor.htm?userId=14500059&webSiteId=0&adInfoId=499&adBookId=0&channel=11&vistURL=http://sale.suning.com/cs/chaoshilydc11/index.html')">苏宁超市粮油节</div>
	<div class="hotTempDiv" onmouseover="showColor(this);" onmouseout="hideColor(this);" onclick="window.open('http://sucs.suning.com/visitor.htm?userId=14500059&webSiteId=0&adInfoId=492&adBookId=0&channel=11&vistURL=http://cuxiao.suning.com/city/tx00109.htm')">全民购机节 天天一元秒</div>
</div>
<!-- 热门商城活动专区end -->
<style>
.hotTempDiv{
	padding:15px 10px 15px 5px;
	border-top:1px solid #CCC;
}

.hotTmp{
	border:1px solid #CCC; 
	border-bottom:1px solid #DDDDDD;
	border-left: 1px solid #D7D7D7;
	background:none repeat scroll 0 0 #FFF;
	background-position: left top;
    background-repeat: repeat-x;
    left: 0;
    padding: 0;
    position: fixed;
    top: 260px;
    _top: expression(documentElement.scrollTop + 260 + "px");
    width: 70px;
    z-index: 9999;
    _position:absolute;
    cursor: pointer;
    font-size:12px;
    text-align: center;
    color:#000;
}
.optCursor{
	background-color: #18c9d2;
	color:#fff;
}
</style>
<script>
/**

 * 鼠标放到分类上，显示阴影

 * @param obj

 */
function showColor(obj){
	$(obj).addClass("optCursor");
}
/**

 * 鼠标离开，解除阴影

 */
function hideColor(obj){
	$(obj).removeClass("optCursor");
}
</script>