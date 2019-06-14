<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String htmlURL = request.getAttribute("htmlURL").toString();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<meta name="viewport" content="target-densitydpi=device-dpi, width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, minimal-ui" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<meta http-equiv="x-ua-compatible" content="IE=edge" />
		
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>

		<script type="text/javascript" src="js/loginJS.js"></script>
		<script type="text/javascript" src="js/vrScanJS.js"></script>
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="css/vrScanStyle.css" type="text/css" />
		<title>heygis-林科大全景</title>
	</head>
	<body>
		<div class="navbar navbar-default navbar-fixed-top navbar-inverse nav">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp"><span class="heygis1">heygis</span></a>
					<a class="navbar-brand"><span class="heygis">林科大全景</span></a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle suoyin" data-toggle="dropdown" role="button" aria-expanded="false">东园 </a>
							<ul class="dropdown-menu" role="menu">
								<li>
									<a href="javascript:dm()">东门</a>
								</li>
								<li>
									<a href="javascript:tsg()">图书馆</a>
								</li>
								<li>
									<a href="javascript:tsgld()">图书馆楼顶</a>
								</li>
								<li>
									<a href="javascript:pqgc()">喷泉广场</a>
								</li>
								<li>
									<a href="javascript:zjxl()">主教楼</a>
								</li>
								<li>
									<a href="javascript:wjphp()">三教旁湖泊</a>
								</li>
								<li>
									<a href="javascript:yst()">一食堂</a>
								</li>
								<li>
									<a href="javascript:dxl()">电子信息楼</a>
								</li>
								<li>
									<a href="javascript:yfl()">逸夫楼</a>
								</li>
								<li>
									<a href="javascript:tml()">土木楼</a>
								</li>
								<li>
									<a href="javascript:dyydc()">东园体育场</a>
								</li>
								<li>
									<a href="javascript:tyysg()">体育艺术馆</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle suoyin" data-toggle="dropdown" role="button" aria-expanded="false">林科大桥 </a>
							<ul class="dropdown-menu" role="menu">
								<li>
									<a href="javascript:lkdq()">林科大桥</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle suoyin" data-toggle="dropdown" role="button" aria-expanded="false">西园 </a>
							<ul class="dropdown-menu" role="menu">
								<li>
									<a href="javascript:qrp()">情人坡</a>
								</li>
								<li>
									<a href="javascript:xyzqc()">西园足球场</a>
								</li>
								<li>
									<a href="javascript:xm()">西门</a>
								</li>
								<li>
									<a href="javascript:wst()">五食堂</a>
								</li>
								<li>
									<a href="javascript:tt()">天台</a>
								</li>
								<li>
									<a href="javascript:shthf()">四食堂后方</a>
								</li>
								<li>
									<a href="javascript:sy()">思源</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="index.jsp">退出全景</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="suoyidiv" class="navbar-fixed-bottom" >
			<button id="showornot" onclick="f()" class="btn btn-primary">隐藏缩略图</button>
			<div id="test" >
				<a href="javascript:pqgc()"><img class="img-thumbnail" src="vtour/img/pqgc.jpg" /><span>喷泉中心</span></a>
				<a href="javascript:qrp()"><img class="img-thumbnail" src="vtour/img/qrp.jpg " /><span>情人坡</span> </a>
				<a href="javascript:yst()"><img class="img-thumbnail" src="vtour/img/yst.jpg " /><span>一食堂</span> </a>
				<a href="javascript:dxl()"><img class="img-thumbnail" src="vtour/img/dxl.jpg " /><span>电子信息楼</span> </a>
				<a href="javascript:yfl()"><img class="img-thumbnail" src="vtour/img/yfl.jpg " /><span>逸夫楼</span> </a>
				<a href="javascript:lkdq()"><img class="img-thumbnail" src="vtour/img/lkdq.jpg " /><span>林科大桥</span> </a>
				<a href="javascript:dyydc()"><img class="img-thumbnail" src="vtour/img/dyydc.jpg " /><span>东园运动场</span> </a>
				<a href="javascript:wst()"><img class="img-thumbnail" src="vtour/img/wst.jpg " /><span>五食堂</span> </a>
				<a href="javascript:xyzqc()"><img class="img-thumbnail" src="vtour/img/xyzqc.jpg " /><span>西园足球场</span> </a>
				<a href="javascript:tyysg()"><img class="img-thumbnail" src="vtour/img/tyysg.jpg " /><span>体育艺术馆</span> </a>
				<a href="javascript:dm()"><img class="img-thumbnail" src="vtour/img/dm.jpg " /><span>东门</span> </a>
				<a href="javascript:xm()"><img class="img-thumbnail" src="vtour/img/xm.jpg " /><span>西门</span> </a>
				<a href="javascript:sy()"><img class="img-thumbnail" src="vtour/img/sy.jpg " /><span>思源</span> </a>
				<a href="javascript:zjxl()"><img class="img-thumbnail" src="vtour/img/zjxl.jpg " /><span>主教学楼</span> </a>
				<a href="javascript:tml()"><img class="img-thumbnail" src="vtour/img/tml.jpg " /><span>土木楼</span> </a>
				<a href="javascript:tsg()"><img class="img-thumbnail" src="vtour/img/tsg.jpg " /><span>图书馆</span> </a>
				<a href="javascript:tsg()"><img class="img-thumbnail" src="vtour/img/tsgld.jpg " /><span>图书馆楼顶</span> </a>
				<a href="javascript:tsg()"><img class="img-thumbnail" src="vtour/img/wjphp.jpg " /><span>三教旁湖泊</span> </a>
				<a href="javascript:tsg()"><img class="img-thumbnail" src="vtour/img/shthf.jpg " /><span>四食堂后方</span> </a>
				<a href="javascript:tsg()"><img class="img-thumbnail" src="vtour/img/tt.jpg " /><span>天台</span> </a>
			</div>
	    </div>  
	    <iframe id="myFrame" src="<%=htmlURL %>" frameborder="0" width="100%" height="100%" scrolling="no">	
		</iframe>
	</body>
</html>
