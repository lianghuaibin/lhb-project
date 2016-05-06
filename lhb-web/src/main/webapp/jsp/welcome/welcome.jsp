<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../include/getContextPath.jsp"%>

<!DOCTYPE HTML>

<html>
<head>
    <title>欢迎光临_${lhb_title}</title>
    <meta name="description" content="${lhb_description}" />
    <meta name="keywords" content="${lhb_keywords}" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link href="${basePath}/logo.ico" rel="shortcut icon" type="image/x-icon" />
    <noscript>
        <link rel="stylesheet" href="${basePath}/jsp/welcome/css/font-awesome.min.css" />
        <link rel="stylesheet" href="${basePath}/jsp/welcome/css/skel.css" />
        <link rel="stylesheet" href="${basePath}/jsp/welcome/css/style.css" />
        <link rel="stylesheet" href="${basePath}/jsp/welcome/css/style-wide.css" />
        <link rel="stylesheet" href="${basePath}/jsp/welcome/css/style-noscript.css" />
    </noscript>
    <!--[if lte IE 9]><link rel="stylesheet" href="${basePath}/jsp/welcome/css/ie/v9.css" /><![endif]-->
    <!--[if lte IE 8]><link rel="stylesheet" href="${basePath}/jsp/welcome/css/ie/v8.css" /><![endif]-->
    <!--[if lte IE 8]><script type="text/javascript" src="${basePath}/jsp/welcome/css/ie/html5shiv.js"></script><![endif]-->
    <script src="${basePath}/jsp/welcome/js/skel.min.js"></script>
    <script src="${basePath}/jsp/welcome/js/init.js"></script>


</head>
<body class="loading">
<div id="wrapper">
    <div id="bg"></div>
    <div id="main">
        <!-- Header -->
        <header id="header">
            <h1>梁怀宾</h1>
            <p><a href="${basePath}/wc/getHtml.wc">个人主页</a> &nbsp;&bull;&nbsp;
                <a href="${basePath}/bsc/myLove.do">最爱</a> &nbsp;&bull;&nbsp;
                <a href="${basePath}/bsc/homePage.do">详细信息</a></p>
            <nav>
                <ul>
                    <li><a href="#" class="fa fa-gittip" title="最爱"><span>Gittip</span></a></li>
                    <li><a href="#" class="fa fa-camera-retro" title="照片"><span>Camera</span></a></li>
                    <li><a href="#" class="fa fa-pagelines" title="微信"><span>weixin</span></a></li>
                    <li><a href="#" class="fa fa-dribbble" title="互联网"><span>Dribbble</span></a></li>
                    <li><a href="#" class="fa fa-linux" title="Liunx"><span>Liunx</span></a></li>
                </ul>
            </nav>
        </header>

        <!-- Footer -->
        <footer id="footer">
            <span class="copyright">&copy; URL: <a href="${basePath}">http://www.lhb0802.cn.</a></span>
        </footer>

    </div>
</div>
</body>
</html>