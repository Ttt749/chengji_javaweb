<%@ page import="main.snnu.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: WT
  Date: 2017/12/1
  Time: 21:32
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
    <script src="${pageContext.request.contextPath}/system/js/showCourse.js"></script>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
%>
<div class="container">
    <table class="table table-hover" id="table1">
        <h1 class="text-center">课程信息表</h1>
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
            <th class="text-center">课程名</th>
            <th class="text-center">课程类别</th>
            <th class="text-center">课程教室</th>
            <th class="text-center">操作</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach var="course" items="${data}">
            <tr>
                <td>${course.cId}</td>
                <td>${course.cName}</td>
                <td>${course.cAttr}</td>
                <td>${course.cClassroom}</td>
                <td>
                    <button type="button" class="btn btn-info btn-sm" onclick="update('${course.cId}','${course.cName}','${course.cAttr}','${course.cClassroom}')">修改</button>
                    <button type="button" class="btn btn-danger btn-sm" onclick="delet('${course.cId}')">删除</button>
                    <button type="button" class="btn btn-success btn-sm" onclick="xuanke('${course.cId}','<%=user.getUserName()%>')">选课</button>
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
<div class="modal fade" id="updateCourese" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title text-center">Update Data</h3>
                    <div class="form-group">
                        <label for="cId" class="col-sm-2 control-label">ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cId">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cName" class="col-sm-2 control-label">课程名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cAttr" class="col-sm-2 control-label">课程类别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cAttr">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cClassroom" class="col-sm-2 control-label">课程教室</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cClassroom">
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
<div class="modal fade" id="insertCourese" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title text-center">Update Data</h3>
                    <div class="form-group">
                        <label for="cIdin" class="col-sm-2 control-label">ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cIdin">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cNamein" class="col-sm-2 control-label">课程名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cNamein">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cAttrin" class="col-sm-2 control-label">课程类别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cAttrin">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cClassroomin" class="col-sm-2 control-label">课程教室</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cClassroomin">
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
<div class="modal fade" id="queryCourese" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title text-center">Get Data</h3>
                    <div class="form-group">
                        <label for="cIdqu" class="col-sm-2 control-label">ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cIdqu">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cNamequ" class="col-sm-2 control-label">课程名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cNamequ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cAttrqu" class="col-sm-2 control-label">课程类别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cAttrqu">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cClassroomqu" class="col-sm-2 control-label">课程教室</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cClassroomqu">
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
<div class="modal fade" id="deleteCourese" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">确认删除？</h4>
                </div>
                <div class="modal-body">
                    确认删除<label id="cdelete"></label>这门课程吗?
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
    <form action="/system/course/findPage">
        <input id="startIndex" name="startIndex" value="">
        <input id="pageSize" name="pageSize" value="">
        <input id="totalCount" name="totalCount" value="">
        <button type="submit" id="submit"></button>
    </form>
</div>
</body>
<script>
        function delet(cId) {
            $('#cdelete').html(cId);
            $('#deleteCourese').modal('show');
        }
        function update(cId,cName,cAttr,cClassroom) {
            $('#cId').val(cId);
            $('#cName').val(cName);
            $('#cAttr').val(cAttr);
            $('#cClassroom').val(cClassroom);
            $('#updateCourese').modal('show');
        }
        function xuanke(cId,sId) {
            if(localStorage.getItem("userRole")==1){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/stucou/insertSC",
                    data:{
                        cId:cId,
                        sId:sId
                    },
                    dataType:"json",
                    success:function (result) {
                        console.log(result.result);
                        if(result.result.msg=="添加成功"){
                            alert("选课成功");
                        }else{
                            var ex = JSON.parse(JSON.stringify(result.result.exception));
                            console.log(ex.message);
                            alert("选课失败");
                        }
                        window.location.reload();
                    }
                })
            }else{
                alert("你不允许选课!");
            }

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
