<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>简谱图像音符识别</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,300italic" rel="stylesheet"
          type="text/css"/>
    <script src="<%=path%>/js/jquery.min.js"></script>
    <script src="<%=path%>/js/jquery.poptrox-2.2.js"></script>
    <script src="<%=path%>/js/skel.min.js"></script>
    <script src="<%=path%>/js/init.js"></script>
    <noscript>
        <link rel="stylesheet" href="<%=path%>/css/skel-noscript.css"/>
        <link rel="stylesheet" href="<%=path%>/css/style.css"/>
    </noscript>
</head>
<body>

<!-- Header -->
<section id="header" style="padding: 192px 0;">
    <header>
        <h1>简谱图像音符识别</h1>
        <p>楚朝阳</p>
    </header>
    <footer>
        <a href="#banner" class="button style2 scrolly">第一步:上传简谱图</a>
    </footer>
</section>

<!-- Banner -->
<section id="banner">
    <header>
        <h2>简谱图上传</h2>
    </header>
    <p>上传简谱图后，后台收到图片后开始进行图像特征提取，将图像进行二值分化过滤算法，和字符定位，过滤掉多余的<br/>
        汉字和音符，获取每一个元音符，然后进行训练数据对比识别出音符数字，最后将数据返回给程序，程序将数据写入到新的识别文件<br/>
        中。可以进行查看识别详情.</p>
    <footer>
        <a href="#first" class="button style2 scrolly">第二步:执行获取返回结果</a>
    </footer>
</section>


<!-- Feature 1 -->
<article id="first" class="container box style1 right">
    <a href="#" class="image full"><img src="img/Two_Tigers.jpg" alt=""/></a>
    <div class="inner">
        <header>
            <h2>实例一<br/>
                《两只老虎》</h2>
        </header>
        <p> 12_3_1|1_2.3_1|3_4 5 ?53_4.5|5_65_4
            31|5654|312 5.|1025|1 0|
            12_3_1|1_2.3_1|3_4 5 ?53_4.5|5_65_4
            31|5654|312 5.|1025|1 0|</p>
    </div>
</article>

<!-- Feature 2 -->
<article class="container box style1 left">
    <a href="#" class="image full"><img
            src="img/jda.png" alt=""/></a>
    <div class="inner">
        <header>
            <h2>实例二:<br/>
                《简单爱》</h2>
        </header>
        <p> ". . . . . .   . . . . . ︵     . . .  . . . .
            "1__11231 1 0l1112‘626  0l2121630l\n" +
            ". . .       . . . . . . .   . . . . .
            "336 -l 1 1 1 3 1 0 l 3 1 2 6 2 0 0 l
            ". . . . . . . .      . . . . . ︵        .︵.
            "__1_1.12_61_501.6_6._j__626 Olft0 _1_2_6l\n"
            ".            . .︵.      . .  .  . .︵. . . .
            "6- 0 _1.2.6|5 - 0 5_3_~11- L_1L6L11
            ".           . .︵.  .      . . . .        . .
            "6- 0 2 6 l 6  -02 6 l6 -0 1     2 ";</p>
    </div>
</article>


<!-- Contact -->
<article class="container box style3">
    <header>
        <h2>图片上传</h2>
        <p>请上传训练好的图谱图文件</p>
    </header>
    <form action="<%=path%>/ccy/discern.do" method="post" enctype="multipart/form-data">
        <div class="row half">
            <div class="6u"><input id="uploadImage" type="file" class="file" name="file" placeholder="Name"/></div>
        </div>
        <div class="row half ">
            <div class="12u">
                <img id="uploadPreview"/>
            </div>
        </div>
        <div class="row">
            <div class="12u">
                <ul class="actions">
                    <li><input style="background: #45c89f;padding: 1rem;width: 200px"  class="button form" type="submit" value="确定上传"/></li>
                </ul>
            </div>
        </div>
    </form>
</article>


<section id="footer">

    <div class="copyright">
        <ul class="menu">
            <li>&copy; 河北大学.</li>
            <li>网络空间安全与计算机科学学院</li>
            <li> Collect from <a href="#" target="_blank" title="楚朝阳">楚朝阳</a></li>
        </ul>
    </div>
</section>

</body>
</html>
<script type="application/javascript">

    $("#uploadImage").on("change", function () {

        var files = !!this.files ? this.files : [];

        if (!files.length || !window.FileReader) return;

        if (/^image/.test(files[0].type)) {
            var reader = new FileReader();
            reader.readAsDataURL(files[0]);
            reader.onloadend = function () {
//                console.log(this.result)
                $("#uploadPreview").attr("src", this.result)//css("background-image", "url("+this.result+")");

            }

        }

    });
</script>