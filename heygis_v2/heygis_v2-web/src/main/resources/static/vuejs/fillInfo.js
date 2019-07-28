new Vue({
    el: "#page",
    data: {
        user: {
            uid:"",
            account: "",
            nickname: "",
            grade: "",
            selfintroduction: "",
            qq: "",
            tel: "",
            name: ""
        },
        originalnickname:"",
        mark1: "",
        mark2: "",
        mark3: "",
        mark4: "",
        b1: true,
        b2: true,
        b3: true,
        b4: true
    },
    methods: {
        /**
         * 昵称校验
         * @param  res 
         */
        checkNickName: function (res) {
            var that = this
            var regex = /[\u4e00-\u9fa5_a-zA-Z0-9_]/;
            var nickname = this.user.nickname
            if (regex.test(nickname)) {
                //axios.post('/user/checkNickName',
                axios.post('http://localhost:8988/user/checkNickName',
                    {
                        nickname: nickname
                    })
                    .then(function (res) {
                        console.log(res)
                        if (res.data.status == 200) {
                            that.mark1 = "<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                            // $("#mark1").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
                            that.b1 = true
                        } else {
                            if(res.data.data == that.originalnickname){
                                that.mark1 = "<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                                that.b1 = true
                            }
                            else{
                                //$("#mark1").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
                                that.mark1 = "<span class='glyphicon glyphicon-remove' style='color: red; width:100px' aria-hidden='true'>昵称已存在</span>"
                                that.b1 = false
                            }
                        }
                    })
                    .catch(function (err) {
                        console.log(err)
                    })
            } else {
                that.mark1 = "<span class='glyphicon glyphicon-remove' style='color: red; width:150px' aria-hidden='true'>昵称格式不正确</span>"
                that.b1 = false
            }
        },
        /**
         * 入学年份校验
         * @param res 
         */
        checkGrade: function (res) {
            var regex = /^\d{4}$/;
            var grade = this.user.grade
            if (regex.test(grade)) {
                this.mark2 = "<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                //$("#mark5").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
                this.b2 = true
            }
            else {
                //$("#mark5").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
                this.mark2 = "<span class='glyphicon glyphicon-remove' style='color: red; width:150px' aria-hidden='true'>入学年份格式不正确</span>"
                this.b2 = false
            }
        },
        /**
     * QQ号码校验
     * @param  res 
     */
        checkQQ: function (res) {
            var regex = /[1-9][0-9]{4,14}/
            var qq = this.user.qq
            if(qq=="暂无"||qq=="") {
                this.b3 = true
                this.mark3=""
            }
            else if (regex.test(qq)) {
                this.mark3 = "<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                this.b3 = true
            }
            else {
                this.mark3 = "<span class='glyphicon glyphicon-remove' style='color: red; width:150px' aria-hidden='true'>QQ号码格式不正确</span>"
                this.b3 = false
            }
        },
        /**
         * 电话号码校验
         * @param res 
         */
        checkTel: function (res) {
            var regex = /^1(3|4|5|7|8)\d{9}$/
            var tel = this.user.tel
            if(tel=="暂无"||tel==""){
                this.b4 = true
                this.mark4=""
            }
            else if (regex.test(tel)) {
                this.mark4 = "<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                this.b4 = true
            }
            else {
                this.mark4 = "<span class='glyphicon glyphicon-remove' style='color: red; width:150px' aria-hidden='true'>手机号码格式不正确</span>"
                this.b4 = false
            }
        },
        /**
         * 个人信息完善
         * @param  res 
         */
        fillInfo: function (res) {
            var that = this
            if(this.b1&this.b2&this.b3&this.b4){
                //console.log("表单提交")
                //获取性别选项
                var gender = $("input[name='optionsRadios']:checked").val()
                //console.log()
                //axios.post("/user/updateUserInfo",{
                axios.post("http://localhost:8988/user/updateUserInfo",{
                    uid:that.user.uid,
                    account: that.user.account,
                    nickname: that.user.nickname,
                    grade: that.user.grade,
                    selfintroduction: that.user.selfintroduction,
                    qq: that.user.qq,
                    tel: that.user.tel,
                    name: that.user.name,
                    gender:gender
                })
                .then(function(res){
                        console.log(res)
                        if(res.data.status==200){
                            //跳回个人中心
                            //window.location.href="http://localhost:8988/selfCenter.html";
                            window.location.href="./selfCenter.html";
                        }else{
                            //跳转失败
                            //window.location.href="http://localhost:8988/fail.html?message=个人信息完善失败";
                            window.location.href="./fail.html?message=个人信息完善失败";
                        }
                })
                .catch(function(err){
                    console.log(err)
                })
            }else{
                $("#submitt").html("<button class='btn btn-danger btn-block' type='submit'>请将所有内容填写正确后再试</button>");
            }
            
        }
    },
    created: function () {
        //console.log("初始化数据")
        var that = this
        //axios.get('/user/getSelfInfo')
        axios.get('http://localhost:8988/user/getSelfInfo')
            .then(function (res) {
                {
                    //console.log(res)
                    that.user = res.data.data
                    that.originalnickname = res.data.data.nickname
                    var gender = res.data.data.gender
                    if (gender == "男") {
                        $("#optionsRadios1").prop("checked", true);
                    }
                    if (gender == "女") {
                        $("#optionsRadios2").prop("checked", true);
                    }
                    if (gender == "保密") {
                        $("#optionsRadios0").prop("checked", true);
                    }
                }
            })
            .catch(function (err) {
                console.log(err)
            })
    }
})