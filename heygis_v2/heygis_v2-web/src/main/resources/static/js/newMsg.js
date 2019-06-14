$(document).ready(function(){
console.log("new message")
    var userState = eval('(' + isLogin() + ')');
    if(userState.loged == true){
		$.post("newMsgServlet",{
			'nw' : 1,
			'uid': userState.uid
		},function(data){
			if(data > 0){
//				alert(data);
//				$('.badge').css("background-color","red");
				$('.badge').text(data);
				$('.badge').removeClass("hidden");
				$('.newMsgMark').removeClass("hidden");
			}else{
//				$('.badge').css("display",'none');
			}
		});
	}else{
//		$('.badge').css("display",'none');
	}
});