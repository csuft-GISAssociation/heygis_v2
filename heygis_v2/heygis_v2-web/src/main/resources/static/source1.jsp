<%@page import="com.heygis.dto.SourceFour"%>
<%@page import="com.heygis.dto.SourceTwo"%>
<%@page import="com.heygis.dto.SourceOne"%>
<%@page import="com.heygis.dto.SourceThree"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//String currPageNo1 = request.getAttribute("currPageNo1").toString();
//String currPageNo2 = request.getAttribute("currPageNo2").toString();
//String currPageNo3 = request.getAttribute("currPageNo3").toString();
//String currPageNo4 = request.getAttribute("currPageNo4").toString();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>heygis-资源下载</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta name="keywords" content="heygis,中南林业科技大学全景地理信息科学,林业科技大学gis协会官方网站">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		
	<script type="text/javascript" src="js/loginJS.js"></script>
	<script type="text/javascript" src="js/source1JS.js"></script>
	<link href="css/source1Style.css" rel="stylesheet" type="text/css" />
	<link href="css/navCSS.css" rel="stylesheet" type="text/css">
	<link href="css/footStyle.css" rel="stylesheet" type="text/css">
	<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
	<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />

  </head>

  
  <body>
  		<jsp:include page="commonPage/navBar.jsp"></jsp:include>
  		<div class="container tabs mianbody">
			<div class="row">
				<div class="col-lg-12">
					<div class="tabbable" id="tabs">
						<ul class="nav nav-tabs">
							<li class="active col-lg-3 col-md-3 col-xs-6" id="ppanel-1">
								<a href="#panel-1" data-toggle="tab">总结大会</a>
							</li>
							<li class=" col-lg-3 col-md-3 col-xs-6" id="ppanel-2">
								<a href="#panel-2" data-toggle="tab">课堂源码</a>
							</li>
							<li class="col-lg-3 col-md-3 col-xs-6" id="ppanel-3">
								<a href="#panel-3" data-toggle="tab">开发工具</a>
							</li>
							<li class="col-lg-3 col-md-3 col-xs-6" id="ppanel-4">
								<a href="#panel-4" data-toggle="tab">拓展强化</a>
							</li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane" id="panel-1">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary sourceTitle" >总结大会</h1>
											<div class="btn-group btn-choose" >
											  <button type="button" class="btn btn-primary dropdown-toggle choose" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											    默认排序 <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu">
											  	<li>
											    	<div class="input-group input-group-sm">
												      <input type="text" class="form-control" placeholder="search" aria-describedby="sizing-addon3" id="searchCtx1">
												      <span class="input-group-btn">
												        <a class="btn btn-default btn-sm" type="button" href="javascript:search(1)" onclick="clearPageNo(1)"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
												      </span>
												    </div>
												</li>
											    <li><a href="javascript:timecho(1,1)" id="timecho">按上传时间</a></li>
											    <li><a href="javascript:timescho(1,2)" id="timescho">按下载数</a></li>
											    <li><a href="javascript:alphacho(1,3)" id="alphacho">按字母</a></li>
											    <li><a href="javascript:sizecho(1,4)"  id="sizecho">按文件大小</a></li>
											    <li role="separator" class="divider"></li>
											    <li><a href="javascript:defaultcho(1,0)" id="defaultcho">默认排序</a></li>
											  </ul>
											</div>
											<p>每一年的总结大会的作品都整理在了这里，欢迎大家互相借鉴，互相学习。</p>
										</header>
										<nav>
										  <ul class="pager">
										    <li class="previous"><a href="" onclick="toLast(1,sortWay1);return false"><span aria-hidden="true">&larr;</span>上一页</a></li>
										    <li class="next"><a href="" onclick="toNext(1,sortWay1);return false">下一页 <span aria-hidden="true">&rarr;</span></a></li>
										  </ul>
										</nav>
										<section class="tiles" id="section_1">
											<%
											int count1 =  ((List<SourceOne>)request.getAttribute("sourceOneList")).size();
											if(count1 > 15){
												count1 = 15;
											}
											for(int i = 0;i<count1;i++){
											SourceOne sourceOne = ((List<SourceOne>)request.getAttribute("sourceOneList")).get(i);
											//for(SourceOne sourceOne : (List<SourceOne>)request.getAttribute("sourceOneList")){
											String st = "style"+(new Random().nextInt(5)+1);
											String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
											%><article class="<%=st%>">
											        <span class="image">
														<img src="<%=bg%>" alt="" />
													</span>
													<div class="detail">
													<h2><%=sourceOne.getName() %>(<%=sourceOne.getLevel() %>)</h2>
													<h4>作者:<%=sourceOne.getUploader() %></h4>
													<h4>下载次数:<%=sourceOne.getDownload_times() %></h4>
													<h5>文件大小:<%=sourceOne.getFile_size() %></h5>
													<h5>上传时间:<%=sourceOne.getUpload_time() %></h5>
													<div class="content">
														<p><%=sourceOne.getIntroduction() %></p>
														<a class="btn btn-primary btn-lg change" href="<%=sourceOne.getDownload_link()%>" onclick="return checkLog('<%=sourceOne.getName()%>')">本站下载地址</a>
													</div>
												</div>
											</article>
											 <%}%>
										</section>
										<nav>
										  <ul class="pager">
										    <li class="previous"><a href="" onclick="toLast(1,sortWay1);return false"><span aria-hidden="true">&larr;</span>上一页</a></li>
										    <li class="next"><a href="" onclick="toNext(1,sortWay1);return false">下一页 <span aria-hidden="true">&rarr;</span></a></li>
										  </ul>
										</nav>
									</div>
								</div>
							</div>

							<div class="tab-pane" id="panel-2">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary sourceTitle">课堂源码</h1>
											<div class="btn-group btn-choose" >
											  <button type="button" class="btn btn-primary dropdown-toggle choose" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											    默认排序 <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu">
											  	<li>
											    	<div class="input-group input-group-sm">
												      <input type="text" class="form-control" placeholder="search" aria-describedby="sizing-addon3" id="searchCtx2">
												      <span class="input-group-btn">
												        <a class="btn btn-default btn-sm" type="button" href="javascript:search(2)" onclick="clearPageNo(2)"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
												      </span>
												    </div>
												</li>
											    <li><a href="javascript:timecho(2,1)" id="timecho">按上传时间</a></li>
											    <li><a href="javascript:timescho(2,2)" id="timescho">按下载数</a></li>
											    <li><a href="javascript:alphacho(2,3)" id="alphacho">按字母</a></li>
											    <li><a href="javascript:sizecho(2,4)"  id="sizecho">按文件大小</a></li>
											    <li role="separator" class="divider"></li>
											    <li><a href="javascript:defaultcho(2,0)" id="defaultcho">默认排序</a></li>
											  </ul>
											</div>
											<p>不仅要看懂课堂上的代码，还要多敲多练。锻炼手指的记忆，增强代码熟练度。</p>
										</header>
										<nav>
										  <ul class="pager page">
										    <li class="previous"><a href="" onclick="toLast(2,sortWay2);return false"><span aria-hidden="true">&larr;</span>上一页</a></li>
										    <li class="next"><a href="" onclick="toNext(2,sortWay2);return false">下一页 <span aria-hidden="true">&rarr;</span></a></li>
										  </ul>
										</nav>
										<section class="tiles" id="section_2">
											<%
											int count2 =  ((List<SourceTwo>)request.getAttribute("sourceTwoList")).size();
											if(count2 > 15){
												count2 = 15;
											}
											for(int i = 0;i<count2;i++){
											SourceTwo sourceTwo = ((List<SourceTwo>)request.getAttribute("sourceTwoList")).get(i);
											//for(SourceTwo sourceTwo : (List<SourceTwo>)request.getAttribute("sourceTwoList")){
											String st = "style"+(new Random().nextInt(5)+1);
											String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
											%><article class="<%=st%>">
											        <span class="image">
														<img src="<%=bg%>" alt="" />
													</span>
													<div class="detail">
													<h2><%=sourceTwo.getName() %></h2>
													<h4>作者:<%=sourceTwo.getUploader() %></h4>
													<h4>下载次数:<%=sourceTwo.getDownload_times() %></h4>
													<h5>文件大小:<%=sourceTwo.getFile_size() %></h5>
													<h5>上传时间:<%=sourceTwo.getUpload_time() %></h5>
													<div class="content">
														<p><%=sourceTwo.getIntroduction() %></p>
														<a class="btn btn-primary btn-lg change" href="<%=sourceTwo.getDownload_link()%>" onclick="return checkLog('<%=sourceTwo.getName()%>')">本站下载地址</a>
													</div>
												</div>
											</article>
											<%}%>
										</section>
										<nav>
										  <ul class="pager">
										    <li class="previous"><a href="" onclick="toLast(2,sortWay2);return false"><span aria-hidden="true">&larr;</span>上一页</a></li>
										    <li class="next"><a href="" onclick="toNext(2,sortWay2);return false">下一页 <span aria-hidden="true">&rarr;</span></a></li>
										  </ul>
										</nav>
									</div>
								</div>
							</div>
							<div class="tab-pane" id="panel-3">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary sourceTitle">开发工具</h1>
											<div class="btn-group btn-choose" >
											  <button type="button" class="btn btn-primary dropdown-toggle choose" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											    默认排序 <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu">
											  	<li>
											    	<div class="input-group input-group-sm">
												      <input type="text" class="form-control" placeholder="search" aria-describedby="sizing-addon3" id="searchCtx3">
												      <span class="input-group-btn">
												        <a class="btn btn-default btn-sm" type="button" href="javascript:search(3)" onclick="clearPageNo(3)"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
												      </span>
												    </div>
												</li>
											    <li><a href="javascript:timecho(3,1)" id="timecho">按上传时间</a></li>
											    <li><a href="javascript:timescho(3,2)" id="timescho">按下载数</a></li>
											    <li><a href="javascript:alphacho(3,3)" id="alphacho">按字母</a></li>
											    <li><a href="javascript:sizecho(3,4)"  id="sizecho">按文件大小</a></li>
											    <li role="separator" class="divider"></li>
											    <li><a href="javascript:defaultcho(3,0)" id="defaultcho">默认排序</a></li>
											  </ul>
											</div>
											<p class="futitle">如果只是在面临老师布置的各种课程设计时才想到我的话，那就太可惜了。</>
										</header>
										<nav>
										  <ul class="pager">
										    <li class="previous"><a href="" onclick="toLast(3,sortWay3);return false"><span aria-hidden="true">&larr;</span>上一页</a></li>
										    <li class="next"><a href="" onclick="toNext(3,sortWay3);return false">下一页 <span aria-hidden="true">&rarr;</span></a></li>
										  </ul>
										</nav>
										<section class="tiles" id="section_3">
											<%
											int count3 =  ((List<SourceThree>)request.getAttribute("sourceThreeList")).size();
											if(count3 > 15){
												count3 = 15;
											}
											for(int i = 0;i<count3;i++){
											SourceThree sourceThree = ((List<SourceThree>)request.getAttribute("sourceThreeList")).get(i);
											//for(SourceThree sourceThree : (List<SourceThree>)request.getAttribute("sourceThreeList")){
											String st = "style"+(new Random().nextInt(5)+1);
											String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
											%><article class="<%=st%>">
											        <span class="image">
														<img src="<%=bg%>" alt="" />
													</span>
													<div class="detail">
													<h2><%=sourceThree.getName() %></h2>
													<h4>下载次数:<%=sourceThree.getDownload_times() %></h4>
													<h5>文件大小:<%=sourceThree.getFile_size() %></h5>
													<h5>上传时间:<%=sourceThree.getUpload_time() %></h5>
													<div class="content">
														<p><%=sourceThree.getIntroduction() %></p>
														<a class="btn btn-primary btn-md" href="<%=sourceThree.getDownload_link_offical()%>" target="_blank">官方下载地址</a> 
														<a class="btn btn-primary btn-md change" href="<%=sourceThree.getDownload_link()%>" onclick="return checkLog('<%=sourceThree.getName() %>')">本站下载地址</a>
													</div>
												</div>
											</article>
											 <%}%>
										</section>
										<nav>
										  <ul class="pager">
										    <li class="previous"><a href="" onclick="toLast(3,sortWay3);return false"><span aria-hidden="true">&larr;</span>上一页</a></li>
										    <li class="next"><a href="" onclick="toNext(3,sortWay3);return false">下一页 <span aria-hidden="true">&rarr;</span></a></li>
										  </ul>
										</nav>
									</div>
								</div>
							</div>
							<div class="tab-pane" id="panel-4">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary sourceTitle">拓展强化</h1>
											<div class="btn-group btn-choose" >
											  <button type="button" class="btn btn-primary dropdown-toggle choose" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											    默认排序 <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu">
											  	<li>
											    	<div class="input-group input-group-sm">
												      <input type="text" class="form-control" placeholder="search" aria-describedby="sizing-addon3" id="searchCtx4">
												      <span class="input-group-btn">
												        <a class="btn btn-default btn-sm" type="button" href="javascript:search(4)" onclick="clearPageNo(4)"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
												      </span>
												    </div>
												</li>
											    <li><a href="javascript:timecho(4,1)"  onclick="clearPageNo(4)" id="timecho">按上传时间</a></li>
											    <li><a href="javascript:timescho(4,2)" onclick="clearPageNo(4)" id="timescho">按下载数</a></li>
											    <li><a href="javascript:alphacho(4,3)" onclick="clearPageNo(4)" id="alphacho">按字母</a></li>
											    <li><a href="javascript:sizecho(4,4)" onclick="clearPageNo(4)"  id="sizecho">按文件大小</a></li>
											    <li role="separator" class="divider"></li>
											    <li><a href="javascript:defaultcho(4,0)" onclick="clearPageNo(4)" id="defaultcho">默认排序</a></li>
											  </ul>
											</div>
											<p>青春不是用来虚度的，而是用来投资自己的。</p>
										</header>
										<nav>
										  <ul class="pager">
										    <li class="previous"><a href="" onclick="toLast(4,sortWay4);return false"><span aria-hidden="true">&larr;</span>上一页</a></li>
										    <li class="next"><a href="" onclick="toNext(4,sortWay4);return false">下一页 <span aria-hidden="true">&rarr;</span></a></li>
										  </ul>
										</nav>
										<section class="tiles" id="section_4">
											<%
											for(int i=0;i<15;i++){
												SourceFour sourceFour = ((List<SourceFour>)request.getAttribute("sourceFourList")).get(i);
												String st = "style"+(new Random().nextInt(5)+1);
												String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
												%><article class="<%=st%>">
											        <span class="image">
														<img src="<%=bg%>" alt="" />
													</span>
													<div class="detail">
													<h2><%=sourceFour.getName() %></h2>
													<h4>下载次数:<%=sourceFour.getDownload_times() %></h4>
													<h5>文件大小:<%=sourceFour.getFile_size() %></h5>
													<h5>上传时间:<%=sourceFour.getUpload_time() %></h5>
													<div class="content">
														<p><%=sourceFour.getIntroduction() %></p>
														<a class="btn btn-primary btn-lg change" href="<%=sourceFour.getDownload_link()%>" onclick="return checkLog('<%=sourceFour.getName()%>')">本站下载地址</a>
													</div>
												</div>
											</article>
											<%}%>
										</section>
										<nav>
										  <ul class="pager">
										    <li class="previous"><a href="" onclick="toLast(4,sortWay4);return false"><span aria-hidden="true">&larr;</span>上一页</a></li>
										    <li class="next"><a href="" onclick="toNext(4,sortWay4);return false">下一页 <span aria-hidden="true">&rarr;</span></a></li>
										  </ul>
										</nav>
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
		<div class="theme-popover-mask"></div>
  </body>
</html>
<script type="text/javascript">
	var currPageNo1 = 1;
	var currPageNo2 = 1;
	var currPageNo3 = 1;
	var currPageNo4 = 1;
	var sortWay1 = 0;
	var sortWay2 = 0;
	var sortWay3 = 0;
	var sortWay4 = 0;
	var sortWay5 = 0;
	var maxNo1 = parseInt(<%=((List<SourceOne>)request.getAttribute("sourceOneList")).size()%>/15)+1;
	var maxNo2 = parseInt(<%=((List<SourceTwo>)request.getAttribute("sourceTwoList")).size()%>/15)+1;
	var maxNo3 = parseInt(<%=((List<SourceThree>)request.getAttribute("sourceThreeList")).size()%>/15)+1;
	var maxNo4 = parseInt(<%=((List<SourceFour>)request.getAttribute("sourceFourList")).size()%>/15)+1;
	var id = "#"+"<%=request.getAttribute("index")%>";
	var idd = "#p"+"<%=request.getAttribute("index")%>";
	$(id).addClass("active");
	$(idd).addClass("active");
	jQuery(document).ready(function($) {
		if(id != "panel-1"){
			$("#ppanel-1").removeClass("active");
		}
	});
</script>