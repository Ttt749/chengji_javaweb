<%@ page import="main.snnu.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: WT
  Date: 2017/12/1
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/common/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/common/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/system/js/showTeacher.js"></script>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
%>
<div class="container">
    <table class="table table-hover" id="table1">
        <h1 class="text-center">教师信息表</h1>
        <div class="container">
            <div class="input-group col-md-4 pull-right" style="margin-top:10px; margin-bottom: 10px; positon:relative;">
                <input type="text" class="form-control" placeholder="请输入字段名" id="queryCondition"/>
                <span class="input-group-btn">
               <button class="btn btn-info btn-search" id="query">查找</button>
               <button class="btn btn-info btn-search" id="insert">添加</button>
        </span>
            </div>
        </div>
        <thead>
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">姓名</th>
            <th class="text-center">年龄</th>
            <th class="text-center">性别</th>
            <th class="text-center">学院</th>
            <th class="text-center">毕业院校</th>
            <th class="text-center">简介</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach var="teacher" items="${data}">
            <tr>
                <td>${teacher.tId}</td>
                <td>${teacher.tName}</td>
                <td>${teacher.tAge}</td>
                <td>${teacher.tSex}</td>
                <td>${teacher.tSchool}</td>
                <td>${teacher.tGraduate}</td>
                <td>${teacher.tText}</td>
                <td>
                    <button type="button" class="btn btn-info btn-sm" onclick="update('${teacher.tId}','${teacher.tName}','${teacher.tAge}','${teacher.tSex}','${teacher.tSchool}','${teacher.tGraduate}','${teacher.tText}')">修改</button>
                    <button type="button" class="btn btn-danger btn-sm" onclick="delet('${teacher.tId}')">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="container">
    <div class="pull-right">
        <ul class="pagination">
            <li class="disabled"><a href="#">每页数量</a></li>
            <li class="active"><a href="#">${count}</a></li>
            <c:if test="${requestScope.count==5}">
                <li><a href="#" onclick="findPage(${currentPage},10)">10</a></li>
                <li><a href="#" onclick="findPage(${currentPage},15)">15</a></li>
            </c:if>
            <c:if test="${requestScope.count==10}">
                <li><a href="#" onclick="findPage(${currentPage},5)">5</a></li>
                <li><a href="#" onclick="findPage(${currentPage},15)">15</a></li>
            </c:if>
            <c:if test="${requestScope.count==15}">
                <li><a href="#" onclick="findPage(${currentPage},5)">5</a></li>
                <li><a href="#" onclick="findPage(${currentPage},10)">10</a></li>
            </c:if>
        </ul>
    </div>
    <div class="pull-right">
        <ul class="pagination">
            <li><a href="#" onclick="findPage(${currentPage}-1,${count})">&laquo;</a></li>
            <li class="active"><a href="#">${currentPage}</a></li>
            <li><a href="#" onclick="findPage(${currentPage}+1,${count})">&raquo;</a></li>
            <li class="disabled"><a>共</a></li>
            <li class="disabled"><a>${totalPage}</a></li>
            <li class="disabled"><a>页</a></li>
        </ul>
    </div>
</div>
<div class="modal fade" id="updateTeacher" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title text-center">Update Data</h3>
                    <div class="form-group">
                        <label for="tId" class="col-sm-2 control-label">ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tId">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tName" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tAge" class="col-sm-2 control-label">年级</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tAge">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tSex" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tSex">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tSchool" class="col-sm-2 control-label">学院</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tSchool">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tGraduate" class="col-sm-2 control-label">毕业院校</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tGraduate">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tText" class="col-sm-2 control-label">简介</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tText">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <div class="col-sm-4"><button type="button" class="btn btn-success" id="doupdate">修改</button></div>
                            <div class="col-sm-4"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="insertTeacher" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title text-center">Update Data</h3>
                    <div class="form-group">
                        <label for="tIdin" class="col-sm-2 control-label">ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tIdin">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tNamein" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tNamein">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tAgein" class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tAgein">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tSexin" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tSexin">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tSchoolin" class="col-sm-2 control-label">学院</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tSchoolin">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tGraduatein" class="col-sm-2 control-label">毕业院校</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tGraduatein">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tTextin" class="col-sm-2 control-label">简介</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tTextin">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <div class="col-sm-4"><button type="button" class="btn btn-success" id="doinsert">提交</button></div>
                            <div class="col-sm-4"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="queryTeacher" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title text-center">Get Data</h3>
                    <div class="form-group">
                        <label for="tIdqu" class="col-sm-2 control-label">ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tIdqu">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tNamequ" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tNamequ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tAgequ" class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tAgequ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tSexqu" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tSexqu">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tSchoolqu" class="col-sm-2 control-label">学院</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tSchoolqu">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tGraduatequ" class="col-sm-2 control-label">毕业院校</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tGraduatequ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tTextqu" class="col-sm-2 control-label">简介</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tTextqu">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <div class="col-sm-4 pull-right"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="deleteTeacher" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">确认删除？</h4>
                </div>
                <div class="modal-body">
                    确认删除<label id="tdelete"></label>这个教师吗?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="dodelete">确认</button>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="hidden">
    <form action="/system/teacher/findPage">
        <input id="startIndex" name="startIndex" value="">
        <input id="pageSize" name="pageSize" value="">
        <input id="totalCount" name="totalCount" value="">
        <button type="submit" id="submit"></button>
    </form>
</div>
</body>
<script>
    function delet(tId) {
        $('#tdelete').html(tId);
        $('#deleteTeacher').modal('show');
    }
    function update(tId,tName,tAge,tSex,tSchool,tGraduate,tText) {
        $('#tId').val(tId);
        $('#tName').val(tName);
        $('#tAge').val(tAge);
        $('#tSex').val(tSex);
        $('#tSchool').val(tSchool);
        $('#tGraduate').val(tGraduate);
        $('#tText').val(tText);
        $('#updateTeacher').modal('show');
    }
    function findPage(currentPage,count) {
        console.log(currentPage,count);
        var totalCount =${totalCount};
        if(currentPage<=0){
            alert("已经是第一页");
        }else if(currentPage>${totalPage}){
            alert("在最后一页了");
        }else {
            $('#startIndex').val(currentPage);
            $('#pageSize').val(count);
            $('#totalCount').val(totalCount);
            $('#submit').click();
        }
    }
</script>
</html>
