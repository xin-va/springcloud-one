<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>电影详情</title>
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
            <img style="width: 250px ; height:350px; float: right; margin-right: 20px" src=${movie.movie_pic}>
        </div>
        <div class="layui-col-md6">
            <h1>${movie.movie_name}</h1>
            <div style="width: 800px;height: 300px;margin-top: 20px">
               <h3>${movie.movie_storyline}</h3>
            </div>
            <hr>
            <div style="margin-top: 30px">
                评论列表
                <table class="layui-table">
                    <colgroup>
                        <col width="50">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>评论内容</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>贤心</td>

                        <td>人生就像是一场修行</td>
                    </tr>
                    <tr>
                        <td>许闲心</td>

                        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <hr>

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">添加评论</label>
                <div class="layui-input-block">
                    <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn">立即提交</button>
                </div>
            </div>

        </div>
        <div class="layui-col-md3">
            <div>
                <h2>主要演员：</h2>
                <#list movie.actors as actor>
                    <h3>${actor.actor_name}</h3>
                </#list>
                </br>
                <h2>影片类型：</h2>
                <#list movie.types as type>
                    <h3>${type.type_name}</h3>
                </#list>
                </br>
                <h2>发行公司：</h2>
                <h3>${movie.movie_company}</h3>
                </br>
                <h2>上映时间</h2>
                <h3>${movie.movie_issuingdate?string("yyyy-MM-dd")}</h3>
            </div>
        </div>
    </div>


</div>





</body>

<script>
</script>


</html>