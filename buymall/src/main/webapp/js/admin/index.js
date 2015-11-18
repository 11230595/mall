//退出登录
function loginOut() {
	$.post("user/loginOut", function(data) {
		if (data.respCode == 0) {
			window.location.href = data.baseUrl;
		}
	});
}

// 绑定回车事件
$(function() {
	$("#dataTemplate").show(100);
	document.onkeydown = function(e) {
		var ev = document.all ? window.event : e;
		if (ev.keyCode == 13) {
			doSubmit();
		}
	}
});
//导入数据提交
function doSubmit() {
	var type = $("#iType").val();
	var url = $("#url").val();

	if (type == "0") {
		alert("请选择类型");
		return;
	}

	if ($.trim(url) == "") {
		alert("请输入商品地址");
		return;
	}

	$.post("product/add_itaobao", {
		"type" : type,
		"url" : url
	}, function(data) {
		if (data.respCode == 0) {
			window.location.reload(true);
		} else {
			alert("网络繁忙，请稍后再试..");
		}
	});
}
function doAPISubmit(){
	var type = $("#tpType").val();
	
	if (type == "0") {
		alert("请选择类型");
		return;
	}
	
	$.post("product/add", $("#tpForm").serialize(), function(data) {
		if (data.respCode == 0) {
			alert("导入成功");
			window.location.reload(true);
		}else if(data.respCode == 2){
			alert("没有搜索到数据，请重新输入条件..");
		} else {
			alert("网络繁忙，请稍后再试..");
		}
	});
}
