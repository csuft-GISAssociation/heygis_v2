var map;
var bool = false;
function loadJScript() {
		var script = document.createElement("script");
		script.type = "text/javascript";
		script.src = "http://api.map.baidu.com/api?v=2.0&ak=fUcsLQ6HipBeGCQUMrpNKhqt&callback=init";
		document.body.appendChild(script);
}	
function controlMap(){
	if(bool){
		map.disableScrollWheelZoom(true);
		map.disableDragging(); 
		$("#controlMap").text("点击打开鼠标移动与滚轮缩放");
		$("#controlMap").removeClass("btn-danger");
		$("#controlMap").addClass("btn-primary");
		bool = false;
	}else{
		map.enableScrollWheelZoom(true);
		map.enableDragging(); 
		$("#controlMap").text("点击关闭鼠标移动与滚轮缩放");
		$("#controlMap").removeClass("btn-primary");
		$("#controlMap").addClass("btn-danger");
		bool = true;
	}
}
function init(){
	var script1 = document.createElement("script");
	script1.type = "text/javascript";
	script1.src = "http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js";

	document.body.appendChild(script1);
	map = new BMap.Map("allmap");
	if($(window).width()<768){
		map.centerAndZoom(new BMap.Point(113.001257,28.137300),16);
	}else{
		map.centerAndZoom(new BMap.Point(113.001257,28.137300),17);
	}
	map.disableScrollWheelZoom(true);
	map.disableDragging(); 
	var polyline = new BMap.Polyline([
		new BMap.Point(112.993882,28.136949),
		new BMap.Point(112.993927,28.137913),
		new BMap.Point(112.994354,28.138008),
		new BMap.Point(112.994677,28.138215),
		new BMap.Point(112.994897,28.138514),
		new BMap.Point(112.996128,28.138478),
		new BMap.Point(112.996909,28.137252),
		new BMap.Point(112.997713,28.137323),
		new BMap.Point(112.997924,28.137367),
		new BMap.Point(112.998639,28.138032),
		new BMap.Point(112.999088,28.138239),
		new BMap.Point(112.999204,28.138418),
		new BMap.Point(112.999339,28.138749),
		new BMap.Point(112.999802,28.139115),
		new BMap.Point(113.001154,28.13974),
		new BMap.Point(113.001226,28.140079),
		new BMap.Point(113.001324,28.140322),
		new BMap.Point(113.00132,28.140632),
		new BMap.Point(113.004105,28.141998),
		new BMap.Point(113.005201,28.140827),
		new BMap.Point(113.005767,28.14117),
		new BMap.Point(113.006202,28.14078),
		new BMap.Point(113.007294,28.141194),
		new BMap.Point(113.007671,28.14117),
		new BMap.Point(113.008349,28.139),
		new BMap.Point(113.008439,28.138685),
		new BMap.Point(113.008143,28.138681),
		new BMap.Point(113.008264,28.138307),
		new BMap.Point(113.007357,28.138315),
		new BMap.Point(113.007298,28.138088),
		new BMap.Point(113.007244,28.137431),
		new BMap.Point(113.006602,28.137164),
		new BMap.Point(113.006517,28.136937),
		new BMap.Point(113.006256,28.136957),
		new BMap.Point(113.006202,28.13724),
		new BMap.Point(113.006014,28.137367),
		new BMap.Point(113.00556,28.137375),
		new BMap.Point(113.00516,28.137487),
		new BMap.Point(113.00317,28.136623),
		new BMap.Point(113.003575,28.135874),
		new BMap.Point(113.001239,28.135619),
		new BMap.Point(113.001545,28.134715),
		new BMap.Point(112.999371,28.134465),
		new BMap.Point(112.999303,28.133708),
		new BMap.Point(112.99823,28.133589),
		new BMap.Point(112.998234,28.1329),
		new BMap.Point(112.997161,28.132812),
		new BMap.Point(112.996451,28.13278),
		new BMap.Point(112.996388,28.134847),
		new BMap.Point(112.995566,28.134887),
		new BMap.Point(112.99549,28.134791),
		new BMap.Point(112.994699,28.134803),
		new BMap.Point(112.994664,28.136105),
		new BMap.Point(112.993846,28.136129),
		new BMap.Point(112.993882,28.136949)

	], {strokeColor:"red", strokeWeight:5, strokeOpacity:1}); 
	map.addOverlay(polyline); 

jQuery(document).ready(function($) {
	var url = "http://api.map.baidu.com/geosearch/v3/local?callback=?";
	$.getJSON(url, {
		'geotable_id': 142312,
		'ak'         : 'Ltlvpt9eVXEOR6H984nynKZA',  //用户ak
		page_index   : 0
		},function(data) {
	        	renderMapAndList(data);   //将获取到的json对map和list进行填充
	        }
	);
	$.getJSON(url, {
		'geotable_id': 142312,
		'ak'         : 'Ltlvpt9eVXEOR6H984nynKZA',  //用户ak
		'page_index' : 1
		},function(data) {
	        	renderMapAndList(data);   //将获取到的json对map和list进行填充
	        }
	);
})
	/*渲染map和list
  	 * 传入res为接收到的json
  	 */
	function renderMapAndList(res) {
//		$("#vtour").html("");		   //清除list中所有行	
//		map.clearOverlays();             //清除map上上一次的maker
        var content = res.contents;

        if (content.length == 0) {
            //$('#mapList').append($('<p style="border-top:1px solid #DDDDDD;padding-top:10px;text-align:center;text-align:center;font-size:18px;" class="text-warning">抱歉，没有找到您想要的短租信息，请重新查询</p>'));
            addRow("该区域未查询到景点");
            return;
        }

        $.each(content, function(i, item){
	      	var tr = $("<tr class='vtourtr'><td>"+item.title+"</td></tr>").click(showInfo);
	        $('#vtour').append(tr);   //生成tr，tr.onclick绑定showInfo,并向list中添加tr
	        	
	        var marker = new BMap.Marker(new BMap.Point(item.location[0], item.location[1]));
			marker.addEventListener('click', showInfo);
            function showInfo() {
//          	map.centerAndZoom(new BMap.Point(item.location[0], item.location[1]),18);
                var content = "<img src="+item.image+" style='height:125px;width:237px'/>"+
                              "<a class='btn btn-primary btn-block btn-sm' href='vtourServlet?mark=1&html="+item.url+"'>点击进入</a>";
                //创建检索信息窗口对象
                var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
                    title  : item.title,      //标题
                    width  : 220,             //宽度
                    height : 170,
                    panel  : "panel",         //检索结果面板
                    enableAutoPan : true,     //自动平移
                    searchTypes   :[
//                      BMAPLIB_TAB_SEARCH,   //周边检索
//                      BMAPLIB_TAB_TO_HERE,  //到这里去
//                      BMAPLIB_TAB_FROM_HERE //从这里出发
                    ]
                });
                searchInfoWindow.open(marker);
            };
 			map.addOverlay(marker);
        });
  	}
}
window.onload = loadJScript;  //异步加载地图
	

