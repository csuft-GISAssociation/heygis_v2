new Vue({
    el:"#page",
    data:{
        b1:false,
        b2:false,
        b3:false,
        b4:false,
        b5:false,
        user:{
            account:"",
            password:"",
            repassword:"",
            nickName:"",
            grade:""
        },
        mark1:"",
        mark2:"",
        mark3:"",
        mark4:"",
        mark5:"",
        //submitBtn:""
    },
    methods:{
        /**
         * 邮箱校验
         * @param  res 
         */
        checkEmail:function(res){
            //console.log("测试离焦   "+this.user.account);
            var that = this
            var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g
            var account = this.user.account
            if (regex.test(account)) {
                axios.post('/user/checkEmail',
                {
                    account:account
                })
                .then(function(res){
                    //console.log(res)
                    if(res.data.status==200){
                        that.mark1 = "<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                       // $("#mark1").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
                        that.b1 = true
                    }else{
                        //$("#mark1").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
                        that.mark1 = "<span class='glyphicon glyphicon-remove' style='color: red; width:100px' aria-hidden='true'>账号已存在</span>"
                        that.b1 = false
                    }
                })
                .catch(function(err){
                    console.log(err)
                })
            }else{
                that.mark1 = "<span class='glyphicon glyphicon-remove' style='color: red; width:150px' aria-hidden='true'>邮箱格式不正确</span>"
                that.b1 = false
            }
        },
        /**
         * 密码校验
         * @param  res 
         */
        checkPwd:function(res){
            var regex = /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
            var password = this.user.password
            if (regex.test($(password).val())&&password!="") {
                this.mark2 ="<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                //$("#mark2").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
                this.b2 = true
            }
            else {
                //$("#mark2").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
                this.mark2="<span class='glyphicon glyphicon-remove' style='color: red;width:150px' aria-hidden='true'>密码格式不正确</span>"
                this.b2 = false
            }   
        },
        /**
         * 再次密码校验
         * @param  res 
         */
        checkRePwd:function(res){
            
            if (this.user.password==this.user.repassword&&this.user.repassword!="") {
                this.mark3="<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                //$("#mark3").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
                this.b3 = true
            }
            else {
                //$("#mark3").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
                this.mark3="<span class='glyphicon glyphicon-remove' style='color: red;width:150px' aria-hidden='true'>两次密码不一致</span>"
                this.b3 = false
            }
        },
        /**
         * 昵称校验
         * @param  res 
         */
        checkNickName:function(res){
            var that = this
            var regex = /[\u4e00-\u9fa5_a-zA-Z0-9_]/;
            var nickName = this.user.nickName
            if (regex.test(nickName) && nickName.length < 16) {
                axios.post('/user/checkNickName',
                {
                    nickname:nickName
                })
                .then(function(res){
                    //console.log(res)
                    if(res.data.status==200){
                        that.mark4 = "<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                       // $("#mark1").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
                        that.b4 = true
                    }else{
                        //$("#mark1").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
                        that.mark4 = "<span class='glyphicon glyphicon-remove' style='color: red; width:100px' aria-hidden='true'>昵称已存在</span>"
                        that.b4 = false
                    }
                })
                .catch(function(err){
                    console.log(err)
                })
            }else{
                that.mark4 = "<span class='glyphicon glyphicon-remove' style='color: red; width:150px' aria-hidden='true'>昵称格式不正确</span>"
                that.b4 =false
            }
        },
        /**
         * 入学年份校验
         * @param res 
         */
        checkGrade:function(res){
            var regex = /^\d{4}$/;
            var grade = this.user.grade
            if (regex.test(grade)) {
                this.mark5="<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span>"
                //$("#mark5").html("<span class='glyphicon glyphicon-ok' style='color: green;' aria-hidden='true'></span> ");
                this.b5 = true
            }
            else {
                //$("#mark5").html("<span class='glyphicon glyphicon-remove' style='color: red;' aria-hidden='true'></span> ");
                this.mark5="<span class='glyphicon glyphicon-remove' style='color: red; width:150px' aria-hidden='true'>入学年份格式不正确</span>"
                this.b5 =false
            }
        },
        /**
         * 用户注册
         * @param res 
         */
        register:function(res){
            //console.log("注册事件发生")
            var that = this
            if (this.b1 && this.b2 && this.b3 && this.b4 && this.b5) {
                //console.log("注册成功")
                axios.post('/user/register',
                {
                    account:that.user.account,
                    password:md5(that.user.password),
                    nickname:that.user.nickName,
                    grade:that.user.grade
                })
                .then(function(res){
                    console.log(res)
                    if(res.data.status==200){
                        //跳转至注册成功
                        window.location.href="http://localhost:8988/success.html";
                    }
                    if(res.data.status==201){
                        //跳转至注册失败
                        window.location.href="http://localhost:8988/fail.html?message=注册失败";
                    }
                })
                .catch(function(res){

                })
            }
            else{
                $("#submitt").html("<button class='btn btn-danger btn-block' type='submit''>请将所有内容填写正确后再试</button>");
                //this.submitBtn="<button class='btn btn-danger btn-block' type='submit'>请将所有内容填写正确后再试</button>"
            }
        }   
    }
})