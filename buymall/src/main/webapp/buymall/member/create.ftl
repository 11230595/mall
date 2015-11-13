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
    <script>
    	if(confirm("对不起，您暂时没开通商户，点击确定可直接开通。")){
    		window.location.href = "${url}/member/create?userId=${user.userId}"
    	}else{
    		window.location.href = "${url}";
    	}
    </script>
  </head>

  <body>
  </body>
</html>
