//定义模板
var template = `
<div class="tab-pane active" id="panel-1">
    <div id="main">
    <div class="inner">
        <header class="page-header">
            <h1 class="text-primary sourceTitle" >{{sourceName}}</h1>
            <div class="btn-group btn-choose" >
              <button type="button" class="btn btn-primary dropdown-toggle choose" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                {{sortName}} <span class="caret"></span>
              </button>
              <ul class="dropdown-menu">
                  <li>
                    <div class="input-group input-group-sm">
                      <input type="text" class="form-control" placeholder="search" aria-describedby="sizing-addon3" v-model="searchCtx">
                      <span class="input-group-btn">
                        <a class="btn btn-default btn-sm" type="button" href="#" v-on:click="searchCho"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
                      </span>
                    </div>
                </li>
                <li><a href="#" v-on:click="timeCho" id="timecho">按上传时间</a></li>
                <li><a href="#" v-on:click="timesCho" id="timescho">按下载数</a></li>
                <li><a href="#" v-on:click="alphacho" id="alphacho">按字母</a></li>
                <li><a href="#" v-on:click="sizeCho"  id="sizecho">按文件大小</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#" v-on:click="defaultCho" id="defaultcho">默认排序</a></li>
              </ul>
            </div>
            <p>{{sourceSay}}</p>
        </header>
        <nav>
          <ul class="pager">
            <li class="previous"><a href="#" v-if="currentPage>1" v-on:click="toLast()"><span aria-hidden="true">&larr;</span>上一页</a></li>
            <li class="next"><a href="#" v-if="currentPage<totalPage" v-on:click="toNext()">下一页 <span aria-hidden="true">&rarr;</span></a></li>
          </ul>
        </nav>
        <section class="tiles" id="section_1" >
                <article v-bind:class="styleList[index]" v-for="(item,index) in sources">
                    <span class="image">
                        <img v-bind:src="imageList[index]" alt="" />
                    </span>
                <div class="detail">
                    <h2 v-if="item.level!=null">{{item.name}}({{item.level}})</h2>
                    <h2 v-else>{{item.name}}</h2>
                    <h4>作者:{{item.uploader}}</h4>
                    <h4>下载次数:{{item.download_times}}</h4>
                    <h5>文件大小:{{item.file_size}}</h5>
                    <h5>上传时间:{{item.upload_time}}</h5>
                    <div class="content">
                        <p>{{item.introduction}}</p>
                        <a class="btn btn-primary btn-lg change" v-bind:href="item.download_link" onclick="return checkLog('')">本站下载地址</a>
                    </div>
                </div>
            </article>
        </section>
        <nav>
          <ul class="pager">
            <li class="previous"><a href="#" v-if="currentPage>1" v-on:click="toLast()"><span aria-hidden="true">&larr;</span>上一页</a></li>
            <li class="next"><a href="#" v-if="currentPage<totalPage" v-on:click="toNext()">下一页 <span aria-hidden="true">&rarr;</span></a></li>
          </ul>
        </nav>
    </div>
</div>
</div>
        `;

//外部对象本身
var that = this

//外部对象本身，用于修改模板
var tempThat = this 

//获取资源公共方法
function getSource(that,type,page){
    //axios.get('/resource/getSource',{
    axios.get('http://localhost:8988/resource/getSource',{
        params:{
            type:type,
            page:page
        }
    })
    .then(function(res){
        //console.log(res)
        if(res.data.status==200){
            that.sources = res.data.data.sources
            that.currentPage = res.data.data.currentPage
            that.totalPage = res.data.data.totalPage
            //产生随机图片
            for(var i = 0;i<that.sources.length;i++){
                var x = Math.floor((Math.random()*14)+1);
                that.imageList[i] = "img/pic"+x+".jpg"
            }
            //产生随机样式
            for(var i = 0;i<that.sources.length;i++){
                var x = Math.floor((Math.random()*5)+1);
                that.styleList[i] = "style"+x
            }
        }
        else{
            //window.location.href="http://localhost:8988/fail.html?message=资源获取失败"
            window.location.href="./fail.html?message=资源获取失败";
        }
    })
    .catch(function(err){
        console.log(err)
    })
}


