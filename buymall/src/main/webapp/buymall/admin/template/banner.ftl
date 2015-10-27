<div class="jumbotron" style="display:none" id="bannerTemplate">
	<table class="table">
	   <caption>已存在的banner</caption>
	   <thead>
	      <tr>
	         <th>banner名称</th>
	         <th>图片地址</th>
	         <th>跳转地址</th>
	         <th>所属页面</th>
	         <th>位置</th>
	         <th>操作</th>
	      </tr>
	   </thead>
	   <tbody>
	      <!-- 内容 -->
	   </tbody>
	</table>
	
	<br>
	<br>
	<h3>新加</h3>
	<!-- banner添加 -->
	<form role="form" id="bannerForm">
	   <div class="form-group">
	      <input class="form-control" type="text" placeholder="标题" name="title" required >
	   </div>
	   <div class="form-group">
	      <input class="form-control" type="text" placeholder="图片地址" name="imgUrl" required >
	   </div>
	   <div class="form-group">
	      <input class="form-control" type="text" placeholder="跳转地址" name="itemUrl" required >
	   </div>
	   <div class="form-group">
	      <input class="form-control" type="text" placeholder="所属页面" name="page">
	   </div>
	   <div class="form-group">
	      <input class="form-control" type="text" placeholder="顺序" name="position">
	   </div>
	   
	   <button type="button" class="btn btn-primary" onclick="doSubmitBanner();" style="width:100%;">提交</button>
	</form>
</div>