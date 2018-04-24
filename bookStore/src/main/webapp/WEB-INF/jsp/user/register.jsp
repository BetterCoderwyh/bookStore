
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" rel="stylesheet" href="${path}/dict/dist/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${path}/dict/css/login.css">
    <link type="text/css" rel="stylesheet" href="${path}/dict/css/bootstrap-datetimepicker.min.css">
    <title>Title</title>
</head>
<body>
            <div class="container">
                <!--登录的form表单-->
                <form action="${path}/user/register" class="form-horizontal" method="post"">
                    <lengend><h3>用户注册页面</h3></lengend>
                    <div class="form-group has-feedback">
                        <label for="reusername" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="reusername" required placeholder="小写字母开头字母或数字,不含中文." name="userName"
                                   style="ime-mode:disabled">
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>

                        </div>
                        <div class="col-sm-3" style="padding-top: 10px;">
                            <label class="alert-danger">${errors.userName}</label>
                            <span class="glyphicon glyphicon-ok text-success" style="display: none" id="usucc"></span>
                            <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="ufail"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label for="repassword" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-5">
                            <input type="password" class="form-control" id="repassword" name="passWord" placeholder="密码长度6-8位" minlength="6" maxlength="8">
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                        <div class="col-sm-3" style="padding-top: 10px;">
                            <label class="alert-danger">${errors.passWord}</label>
                            <span class="glyphicon glyphicon-ok text-success" style="display: none" id="psucc"></span>
                            <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="pfail"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="col-sm-2 control-label">确认密码</label>
                        <div class="col-sm-5">
                            <input type="password" class="form-control" id="repwd" name="repwd" minlength="6" maxlength="8" placeholder="和密码保持一致">
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                        <div class="col-sm-3" style="padding-top: 10px;">
                            <span class="glyphicon glyphicon-ok text-success" style="display: none" id="rpsucc"></span>
                            <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="rpfail"></span>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-5">
                            <input type="email" class="form-control" id="reemail" placeholder="合法邮箱格式" name="email">
                            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                        </div>
                        <div class="col-sm-3" style="padding-top: 10px;">
                            <span class="glyphicon glyphicon-ok text-success" style="display: none" id="esucc"></span>
                            <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="efail"></span>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-5">
                            <input type="tel" class="form-control" id="rephone" name="phone" placeholder="合法手机格式">
                            <span class="glyphicon glyphicon-earphone form-control-feedback"></span>
                        </div>
                        <div class="col-sm-3" style="padding-top: 10px;">
                            <span class="glyphicon glyphicon-ok text-success" style="display: none" id="phsucc"></span>
                            <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="phfail"></span>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label class="col-sm-2 control-label">公司</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="recompany" name="company" placeholder="请输入公司地址">
                            <span class="glyphicon glyphicon-home form-control-feedback"></span>
                        </div>
                        <div class="col-sm-3" style="padding-top: 10px;">
                            <span class="glyphicon glyphicon-ok text-success" style="display: none" id="csucc"></span>
                            <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="cfail"></span>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="readdress" name="address" placeholder="请输入收货地址">
                            <span class="glyphicon glyphicon-home form-control-feedback"></span>
                        </div>
                        <div class="col-sm-3" style="padding-top: 10px;">
                            <span class="glyphicon glyphicon-ok text-success" style="display: none" id="asucc"></span>
                            <span class="glyphicon glyphicon-remove text-danger" style="display: none" id="afail"></span>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <input type="submit" class="btn btn-primary" value="注册">
                    </div>
                </form>
                <!--form结束-->
                <a href="#">已有账号点我登录</a>
            </div>

</body>
</html>
