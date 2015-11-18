<!-- 热门商城活动专区start -->
<div class="hotTmp" id="hotTmp">
	<div style="padding:15px 0 10px 5px;color:red;">热门活动</div>
	<div id="hotData">
	</div>
</div>
<!-- 热门商城活动专区end -->
<style>
.hotTempDiv{
	padding:10px 10px 10px 5px;
	border-top:1px solid #CCC;
}

.hotTmp{
	border:1px solid #CCC; 
	border-bottom:1px solid #DDDDDD;
	border-left: 1px solid #D7D7D7;
	background:none repeat scroll 0 0 #f5f5f5;
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
    font-size:13px;
    text-align: center;
    color:#3f3d3d;
	font-family:Calibri,Arial;
}
.optCursor{
	background-color: #18c9d2;
	color:#fff;
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
	$.post("${request.contextPath}/hd/findByPage/5/1",function(data){
		$("#hotData").empty();
		$.each(data.page.list,function(i,activity){
			var str = '<a href="'+activity.itemUrl+'" data-toggle="tooltip" title="'+activity.activityDesc+'">\
					   	<div class="hotTempDiv" onmouseover="showColor(this);" onmouseout="hideColor(this);">'+activity.title+'</div>\
					   </a>';
			$("#hotData").append(str);
		})
		$("[data-toggle='tooltip']").tooltip({html : true });
	});
}
</script>