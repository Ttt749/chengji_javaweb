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
    <script src="${pageContext.request.contextPath}/system/js/showStucou.js"></script>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
%>
<div class="container">
    <table class="table table-hover" id="table1">
        <h1 class="text-center">成绩信息表</h1>
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
            <th class="text-center">学生id</th>
            <th class="text-center">课程id</th>
            <th class="text-center">成绩</th>
            <th class="text-center">操作</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach var="stucou" items="${data}">
            <tr>
                <td>${stucou.sId}</td>
                <td>${stucou.cId}</td>
                <td>${stucou.scScore}</td>
                <td>
                    <button type="button" class="btn btn-info btn-sm" onclick="update('${stucou.sId}','${stucou.cId}','${stucou.scScore}')">修改</button>
                    <button type="button" class="btn btn-danger btn-sm" onclick="delet('${stucou.sId},${stucou.cId}')">删除</button>
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
<div class="modal fade" id="updateStucou" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title text-center">Update Data</h3>
                    <div class="form-group">
                        <label for="sId" class="col-sm-2 control-label">学生id</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sId">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cId" class="col-sm-2 control-label">课程id</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cId">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="scScore" class="col-sm-2 control-label">成绩</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="scScore">
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
<div class="modal fade" id="insertStucou" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title text-center">Update Data</h3>
                    <div class="form-group">
                        <label for="sIdin" class="col-sm-2 control-label">学生id</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sIdin">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cIdin" class="col-sm-2 control-label">课程id</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cIdin">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="scScorein" class="col-sm-2 control-label">成绩</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="scScorein">
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
<div class="modal fade" id="queryStucou" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <h3 class="form-title text-center">Get Data</h3>
                    <div class="form-group">
                        <label for="sIdqu" class="col-sm-2 control-label">学生id</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sIdqu">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cIdqu" class="col-sm-2 control-label">课程id</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cIdqu">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="scScorequ" class="col-sm-2 control-label">成绩</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="scScorequ">
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
<div class="modal fade" id="deleteStucou" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">确认删除？</h4>
                </div>
                <div class="modal-body">
                    确认删除<label id="scdelete1"></label>-<label id="scdelete2"></label>>这条信息吗?
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
    <form action="/system/stucou/findPage">
        <input id="startIndex" name="startIndex" value="">
        <input id="pageSize" name="pageSize" value="">
        <input id="totalCount" name="totalCount" value="">
        <button type="submit" id="submit"></button>
    </form>
</div>
</body>
<script>
    function delet(sId,cId) {
        $('#scdelete1').html(sId);
        $('#scdelete2').html(cId);
        $('#deleteStucou').modal('show');
    }
    function update(sId,cId,scScore) {
        $('#sId').val(sId);
        $('#cId').val(cId);
        $('#scScore').val(scScore);
        $('#updateStucou').modal('show');
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
