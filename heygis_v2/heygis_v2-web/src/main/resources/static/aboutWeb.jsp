<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="heygis,地理信息科学,中南林业科技大学GIS">
		<meta name="description" content="中南林业科技大学gis协会官方网站">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		
		<script type="text/javascript" src="js/loginJS.js"></script>
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/aboutWebStyle.css" rel="stylesheet" type="text/css" />
		<title>heygis-关于本网站</title>
	</head>
	<body>
		<jsp:include page="commonPage/navBar.jsp"></jsp:include>

		<br/><br/><br/>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="text-left container" style="font-size:22px;box-shadow: 5px 5px 20px #B1B0B0;background:white">
						<h1 class="text-center">关于本网站</h1>
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本网站从有想法到最后的实现大概花费了我们两个人半年左右的时间，虽然整个网站规模不大，但是还是花了我们很多的心思。我们之前并没有接触过有关建站
						方面的知识，从jsp到servlet均是自学，因此在这个版本中没有上ssh框架是一个很大遗憾。<br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;论坛区主要是由余瑞成负责，我们没有直接使用discuz提供的框架，而是选择了自己写，原因有以下几点：discuz论坛的功能很完善，但是我们希望是一个小型的轻论坛，能够提供一
						个界面清爽，操作简单的论坛区，discuz中的很多功能我们均无需使用，因此我们参考了它最核心的数据字典。<br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资源下载区主要由夏健超负责，这个版块的灵感来源于本专业设计到许多专业方面的专业软件，包括本协会也许使用到各类编译工具和数据库工具，为了更好的方便协会成员与本专业成员。
						资源下载的方式现在采用了腾讯云的对象存储服务和360网盘结合的方式，我们会在接下来尽可能地全部使用云对象存储方式来方便大家的下载（感觉还没工作就要破产了呀！）。<br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;林科大全景则是两人兴趣使然，从全景的选择、拍摄，到后期的修图合成均是协作完成，由于天气和相机的原因，部分照片并不如人意，且迫于时间原因，在网站上线时并没有处理好所有的全景内容，我们会在接下来的时间里逐步推出。<br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;以上是我们俩做此网站的初衷，这并不是为了总结大会而产生，我们更希望协会可以借此营造一个全新的氛围，发挥出无限的可能。<br/>
							<p style="margin-left:45px">最后，关于本网站用到的技术如下：<br/>
							前端：<br/>
							&nbsp;&nbsp;&nbsp;1、bootstrap<br/>
							&nbsp;&nbsp;&nbsp;2、jquery<br/>
							&nbsp;&nbsp;&nbsp;3、google-code-prettify<br/>
							&nbsp;&nbsp;&nbsp;4、百度地图LBS云<br/>
							后台：<br/>
							&nbsp;&nbsp;&nbsp;1、tomcat<br/>
							&nbsp;&nbsp;&nbsp;2、mysql<br/>
							&nbsp;&nbsp;&nbsp;3、腾讯云云服务器云解析及云存储服务<br/>
							&nbsp;&nbsp;&nbsp;4、apache commons pool<br/>
							&nbsp;&nbsp;&nbsp;5、360网盘<br/>
							其他：<br/>
							&nbsp;&nbsp;&nbsp;1、eclipse/myeclipse<br/>
							&nbsp;&nbsp;&nbsp;2、krpano<br/>
							&nbsp;&nbsp;&nbsp;3、ptgui<br/>
							&nbsp;&nbsp;&nbsp;4、lightroom<br/>
							&nbsp;&nbsp;&nbsp;5、photoshop<br/>
							</p>
						</p>
					</div>
					<div class="VivaTimeline">
						<h1>从想法到实际</h1>
						<dl>
	                        <dt>Jan 2016</dt>                                    
	                        <dd class="pos-left clearfix">
	                            <div class="circ"></div>
	                            <div class="time">one day</div>
	                            <div class="events">
	                                <div class="events-header">想为协会制作一个网站的想法萌发...</div>                               
	                            </div>
	                        </dd>
	                        <dt>Feb 2016</dt>
	                        <dd class="pos-right clearfix">
	                            <div class="circ"></div>
	                            <div class="time">Feb~Mar</div>
	                            <div class="events">
	                                <div class="events-header">了解关于网站的制作，补充建站知识。</div>                                                     
	                            </div>
	                        </dd>                              
	                        <dt>Mar 2016</dt>  
	                        <dd class="pos-left clearfix">
	                            <div class="circ"></div>
	                            <div class="time">early Mar</div>
	                            <div class="events">
	                                <div class="events-header">确定了制作本网站的决心，开始讨论网站功能。</div>                               
	                            </div>
	                        </dd> 
	                        <dd class="pos-right clearfix">
	                            <div class="circ"></div>
	                            <div class="time">17 Mar</div>
	                            <div class="events">
	                                <div class="events-header">利用Axure设计出首页原型，雏形初现。</div>                                                     
	                            </div>
	                        </dd> 
	                        <dd class="pos-left clearfix">
	                            <div class="circ"></div>
	                            <div class="time">late Mar</div>
	                            <div class="events">
	                                <div class="events-header">讨论完善其他功能，确定资源下载板块与论坛板块。</div>                               
	                            </div>
	                        </dd>                        
	                        <dt>Apr 2016</dt>
	                        <dd class="pos-right clearfix">
	                            <div class="circ"></div>
	                            <div class="time">early Apr</div>
	                            <div class="events">
	                                <div class="events-header">开始着手其他页面的UI设计，讨论网站域名。</div>                                                     
	                            </div>
	                        </dd> 
	                        <dd class="pos-left clearfix">
	                            <div class="circ"></div>
	                            <div class="time">mid Apr</div>
	                            <div class="events">
	                                <div class="events-header">确定域名，购买域名，申请备案。</div>                               
	                            </div>
	                        </dd> 
	                        <dd class="pos-right clearfix">
	                            <div class="circ"></div>
	                            <div class="time">late Apr</div>
	                            <div class="events">
	                                <div class="events-header">各页面的html代码完成，域名备案成功。<br/>
	                                							讨论bbs的数据库设计，一定程度上参考了discuz，确定数据结构。
	                                </div>  
	                            </div>
	                        </dd> 
	                        <dt>May 2016</dt>
	                        <dd class="pos-left clearfix">
	                            <div class="circ"></div>
	                            <div class="time">early Apr</div>
	                            <div class="events">
	                                <div class="events-header">着手后台逻辑代码，网站功能逐渐实现。</div>                               
	                            </div>
	                        </dd> 
	                        <dd class="pos-right clearfix">
	                            <div class="circ"></div>
	                            <div class="time">mid May</div>
	                            <div class="events">
	                                <div class="events-header">发现bootstrap，推翻原有界面重新进行设计。</div>  
	                            </div>
	                        </dd> 
	                        <dd class="pos-left clearfix">
	                            <div class="circ"></div>
	                            <div class="time">late Apr</div>
	                            <div class="events">
	                                <div class="events-header">基于新页面重新编写代码，期间增加了林科大全景板块。</div>                               
	                            </div>
	                        </dd>
	                        <dd class="pos-right clearfix">
	                            <div class="circ"></div>
	                            <div class="time">31 May</div>
	                            <div class="events">
	                                <div class="events-header">第一次整合代码</div>  
	                            </div>
	                        </dd> 
	                        <dt>Jun 2016</dt>
	                        <dd class="pos-left clearfix">
	                            <div class="circ"></div>
	                            <div class="time">early Apr</div>
	                            <div class="events">
	                                <div class="events-header">小功能的完善，频繁的迭代，各种找bug。</div>                               
	                            </div>
	                        </dd>
	                        <dd class="pos-right clearfix">
	                            <div class="circ"></div>
	                            <div class="time">15 Jun</div>
	                            <div class="events">
	                                <div class="events-header">总结大会，正式公布于众。</div>  
	                            </div>
	                        </dd> 
	                    </dl>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid footer">
			<div class="container row-fluid foot">
				<div class="col-md-4  col-sm-6 foot-left">
					<h1 class="footh1">联系我们</h1> Email:heygis@163.com
					<br /> QQ:12345678
					<br /> Address:长沙市韶山南路498号中南林业科技大学
					<br />
				</div>
				<div class="col-md-4  col-sm-6 foot-right">
					<h1 class="footh1">相关链接</h1>
					<a href="feedbackServlet">意见反馈</a>
					<br /> <a href="aboutWeb.jsp">关于本网站</a>
					<br /> <a href="aboutMaker.jsp"> 关于制作者</a>
					<br />
				</div>
				<div class="col-md-4  col-sm-12 shenming">
					<span>注意：本站资源均来源于原创或网络,如有侵权请联系站长清除。</span>
					<br />
					<a href="http://www.miibeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">湘ICP备16006264</a>
				</div>
			</div>
		</div>
		<div class="theme-popover col-md-12">
			<div class="theme-poptit">
				<a href="javascript:;" title="关闭" class="close">×</a>
				<h3>登录 是一种态度</h3>
			</div>
			<div class="theme-popbod dform">
				<form id="loginForm" class="theme-signin" name="loginform"  method="post" onsubmit="return login()">
					<ol>
						<li>
							<h4 id="loginMessage">你必须先登录！</h4>
						</li>
						<li><strong>用户名：</strong>
							<input class="ipt" type="text" name="account" value="" size="20" placeholder="账号（邮箱）" required/>
						</li>
						<li><strong>密码：</strong>
							<input class="ipt" type="password" name="password" value="" placeholder="密码" size="20" required/>
						</li>
						<li>
							<input class="btn btn-primary" type="submit" name="submit" value=" 登 录    " />
							<a href="register.jsp">&nbsp;注册</a>
						</li>
					</ol>
				</form>
				<form id="logout" method="post" action="logoutServlet">
					<INPUT TYPE="submit" name="test" value = "go" style="display:none">
				</form>
			</div>
		</div>
		<div class="theme-popover-mask"></div>			
	</body>
</html>
    