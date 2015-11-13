function loginOut(){
	$.post(BASE_URL + "/user/loginOut",function(data){
		if(data.respCode == 0){
			window.location.href = data.baseUrl;
		}
	});
}