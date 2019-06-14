<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>heygis-报名界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
	<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

	<script type="text/javascript" src="js/loginJS.js"></script>
	<link href="css/navCSS.css" rel="stylesheet" type="text/css">
	<link href="css/footStyle.css" rel="stylesheet" type="text/css">
	<link href="css/loginStyle.css" rel="stylesheet" type="text/css"/>
	<link href="css/JoinUSCSS.css" rel="stylesheet" type="text/css"/>
</head>
  
  <body>
  		<jsp:include page="commonPage/navBar.jsp"></jsp:include>
  		<br /><br /><br /><br />
  		<div class="container">
			<form action="joinUSServlet" method="post">
				<div class="row col-lg-12 info">
					<h1 class="text-center">GIS协会报名表</h1><br />
					<div class="col-md-1 margin">姓名：</div>
					<div class="col-md-5 margin"><input type="text" name="name" class="form-control" placeholder="请填写你的真实姓名"required/> </div>
					<div class="col-md-1 margin">专业：</div>
					<div class="col-md-5 margin"><input type="text" name="profession" class="form-control" placeholder="请填写你所在的年级专业班级"required/></div>
					<div class="col-md-1 margin">电话：</div>
					<div class="col-md-5 margin"><input type="text" name="tel" class="form-control" placeholder="请填写你的电话号码，方便我们联系你。"required/> </div>
					<div class="col-md-1 margin">QQ：</div>
					<div class="col-md-5 margin"><input type="text" name="QQ" class="form-control" placeholder="请填写你的QQ号。"required/></div>
					<div class="col-md-2 margin">你加入的其他社团：</div>
					<div class="col-md-10 margin"><input type="text" name="other" class="form-control" placeholder="请填写你所加入的其他社团或者组织。"required/></div>
					<div class="col-md-12 margin">自我介绍：</div>
					<div class="col-md-12 margin">
						<textarea class="form-control" name="selfIntro" style="max-width:100%;min-width:100%;min-height: 200px;" placeholder="越详细越好" required></textarea>
					</div>
					<div class="col-md-12 margin">加入gis协会的目的：</div>
					<div class="col-md-12 margin">
						<textarea class="form-control" name="goal" style="max-width:100%;min-width:100%;min-height: 200px;" placeholder="请简述一下你为什么选择加入GIS协会" required></textarea>
					</div>
					<div class="col-md-12 margin"><input type="submit" class="btn btn-block btn-primary" value="提交"></div>
				</div>
			</form>
		</div>
		<jsp:include page="commonPage/footer.jsp"></jsp:include>
		<jsp:include page="commonPage/login.jsp"></jsp:include>
		<div class="theme-popover-mask"></div>
	</body>
</html>
