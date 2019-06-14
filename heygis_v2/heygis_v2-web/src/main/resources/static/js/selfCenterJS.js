var newMsgPage = 2;
var oldMsgPage = 1;
var mythreadpage = 1;
var showOld = true;
var showMyT = true;

jQuery(document).ready(function($) {
	$('#modifyIcon').click(function() {
		$('.theme-popover-mask').fadeIn(100);
		$('#changeIcon').slideDown(200);
	});
	$('#theme #close').click(function() {
		$('.theme-popover-mask').fadeOut(100);
		$('#changeIcon').slideUp(200);
	});
	havaNewMsg();
});
$(document).ready(function(){ 
	var needHeight = window.screen.height-150;
	//document.getElementById("mainbody").style.minHeight=needHeight;
	$(".mainbody").css("minHeight",needHeight);
} );
function readMsg(mid){
	$.post("readMsgServlet",{
		'mid' : mid
	},function(data){
		return ture;
	});
}
function showOldMsg(){
	if(showOld){
		getOldMsg();
		showOld = false;
	}
}
function showMyThread(){
	if(showMyT){
		getMyThread();
		showMyT = false;
	}
}


function getOldMsg(){
	$.post("selfCenMsgList",{
		'n'    : 0,
		'page' : oldMsgPage
	},function(data){
		if(data.size == 0){
			appendOldMsgList(data);
		}else{
			oldMsgPage++;
			appendOldMsgList(data);
		}
//		alert(data.size);
	});
}
function appendOldMsgList(res){
	var content=res.msgArray;
	if(res.size == 0){
		$('#oldMsgInfo').html("<p style='color:white;font-size:17px'>没有更多了！</p>");
	}else{
		$.each(content, function(i, item){
			if(item.type == 1){
				$('#oldMsgList').append(
					"<div class='message-cotent'><div class='col-md-9 col-xs-9 message-detail'>"
						+"<a href='topicsServlet?fPage=1&tid="+item.tid+"&page="+item.page+"&seeposi="+item.position+"#position"+(item.position-1)+"'>"
						+item.author+"<br/>在’"+item.subject+"‘中回复了你！"
						+"</a></div><div class='col-md-3 col-xs-3 message-date'>"
						+"<p >"+item.dateline+"</p></div></div>"
				);
			}else if(item.type == 2){
				$('#oldMsgList').append(
					"<div class='message-cotent'><div class='col-md-9 col-xs-9 message-detail'>"
						+"<a href='topicsServlet?fPage=1&tid="+item.tid+"&page="+item.page+"&seeposi="+item.position+"#position"+(item.position-1)+"'>"
						+item.author+"<br/>回复了你在”"+item.subject+"“中的回复！"
						+"</a></div><div class='col-md-3 col-xs-3 message-date'>"
						+"<p >"+item.dateline+"</p></div></div>"
				);
			}
		});
	}
}

function getNewMsg(){
	$.post("selfCenMsgList",{
		'n'    : 1,
		'page' : newMsgPage
	},function(data){
		if(data.size == 0){
			appendNewMsgList(data);
		}else{
			newMsgPage++;
			appendNewMsgList(data);
		}
//		alert(newMsgPage);
	});
}
function appendNewMsgList(res){
	var content=res.msgArray;
	if(res.size == 0){
		$('#newMsgInfo').html("<p style='color:white;font-size:17px'>没有更多了！</p>");
	}else{
		$.each(content, function(i, item){
			if(item.type == 1){
				$('#newMsgList').append(
					"<div class='message-cotent'><div class='col-md-9 col-xs-9 message-detail'>"
						+"<a onclick='return readMsg(item.mid)' href='topicsServlet?fPage=1&tid="+item.tid+"&page="+item.page+"&seeposi="+item.position+"#position"+(item.position-1)+"'>"
						+item.author+"<br/>在’"+item.subject+"‘中回复了你！"
						+"</a></div><div class='col-md-3 col-xs-3 message-date'>"
						+"<p >"+item.dateline+"</p></div></div>"
				);
			}else if(item.type == 2){
				$('#newMsgList').append(
					"<div class='message-cotent'><div class='col-md-9 col-xs-9 message-detail'>"
						+"<a onclick='return readMsg(item.mid)' href='topicsServlet?fPage=1&tid="+item.tid+"&page="+item.page+"&seeposi="+item.position+"#position"+(item.position-1)+"'>"
						+item.author+"<br/>回复了你在”"+item.subject+"“中的回复！"
						+"</a></div><div class='col-md-3 col-xs-3 message-date'>"
						+"<p >"+item.dateline+"</p></div></div>"
				);
			}
		});
	}
}

function getMyThread(){
	$.post("selfCenMsgList",{
		'n'	   : 3,
		'page' : mythreadpage
	},function(data){
		if(data.size == 0){
			appendmyThreadist(data);
		}else{
			mythreadpage++;
			appendmyThreadist(data);
		}
//		alert(data.size);
	});
}
function appendmyThreadist(res){
	var content=res.threadArray;
	if(res.size == 0){
		$('#myThreadInfo').html("<p style='color:white;font-size:17px'>没有更多了！</p>");
	}else{
		$.each(content, function(i, item){
			$('#myThreadList').append(
				"<div class='thread'><div class='thread-subject'><a  href='topicsServlet?fPage=1&tid="+item.tid+"&page="+res.page+"'>"
				+item.subject
				+"</a></div><hr class='t-hr'/><div class='thread-info'><p >回复:"
				+item.replies
				+"</p><p >查看:"
				+item.views
				+"</p><p >发帖时间:"
				+item.dateline
				+"</p></div></div>"
			);
		});
	}
}

function havaNewMsg(){
    var userState = eval('(' + isLogin() + ')');
    if(userState.loged == true){
		$.post("newMsgServlet",{
			'nw' : 1,
			'uid': uid
		},function(data){
			if(data > 0){
//				alert(data);
//				$('.badge').css("background-color","red");
				$('.badge').text(data);
				location.hash="#pod";
				$('.badge').removeClass("hidden");
				$('.newMsgMark').removeClass("hidden");
			}else{
//				$('.badge').css("display",'none');
			}
		});
	}else{
//		$('.badge').css("display",'none');
	}
}
