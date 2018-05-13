<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap Admin Theme v3</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <#include "../common/header.ftl">
    <!-- styles -->
    <link href="/foodshop/css/login.css" rel="stylesheet">

</head>
<body class="login-bg">
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <!-- Logo -->
                <div class="logo">
                    <h1><a href="#">卖家管理后台</a></h1>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="page-content container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-wrapper">
                <div class="box">
                    <div class="content-wrap">
                        <h6>登录</h6>
                        <div class="social">
                            <a class="face_login" href="#">
	                                <span class="face_icon">
	                                    <img src="images/facebook.png" alt="fb">
	                                </span>
                                <span class="text">微信登录</span>
                            </a>
                            <div class="division">
                                <hr class="left">
                                <span>或者</span>
                                <hr class="right">
                            </div>
                        </div>
                        <form  role="form" action="/foodshop/seller/owner/checkin" method="post">
                            <input name="username" class="form-control" type="text"   placeholder="用户名">
                            <input name="password" class="form-control" id="password" type="password" placeholder="密码">
                            <div class="action">
                                <button class="btn btn-primary signup" type="submit">登录</button>
                            </div>
                        </form>
                    </div>
                </div>

                <#--<div class="already">-->
                    <#--<p>Don't have an account yet?</p>-->
                    <#--<a href="signup.html">Sign Up</a>-->
                <#--</div>-->
            </div>
        </div>
    </div>
</div>

<script src="/foodshop/js/common.js"></script>
</body>
</html>