var vue = new Vue({
    el: "#app",
    data: {
        user: {id:"",username:"",password:"",age:"",sex:"",email:""},
        userList: []
    },
    methods: {
        findAll: function () {
            var that =this
            axios.get('/user/findAll')
                .then(function(response){
                    //console.log(response);
                    that.userList = response.data
                })
                .catch(function(err){
                    console.log(err);
                });
        },
        findById: function (userid) {
            //console.log(userid)
            var that = this;
            axios.get('/user/findUserById/'+userid)
                .then(function (res) {
                    //console.log(res)
                    that.user = res.data
                    $('#myModal').modal("show");
                 })
                .catch(function (err) { console.log(err) })

        },
        update: function (user) {
            var that = this
            console.log(that.user)
            axios.post('/user/updateUser',that.user)
                .then(function (response) {
                    //console.log(response)
                    that.findAll()
                })
                .catch(function (error) {
                    console.log(error)
                });
        }
    },
    created:function () {
        this.findAll();
    }
});