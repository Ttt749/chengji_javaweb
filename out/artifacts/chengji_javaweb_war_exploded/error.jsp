<%--
  Created by IntelliJ IDEA.
  User: WT
  Date: 2017/11/30
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body bgcolor="#FFFFFF">
<div align="center">
    <h1>错误信息</h1>
    <%
        String error = request.getParameter("error");
        if(error!=null){%>
    <h2>错误:</h2><h3><%=error%></h3>
        <%}
    %>
    <h3><%=exception.toString()%>%></h3>
    <a href="javascript:history.back();">返回</a>
</div>
</body>
</html>
