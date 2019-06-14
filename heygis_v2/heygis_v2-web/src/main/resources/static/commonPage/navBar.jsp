<!--设置pageEncoding，通过jsp include导入时防止中文乱码-->
<%@ page pageEncoding="UTF-8"%>

<%--非主页的导航栏navBar--%>
<div class="navbar navbar-default navbar-fixed-top navbar-inverse nav">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle newMsgMark hidden" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="badge">0</span>
            </button>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"><span class="heygis">HeyGIS</span></a>
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
                    <a href="sourceServlet?index=panel-1">资源区</a>
                </li>
                <li>
                    <a href="index.jsp#lkdVR">林科大全景</a>
                </li>
                <%if((Boolean)request.getAttribute("loged")){ %>
                <li>
                    <a href="selfCenterServlet">个人中心<span class="badge hidden">0</span></a>
                </li>
                <li>
                    <a class="btn" href="javascript:document:logout.submit()" >退出</a>
                </li>
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
</div>