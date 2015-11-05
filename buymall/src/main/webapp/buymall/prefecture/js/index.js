/**
 * 分类获取数据
 * @param type
 */
function getType(type){
	$.post("type",{
		"type":type
		},function(data){
			$("#content").empty();
			if(data.frameUrls.length == 0){
				$("#content").append("<h2>暂无数据....</h2>");
			}
			$.each(data.frameUrls,function(i,json){
				var template = $("#contentTmplate").clone();
				template.find("p").text(json.tName + ":");
				template.find("#mainFrame").attr("src",json.tUrl);
				template.find("#mainFrame").attr("height",json.height);
				$("#content").append(template.show());
			});
	})
}

/**
 * 顶部标签样式
 * @param obj
 */
function activeLi(obj,flag){
	$('body,html').animate({scrollTop:0},800); 
	$(obj).parent().find("li").each(function(){
		if($(this).attr("class") == "active"){
			$(this).removeClass();
		}
	});
	if(flag != "delete")
		$(obj).addClass("active");
}