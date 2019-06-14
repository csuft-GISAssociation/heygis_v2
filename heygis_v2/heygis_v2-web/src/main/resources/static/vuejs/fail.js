new Vue({
    el:"#page",
    data:{
        message:""
    },
    created:function(res){
        //获取url参数
       var message = getQueryVariable("message")
       //console.log(decodeURI(message))
       this.message = decodeURI(message)
    }
})