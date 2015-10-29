<style>
	.tcdPageCode{padding: 15px 20px;text-align: left;color: #ccc;text-align:center;}
	.tcdPageCode a{display: inline-block;color: #428bca;display: inline-block;height: 25px;	line-height: 25px;	padding: 0 10px;border: 1px solid #ddd;	margin: 0 2px;border-radius: 4px;vertical-align: middle;}
	.tcdPageCode a:hover{text-decoration: none;border: 1px solid #428bca;}
	.tcdPageCode span.current{display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;color: #fff;background-color: #428bca;	border: 1px solid #428bca;border-radius: 4px;vertical-align: middle;}
	.tcdPageCode span.disabled{	display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;	color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;border-radius: 4px;vertical-align: middle;}
</style>
<div class="tcdPageCode"></div>

<script>
	var type = "${type!''}";	
    $(".tcdPageCode").createPage({
        pageCount:${page.totalPage},
        current:${page.pageNo},
        backFn:function(p){
            window.location.href="${request.contextPath}/index/" + p  + (type == "" ? "" : "?type=" + type);
        }
    });
</script>
								