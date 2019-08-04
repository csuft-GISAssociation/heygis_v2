var template = `
        <div>
            <div class="navbar navbar-default navbar-fixed-top navbar-inverse nav">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle newMsgMark hidden" data-toggle="collapse"
                        data-target="#navbar-ex-collapse">
                            <span class="badge">
                                4
                            </span>
                        </button>
                        <button style="margin-right:4px" type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#navbar-ex-collapse">
                            <span class="sr-only">
                                Toggle navigation
                            </span>
                            <span class="icon-bar">
                            </span>
                            <span class="icon-bar">
                            </span>
                            <span class="icon-bar">
                            </span>
                        </button>
                        <a class="navbar-brand" href="###">
                            <span class="heygis">
                                HeyGIS
                            </span>
                        </a>
                    </div>
                    <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active">
                                <a href="/###">
                                    首页
                                </a>
                            </li>
                            <li>
                                <a href="/#bbs">
                                    论坛区
                                </a>
                            </li>
                            <li>
                                <a href="/#sourceDownLoad">
                                    资源区
                                </a>
                            </li>
                            <li>
                                <a href="/#lkdVR">
                                    林科大全景
                                </a>
                            </li>
                            <!--登录判断-->
                            <li v-if="loginFlag">
                                <a href="/selfCenter.html">
                                    个人中心
                                    <span class="badge hidden">
                                        4
                                    </span>
                                </a>
                            </li>
                            <li v-if="loginFlag">
                                <!--<a class="btn"href="javascript:document:logout.submit()">退出</a>-->
                                <a class="btn" href="javascript:;" v-on:click="logout">
                                    退出
                                </a>
                            </li>
                            <li v-if="!loginFlag">
                                <a class="btn theme-login" href="javascript:;" v-on:click="showLoginForm">
                                    登录
                                </a>
                            </li>
                            <li v-if="!loginFlag">
                                <a class="btn " href="/register.html">
                                    注册
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="theme-popover col-md-12">
                <div class="theme-poptit">
                    <a href="javascript:;" title="关闭" class="close" v-on:click="closeForm">
                        ×
                    </a>
                    <h3>
                        登录是一种态度
                    </h3>
                </div>
                <div class="theme-popbod dform">
                    <form id="loginForm" class="theme-signin" name="loginform" v-on:submit.prevent="login">
                        <ol>
                            <li>
                                <h4 id="loginMessage">
                                    你必须先登录！
                                </h4>
                            </li>
                            <li>
                                <strong>
                                    用户名：
                                </strong>
                                <input class="ipt" type="text" v-model="user.account" size="20" placeholder="账号（邮箱）"
                                required/>
                            </li>
                            <li>
                                <strong>
                                    密码：
                                </strong>
                                <input class="ipt" type="password" v-model="user.password" placeholder="密码"
                                size="20" required/>
                            </li>
                            <li>
                                <input class="btn btn-primary" type="submit" name="submit" value=" 登 录  "
                                />
                                <a href="register.html">
                                    &nbsp;注册
                                </a>
                            </li>
                        </ol>
                    </form>
                </div>
            </div>
        </div>
        `;
