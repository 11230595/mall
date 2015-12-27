<link href="${request.contextPath}/bootstrap/css/bootstrap-page.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${request.contextPath}/js/jqPaginator.min.js"></script><!-- 分页 -->
<ul class="pagination" id="pagination" style="margin-top:11px;"></ul>
<script>
	var type = "${type!''}";
	var userType = "${userType!''}";
	var totalCount = ${page.totalCount}; //总条数
	var pageNo = ${page.pageNo};
	var nextPage = ${page.nextPage}; //下一页
	var prePage = ${page.prePage}; //上一页
	var totalPage = ${page.totalPage}; //总页
	
	var params = "";
	
	if(type != ""){
		params = "?type=" + type;
	}else if(type != "" && userType != ""){
		params = "?type=" + type + "&userType=" +  userType;
	}else if(userType != ""){
		params = "?userType=" + userType;
	}
	
	//首页
	function firstPage(){
		window.location.href="${request.contextPath}/index/1"+ params;
	}
	//最后一页
	function lastPage(){
		window.location.href="${request.contextPath}/index/" + totalPage + params;
	}
	//上一页
	function prevPage(){
		window.location.href="${request.contextPath}/index/" + prePage + params;
	}
    //下一页
	function toNextPage(){
		window.location.href="${request.contextPath}/index/" + nextPage + params;
	}
	
	$.jqPaginator('#pagination', {
        totalPages: totalPage,
        visiblePages: 3,
        currentPage: pageNo,
        first:'<li class="first"><a href="javascript:void(0);" onclick="firstPage();" style="padding-top:2px;">首页</a></li>',
        last:'<li class="last"><a href="javascript:void(0);" onclick="lastPage();" style="padding-top:2px;">末页</a></li>',
        prev: '<li class="prev"><a href="javascript:void(0);" onclick="prevPage();" style="padding-top:2px;">上页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);" onclick="toNextPage();" style="padding-top:2px;">下页</a></li>',
        page: '<li class="page"><a href="javascript:void(0);" style="padding-top:2px;">{{page}}</a></li>',
        onPageChange: function (num, type) {
        	if(num != pageNo){
        		window.location.href="${request.contextPath}/index/" + num + params;
        	}
            if(totalCount == 0){
				$(".tcdPageCode").append("暂无数据,请选择其他分类...");
			}
        }
    });
</script>
								