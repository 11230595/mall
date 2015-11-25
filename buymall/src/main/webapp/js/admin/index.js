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
			alert("导入成功");
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

//导入数据提交
function submit_jd() {
	var type = $("#type").val();
	var itemUrl = $("#itemUrl").val();
	var catchUrl = $("#catchUrl").val();
	var reservePrice = $("#reservePrice").val();
	var zkFinalPrice = $("#zkFinalPrice").val();

	if (type == "0") {
		alert("请选择类型");
		return;
	}

	if ($.trim(itemUrl) == "") {
		alert("请输入商品地址");
		return;
	}
	
	if ($.trim(catchUrl) == "") {
		alert("请输入原价");
		return;
	}
	
	if ($.trim(reservePrice) == "") {
		alert("请输入现价");
		return;
	}
	
	if ($.trim(zkFinalPrice) == "") {
		alert("请输入商品推广地址");
		return;
	}
	$.post("../product/add_jd?catchUrl="+catchUrl, $("#f").serialize(), function(data) {
		if (data.respCode == 0) {
			alert("导入成功");
			window.location.reload(true);
		} else {
			alert("网络繁忙，请稍后再试..");
		}
	});
}

//导入数据提交
function submit_99() {
	var type = $("#type").val();
	var url = $("#url").val();
	var day = $("#day").val();
	
	if (type == "0") {
		alert("请选择类型");
		return;
	}

	if ($.trim(url) == "") {
		alert("请输入商品地址");
		return;
	}
	if($.trim(day) == ""){
		alert("请输入几天后过期");
		return;
	}
	if(isNaN(day)){
		alert("几天后过期只能使用数值型！");
		return;
	}

	$.post("../product/add_tk_activity", {
		"type" : type,
		"url" : url,
		"day":day
	}, function(data) {
		if (data.respCode == 0) {
			alert("导入成功");
			window.location.reload(true);
		} else {
			alert("网络繁忙，请稍后再试..");
		}
	});
}
