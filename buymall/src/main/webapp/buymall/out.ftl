<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>囤货网-跳转中</title>
<script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
</head>
<body>
	<#include "template/taodianjin.ftl"><!-- 淘点金模板 -->
	
	<script>
		function skip(){
			document.getElementById("alink").click();
		}
		
		window.onload=skip;
	</script>
</body>
</html>