<div class="jumbotron" style="display:none" id="dataTemplate">
	<h3>淘宝API方式导入数据</h3>
	<!-- form start -->
    <form role="form" id="tpForm">
    	<div class="form-group">
    	  <label for="name">关键字</label>
	      <input class="form-control" type="text" placeholder="请输入关键字，如：女装" name="q" required >
	   	</div>
	   	<div class="form-group">
	   	  <label for="name">请选择关键字所属分类</label>
	      <select class="form-control" id="tpType" name="type">
	         <option value="0">请选择关键字所属分类</option>
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
	   	  <label for="name">是否只抓取天猫</label>
	      <select class="form-control" id="type" name="sort">
	         <option value="false">全部</option>
	         <option value="true">只天猫</option>
	      </select>
	   </div>
	   	<div class="form-group">
	   	  <label for="name">请输入抓取的条数，如：10</label>
	      <input class="form-control" type="text" placeholder="请输入抓取的条数，如：10" name="pageSize" value="10" required >
	   	</div>
	   	<div class="form-group">
	   	  <label for="name">请输入抓取的页数，如：1</label>
	      <input class="form-control" type="text" placeholder="请输入抓取的页数，如：1" name="pageNo" value="1" required >
	   	</div>
	   	<div class="form-group">
	   	  <label for="name">价格下限</label>
	      <input class="form-control" type="text" placeholder="请输入整数型的价格下限" name="startPrice" value="1" required >
	   	</div>
	   	<div class="form-group">
	   	  <label for="name">价格上限</label>
	      <input class="form-control" type="text" placeholder="请输入整数型的价格上限" name="endPrice" value="1" required >
	   	</div>
	   	
	   	<div class="form-group">
	   	  <label for="name">请选择抓取时的排序方式</label>
	      <select class="form-control" id="type" name="sort">
	         <option value="0">请选择抓取时的排序方式</option>
	         <option value="_des">降序</option>
	         <option value="_asc">升序</option>
	         <option value="total_sales">销量</option>
	         <option value="tk_rate">淘客佣金比率</option>
	         <option value="tk_total_sales">累计推广量</option>
	         <option value="tk_total_commi">总支出佣金</option>
	      </select>
	   </div>
	   
	   <button type="button" class="btn btn-primary" onclick="doAPISubmit();" style="width:100%;">提交</button>
    </form>
	<!-- form end -->
</div>