var page = getQueryString("page");

//用于判断是一般登陆，还是发帖时未登录要求登陆
var whichsubmit = 0;

//被回复的用户数据
var userBeReplyed = new Object();

function next() {
    if (page == totalPage) {
        alert("没有下一页了！");
        return false;
    }
    page++;
    var path = "topicsServlet?fPage=" + getQueryString("fpage") + "&tid=" + getQueryString("tid") + "&page=" + page;
    window.location.href = path;
}

function last() {
    if (page == 1) {
        alert("没有上一页了！");
        return false;
    }
    page--;
    var path = "topicsServlet?fPage=" + getQueryString("fpage") + "&tid=" + getQueryString("tid") + "&page=" + page;
    window.location.href = path;
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}


//$(document).ready(function(){
//	$("#post_submit").click(function(){
//		alert($("#textarea_post").val());
//		$("#test").html($("#textarea_post").val());
//	});
//});
//
//废弃可删除
// var posi;
// var uid;
// var nickname;
// var account;
// var redpid;
// var redmes;


jQuery(document).ready(function ($) {
    $('.reply .close').click(function () {
        $('.reply').slideUp(200);
    })
})

function postPublic() {
    var userState = eval('(' + isLogin() + ')');
    if (userState.loged == false) {
        whichsubmit = 1;
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover').slideDown(200);
    } else {
        finalpostPublic();
    }
}

function finalpostPublic() {
    if (document.getElementById("textarea_post").value == '') {
        alert("帖子内容不能为空！");
        if (whichsubmit == 1) {
            location.reload();
        }
    } else {
        document.getElementById('postpubllic').submit();
    }
}

function reply(_posi, _uid, _account, _nickname, _redpid) {
//	$("#posi_subButton").click(posiReplyPublic(posi,uid,account,nickname,redmes));
//	document.getElementById('posi_subButton').onclick = posiReplyPublic(posi,uid,account,nickname,redmes);
    userBeReplyed.posi = _posi;
    userBeReplyed.uid = _uid;
    userBeReplyed.account = _account;
    userBeReplyed.nickname = _nickname;
    userBeReplyed.redpid = _redpid;
    $('.reply').slideDown(200);
    $('#posi_reply_textarea').focus();
}

function posiReplyPublic() {
//	document.getElementById('postauthor_account').value = userBeReplyed.account;
    document.getElementById('replyposi').value = userBeReplyed.posi;
    document.getElementById('postauthor_uid').value = userBeReplyed.uid;
    document.getElementById('replypid').value = userBeReplyed.redpid;
    document.getElementById('replyhead').value = "<fieldset id=''><legend>回复:" + userBeReplyed.posi + "楼" + userBeReplyed.nickname + "</legend><blockquote>";
    var userState = eval('(' + isLogin() + ')');
    if (userState.loged == false) {
        whichsubmit = 2;
        $('.reply').slideUp(200);
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover').slideDown(200);
    } else {
        replyfinalsubmit();
    }
}

function replyfinalsubmit() {
    if (document.getElementById("posi_reply_textarea").value == '') {
        alert("帖子内容不能为空！");
        if (whichsubmit == 2) {
            location.reload();
        }
    } else {
        document.getElementById('posi_reply_form').submit();
    }
}

/** 定制版loginJS */
jQuery(document).ready(function ($) {
    $('.theme-login').click(function () {
        whichsubmit == 0;
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
            "password" : md5($("input[name='password']").prop("value"))
        },
        success: function (data) {
            if (data == 0) {
                $('#loginMessage').html("账号或密码错误！");
                $('#loginMessage').css("color", 'red');
                $('#loginMessage').css("font-size", '16px');
            } else if (data == 1) {
                if (whichsubmit == 0) {
                    location.reload();
                } else if (whichsubmit == 1) {
                    finalpostPublic();
                } else if (whichsubmit == 2) {
                    replyfinalsubmit();
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
/** 定制版loginJS結束 */


function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

jQuery(document).ready(function ($) {
    if (getQueryString("seeposi") != null) {
//		$("#posi"+getQueryString("seeposi")).css('backgroundColor','#FFFF77');
//		setTimeout(function(){
//	        $("#posi"+getQueryString("seeposi")).css('backgroundColor','');
//	    },1300);
//		$("#posi"+getQueryString("seeposi")).css('backgroundColor','');
//		$("#posi"+getQueryString("seeposi")).animate({
//			opacity:'0.3'
//		},"slow");
//		$("#posi"+getQueryString("seeposi")).animate({
//			opacity:'1'
//		},"slow");
        $("#posi" + getQueryString("seeposi")).animate({
            backgroundColor: '#FFFF77'
        }, 300);
        $("#posi" + getQueryString("seeposi")).animate({
            backgroundColor: ''
        }, 3000);
    }
})

function openCode(i) {
    if (i == 1) {
        closeImg(1);
        $("#codeDiv1").css("visibility", "visible");
        document.getElementById("code-text1").focus();
    } else if (i == 2) {
        closeImg(2);
        $("#codeDiv2").css("visibility", "visible");
        document.getElementById("code-text2").focus();
    }
}

function closeCode(i) {
    if (i == 1) {
        document.getElementById("code-text1").value = '';
        $("#codeDiv1").css("visibility", "hidden");
        $('#textarea_post').focus();
    } else if (i == 2) {
        document.getElementById("code-text2").value = '';
        $("#codeDiv2").css("visibility", "hidden");
        $('#posi_reply_textarea').focus();
    }
}

function openImg(i) {
    if (i == 1) {
        $("#codeDiv1").css("visibility", "hidden");
        $("#imgDiv1").css("visibility", "visible");
    } else if (i == 2) {
        $("#codeDiv2").css("visibility", "hidden");
        $("#imgDiv2").css("visibility", "visible");
    }
}

function closeImg(i) {
    if (i == 1) {
        $("#imgDiv1").css("visibility", "hidden");
    } else if (i == 2) {
        $("#imgDiv2").css("visibility", "hidden");
    }
}

function addCode(i) {
    if (i == 1) {
        var code = document.getElementById("code-text1").value;
        document.getElementById("code-text1").value = '';
        code = $('#textarea_post').val() + "<pre class='prettyprint'>" + code + "</pre>\n";
        $('#textarea_post').val(code);
        $("#codeDiv1").css("visibility", "hidden");
        $('#textarea_post').focus();
    } else if (i == 2) {
        var code = document.getElementById("code-text2").value;
        document.getElementById("code-text2").value = '';
        code = $('#posi_reply_textarea').val() + "<pre class='prettyprint'>" + code + "</pre>\n";
        $('#posi_reply_textarea').val(code);
        $("#codeDiv2").css("visibility", "hidden");
        $('#posi_reply_textarea').focus();
    }
}