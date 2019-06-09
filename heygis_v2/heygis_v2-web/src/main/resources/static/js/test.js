new Vue({
    el:'#app',
    data:{
        userList:[]
    },
    created:function () {
        var that =this
        axios.get('/test').then(
            function (res) {
                console.log(res)
                that.userList = res.data
            }
        )
    }
})