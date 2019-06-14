$(document).ready(function () {
    var needHeight = window.screen.height - 150;
    //document.getElementById("mainbody").style.minHeight=needHeight;
    $(".mainbody").css("minHeight", needHeight);
});

var b1 = false;
var b2 = false;
var b3 = false;
var b4 = false;
var b5 = false;

function testEmail() {
    var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
    var account = $("#inputEmail3").val();
    if (regex.test(account)) {
        var _url = "registerJudgeServlet";
        var _data = "judgeIndex=1&account=" + account;
        $.ajax({
            type: "post",
            data: _data,
            url: _url,
            success: function (result) {
                if (result == account) {
                    $("#mark1").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
                    b1 = true;
                } else {
                    $("#inputEmail3").val("");
                    $("#inputEmail3").attr("placeholder", result);
                    $("#mark1").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
                    b1 = false;
                }
            }
        });
    } else {
        $("#mark1").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
        b1 = false;
    }
}

function clear() {
    if ($("#inputEmail3").val()) {

    }
}

function testPwd() {
    var regex = /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
    if (regex.test($("#inputPassword1").val())) {
        $("#mark2").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
        b2 = true;
    }
    else {
        $("#mark2").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
        b2 = false;
    }
}

function testRePwd() {
    if ($("#inputPassword1").val() == $("#inputPassword2").val()) {
        $("#mark3").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
        b3 = true;
    }
    else {
        $("#mark3").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
        b3 = false;
    }
}

function testNickName() {
    var regex = /[\u4e00-\u9fa5_a-zA-Z0-9_]/;
    var nickName = $("#inputnickName").val();
    if (regex.test(nickName) && nickName.length < 16) {
        var _url = "registerJudgeServlet";
        var _data = "judgeIndex=2&nickName=" + nickName;
        $.ajax({
            type: "post",
            data: _data,
            url: _url,
            success: function (result) {
                if (result == nickName) {
                    $("#mark4").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
                    b4 = true;
                } else {
                    $("#inputnickName").val("");
                    $("#inputnickName").attr("placeholder", result);
                    $("#mark4").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
                    b4 = false;
                }
            }
        });
    }
    else {
        $("#mark4").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
        b4 = false;
    }

}

function testGrade() {
    var regex = /^\d{4}$/;
    var grade = $("#inputGrade").val();
    if (regex.test(grade)) {
        $("#mark5").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
        b5 = true;
    }
    else {
        $("#mark5").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
        b5 = false;
    }
}

function register() {
    if (b1 && b2 && b3 && b4 && b5) {
        $("input[name='passWord']").attr("value",md5($('#inputPassword1').prop("value")));
        $("#registerForm").submit();
    } else {
        $("#submitt").html("<button class='btn btn-danger btn-block' type='button' onclick='register()'>请将所有内容填写正确后再试</button>");
    }
}
