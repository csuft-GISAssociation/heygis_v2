$(document).ready(function(){ 
	var needHeight = window.screen.height-150;
	//document.getElementById("mainbody").style.minHeight=needHeight;
	$(".mainbody").css("minHeight",needHeight);
} );
$(function(){
	$("#tabs a:first").tab("show");
	$("#tabs a").click(function(){
		$(this).tab("show");
	});
});

function timecho(e,s){
	if(e==1){sortWay1 = 1;currPageNo=vaildPage1()}
	if(e==2){sortWay2 = 1;currPageNo=vaildPage2()}
	if(e==3){sortWay3 = 1;currPageNo=vaildPage3()}
	if(e==4){sortWay4 = 1;currPageNo=vaildPage4()}
	$(".choose").html("按上传时间 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data ="sourceType="+e+"&sortWay="+s+"&currPageNo="+currPageNo;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}
function timescho(e,s){
	if(e==1){sortWay1 = 2;currPageNo=vaildPage1()}
	if(e==2){sortWay2 = 2;currPageNo=vaildPage2()}
	if(e==3){sortWay3 = 2;currPageNo=vaildPage3()}
	if(e==4){sortWay4 = 2;currPageNo=vaildPage4()}
	$(".choose").html("按下载数 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data ="sourceType="+e+"&sortWay="+s+"&currPageNo="+currPageNo;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}
function alphacho(e,s){
	if(e==1){sortWay1 = 3;currPageNo=vaildPage1()}
	if(e==2){sortWay2 = 3;currPageNo=vaildPage2()}
	if(e==3){sortWay3 = 3;currPageNo=vaildPage3()}
	if(e==4){sortWay4 = 3;currPageNo=vaildPage4()}
	$(".choose").html("按字母 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data ="sourceType="+e+"&sortWay="+s+"&currPageNo="+currPageNo;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}
function sizecho(e,s){
	if(e==1){sortWay1 = 4;currPageNo=vaildPage1()}
	if(e==2){sortWay2 = 4;currPageNo=vaildPage2()}
	if(e==3){sortWay3 = 4;currPageNo=vaildPage3()}
	if(e==4){sortWay4 = 4;currPageNo=vaildPage4()}
	$(".choose").html("按文件大小 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data ="sourceType="+e+"&sortWay="+s+"&currPageNo="+currPageNo;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}
function defaultcho(e,s){
	var currPageNo;
	if(e==1){sortWay1 = 0;currPageNo=vaildPage1()}
	if(e==2){sortWay2 = 0;currPageNo=vaildPage2()}
	if(e==3){sortWay3 = 0;currPageNo=vaildPage3()}
	if(e==4){sortWay4 = 0;currPageNo=vaildPage4()}
	$(".choose").html("默认排序 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data = "sourceType="+e+"&sortWay="+s+"&currPageNo="+currPageNo;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}
function checkLog(name){
    var userState = eval('(' + isLogin() + ')');
	if(userState.loged == true){
		//alert("其实已经可以下载了，但是现在是测试阶段，所以不跳转了。嘿嘿！！");
		var _url = "addCountServlet";
		var _data ="sourceName="+name;
		$.ajax({
			type:"post",
			data:_data,
			url:_url,
			success:function(data){
//				alert(data);
				return true;
			}
		});
		return true;
	}else{
		$('.change').removeClass("btn-primary");
		$('.change').addClass("btn-danger");
		$('.change').text("请先登录再下载");
		return false;
	}
}
function toNext(e,s){
	if(e==1){currPageNo1++}
	if(e==2){currPageNo2++}
	if(e==3){currPageNo3++}
	if(e==4){currPageNo4++}
	if(s==0){defaultcho(e,s)}
	if(s==1){timecho(e,s)}
	if(s==2){timescho(e,s)}
	if(s==3){alphacho(e,s)}
	if(s==4){sizecho(e,s)}
	if(s==5){search(e)}
}
function toLast(e,s){
	if(e==1){currPageNo1--}
	if(e==2){currPageNo2--}
	if(e==3){currPageNo3--}
	if(e==4){currPageNo4--}
	if(s==0){defaultcho(e,s)}
	if(s==1){timecho(e,s)}
	if(s==2){timescho(e,s)}
	if(s==3){alphacho(e,s)}
	if(s==4){sizecho(e,s)}
	if(s==5){search(e)}
}
function clearPageNo(e){
	if(e==1){currPageNo1=1}
	if(e==2){currPageNo2=1}
	if(e==3){currPageNo3=1}
	if(e==4){currPageNo4=1}
}
function vaildPage1(){
	if(currPageNo1 > maxNo1){
		currPageNo1 = maxNo1;
	}if(currPageNo1 < 1){
		currPageNo1 = 1;
	}return currPageNo1;
}
function vaildPage2(){
	if(currPageNo2 > maxNo2){
		currPageNo2 = maxNo2;
	}if(currPageNo2 < 1){
		currPageNo2 = 1;
	}return currPageNo2;
}
function vaildPage3(){
	if(currPageNo3 > maxNo3){
		currPageNo3 = maxNo3;
	}if(currPageNo3 < 1){
		currPageNo3 = 1;
	}return currPageNo3;
}
function vaildPage4(){
	if(currPageNo4 > maxNo4){
		currPageNo4 = maxNo4;
	}if(currPageNo4 < 1){
		currPageNo4 = 1;
	}return currPageNo4;
}
function search(e){
	var currPageNo;
	if(e==1){sortWay1 = 5;currPageNo=vaildPage1()}
	if(e==2){sortWay2 = 5;currPageNo=vaildPage2()}
	if(e==3){sortWay3 = 5;currPageNo=vaildPage3()}
	if(e==4){sortWay4 = 5;currPageNo=vaildPage4()}
	var _text = "#searchCtx"+e;
	var _url = "searchServlet";
	$(".choose").html("按条件'"+$(_text).val()+"'<span class='caret'></span>");
	var _data = "sourceType="+e+"&searchCtx="+$(_text).val()+"&currPageNo="+currPageNo;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}

