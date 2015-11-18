//跳转到banner页面
$(function(){
	fillBannerData();
})
//填充banner页面数据表格
function fillBannerData(){
	$.post("../../banner/findAll",function(data){
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
	$.post("../../banner/admin/del/"+id,function(data){
		if(data.respCode == 0){
			fillBannerData()
		}
	})
}

//提交，保存banner
function doSubmitBanner(){
	$.post("../../banner/admin/add",$("#bannerForm").serialize(),function(data){
		if(data.respCode == 0){
			window.location.reload(true);
		}
	})
}