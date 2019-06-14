var nickNameOld;
var b1=true;
var b2=true;
$(document).ready(function(){ 
	nickNameOld = $("#nickName").val();
});
function testNickName(){
	var nickName = $("#nickName").val();
	if(nickName == nickNameOld){
		$("#mark1").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
		b1 = true;
		return;
	}
	var _url = "registerJudgeServlet";
	var _data ="judgeIndex=2&nickName="+nickName;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(result){
			if(result==nickName){
				$("#mark1").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
				b1 = true;
			}else{
				$("#nickName").val("");
				$("#nickName").attr("placeholder",result);
				$("#mark1").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
				b1 = false;
			}
		}
	});
}
function testGrade(){
	var regex = /^[0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}%/;
	var grade = $("#grade").val();
	if(regex.test(grade)){
		$("#mark2").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
		b2 = true;
	}
	else{
		$("#mark2").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
		b2 = false;
	}
}
function fillInfo(){
	if(b1&&b2){
		$("#fillInfoForm").submit();
	}else{
		$("#submitt").html("<button class='btn btn-danger btn-block' onclick='fillInfo()'>请将所有内容填写正确后再试</button>");
	}
}