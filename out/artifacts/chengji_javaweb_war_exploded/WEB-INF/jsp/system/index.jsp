<%@ page import="main.snnu.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: WT
  Date: 2017/11/30
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/nav.css">
    <link rel="shortcut icon" href="http://localhost:8080/session/image/tubiao.jpg" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/common/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/common/js/bootstrap.min.js"></script>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    session.setAttribute("userRole",user.getUserRole());
%>
<div class="top-nav">
    <p>成绩管理系统</p>
    <li><span class="glyphicon glyphicon-user"></span>&nbsp;<%=user.getUserName()%>|<a href="/session/logout">退出</a>
    </li>
</div>
<div class="content">
    <ul class="leval" id="left-nav" style="overflow: hidden">
        <li class="model frame-model" data-title="showStudent">
            <div class="leval-div"><span>学生信息</span></div>
        </li>
        <li class="model frame-model" data-title="showCourse">
            <div class="leval-div"><span>课程信息</span></div>
        </li>
        <li class="model frame-model" data-title="showTeacher">
            <div class="leval-div"><span>教师信息</span></div>
        </li>
        <li class="model frame-model" data-title="showStuCou">
            <div class="leval-div"><span>成绩信息</span></div>
        </li>
        <li class="model frame-model" data-title="showTeaCou">
            <div class="leval-div"><span>授课信息</span></div>
        </li>
        <c:if test="${sessionScope.userRole==4}">
        <li class="model frame-model" data-title="showUser">
            <div class="leval-div"><span>用户信息</span></div>
        </li>
        </c:if>
    </ul>
    <div class="main-content">
        <iframe id = "main-frame" src="/system/showStudent" frameborder="0" style="width:100%;height:100%"></iframe>
    </div>
</div>

<script>
    /**
     * iframe
     */
    $(function(){
        localStorage.setItem("userRole",<%=user.getUserRole()%>);
        console.log(localStorage.getItem("userRole"));
        var params = {
            "showStudent":{
                url:"/system/showStudent"
            },
            "showCourse":{
                url:"/system/showCourse"
            },
            "showTeacher":{
                url:"/system/showTeacher"
            },
            "showStuCou":{
                url:"/system/showStuCou"
            },
            "showTeaCou":{
                url:"/system/showTeaCou"
            },
            "showUser":{
                url:"/system/showUser"
            }
        };

        $(".leval").on("click",".frame-model",function(){
            var title = $(this).data("title");
            $("#main-frame").attr("src",params[title].url);
        });
    });
</script>
</body>
</html>
