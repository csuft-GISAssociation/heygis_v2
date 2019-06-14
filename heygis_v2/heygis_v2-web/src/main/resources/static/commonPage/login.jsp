<!--设置pageEncoding，通过jsp include导入时防止中文乱码-->
<%@page pageEncoding="UTF-8"%>

<script src="//cdnjs.cloudflare.com/ajax/libs/blueimp-md5/2.10.0/js/md5.js"></script>
<%--登陆窗口--%>
<div class="theme-popover col-md-12">
    <div class="theme-poptit">
        <a href="javascript:;" title="关闭" class="close">×</a>
        <h3>登录 是一种态度</h3>
    </div>
    <div class="theme-popbod dform">
        <form id="loginForm" class="theme-signin" name="loginform" method="post" onsubmit="return login()">
            <ol>
                <li>
                    <h4 id="loginMessage">你必须先登录！</h4>
                </li>
                <li><strong>用户名：</strong>
                    <input class="ipt" type="text" name="account" value="" size="20" placeholder="账号（邮箱）" required/>
                </li>
                <li><strong>密码：</strong>
                    <input class="ipt" type="password" name="password" value="" placeholder="密码" size="20"
                           required/>
                </li>
                <li>
                    <input class="btn btn-primary" type="submit" name="submit" value=" 登 录    "/>
                    <a href="register.jsp">&nbsp;注册</a>
                </li>
            </ol>
        </form>
        <form id="logout" method="post" action="logoutServlet">
            <INPUT TYPE="submit" name="test" value="go" style="display:none">
        </form>
    </div>
</div>
