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
	document.onkeydown = function(e) {
		var ev = document.all ? window.event : e;
		if (ev.keyCode == 13) {
			doSubmit();
		}
	}
});

function doSubmit() {
	var type = $("#type").val();
	var url = $("#url").val();

	if (type == "") {
		alert("请选择类型");
		return;
	}

	if ($.trim(url) == "") {
		alert("请输入商品地址");
		return;
	}

	$.post("product/add", {
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