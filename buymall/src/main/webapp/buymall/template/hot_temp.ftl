<!-- 热门商城活动专区start -->
<div class="hotTmp" id="hotTmp">
</div>
<!-- 热门商城活动专区end -->
<style>
.hotTempDiv{
	padding:7px 5px 5px 5px;
	color:#fff;
}

.hotTmp{
	background:none repeat scroll 0 0 #c81623;
	background-position: left top;
    background-repeat: repeat-x;
    left: 0;
    padding: 0;
    position: fixed;
    bottom: 0px;
    _top: expression(documentElement.scrollTop + 260 + "px");
    width: 70px;
    z-index: 9999;
    _position:absolute;
    cursor: pointer;
    font-size:13px;
    text-align: center;
    color:#fff;
	font-family:Calibri,Arial;
}
.optCursor{
	background-color: #fff;
	color:#c81623;
}
.hotTmp a{
	color:#3f3d3d
}
.hotTmp a:hover{color:#3f3d3d}
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

$(function(){
	getActivity();
});
//分页查询活动数据
function getActivity(){
	$.post("${request.contextPath}/hd/findByPage/7/1",function(data){
		$("#hotTmp").empty();
		$.each(data.page.list,function(i,activity){
			var str = '<a href="'+activity.itemUrl+'" target="_blank" data-toggle="tooltip" title="'+activity.activityDesc+'">\
					   	<div class="hotTempDiv" onmouseover="showColor(this);" onmouseout="hideColor(this);">'+activity.title+'</div>\
					   </a>';
			$("#hotTmp").append(str);
		})
		$("[data-toggle='tooltip']").tooltip({html : true });
	});
}
</script>