<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <#include "../template/ico.ftl"><!-- ico文件-->
    <title>囤货网-商户中心</title>
    <link href="${request.contextPath}/bootstrap/css/bootstrapv2.css" rel="stylesheet">
    <script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/bootstrap/js/modal.js"></script>
    
  </head>

  <body>
  
  	<div class="container">
		<div id="content" class="modal hide fade in" style="display: none; ">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">×</a>
				<h3>输入手机号，一步即可开通</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="f" action="${url}/member/create">
					<input type="hidden" value="${user.userId}" name="userId">
					<div class="form-group">
				      <label for="lastname" class="col-sm-2 control-label">手机号：</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="phoneNum" name="phoneNum" placeholder="请输入手机号">
				      </div>
				   </div>
			   </form>
			</div>
			<div class="modal-footer">
				<a href="javascript:void(0);" onclick="checkMobile();" class="btn btn-success">立即开通</a>
				<a href="${url}" class="btn" data-dismiss="modal">稍后开通</a>
			</div>
		</div>
		<a data-toggle="modal" id="alertDiv" href="#content" class="btn-large"></a>
	</div>
  </body>
  
  <script>
    	if(confirm("对不起，您暂时没开通商户，点击确定可直接开通。")){
    		$("#alertDiv").click();
    	}else{
    		window.location.href = "${url}";
    	}
    	
    	function checkMobile(str) {
    		var str = $("#phoneNum").val();
		    if(str==""){
		        alert("手机号不能为空！");
		    } else{
		        var re = /^1\d{10}$/
		        if (re.test(str)) {
		            createMember(str);
		        } else {
		            alert("手机号格式错误！");
		            return;
		        }
		    }
		}
    	
    	function createMember(phoneNum){
    		if($.trim(phoneNum) == ""){
    			alert("请输入手机号");
    			return;
    		}else{
    			$("#f").submit();
    		}
    	}
    	
    	$(function () { 
    		$('#content').on('hide.bs.modal', function () {
	      		window.location.href = "${url}";
	      	})
	    });
	    
    </script>
</html>
