function submitt(){
	if($('textarea').val()==""){
		$("#submit").html(
				"<span class='btn btn-default' onclick='f()'><input type='checkbox' name='checkbox' id='checkbox'/>使用游客身份匿名发布</span><button name='Submit' onclick='submitt()' class='btn btn-danger'>请填写反馈内容</button>"				
		);
		return false;
	}
	if($('#checkbox').is(':checked')){
		$("#check").val("1");
		$("#publish").submit();
	}else{
        var userState = eval('(' + isLogin() + ')');
		if(userState.loged==true){
			$("#check").val("2");
			$("#publish").submit();
		}else{
			$("#submit").html(
					"<span class='btn btn-default' onclick='f()'><input type='checkbox' name='checkbox' id='checkbox'/>使用游客身份匿名发布</span><button name='Submit' onclick='submitt()' class='btn btn-danger'>请先登录或者勾选使用游客模式匿名登录后再发表反馈</button>"		
			);
		}
	}
}
function clearr(){
	$("#submit").html(
			"<span class='btn btn-default' onclick='f()'><input type='checkbox' name='checkbox' id='checkbox'/>使用游客身份匿名发布</span><button name='Submit' onclick='submitt()' class='btn btn-primary'>发布</button>"		
	);
}
function f(){
	 var isChecked = !$('#checkbox').prop("checked");
	 $('#checkbox').prop("checked", isChecked);
	 if($('#checkbox').is(':checked')){
		 $('button').html("发布");
		 $('button').removeClass("btn-danger");
		 $('button').addClass("btn-primary");
	 }
}