//按条件获取资源公共方法
function getSourceByCondition(that,type,page,condition){
    //axios.post('/resource/getSourceByCon',{
    axios.post('http://localhost:8988/resource/getSourceByCon',{
            type:type,
            page:page,
            conditionId:condition.conditionId,
            conditionName:condition.conditionName
    },{
        headers: {'Content-Type':'application/json;charset=UTF-8'}
    })
    .then(function(res){
        //console.log(res)
        if(res.data.status==200){
            that.sources = res.data.data.sources
            that.currentPage = res.data.data.currentPage
            that.totalPage = res.data.data.totalPage
            //产生随机图片
            for(var i = 0;i<that.sources.length;i++){
                var x = Math.floor((Math.random()*14)+1);
                that.imageList[i] = "img/pic"+x+".jpg"
            }
            //产生随机样式
            for(var i = 0;i<that.sources.length;i++){
                var x = Math.floor((Math.random()*5)+1);
                that.styleList[i] = "style"+x
            }
        }
        else{
            //window.location.href="http://localhost:8988/fail.html?message=资源获取失败";
            window.location.href="./fail.html?message=资源获取失败";
        }
    })
    .catch(function(err){
        console.log(err)
    })
}

//按关键字查询
function getSourceByKeyWord(that,type,keyWord){
    //axios.get('/resource/getSourceByKeyWord',{
        axios.get('http://localhost:8988/resource/getSourceByKeyWord',{
        params:{
            type:type,
            keyWord:keyWord
        }
    })
    .then(function(res){
        //console.log(res)
        if(res.data.status==200){
            that.sources = res.data.data
            that.currentPage = 1
            that.totalPage = 1
            //产生随机图片
            for(var i = 0;i<that.sources.length;i++){
                var x = Math.floor((Math.random()*14)+1);
                that.imageList[i] = "img/pic"+x+".jpg"
            }
            //产生随机样式
            for(var i = 0;i<that.sources.length;i++){
                var x = Math.floor((Math.random()*5)+1);
                that.styleList[i] = "style"+x
            }
        }else{
           //未查询到内容的提示，暂时先这样做
           that.sources=[]
           that.currentPage = 1
           that.totalPage = 1
           alert("啥都没找到!")
        }
    })
    .catch(function(err){
        console.log(err)
    })
}

