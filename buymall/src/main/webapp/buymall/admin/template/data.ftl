<div class="jumbotron" style="display:none" id="dataTemplate">
    <h3>导入数据</h3>
    <!-- form start -->
    <form role="form" id="f">
	   <div class="form-group">
	      <select class="form-control" id="type">
	         <option value="0">请选择分类</option>
	         <option value="1">女装</option>
	         <option value="2">男装</option>
	         <option value="3">内衣</option>
	         <option value="4">鞋品</option>
	         <option value="5">儿童</option>
	         <option value="6">母婴</option>
	         <option value="7">居家</option>
	         <option value="8">食品</option>
	         <option value="9">数码</option>
	         <option value="10">箱包</option>
	         <option value="11">美妆</option>
	      </select>
	   </div>
	
	   <div class="form-group">
	      <div class="form-group">
		    <label for="name">商品地址</label>
		    <textarea class="form-control" rows="3" id="url"></textarea>
		  </div>
	   </div>
	   
	   <button type="button" class="btn btn-primary" onclick="doSubmit();" style="width:100%;">提交</button>
	</form>
	<!-- form end -->
	
</div>