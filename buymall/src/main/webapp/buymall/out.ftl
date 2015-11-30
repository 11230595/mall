<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>囤货网-跳转中</title>
<script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
<script src="${request.contextPath}/js/jquery/jquery.cookie.js"></script><!-- jquery cookie -->
</head>
<body>
	<#if product??>
		<#if product.userType == 0 || product.userType ==1><!-- 淘宝或者天猫 使用淘点金 -->
			<a data-type="0" id="alink" biz-itemid="${product.numIid!''}" style="display:none;" data-tmpl="470x190" data-tmplid="1111" data-rd="2" data-style="2" data-border="1" href="${product.itemUrl!''}"></a>
			<script type="text/javascript">
			    (function(win,doc){
			        var s = doc.createElement("script"), h = doc.getElementsByTagName("head")[0];
			        if (!win.alimamatk_show) {
			            s.charset = "gbk";
			            s.async = true;
			            s.src = "http://a.alimama.cn/tkapi.js";
			            h.insertBefore(s, h.firstChild);
			        };
			        var o = {
			            pid: "mm_18774322_11774819_41732376",/*推广单元ID，用于区分不同的推广渠道*/
			            appkey: "23271271",/*通过TOP平台申请的appkey，设置后引导成交会关联appkey*/
			            unid: "",/*自定义统计字段*/
			            type: "click" /* click 组件的入口标志 （使用click组件必设）*/
			        };
			        win.alimamatk_onload = win.alimamatk_onload || [];
			        win.alimamatk_onload.push(o);
			    })(window,document);
			</script>
		<#else><!-- 其他的直接跳转走 -->
			<a id="alink" href="${product.itemUrl!''}"></a>
		</#if>
	<#else>
	参数有误
	</#if>
	
	<script>
		function skip(){
			document.getElementById("alink").click();
		}
		var onlyId = '${onlyId!""}';
		if($.cookie(onlyId) == '' || $.cookie(onlyId) == null || $.cookie(onlyId) == undefined){
			$.cookie(onlyId, onlyId);
			window.onload=skip;
		}else{
			history.back();
		}
	</script>
</body>
</html>