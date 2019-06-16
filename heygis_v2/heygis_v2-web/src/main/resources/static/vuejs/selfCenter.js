var cropper
var options = {}
new Vue({
    el:"#page",
    data:{
        user:{
            uid:"",
            account:"",
            selfIntroduction:"",
            nickName:"",
            gender:"",
            grade:"",
            qq:"",
            tel:"",
            icon_img:""
        }
    },
    methods:{
        /**
         * 显示修改头像组件 
         */
        showIconEdit:function(){
            options = {
                thumbBox: '.thumbBox',
                spinner: '.spinner',
                imgSrc: 'img/pic2.jpg'
            }
            cropper= $('.imageBox').cropbox(options);
            $('.theme-popover-mask').fadeIn(100);
            $('#changeIcon').slideDown(200);
        },
        /**
         * 关闭修改头像组件
         */
        closeIconEdit:function(){
            $('.theme-popover-mask').fadeOut(100);
            $('#changeIcon').slideUp(200);
        },
        /**
         * 获取图片
         * @param  res 
         */
        getFile:function(res){
            //console.log(res)
            //图片转为base64 回显到图片框中
            var reader = new FileReader()
            reader.readAsDataURL(res.target.files[0]);
            reader.onload = function(e) {
                //console.log(e)
                options.imgSrc = e.target.result;
                cropper = $('.imageBox').cropbox(options);
            }
        },
        /**
         * 放大
         */
        zoomInClick:function(){
            cropper.zoomIn();
        },
        /**
         * 缩小
         */
        zoomOutClick:function(){
            cropper.zoomOut();
        },
        /**
         * 图片上传
         * @param  res 
         */
        uploadImg:function(){
            //console.log("图片表单提交")
            var that = this
            var img = cropper.getDataURL();
            //console.log(img)
            let formData = new FormData();
            formData.append("file",this.convertBase64UrlToBlob(img));
            axios.post('/comm/uploadImg',formData,
            {       
                uid:that.user.uid
            })
            .then(function(res){
                console.log(res)
                if(res.data.status==200){
                    //图片上传成功
                    location.reload();
                }else{
                     //跳转失败
                     window.location.href="http://localhost:8988/fail.html?message=头像上传失败";
                }
            })
            .catch(function(err){
                
            })
            return false
        },
        /**
         * 将以base64的图片url数据转换为Blob
         * @param  urlData 
         */
        convertBase64UrlToBlob:function(urlData){
            //console.log("base64转file")
            var bytes=window.atob(urlData.split(',')[1]);//去掉url的头，并转换为byte  
            //处理异常,将ascii码小于0的转换为大于0  
            var ab = new ArrayBuffer(bytes.length);  
            var ia = new Uint8Array(ab);  
            for (var i = 0; i < bytes.length; i++) {  
                ia[i] = bytes.charCodeAt(i);  
            }  
            return new Blob( [ab] , {type : 'image/png'});
        }
},
    /**
     * 初始化用户基本信息
     */
    created:function(){
        
        //console.log("页面初始化")
        var that = this
        axios.get('/user/getSelfInfo')
        .then(function(res){{
            //console.log(res)
            if(res.data.status==200){
                that.user = res.data.data
            }
            else{
                //用户未登录或者登陆过去，跳回首页
                window.location.href="http://localhost:8988/index.html"
            }
        }})
        .catch(function(err){
            console.log(err)
             //cookie不存在，跳回首页
             window.location.href="http://localhost:8988/index.html"
        })


       
        

    }
})