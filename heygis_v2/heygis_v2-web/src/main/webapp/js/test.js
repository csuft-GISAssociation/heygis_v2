new Vue({
    el:"#page",
    data:{
        userList:[]
    },
    created:function () {
        axios.get('/test').then(
            function (res) {
                console.log(res)
            }
        )
    }
})