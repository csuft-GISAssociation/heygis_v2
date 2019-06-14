<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.heygis.dto.FeedbackMsg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>heygis-意见反馈</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="keywords" content="heygis,地理信息科学,中南林业科技大学GIS">
	<meta name="description" content="中南林业科技大学gis协会官方网站意见反馈">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		
	<script type="text/javascript" src="js/loginJS.js"></script>
	<script type="text/javascript" src="js/feedbackJS.js"></script>
	<link href="css/navCSS.css" rel="stylesheet" type="text/css">
	<link href="css/footStyle.css" rel="stylesheet" type="text/css">
	<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
	<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/feedbackStyle.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  		<jsp:include page="commonPage/navBar.jsp"></jsp:include>

  		<br /><br /><br />
		<h1 class="text-primary">意见反馈</h1>
		请提出您对本网站的意见建议或者网站的bug，我们会及时的回复您并解决反馈的问题。希望在大家的帮助下可以将本网站越办越好!
		<hr />
		<%
		List<FeedbackMsg> feedbackMsgList = (List<FeedbackMsg>)request.getAttribute("feedbackMsgList");
		if(feedbackMsgList != null){
			for(FeedbackMsg msg:feedbackMsgList){
				%>
				<div class="message container">
					<div class="face">
						<img src=<%=msg.getAccountImg() %> class=img-responsive>
					</div>
					<div class="messagebox">
						<span class="triangle"></span>
						<div class="name"><strong>访客:<%=msg.getNickname()%></strong></div>
						<div class="date">发表时间:<%=msg.getTime()%></div>
						<div class="content"><%=msg.getFeedbackContent()%></div>
					</div>
				</div>	
		<%	}
		} %>
		<br />
		<div id="form" class="container">
			<div class="content">
				<form action="addFeedbackServlet" method="post" id="publish">
					<input type="hidden" id="check" name="check" value="0">
					<div class="form-group">
						<textarea form="publish" id="content" name="content" class="form-control" rows="4" placeholder="填写您的留言。在您发布前，请先确认已登录或者已勾选游客模式" onblur="vaildnull()" onfocus="clearr()"></textarea>					
					</div>
					<div class="form-group" id="submit" style="text-align: right;">
						<span class="btn btn-default"  onclick="f()"><input type="checkbox" name="checkbox" id="checkbox"/>使用游客身份匿名发布</span>
						<button name="Submit"  onclick="submitt()" class="btn btn-primary">发布</button>
					</div>
				</form>
			</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		<jsp:include page="commonPage/footer.jsp"></jsp:include>
		<jsp:include page="commonPage/login.jsp"></jsp:include>
		<div class="theme-popover-mask"></div>
  </body>
</html>
