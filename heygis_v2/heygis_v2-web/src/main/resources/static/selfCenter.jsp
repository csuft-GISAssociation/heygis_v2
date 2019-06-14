<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.heygis.dto.ForumMsgPage"%>
<%@ page import="com.heygis.dto.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getAttribute("user");
ForumMsgPage fMsgPage = (ForumMsgPage)request.getAttribute("fMsgPage");
SimpleDateFormat formatter = new SimpleDateFormat ("yy-MM-dd HH:mm:ss");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>heygis-个人中心</title>
    
	<meta name="keywords" content="">
		<meta name="description" content="">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		<script type="text/javascript" src="js/loginJS.js"></script>
		<script type="text/javascript" src="js/selfCenterJS.js"></script>
		<script type="text/javascript" src="js/cropbox.js"></script>
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/selfCenterStyle.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  		<jsp:include page="commonPage/navBar.jsp"></jsp:include>
		<br /><br /><br /><br />
		<div class="section Top mainbody" id="mainbody">
	      <div class="container">
	      	<h1 class="text-primary"><span class="glyphicon glyphicon-user"></span>个人中心</h1><br />
	        <div class="row ">
	          	<div class="col-sm-12 col-md-5">
		          	<div class="col-sm-5">
	          			<img src="<%=user.getIconImg() %>" class="img-responsive iconImg" /><br />
		          		<a class="btn btn-primary btn-block" id="fillInfo" href="fillInfo.jsp">完善信息</a>
		          		<button class="btn btn-primary btn-block" id="modifyIcon">修改头像</button>
		          	</div>
		          	<div class="col-sm-7 userInfo">
		          		<table class="table">
		          			<th>用户信息</th>
							<tr>
								<td>账号</td>
								<td><%=user.getAccount()%></td>
							</tr>
							<tr>
								<td>个性签名</td>
								<td><%=user.getSelfIntroduction() %></td>
							</tr>
							<tr>
								<td>昵称</td>
								<td><%=user.getNickName() %></td>
							</tr>
							<tr>
								<td>性别</td>
								<td><%=user.getGender() %></td>
							</tr>
							<tr>
								<td>入学年份</td>
								<td><%=user.getGrade() %></td>
							</tr>
							<tr>
								<td>QQ</td>
								<td><%=user.getQQ() %></td>
							</tr>
							<tr>
								<td id="pod">电话</td>
								<td><%=user.getTel() %></td>
							</tr>
						</table>
		          	</div>
	         	</div>
	          	<div class="col-sm-12 col-md-7"">
	          		<div class="tabs">
						<div class="">
							<div class="tabbable" id="tabs">
								<ul class="nav nav-tabs">
									<li class="active">
										<a href="#panel-1" data-toggle="tab">未读信息</a>
									</li>
									<li class="">
										<a href="#panel-2" data-toggle="tab" onclick="showOldMsg()">已读信息</a>
									</li>
									<li class="">
										<a href="#panel-3" data-toggle="tab" onclick="showMyThread()">我的发帖</a>
									</li>
								</ul>
							</div>
							<div class="tab-content row">
									<div class="tab-pane active" id="panel-1">
										<div id="newMsgList" class="list">
										<%for(int i=0; i< fMsgPage.getSize();i++){ %>
											<div class="message-cotent">
												<div class="col-md-9 col-xs-9 message-detail">
													<a onclick="return readMsg(<%=fMsgPage.getMsg(i).getMid() %>)" href="topicsServlet?fPage=1&tid=<%=fMsgPage.getMsg(i).getTid() %>&page=<%=fMsgPage.getMsg(i).getPage()%>&seeposi=<%=fMsgPage.getMsg(i).getPosition()%>#position<%=fMsgPage.getMsg(i).getPosition()-1%>">
												<%if(fMsgPage.getMsg(i).getType() == 1){ %>
														<%=fMsgPage.getMsg(i).getAuthor() %><br/>在主题”<%=fMsgPage.getMsg(i).getSubject() %>“中回复了你!												
												<%}else if(fMsgPage.getMsg(i).getType() == 2){ %>
														<%=fMsgPage.getMsg(i).getAuthor() %><br/>回复了你在”<%=fMsgPage.getMsg(i).getSubject() %>“中的回复!
												<%} %>
													</a>
												</div>
												<div class="col-md-3 col-xs-3 message-date">
													<p ><%=formatter.format(new Date(fMsgPage.getMsg(i).getDateline())) %></p>
												</div>
											</div>
										<%} %>
										</div>
										<div id="newMsgInfo">
										<%if(fMsgPage.getSize() == 0){%>
											<p style='color:white;font-size:17px'>没有更多了！</p>
										<%} %>
										</div>
										<a href="javascript:getNewMsg();" class='seemore' onclick="">查看更多</a>
									</div>
									<div class="tab-pane" id="panel-2">
										<div id ="oldMsgList" class="list"></div>
										<div id="oldMsgInfo"></div>
										<a href="javascript:getOldMsg();" class='seemore'>查看更多</a>
									</div>
									<div class="tab-pane" id="panel-3">
										<div id="myThreadList" class="list">
										</div>
										<div id="myThreadInfo"></div>
										<a href="javascript:getMyThread();" class='seemore'>查看更多</a>
									</div>
								</div>
						</div>
					</div>
	          	</div>
	        </div>
	      </div>
	    </div>
		<jsp:include page="commonPage/footer.jsp"></jsp:include>
		<jsp:include page="commonPage/login.jsp"></jsp:include>
		<div id="changeIcon" class="col-md-12">
			<div class="theme-poptit" id="theme">
				<a href="javascript:;" title="关闭" id="close" class="close">×</a>
				<h3>修改头像</h3>
			</div>
			<div class="">
				<div class="imageBox">
					<div class="thumbBox"></div>
					<div class="spinner" style="display: none">Loading...</div>
				</div>
				<div class="action">
					<input type="file" id="file" class="btn btn-primary">
					<div class="col-xs-4 iconbtn">
						<button id="btnZoomIn" class="btn btn-primary btn-block">
							<span class="glyphicon glyphicon-plus"></span>
						</button>
					</div>
					<div class="col-xs-4 iconbtn">
						<button id="btnZoomOut" class="btn btn-primary btn-block">
							<span class="glyphicon glyphicon-minus"></span>
						</button>
					</div>
					<div class="col-xs-4 iconbtn">
						<form id="form1" action="userIconServlet" method="post">
							<input type="button" id="btnCrop" value="确定" class="btn btn-primary btn-block">
							<textarea class="rrr" form="form1" name="imgURL"></textarea>
						</form>	
					</div>
				</div>
			</div>
		</div>
		<div class="theme-popover-mask"></div>
	</body>
</html>