Vue.component('header-counter', {
    data: function () {
        return {
            loginFlag:false,
            user:{
                account:"",
                password:""
            }
        }
    },
    methods:{
         /**
         * 登录
         * @param  res 
         */
        login:function(res){
            //console.log("表单提交事件触发")
            // 感觉没必要，好像已经做了非空判断
            // if(this.user.account==""||this.user.password==""){ 
            //     $("#loginMessage").text("账号与密码不许为空！");
            //     $("#loginMessage").css("color", "red");
            //     $("#loginMessage").css("font-size", "15px");
            // }
         
          //axios.post('/user/login',{
          axios.post('http://localhost:8988/user/login',{
              account:this.user.account,
              password:md5(this.user.password)
          })
          .then(function(res){
              console.log(res)
              if(res.data.status==201){
                $('#loginMessage').html("账号或密码错误！");
                $('#loginMessage').css("color", 'red');
                $('#loginMessage').css("font-size", '16px');
              }
              if(res.data.status==200){
                location.reload();
              }
          })
          .catch(function(err){
              console.log(err)
          })
        },
        /**
         * 退出
         * @param  res 
         */
        logout:function(res){
            console.log("绑定退出事件")
            //axios.post('/user/logout')
            axios.post('http://localhost:8988/user/logout')
            .then(function(res){
                //console.log(res)
                if(res.data.status==200){
                    //跳转至首页
                    //window.location.href="http://localhost:8988/index.html";
                    window.location.href="/index.html";
                }
            })
            .catch(function(err){
                console.log(err)
            })
        },
        /**
         * 点击登录
         * @param  res 
         */
        showLoginForm:function(res){
            //alert($)
            $('.theme-popover-mask').fadeIn(100);
            $('.theme-popover').slideDown(200);
        },
        /**
         * 点击关闭
         * @param  res 
         */
        closeForm:function(res){
            $('.theme-popover-mask').fadeOut(100);
            $('.theme-popover').slideUp(200);
        }
    },
    created:function(){
        var that = this
        //console.log("vue 创建")
        //做登录判断请求
        //axios.get('/user/isLogin')
        axios.defaults.withCredentials = true// 允许携带cookie信息
        axios.get('http://localhost:8988/user/isLogin')
            .then(function(res){
                console.log(res)
                if(res.data.data=="nologin"){
                    //用户未登录
                    that.loginFlag = false
                }
                if(res.data.data=="logined"){
                    that.loginFlag = true
                }
            })
            .catch(function(err){
                //若没有cookie，发生400异常，说明未登录
                console.log(err)
                that.loginFlag = false;
        })
    },
    //template: '<div><div class="navbar navbar-default navbar-fixed-top navbar-inverse nav"><div class="container"><div class="navbar-header"><button type="button"class="navbar-toggle newMsgMark hidden"data-toggle="collapse"data-target="#navbar-ex-collapse"><span class="badge">4</span></button><button style="margin-right:4px"type="button"class="navbar-toggle"data-toggle="collapse"data-target="#navbar-ex-collapse"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button><a class="navbar-brand"href="###"><span class="heygis">HeyGIS</span></a></div><div class="collapse navbar-collapse"id="navbar-ex-collapse"><ul class="nav navbar-nav navbar-right"><li class="active"><a href="http://localhost:8988/index.html/###">首页</a></li><li><a href="http://localhost:8988/index.html/#bbs">论坛区</a></li><li><a href="http://localhost:8988/index.html/#sourceDownLoad">资源区</a></li><li><a href="http://localhost:8988/index.html/#lkdVR">林科大全景</a></li><!--登录判断--><li v-if="loginFlag"><a href="/selfCenter.html">个人中心<span class="badge hidden">4</span></a></li><li v-if="loginFlag"><!--<a class="btn"href="javascript:document:logout.submit()">退出</a>--><a class="btn"href="javascript:;"v-on:click="logout">退出</a></li><li v-if="!loginFlag"><a class="btn theme-login"href="javascript:;"v-on:click="showLoginForm">登录</a></li><li v-if="!loginFlag"><a class="btn "href="/register.html">注册</a></li></ul></div></div></div><div class="theme-popover col-md-12"><div class="theme-poptit"><a href="javascript:;"title="关闭"class="close"v-on:click="closeForm">×</a><h3>登录是一种态度</h3></div><div class="theme-popbod dform"><form id="loginForm"class="theme-signin"name="loginform"v-on:submit.prevent="login"><ol><li><h4 id="loginMessage">你必须先登录！</h4></li><li><strong>用户名：</strong><input class="ipt"type="text"v-model="user.account"size="20"placeholder="账号（邮箱）"required/></li><li><strong>密码：</strong><input class="ipt"type="password"v-model="user.password"placeholder="密码"size="20"required/></li><li><input class="btn btn-primary"type="submit"name="submit"value=" 登 录  "/><a href="register.html">&nbsp;注册</a></li></ol></form></div></div></div>'
      template: template
    })

new Vue({el: '#components-header'})