var source1 ={
    template: template,
    data:function(){
        return{
            sourceName:'总结大会',
            sourceSay:'每一年的总结大会的作品都整理在了这里，欢迎大家互相借鉴，互相学习。',
            sources:[],
            imageList:[],
            styleList:[],
            currentPage:0,
            totalPage:0,
            searchCtx:"",
            sortName:"默认排序",
            condition:[
                {
                    conditionId:1,
                    conditionName:"time"
                },
                {
                    conditionId:2,
                    conditionName:"times"
                },
                {
                    conditionId:3,
                    conditionName:"alpha"
                },
                {
                    conditionId:4,
                    conditionName:"size"
                }
        ]
        }
    },
    methods:{
         /**
         * 下一页
         */
        toNext:function(){
            //console.log("跳转下一页")
            var page = this.currentPage + 1
            if(this.sortName=="按上传时间"){
                that.getSourceByCondition(this,0,page,this.condition[0])
            }
            else if(this.sortName=="按下载次数"){
                that.getSourceByCondition(this,0,page,this.condition[1])
            }
            else if(this.sortName=="按字母顺序"){
                that.getSourceByCondition(this,0,page,this.condition[2])
            }
            else if(this.sortName=="按文件大小"){
                that.getSourceByCondition(this,0,page,this.condition[3])
            }
            else{
                that.getSource(this,0,page)
            }
        },
        /**
         * 上一页
         */
        toLast:function(){
            //console.log("跳转上一页")
            var page = this.currentPage - 1
            if(this.sortName=="按上传时间"){
                that.getSourceByCondition(this,0,page,this.condition[0])
            }
            else if(this.sortName=="按下载次数"){
                that.getSourceByCondition(this,0,page,this.condition[1])
            }
            else if(this.sortName=="按字母顺序"){
                that.getSourceByCondition(this,0,page,this.condition[2])
            }
            else if(this.sortName=="按文件大小"){
                that.getSourceByCondition(this,0,page,this.condition[3])
            }
            else{
                that.getSource(this,0,page)
            }
        },
        /**
         * 根据关键字搜索
         */
        searchCho:function(){
            //console.log("关键字搜索")
            this.sortName = "按条件:"+this.searchCtx
            that.getSourceByKeyWord(this,0,this.searchCtx)
        },
        /**
         * 上传时间
         */
        timeCho:function(){
            //console.log("上传时间")
            this.sortName = "按上传时间"
            var page = this.currentPage
            that.getSourceByCondition(this,0,page,this.condition[0])
        },
        /**
         * 下载次数
         */
        timesCho:function(){
            //console.log("下载次数")
            this.sortName = "按下载次数"
            var page = this.currentPage
            that.getSourceByCondition(this,0,page,this.condition[1])
        },
        /**
         * 字母顺序
         */
        alphacho:function(){
            //console.log("字母顺序")
            this.sortName = "按字母顺序"
            var page = this.currentPage
            that.getSourceByCondition(this,0,page,this.condition[2])
        },
        /**
         * 文件大小
         */
        sizeCho:function(){
            //console.log("文件大小")
            this.sortName = "按文件大小"
            var page = this.currentPage
            that.getSourceByCondition(this,0,page,this.condition[3])
        },
        /**
         * 默认排序
         */
        defaultCho:function(){
            this.sortName = "默认排序"
            var page = this.currentPage
            that.getSource(this,0,page)
        }
    },
    created:function(){
        //获取总结大会资源
        var page = this.$route.query.page
        that.getSource(this,0,page)
    }
 }

 var source2 ={
    template: template,
    data:function(){
        return{
            sourceName:'课堂源码',
            sourceSay:'不仅要看懂课堂上的代码，还要多敲多练。锻炼手指的记忆，增强代码熟练度。',
            sources:[],
            imageList:[],
            styleList:[],
            currentPage:0,
            totalPage:0,
            searchCtx:"",
            sortName:"默认排序",
            condition:[
                {
                    conditionId:1,
                    conditionName:"time"
                },
                {
                    conditionId:2,
                    conditionName:"times"
                },
                {
                    conditionId:3,
                    conditionName:"alpha"
                },
                {
                    conditionId:4,
                    conditionName:"size"
                }
        ]
        }
    },
    methods:{
         /**
         * 下一页
         */
        toNext:function(){
            //console.log("跳转下一页")
            var page = this.currentPage + 1
            if(this.sortName=="按上传时间"){
                that.getSourceByCondition(this,1,page,this.condition[0])
            }
            else if(this.sortName=="按下载次数"){
                that.getSourceByCondition(this,1,page,this.condition[1])
            }
            else if(this.sortName=="按字母顺序"){
                that.getSourceByCondition(this,1,page,this.condition[2])
            }
            else if(this.sortName=="按文件大小"){
                that.getSourceByCondition(this,1,page,this.condition[3])
            }
            else{
                that.getSource(this,1,page)
            }
        },
        /**
         * 上一页
         */
        toLast:function(){
            //console.log("跳转上一页")
            var page = this.currentPage - 1
            if(this.sortName=="按上传时间"){
                that.getSourceByCondition(this,1,page,this.condition[0])
            }
            else if(this.sortName=="按下载次数"){
                that.getSourceByCondition(this,1,page,this.condition[1])
            }
            else if(this.sortName=="按字母顺序"){
                that.getSourceByCondition(this,1,page,this.condition[2])
            }
            else if(this.sortName=="按文件大小"){
                that.getSourceByCondition(this,1,page,this.condition[3])
            }
            else{
                that.getSource(this,1,page)
            }
        },
        /**
         * 根据关键字搜索
         */
        searchCho:function(){
            //console.log("关键字搜索")
            this.sortName = "按条件:"+this.searchCtx
            that.getSourceByKeyWord(this,1,this.searchCtx)
        },
        /**
         * 上传时间
         */
        timeCho:function(){
            //console.log("上传时间")
            this.sortName = "按上传时间"
            var page = this.currentPage
            that.getSourceByCondition(this,1,page,this.condition[0])
        },
        /**
         * 下载次数
         */
        timesCho:function(){
            //console.log("下载次数")
            this.sortName = "按下载次数"
            var page = this.currentPage
            that.getSourceByCondition(this,1,page,this.condition[1])
        },
        /**
         * 字母顺序
         */
        alphacho:function(){
            //console.log("字母顺序")
            this.sortName = "按字母顺序"
            var page = this.currentPage
            that.getSourceByCondition(this,1,page,this.condition[2])
        },
        /**
         * 文件大小
         */
        sizeCho:function(){
            //console.log("文件大小")
            this.sortName = "按文件大小"
            var page = this.currentPage
            that.getSourceByCondition(this,1,page,this.condition[3])
        },
        /**
         * 默认排序
         */
        defaultCho:function(){
            this.sortName = "默认排序"
            var page = this.currentPage
            that.getSource(this,1,page)
        }
    },
    created:function(){
        //获取课堂源码资源
        var page = this.$route.query.page
        that.getSource(this,1,page)
    }
 }


 var source3 ={
    template: template,
    data:function(){
        return{
            sourceName:'开发工具',
            sourceSay:'如果只是在面临老师布置的各种课程设计时才想到我的话，那就太可惜了。',
            sources:[],
            imageList:[],
            styleList:[],
            currentPage:0,
            totalPage:0,
            searchCtx:"",
            sortName:"默认排序",
            condition:[
                {
                    conditionId:1,
                    conditionName:"time"
                },
                {
                    conditionId:2,
                    conditionName:"times"
                },
                {
                    conditionId:3,
                    conditionName:"alpha"
                },
                {
                    conditionId:4,
                    conditionName:"size"
                }
        ]
        }
    },
    methods:{
         /**
         * 下一页
         */
        toNext:function(){
            //console.log("跳转下一页")
            var page = this.currentPage + 1 
            if(this.sortName=="按上传时间"){
                that.getSourceByCondition(this,2,page,this.condition[0])
            }
            else if(this.sortName=="按下载次数"){
                that.getSourceByCondition(this,2,page,this.condition[1])
            }
            else if(this.sortName=="按字母顺序"){
                that.getSourceByCondition(this,2,page,this.condition[2])
            }
            else if(this.sortName=="按文件大小"){
                that.getSourceByCondition(this,2,page,this.condition[3])
            }
            else{
                that.getSource(this,2,page)
            }
        },
        /**
         * 上一页
         */
        toLast:function(){
            //console.log("跳转上一页")
            var page = this.currentPage - 1
            if(this.sortName=="按上传时间"){
                that.getSourceByCondition(this,2,page,this.condition[0])
            }
            else if(this.sortName=="按下载次数"){
                that.getSourceByCondition(this,2,page,this.condition[1])
            }
            else if(this.sortName=="按字母顺序"){
                that.getSourceByCondition(this,2,page,this.condition[2])
            }
            else if(this.sortName=="按文件大小"){
                that.getSourceByCondition(this,2,page,this.condition[3])
            }
            else{
                that.getSource(this,2,page)
            }
        },
        /**
         * 根据关键字搜索
         */
        searchCho:function(){
            //console.log("关键字搜索")
            this.sortName = "按条件:"+this.searchCtx
            that.getSourceByKeyWord(this,2,this.searchCtx)
        },
        /**
         * 上传时间
         */
        timeCho:function(){
            //console.log("上传时间")
            this.sortName = "按上传时间"
            var page = this.currentPage
            that.getSourceByCondition(this,2,page,this.condition[0])
        },
        /**
         * 下载次数
         */
        timesCho:function(){
            //console.log("下载次数")
            this.sortName = "按下载次数"
            var page = this.currentPage
            that.getSourceByCondition(this,2,page,this.condition[1])
        },
        /**
         * 字母顺序
         */
        alphacho:function(){
            //console.log("字母顺序")
            this.sortName = "按字母顺序"
            var page = this.currentPage
            that.getSourceByCondition(this,2,page,this.condition[2])
        },
        /**
         * 文件大小
         */
        sizeCho:function(){
            //console.log("文件大小")
            this.sortName = "按文件大小"
            var page = this.currentPage
            that.getSourceByCondition(this,2,page,this.condition[3])
        },
        /**
         * 默认排序
         */
        defaultCho:function(){
            this.sortName = "默认排序"
            var page = this.currentPage
            that.getSource(this,2,page)
        }
    },
    created:function(){
       //获取开发工具资源
       var page = this.$route.query.page
       that.getSource(this,2,page)
    }
 }

 var source4 ={
    template: template,
    data:function(){
        return{
            sourceName:'拓展强化',
            sourceSay:'青春不是用来虚度的，而是用来投资自己。',
            sources:[],
            imageList:[],
            styleList:[],
            currentPage:0,
            totalPage:0,
            searchCtx:"",
            sortName:"默认排序",
            condition:[
                {
                    conditionId:1,
                    conditionName:"time"
                },
                {
                    conditionId:2,
                    conditionName:"times"
                },
                {
                    conditionId:3,
                    conditionName:"alpha"
                },
                {
                    conditionId:4,
                    conditionName:"size"
                }
        ]
        }
    },
    methods:{
        /**
         * 下一页
         */
        toNext:function(){
            //console.log("跳转下一页")
            var page = this.currentPage + 1 
            if(this.sortName=="按上传时间"){
                that.getSourceByCondition(this,3,page,this.condition[0])
            }
            else if(this.sortName=="按下载次数"){
                that.getSourceByCondition(this,3,page,this.condition[1])
            }
            else if(this.sortName=="按字母顺序"){
                that.getSourceByCondition(this,3,page,this.condition[2])
            }
            else if(this.sortName=="按文件大小"){
                that.getSourceByCondition(this,3,page,this.condition[3])
            }
            else{
                that.getSource(this,3,page)
            }
        },
        /**
         * 上一页
         */
        toLast:function(){
            //console.log("跳转上一页")
            var page = this.currentPage - 1
            if(this.sortName=="按上传时间"){
                that.getSourceByCondition(this,3,page,this.condition[0])
            }
            else if(this.sortName=="按下载次数"){
                that.getSourceByCondition(this,3,page,this.condition[1])
            }
            else if(this.sortName=="按字母顺序"){
                that.getSourceByCondition(this,3,page,this.condition[2])
            }
            else if(this.sortName=="按文件大小"){
                that.getSourceByCondition(this,3,page,this.condition[3])
            }
            else{
                that.getSource(this,3,page)
            }
        },
        /**
         * 根据关键字搜索
         */
        searchCho:function(){
            //console.log("关键字搜索")
            this.sortName = "按条件:"+this.searchCtx
            that.getSourceByKeyWord(this,3,this.searchCtx)
        },
        /**
         * 上传时间
         */
        timeCho:function(){
            //console.log("上传时间")
            this.sortName = "按上传时间"
            var page = this.currentPage
            that.getSourceByCondition(this,3,page,this.condition[0])
        },
        /**
         * 下载次数
         */
        timesCho:function(){
            //console.log("下载次数")
            this.sortName = "按下载次数"
            var page = this.currentPage
            that.getSourceByCondition(this,3,page,this.condition[1])
        },
        /**
         * 字母顺序
         */
        alphacho:function(){
            //console.log("字母顺序")
            this.sortName = "按字母顺序"
            var page = this.currentPage
            that.getSourceByCondition(this,3,page,this.condition[2])
        },
        /**
         * 文件大小
         */
        sizeCho:function(){
            //console.log("文件大小")
            this.sortName = "按文件大小"
            var page = this.currentPage
            that.getSourceByCondition(this,3,page,this.condition[3])
        },
        /**
         * 默认排序
         */
        defaultCho:function(){
            this.sortName = "默认排序"
            var page = this.currentPage
            that.getSource(this,3,page)
        }
    },
    created:function(){
        //获取拓展强化资源
        var page = this.$route.query.page
        that.getSource(this,3,page)
    }
 }

 //定义路由对象
 var router = new VueRouter({
    routes:[{
        path:'/zjdh',
        component:source1
    },
    {
        path:'/ktym',
        component:source2
    },
    {
        path:'/kfgj',
        component:source3
    },
    {
        path:'/tzqh',
        component:source4
    }]
 })

 //初始化vue对象
 new Vue({
     el:"#page",
     router:router
 })