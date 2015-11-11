<div class="zySearch" id="zySearch"></div>
<style>
.zySearch{position:relative}
.zySearch .search-img{background:url("../images/chicken.gif") no-repeat scroll left top transparent;display:block;height:0;left:39%;margin-left:-12px;position:absolute;top:10px;width:24px;}
.zySearch .search-input{color:#999;border:1px solid #D0D0D0;height:33px;line-height:33px;margin-right:5px;padding:0 10px;width:268px;}
.zySearch .search-btn{background:none repeat scroll 0 0 #18c9d2;border:0 none;border-radius:0;color:#FFFFFF;cursor:pointer;height:35px;line-height:33px;padding:0;vertical-align:baseline !important;width:76px;text-align:center;vertical-align:middle;white-space:nowrap;margin-bottom:0;font-weight:normal;font-size:14px;display:inline-block;position:relative;}
</style>

<script type="text/javascript">
$("#zySearch").zySearch({
	"width":"355",
	"height":"33",
	"parentClass":"pageTitle",
	"callback":function(keyword){
		console.info("搜索的关键字");
		console.info(keyword);
	}
});
</script>