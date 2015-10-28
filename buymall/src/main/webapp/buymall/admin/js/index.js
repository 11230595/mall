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
function doAPISubmit(){
	var type = $("#tpType").val();
	
	if (type == "") {
		alert("请选择类型");
		return;
	}
	
	$.post("tp/add", $("#tpForm").serialize(), function(data) {
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
//跳转到banner页面
function toBannerPage(obj){
	$(obj).parent().parent().find("li").removeClass();
	$(obj).parent().addClass("active");
	$("#dataTemplate").hide();
	$("#bannerTemplate").show();
	
	fillBannerData();
	position(); //改变脚信息的位置
}
//填充banner页面数据表格
function fillBannerData(){
	$.post("banner/findAll",function(data){
		$("#bannerTemplate").find("tbody").empty();
		$.each(data.banners,function(i,d){
			var html = '<tr class="active">				\
				         <td style="width:20%">'+d.title+'</td>			\
				         <td style="width:30%">'+d.imgUrl+'</td>			\
				         <td style="width:30%">'+d.itemUrl+'</td>			\
						 <td style="width:10%">'+d.page+'</td>			\
						 <td style="width:5%">'+d.position+'</td>		\
						 <td style="width:5%"><a href="javascript:void(0);" onclick="deleteBanner(\''+d.id+'\')">删除</a></td>		\
				      </tr>';
			$("#bannerTemplate").find("tbody").append(html);
		});
		
		$("#bannerTemplate tr:odd").addClass("success");
		$("#bannerTemplate tr:even").addClass("active");
	})
}

function deleteBanner(id){
	$.post("banner/del/"+id,function(data){
		if(data.respCode == 0){
			fillBannerData()
		}
	})
}

//提交，保存banner
function doSubmitBanner(){
	$.post("banner/add",$("#bannerForm").serialize(),function(data){
		if(data.respCode == 0){
			window.location.reload(true);
		}
	})
}