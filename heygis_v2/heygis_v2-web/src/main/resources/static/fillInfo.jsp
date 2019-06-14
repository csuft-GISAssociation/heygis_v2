<%@page import="com.heygis.dto.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(!(Boolean)request.getAttribute("loged")){
	response.sendRedirect("index.jsp");
	return;
}
User user = (User)request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		
		<script type="text/javascript" src="js/loginJS.js"></script>
		<script type="text/javascript" src="js/fillInfoJS.js"></script>
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/fillInfoStyle.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" media="screen" href="css/BGstyle.css">
		
		<title>heygis-完善信息</title>
	</head>
	<body>
		<jsp:include page="commonPage/navBar.jsp"></jsp:include>

		<div style="position:absolute; width:100%;height:100%">
			<div id="particles-js"></div>
			<script src="js/particles.js"></script>
			<script src="js/app.js"></script>
		</div>
		<div class="section">
			<div class="container">
				<br /><br /><br />
				<h1 class="text-primary">完善信息</h1>
				<div class="row" style="color:white">
					<div class="col-md-12">
						<form class="form-horizontal" role="form" id="fillInfoForm" action="fillInfoServlet" method="post">
							<div class="form-group">
								<h3>必填信息</h3>
							    <label class="col-sm-offset-2 col-xs-2 text-right">邮箱</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="email" class="form-control" id="Email"  value="<%=user.getAccount() %>" disabled="true">
							    	 <input type="hidden" class="form-control" name="account" value="<%=user.getAccount() %>">
							    </div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">昵称</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="nickName" name="nickName" value="<%=user.getNickName() %>" onblur="testNickName()">
							    </div>
							    <div class="col-xs-1 judge">
									<label class="control-label" id="mark1"></label>
								</div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">年级</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="grade" name="grade" value="<%=user.getGrade() %>" onblur="testGrade()">
							    </div>
							     <div class="col-xs-1 judge">
									<label class="control-label" id="mark2"></label>
								</div>
							</div>
							<div class="form-group">
								<h3>选填信息</h3>
							    <label class="col-sm-offset-2 col-xs-2 text-right">个性签名</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="selfintroduction" name="selfintroduction" value="<%=user.getSelfIntroduction() %>">
							    </div>
							    <div class="col-xs-1 judge">
									<label class="control-label" id="mark3"></label>
								</div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">性别</label>
							    <div class="col-xs-9 col-sm-6">
							    	<div class="radio-inline col-xs-3 col-sm-2">
										<label>
										    <input type="radio" name="optionsRadios" id="optionsRadios0" value="保密">保密
										</label>
									</div>
							    	<div class="radio-inline col-xs-3 col-sm-2">
										<label>
										    <input type="radio" name="optionsRadios" id="optionsRadios1" value="男">男
										</label>
									</div>
									<div class="radio-inline col-xs-3 col-sm-2">
										<label>
										    <input type="radio" name="optionsRadios" id="optionsRadios2" value="女">女
										</label>
									</div>
							    </div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">QQ</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="QQ" name="QQ" value="<%=user.getQQ() %>">
							    </div>
							    <div class="col-xs-1 judge">
									<label class="control-label" id="mark4"></label>
								</div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">电话</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="tel" name="tel" value="<%=user.getTel() %>">
							    </div>
							     <div class="col-xs-1 judge">
									<label class="control-label" id="mark5"></label>
								</div>
							</div>
							<div class="col-sm-offset-3 col-sm-7" id="submitt">
								<button class="btn btn-primary btn-block" onclick="fillInfo()">确定修改</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br /><br /><br />

		<jsp:include page="commonPage/footer.jsp"></jsp:include>
		<jsp:include page="commonPage/login.jsp"></jsp:include>
		<div class="theme-popover-mask"></div>
	</body>
</html>
<script type="text/javascript">
   	var gender = "<%=user.getGender()%>";
   	if(gender=="男"){
   		$("#optionsRadios1").prop("checked",true);
   	}
   	if(gender=="女"){
   		$("#optionsRadios2").prop("checked",true);
   	}
   	if(gender=="保密"){
   		$("#optionsRadios0").prop("checked",true);
   	}
   </script>
