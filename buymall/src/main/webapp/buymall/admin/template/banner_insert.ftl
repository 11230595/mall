<div class="jumbotron" id="bannerTemplate">
	<table class="table">
	   <caption>已存在的banner</caption>
	   <thead>
	      <tr>
	         <th style="width:20%">banner名称</th>
	         <th style="width:30%">图片地址</th>
	         <th style="width:30%">跳转地址</th>
	         <th style="width:10%">所属页面</th>
	         <th style="width:5%">位置</th>
	         <th style="width:5%">操作</th>
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
	      <input class="form-control" type="text" placeholder="所属页面，如首页" name="page">
	   </div>
	   <div class="form-group">
	      <input class="form-control" type="text" placeholder="顺序，请填写数字" name="position">
	   </div>
	   <div class="form-group">
	   	  <select class="form-control" name="type" id="type">
	         <option value="-1">请选择banner类型</option>
	         <option value="0">首页上部4个大图</option>
	         <option value="2">上部下方的三个小图</option>
	      </select>
	   </div>
	   
	   <button type="button" class="btn btn-primary" onclick="doSubmitBanner();" style="width:100%;">提交</button>
	</form>
</div>