<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>heygis-跳转页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>

	<script type="text/javascript" src="js/jquery.form.js"></script>
	<script type="text/javascript" src="js/loginJS.js"></script>
	<link href="css/navCSS.css" rel="stylesheet" type="text/css">
	<link href="css/footStyle.css" rel="stylesheet" type="text/css">
	<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/JoinUSCSS.css" rel="stylesheet" type="text/css" />
  </head>
  
  	<body>
  		<div class="navbar navbar-default navbar-fixed-top navbar-inverse nav">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle newMsgMark" data-toggle="collapse" data-target="#navbar-ex-collapse">
						<span class="badge">4</span>
					</button>
					<button style="margin-right:4px" type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="###"><span class="heygis">HeyGIS</span></a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="index.jsp">首页</a>
						</li>
						<li>
							<a href="index.jsp#bbs">论坛区</a>
						</li>
						<li>
							<a href="index.jsp#sourceDownLoad">资源区</a>
						</li>
						<li>
							<a href="index.jsp#lkdVR">林科大全景</a>
						</li>
						<%if(request.getAttribute("loged") != null){ %>
							<%if(request.getAttribute("loged").equals(true)){ %>
						<li>
							<a href="selfCenterServlet">个人中心<span class="badge">4</span></a>
						</li>
						<li>
							<a class="btn" href="javascript:document:logout.submit()" >退出</a>
						</li>
						<%} %>
					<%}else{ %>
						<li>
							<a class="btn theme-login" href="javascript:;">登录</a>
						</li>
						<li>
							<a class="btn " href="register.jsp">注册</a>
						</li>
					<%} %>
					</ul>
				</div>
			</div>
		</div><br /><br /><br /><br />
  		<div class="container mianbody" style="color:white;min-height:window.screen.height-100">
			<h1>恭喜你报名成功，<br/>我们会在接下来的时间联系你，<br/>请保持手机畅通。</h1>
			<a class="btn btn-lg btn-primary" href="index.jsp">返回主页</a>
		</div>

		<jsp:include page="commonPage/footer.jsp"></jsp:include>
		<jsp:include page="commonPage/login.jsp"></jsp:include>
		<div class="theme-popover-mask"></div>
	</body>
	<script>
		$(document).ready(function(){ 
			var needHeight = window.screen.height;
			$(".mianbody").css("min-height",needHeight-300);
		} );
	</script>
</html>
