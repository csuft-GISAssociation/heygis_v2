/**
 * 登陆用js
 * 包含：
 * 登录窗口控制
 * login() : 登陆函数
 * isLogin() : 获取用户状态，判断是否登陆
 *
 * PS:论坛的登陆逻辑有修改，
 * 所以有单独的修改的登陆代码
 * 如果登陆的逻辑有修改
 * 要记得去修改forums.js和topics.js
 * 中的定制版的登陆代码
 */

jQuery(document).ready(function ($) {
    $('.theme-login').click(function () {
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover').slideDown(200);
    });
    $('.theme-poptit .close').click(function () {
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover').slideUp(200);
    });
});

// function login() {
//     if ($("[name='account']").val() == "") {
//         $("#loginMessage").text("账号与密码不许为空！");
//         $("#loginMessage").css("color", "red");
//         $("#loginMessage").css("font-size", "15px");
//         return false;
//     }
//     $.ajax({
//         type: 'post',
//         url: 'loginServlet',
//         data: {
//             "account" : $("input[name='account']").prop("value"),
//             "password" : md5($("input[name='password']").prop("value"))
//         },
//         success: function (data) {
//             if (data == 0) {
//                 $('#loginMessage').html("账号或密码错误！");
//                 $('#loginMessage').css("color", 'red');
//                 $('#loginMessage').css("font-size", '16px');
//             } else if (data == 1) {
//                 location.reload();
//             }
//         }
//     });
//     return false; // 阻止表单自动提交事件
// }

// //获取用户状态，判断是否登陆
// function isLogin() {
//     var result;
//     $.ajax({
//         type: 'post',
//         url: 'isLoginServlet',
//         async: false,
//         success: function (data) {
//             result = data;
//         }
//     });
//     return result;
// }