<%@page import="com.heygis.util.TopicWordProcess"%>
<%@page import="com.heygis.dto.ForumThread"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.heygis.dto.ForumPostPage" %>
<%@ page import="com.heygis.dto.ForumPost" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	ForumPostPage postPage = (ForumPostPage)request.getAttribute("postPage");
	SimpleDateFormat formatter = new SimpleDateFormat ("yy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<%--<script type="text/javascript" src="js/loginJS.js"></script>--%>
		<%--<script src="http://twemoji.maxcdn.com/twemoji.min.js"></script>--%>
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		
		<script type="text/javascript" src="js/topics.js"></script>
		<script type="text/javascript" src="js/jquery.color.js"></script>
		<script type="text/javascript" src="forums/google-code-prettify/prettify.js"></script>
		<link href="forums/google-code-prettify/prettify.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/loginStyle.css" />
		<link rel="stylesheet" type="text/css" href="css/topics.css" />
		<link rel="stylesheet" type="text/css" href="css/navCSS.css" />
	</head>

	<body onload="prettyPrint()">
		<jsp:include page="../commonPage/navBar.jsp"></jsp:include>
		<jsp:include page="../commonPage/login.jsp"></jsp:include>
		<div class="theme-popover-mask">
		</div>
		<div class="post_wraper container">
			<div class="row">
				<div class="thread_title col-md-10 col-sm-12 col-center-block">
					<h1 style="font-size: 30px;">
						<span><%=postPage.getPost(0).getSubject()%></span>
					</h1>
				</div>
				<div  class="col-md-10 col-sm-12 col-center-block thread_path">
						<a href="forumsServlet?fid=<%=postPage.getPost(0).getFid() %>&page=<%=postPage.getfPage() %>">> 返回帖子列表 </a>
						<div class="clear"></div>
				</div>
				<div class="postlist col-md-10 col-sm-12 col-center-block">
				<%
					ForumPost post = null;
				    for(int i=0;i<30;i++){
						if(postPage.getPost(i) == null)
							break;
						post = postPage.getPost(i);
				%>
					<div id="position<%=post.getPosition() %>"></div>
					<div class="post" id="posi<%=post.getPosition() %>">
						<div class="p_author col-md-2 col-sm-2 col-xs-2 ">
							<div class="p_author_icon  col-md-8 col-sm-9 col-xs-12 col-center-block">
								<img class="img-responsive" src="<%=post.getIcon() %>" />
							</div>
							<a herf="">
								<%=post.getAuthor() %>
							</a>
						</div>
						<div class="p_content col-md-10 col-sm-10 col-xs-10">
							<div class="p_detail" id="message<%=post.getPosition() %>" ">
								<%int begin;
								  if((begin=post.getMessage().indexOf("<pre class")) >= 0){ %>  
									<%=TopicWordProcess.process(post.getMessage(),begin) %>
								<%}else{ %>
									<%=post.getMessage().replaceAll("\n","<br>") %>
								<%} %>
							</div>
							<div class="replay_tail">
								<ul>
									<li>
										<a class="replay" href="#">管理</a>
									</li>
									<li>
										<a class="replay" href="###" onclick="reply(<%=post.getPosition()%>,<%=post.getAuthorUid()%>,'<%=post.getAuthorAccount()%>','<%=post.getAuthor()%>',<%=post.getPid()%>)">回复</a>
									</li>
									<li><%=formatter.format(post.getDateline()) %></li>
								</ul>
							</div>
						</div>
					</div>
				<%} %>
				</div>
				<div class="col-md-10 col-sm-12  col-center-block">
					<div style="float:left;padding:5px 10px 0px 10px">
						<a style="color:white" href="javascript:last();">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a style="color:white"  href="javascript:next();">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a style="color:white;">共<%=postPage.getTotalPageNum()%>页</a>
					</div>
				</div>
			</div>
		</div>
		
		<!--  a style="color:white" href="javascript:last();">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style="color:white"  href="javascript:next();">下一页</a-->
		
		<div class="post_reply_wraper container">
			<div class="row">
				<form action='addPostServlet?fid=<%=post.getFid() %>&tid=<%=postPage.getTid() %>' method="post" id="postpubllic">
					<div class="post_reply_content col-center-block col-md-10 col-sm-12">
						<!--<div style="height: auto;">
							<div class="post_reoly_head col-md-8 col-sm-12">
								鍙戣〃鍥炲
							</div>
							<div class="clear"></div>
						</div>-->
						<div id="textarea" style="height: auto;">
							<div class="post_reply_textarea col-md-9 col-sm-12">
								<!--<a herf="#">添加表情</a>-->
								<p>|</p>
								<a onclick="openCode(1)" class="codeA">添加代码
									<div id="codeDiv1" class="codeDiv">
										<textarea class="codetext form-control" id="code-text1" ></textarea>
										<div>
											<a class="btn btn-xs btn-primary codebtn" onclick="addCode(1)">确定</a>
											<a class="btn btn-xs btn-danger codebtn" onclick="closeCode(1)">取消</a>
										</div>
									</div>
								</a>
								<p>|</p>
								<a onclick="openImg(1)" class="codeA">添加图片
									<div id="imgDiv1" class="imgDiv">
										<input type="file" id="file1" value="选择图片" class="btn-sm btn-primary myfile"/>
										<a  class="btn btn-sm btn-primary imgbtn" onclick="javascript:alert('sorry,该功能还未上线')">确定</a>
										<a  onclick="closeImg(1)" class="btn btn-sm btn-danger imgbtn" >取消</a>
									</div>
								</a>
								<textarea id="textarea_post" name="message"></textarea>
							</div>	
							<div class="clear"></div>
						</div>
						<input type="hidden" name="t_uid" value="<%=postPage.getPost(0).getAuthorUid() %>"/>
						<input type="hidden" name="subject" value="<%=postPage.getPost(0).getSubject() %>"/>
						<div id="submit">
							<input type="button" class="post_reply_submit  btn btn-primary" value="发表" id="reply_post_submit" onclick="postPublic()"/>
						</div>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>	
		<div class="reply col-md-12">
			<div class="reply-poptit">
				<a href="javascript:;" title="关闭" class="close">×</a>
				<p>回复:</p>
				<div class="clear"></div>
			</div>
				<form id="posi_reply_form" action="replyPostServlet?fid=<%=post.getFid() %>&tid=<%=postPage.getTid() %>" method="post">
					<div class="posi_reply_content col-center-block col-md-12 col-sm-12">
						<div id="textarea" style="height: auto;">
							<div class="posi_reply_textarea col-md-9 col-sm-12">
								<!--<a herf="#">添加表情</a>-->
								<p>|</p>
								<a onclick="openCode(2)" class="codeA">添加代码
									<div id="codeDiv2" class="codeDiv">
										<textarea class="codetext form-control" id="code-text2" ></textarea>
										<div>
											<a class="btn btn-xs btn-primary codebtn" onclick="addCode(2)">确定</a>
											<a class="btn btn-xs btn-danger codebtn" onclick="closeCode(2)">取消</a>
										</div>
									</div>
								</a>
								<p>|</p>
								<a onclick="openImg(2)" class="codeA">添加图片
									<div id="imgDiv2" class="imgDiv">
										<input type="file" id="file2" value="选择图片" class="btn-sm btn-primary myfile"/>
										<a  class="btn btn-sm btn-primary imgbtn" onclick="javascript:alert('sorry,该功能还未上线')">确定</a>
										<a  onclick="closeImg(2)" class="btn btn-sm btn-danger imgbtn" >取消</a>
									</div>
								</a>
								<textarea id="posi_reply_textarea" name="message"></textarea>
							</div>	
							<div class="clear"></div>
						</div>
						<input type="hidden" name="t_uid" value="<%=postPage.getPost(0).getAuthorUid() %>"/>
						<input type="text" name="postauthor_uid" id="postauthor_uid" style="display: none; " value="0"/>
						<!--input type="text" name="postauthor_account" id="postauthor_account" style="display: none; " value="0"/-->
						<input type="text" name="replyposi" id="replyposi" style="display: none; " value="0"/>
						<input type="text" name="replyhead" id="replyhead" style="display: none; " value="0" />
						<input type="hidden" name="replypid" id="replypid" value="0"/> 
						<input type="text" name="subject" id="subject" style="display: none; " value="<%=postPage.getPost(0).getSubject()%>"/>
						<div id="submit">
							<input type="button" class="posi_subButton btn btn-primary" value="发表" id="post_submit" onclick="posiReplyPublic()"/>
						</div>
						<div class="clear"></div>
					</div>
				</form>
		</div>
	</body>
	<script type="text/javascript" src="js/newMsg.js"></script>
	<script>
		var totalPage = <%=postPage.getTotalPageNum()%>;
	</script>
</html>