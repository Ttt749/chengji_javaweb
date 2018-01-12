<%--
  Created by IntelliJ IDEA.
  User: WT
  Date: 2017/11/30
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LoginPage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/session/css/loginPage.css" rel="stylesheet">
    <link rel="shortcut icon" href="http://localhost:8080/session/image/tubiao.jpg" type="image/x-icon" />
    <link href="${pageContext.request.contextPath}/common/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/common/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/common/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/session/js/loginPage.js"></script>
</head>
<body>
<%
    String userName = "";
    String userPassword = "";
    String flag = "";
    //获取当前站点的所有Cookie
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
        if ("userName".equals(cookies[i].getName())) {
            userName = cookies[i].getValue();
        } else if ("userPassword".equals(cookies[i].getName())) {
            userPassword = cookies[i].getValue();
        } else if ("flag".equals(cookies[i].getName())){
            flag = cookies[i].getValue();
        }
    }
%>
<div class="container">
    <div class="row">
        <div class="form clo-md-6">
            <form class="form-horizontal" role="form" action="/session/login">
                <h3 class="form-title">Login to your account</h3>
                <div class="form-group">
                    <label for="userName" class="col-sm-2 control-label">
                        <span class="glyphicon glyphicon-user"></span>
                    </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="userName" placeholder="userName" name="userName" value="<%=userName%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="userPassword" class="col-sm-2 control-label">
                        <span class="glyphicon glyphicon-lock"></span>
                    </label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="userPassword" placeholder="userPassword" name="userPassword" value="<%=userPassword%>">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-10">
                        <div class="col-sm-4"><button type="submit" class="btn btn-success">Sign in</button></div>
                        <div class="col-sm-4"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">Sign up</button></div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title">Sign up</h3>
                    <div class="form-group">
                        <label for="1" class="col-sm-2 control-label">
                            <span class="glyphicon glyphicon-user"></span>
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="1" placeholder="请输入用户名" name="userName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="2" class="col-sm-2 control-label">
                            <span class="glyphicon glyphicon-lock"></span>
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="2" placeholder="请输入用户密码" name="userPassword">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="3" class="col-sm-2 control-label">
                            <span class="glyphicon glyphicon-lock"></span>
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="3" placeholder="请确认用户密码" name="reuserPassword">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <div class="col-sm-4"><button type="submit" class="btn btn-success">注册</button></div>
                            <div class="col-sm-4"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
