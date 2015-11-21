<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${url}">囤货网首页</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="${request.contextPath}/admin">淘宝导入数据</a></li>
            <li id="jd" ><a href="${request.contextPath}/admin/jd">京东导入数据</a></li>
            <li><a href="#about">模板管理</a></li>
            <li><a href="${request.contextPath}/banner/admin/toAdd">Banner管理</a></li>
            <li><a href="${request.contextPath}/hd/admin/add">平台活动管理</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">欢迎您：${user.userCode!"管理员"}</a></li>
            <li><a href="javascript:void(0);" onclick="loginOut();">退出</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>