<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>选座位</title>
    <link rel="stylesheet" href="http://www.movie.com/css/layui.css" media="all">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" href="index.css">

</head>



<body class="layui-layout-body">
<div  id="main">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">万达影城</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">登录</a></dd>
                    <dd><a href="">注册</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>
</div>



<div class="layui-fluid" style="margin-top: 20px;">

    <div class="layui-row" layui-col-space10>
        <div class="layui-col-md3">
            <div style="height: 30px; width: 450px;"></div>
        </div>
        <div class="layui-col-md6">

            <div style="margin:30px auto;height: 30px; width: 500px;line-height: 30px; text-align: center; border: black 1px solid;">大荧幕</div>
            <div style="margin-top: 150px; text-align: center">

                    <#list 1..show.showRoom.showroom_capacity as index>

                            <input style="width: 25px; height: 25px ; margin-right: 15px;" type="checkbox" v-model="seat" name=${index} value=${index}>
                            <#if index%15==0>
                                </br>
                            </#if>


                    </#list>


            </div>
            <div style="margin-top: 50px;">
                <button @click="getSeat(${show.movie_show_id})" type="button" class="layui-btn layui-btn-danger" style="display:block;margin:5px auto">购票</button>
            </div>
        </div>
        <div class="layui-col-md3">

        </div>


    </div>



</div>
</div>
</body>

<script>
    var app = new Vue({
        el:"#main",
        data:{
            id:"kkkk",
            seat:[]
        },
        methods:{
            getSeat:function (showMovieId) {
                window.console.log(this.seat)
                if (this.seat.length==0){
                    window.alert("请先选择座位再下单")
                }else {
                    axios.get("http://movie.com:8081/insertOrder?seats="+this.seat.toString()+"&movieShowId="+showMovieId).then(
                    function (response) {
                        window.console.log(response)
                    },
                    function (reason) {  }
                )}

            }
        }
    })
</script>


</html>