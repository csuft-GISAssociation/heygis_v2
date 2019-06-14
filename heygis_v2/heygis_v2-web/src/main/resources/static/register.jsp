<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="heygis,地理信息科学,中南林业科技大学GIS">
		<meta name="description" content="中南林业科技大学gis协会官方网站注册页面">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		
		<script type="text/javascript" src="js/loginJS.js"></script>
		<script type="text/javascript" src="js/registerJS.js"></script>
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/registerStyle.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" media="screen" href="css/BGstyle.css">
		
		<title>heygis-注册</title>
	</head>

	<body>
		<jsp:include page="commonPage/navBar.jsp"></jsp:include>
		
		<div style="position:absolute; width:100%;height:100%">
			<div id="particles-js"></div>
			<script src="js/particles.js"></script>
			<script src="js/app.js"></script>
		</div>
				
		<div class="container mainbody">
			<div class="row"><br /> <br /> <br /> 
				<h1 class="text-primary">注册</h1>
				<br /> 
				<div class="col-sm-offset-3 col-sm-6">
					<form class="form-horizontal" role="form" id="registerForm" action="registerServlet" method="get">
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="email" name="account1" class="form-control" id="inputEmail3" placeholder="邮箱   将作为您登陆的账号" onblur="testEmail()" onclick="clear()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark1"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="password" class="form-control" id="inputPassword1" placeholder="密码(已使用md5加密) 6~22位数字字符或者特殊符号" onblur="testPwd()">
									<input type="hidden" name="passWord" >
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark2"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="password" class="form-control" id="inputPassword2" placeholder="请再次输入密码" onblur="testRePwd()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark3"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="text" name="nickName" class="form-control" id="inputnickName" placeholder="昵称" onblur="testNickName()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark4"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="text" name="grade" class="form-control" id="inputGrade" placeholder="入学年份 例如：2013" onblur="testGrade()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark5"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10" id="submitt">
									<button class="btn btn-primary btn-block" type="button"  onclick="register()">注册</button>
								</div>
							</div>
						</form>
				</div>
			</div>
		</div>
		
		<br />
		<jsp:include page="commonPage/footer.jsp"></jsp:include>
		<jsp:include page="commonPage/login.jsp"></jsp:include>
		<div class="theme-popover-mask"></div>
	</body>
</html>