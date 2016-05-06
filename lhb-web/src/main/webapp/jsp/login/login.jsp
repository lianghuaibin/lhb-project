<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/getContextPath.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>登陆_${lhb_title}</title>
    <meta name="description" content="${lhb_description}" />
    <meta name="keywords" content="${lhb_keywords}" />
    <link href="${basePath}/logo.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="${basePath}/resources/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${basePath}/resources/css/login/login.css" rel="stylesheet" type="text/css">

</head>
<style>
</style>
<script type="text/javascript">
    var basePath='${basePath}';
</script>
<body >
<div class="box">

    <div class="login-box">

        <div class="login-title text-center">
            <h1><small>Welcome To Lhb Home</small></h1>
        </div>

        <div class="login-content ">
            <p class="error_style"></p>
            <div class="form">
                <form id="login_form" action="${basePath}/login.bs" method="post">
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" name="account" class="form-control" placeholder="用户名">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="text" name="password" class="form-control" placeholder="密码">
                            </div>
                        </div>
                    </div>



                    <div class="form-group form-actions">
                        <div class="col-xs-4 col-xs-offset-4 ">
                            <button type="button" class="btn btn-sm btn-info" onclick="login.loginCheck();">
                                <span class="glyphicon glyphicon-off"></span> 登录</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-6 link">
                            <p class="text-center remove-margin"><small>忘记密码？</small>
                                <a href="javascript:void(0)" onclick="common.alertInfo('此功能暂未开通，敬请期待~~~');" ><small>找回</small></a>
                            </p>
                        </div>
                        <div class="col-xs-6 link">
                            <p class="text-center remove-margin"><small>还没注册?</small>
                                <a href="javascript:void(0)" onclick="common.alertInfo('此功能暂未开通，敬请期待~~~');" ><small>注册</small></a>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
<script src="${basePath}/resources/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/js/common/common.js"></script>
<script type="text/javascript" src="${basePath}/resources/js/login/login.js"></script>
</body>
</html>