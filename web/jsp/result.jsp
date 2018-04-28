<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>简谱音符识别 </title>
    <link href="<%=path%>/assets/css/bootstrap.css" rel="stylesheet">
    <link href="<%=path%>/assets/css/main.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="<%=path%>/assets/js/hover.zoom.js"></script>
    <script src="<%=path%>/assets/js/hover.zoom.conf.js"></script>
</head>
<body>
<div class="container box style1 left">

    <div class="inner">
        <header>
            <h2></h2>
        </header>
        <p> </p>
    </div>
</div>

<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>

            </button>
            <a class="navbar-brand" href="http://localhost:8080/">返回</a>
        </div>
        <div class="navbar-collapse collapse">

        </div>
    </div>
</div>
<div id="ww">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 centered">

                <h1>${fileName}</h1>
                <p>${result}</p>

            </div>
        </div>
    </div>
</div>
</body>
</html>
