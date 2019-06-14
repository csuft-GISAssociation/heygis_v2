var wherelog = 0;
var page = getQueryString("page");

function next() {
    if (page == totalPage) {
        alert("没有下一页了！");
        return false;
    }
    page++;
    var path = "forumsServlet?fid=" + getQueryString("fid") + "&page=" + page;
    window.location.href = path;
}

function last() {
    if (page == 1) {
        alert("没有上一页了！");
        return false;
    }
    page--;
    var path = "forumsServlet?fid=" + getQueryString("fid") + "&page=" + page;
    window.location.href = path;
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

$(function () {
//  $('#thread_subTextarea').focus(function(){
//      if($(this).val() == '发表新帖：标题'){
//      		$(this).css("color","#000000");
//              $(this).val('');//清空
//          }
//  }).blur(function(){
//      if($(this).val() == ''){
//      		$(this).css("color","#ADADAD");
//              $(this).val('发表新帖：标题');//填充提示文字
//          }
//  });

//});
//$(function(){
//  $('#post_textarea').focus(function(){
//      if($(this).val() == '发表新帖：内容'){
//      		$(this).css("color","#000000");
//              $(this).val('');//清空
//          }
//  }).blur(function(){
//      if($(this).val() == ''){
//      		$(this).css("color","#ADADAD");
//              $(this).val('发表新帖：内容');//填充提示文字
//          }
//  });

});

function public() {
    var div = document.getElementById('thread_public');
    div.setAttribute("class", "thread_public_wraper container visible");
    document.getElementById("anchor_scroll").click();
}

function threadpublic() {
    var userState = eval('(' + isLogin() + ')');
    if (userState.loged == false) {
        wherelog = 1;
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover').slideDown(200);
    } else {
        finalsubmit();
    }
}

function finalsubmit() {
    if (document.getElementById("thread_subTextarea").value == '') {
        alert("标题不能为空！");
    } else {
        if (document.getElementById("post_textarea").value == '') {
            alert("内容不能为空！");
        } else {
            document.getElementById("threadpublic").submit();
        }
    }
}

/** 定制版loginJS */
jQuery(document).ready(function ($) {
    $('.theme-login').click(function () {
        wherelog = 0;
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover').slideDown(200);
    })
    $('.theme-poptit .close').click(function () {
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover').slideUp(200);
    })

})

function login() {
    $.ajax({
        type: 'post',
        url: 'loginServlet',
        data: {
            "account" : $("input[name='account']").prop("value"),
            "password" : md5($("input[name='password']").prop("value"))},
        success: function (data) {
            if (data == 0) {
                $('#loginMessage').html("账号或密码错误！");
                $('#loginMessage').css("color", 'red');
                $('#loginMessage').css("font-size", '16px');
            } else if (data == 1) {
                if (wherelog == 0) {
                    location.reload();
                } else if (where = 1) {
                    $('.theme-popover-mask').fadeOut(100);
                    $('.theme-popover').slideUp(200);
                    finalsubmit();
                }
            }
        }
    });
    return false; // 阻止表单自动提交事件
}
//获取用户状态，判断是否登陆
function isLogin() {
    var result;
    $.ajax({
        type: 'post',
        url: 'isLoginServlet',
        async: false,
        success: function (data) {
            result = data;
        }
    });
    return result;
}
/**loginJSj结束*/

function openCode() {
    closeImg();
    $("#codeDiv").css("visibility", "visible");
    document.getElementById("code-text").focus();
}

function closeCode() {
    document.getElementById("code-text").value = '';
    $("#codeDiv").css("visibility", "hidden");
    $('#post_textarea').focus();
}

function openImg() {
    $("#codeDiv").css("visibility", "hidden");
    $("#imgDiv").css("visibility", "visible");
}

function closeImg() {
    $("#imgDiv").css("visibility", "hidden");
}

function addCode() {
    var code = document.getElementById("code-text").value;
    document.getElementById("code-text").value = '';
    code = $('#post_textarea').val() + "<pre class='prettyprint'>" + code + "</pre>\n";
    $('#post_textarea').val(code);
    $("#codeDiv").css("visibility", "hidden");
    $('#post_textarea').focus();
}
