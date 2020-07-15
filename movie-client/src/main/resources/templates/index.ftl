<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>万达电影购票系统</title>
    <link rel="stylesheet" href="http://www.movie.com/css/layui.css" media="all">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" href="index.css">

</head>



<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin" id="mian">
        <div class="layui-header">
            <div class="layui-logo">万达影城</div>
            <!-- 头部区域（可配合layui已有的水平导航） -->

            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="http://movie.com:8082/goLogin">登录</a>
                </li>
                <li class="layui-nav-item">
                    <a href="">注册</a>
                </li>

            </ul>
        </div>

        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed" v-for="(item , index) in Storelist">
                        <a class="" href="javascript:;" @click="getShowRoomAndMovies(item)" >{{item.store_name}}</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="layui-body">
            <h2>{{storeCurrent}}</h2>
            <div style="margin: 30px 40px">
                <label class="">放映厅</label>
                <select  v-model="showroomid">
                    <option  v-for="(item) in showrooms" :value="item.showroom_id" >{{item.showroom_name}}</option>
                </select>

                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

                <label class="">上映时间</label>
                <select name="" lay-verify="">
                    <option value="">--</option>
                    <option v-for="(item , index) in showrooms" value="item.showroom_id">{{item.showroom_name}}</option>
                </select>

                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

                <button type="button" class="layui-btn" @click="getShowBySearch(1,showroomid,showTime)">查询</button>
            </div>


            <div class="" id="box" >
                <ul>
                    <li v-for="(item,index) in movieList" >
                        <img @click="goMovieInfo(item)" :src="item.movie.movie_pic" alt="" >
                        <div style="text-align:center; margin-top: 10px">
                            <p @click="goMovieInfo(item)">片名：<span>{{item.movie.movie_name}}</span></p>
                            <p>类型：<span v-for="(type , index) in item.movie.types">{{type.type_name}}<span v-if="index!=item.movie.types.length-1">/</span></span></p>
                            <p>主演：<span v-for="(actor, index) in item.movie.actors">{{actor.actor_name}} <span v-if="index!=item.movie.actors.length-1">/</span></span></p>
                            <p>放映时间：<span>{{item.show_date}}</span></p>
                            <p>价格：<span>{{item.price}}</span></p>
                            <button @click="goSeat(item)" type="button" class="layui-btn layui-btn-danger" style="display:block;margin:5px auto">购票</button>
                        </div>
                    </li>
                </ul>
            </div>

            <div class="page-normal">
                <a v-show="pageNum!=1" @click="getShowMovieByShowRoomIds(pageNum-1,showroomids)">&nbsp;&lt;&nbsp;</a>
                <a @click="getShowMovieByShowRoomIds(page,showroomids)"  v-for="page of pageCount" :class="page==pageNum ? 'page-current':''">{{page}}</a>
                <a v-show="pageNum!= pageCount" @click="getShowMovieByShowRoomIds(pageNum+1,showroomids)">&nbsp;&gt;&nbsp;</a>
            </div>

        </div>



        <div class="layui-footer">
            <!-- 底部固定区域 -->
            © 万达影城
        </div>
    </div>

</body>

<script>
    var app = new Vue({
        el:"#mian",
        data:{
            Storelist:[],
            showrooms:[],
            showroomids:"",
            movieList:[],
            storeCurrent:"",
            pageCount:"",
            pageNum:"",
            showroomid:"",
            showTime:""
        },
        methods:{
            getStore:function () {
                var that = this;
                axios.get("http://movie.com:8081/getStore").then(
                    function (response) {
                        that.Storelist = response.data
                    },
                    function (reason) {  }
                )
            },

            getShowMovieByShowRoomIds:function (page ,showroomIds) {
                var that = this;
                if (showroomIds == null || showroomIds.length ==0){
                    var url = "http://movie.com:8081/getShowMovies?pageNum="+page
                }else {
                    var url = "http://movie.com:8081/getShowMovies?pageNum="+page+"&showroomIds="+showroomIds
                }
                axios.get(url).then(
                    function (response) {
                        that.movieList =response.data.showMovieList
                        that.pageCount = response.data.pageCount
                        that.pageNum = response.data.pageNum
                    },
                    function (reason) {  }
                )
            },
            getShowRoomAndMovies:function (p) {
                this.storeCurrent=p.store_name
                this.showrooms = p.showRooms;
                this.showroomids = ""
                for (var i in this.showrooms){
                    if (this.showroomids.length>0){
                        this.showroomids += ","
                    }
                    this.showroomids += this.showrooms[i].showroom_id
                }
                this.getShowMovieByShowRoomIds(1,this.showroomids)
            },
            goMovieInfo:function(item){
                window.console.log(item)
                window.open("http://movie.com:8081/getMovieInfo?movieId="+item.movie.movie_id)
            },
            goSeat:function (item) {
                window.open("http://movie.com:8081/getSeatInfo?showMovieId="+item.movie_show_id)
            },
            getShowBySearch:function (page , showIds , time) {
                if (time == "" && showIds != null){
                    this.getShowMovieByShowRoomIds(page,showIds);
                }
            }

        },
        mounted:function () {
            this.getStore();
            this.getShowMovieByShowRoomIds(1,null)
        }

    })
</script>


</html>