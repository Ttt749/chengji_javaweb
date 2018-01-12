/**
 * Created by WT on 2017/12/2.
 */
$(function () {
    $('#insert').on('click',function () {
        $('#insertCourese').modal('show');
    });
    $('#doinsert').on('click',function () {
        var course = {
            cId:$('#cIdin').val(),
            cName:$('#cNamein').val(),
            cAttr:$('#cAttrin').val(),
            cClassroom:$('#cClassroomin').val()
        };
        if(localStorage.getItem("userRole")>=2){
            if(course.cId==null||course.cId.length<=0||course.cName==null||course.cName.length<=0||course.cAttr==null||course.cAttr.length<=0||course.cClassroom==null||course.cClassroom.length<=0){
                alert("请补全课程信息");
            }else{
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/course/insertCourse",
                    data:JSON.stringify(course),
                    dataType:"json",
                    success:function (result) {
                        console.log(result);
                        if(result.result.msg=="添加成功"){
                            alert("添加成功");
                        }else{
                            alert("添加失败");
                        }
                        window.location.reload();
                    }
                })
            }
        }else {
            alert("权限不够");
        }
    });
    $('#doupdate').on('click',function () {
        var course = {
            cId:$('#cId').val(),
            cName:$('#cName').val(),
            cAttr:$('#cAttr').val(),
            cClassroom:$('#cClassroom').val()
        };
        if(localStorage.getItem("userRole")>=2){
            if(course.cId==null||course.cId.length<=0||course.cName==null||course.cName.length<=0||course.cAttr==null||course.cAttr.length<=0||course.cClassroom==null||course.cClassroom.length<=0){
                alert("请补全课程信息");
            }else{
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/course/updateCourse",
                    data:JSON.stringify(course),
                    dataType:"json",
                    success:function (result) {
                        console.log(result);
                        if(result.result.msg=="更新成功"){
                            alert("更新成功");
                        }else{
                            alert("更新失败");
                        }
                        window.location.reload();
                    },
                    error:function (data) {
                        alert("出错啦");
                    }
                })
            }
        }else {
            alert("权限不够");
        }
    });
    $('#dodelete').on('click',function () {
        if(localStorage.getItem("userRole")>=2){
            $.ajax({
                type:"post",
                url:"http://localhost:8080/system/course/deleteCourse",
                data:{
                    cId:$('#cdelete').html()
                },
                dataType:"json",
                success:function (result) {
                    console.log(result);
                    if(result.result.msg=="删除成功"){
                        alert("删除成功");
                    }else{
                        alert("删除失败");
                    }
                    window.location.reload();
                }
            })
        }else {
            alert("权限不够");
        }

    });
    $('#query').on('click',function () {
       if($('#queryCondition')==null||$('#queryCondition')==""){
           alert("请输入查询条件");
       }else{
           $.ajax({
               type:"post",
               url:"http://localhost:8080/system/course/queryCourse",
               data:{
                   cId:$('#queryCondition').val()
               },
               dataType:"json",
               success:function (result) {
                   console.log(result);
                   if(result.result.msg=="查询成功"){
                        var data = result.result.data;
                        $('#cIdqu').val(data.cId);
                        $('#cNamequ').val(data.cName);
                        $('#cAttrqu').val(data.cAttr);
                        $('#cClassroomqu').val(data.cClassroom);
                        $('#queryCourese').modal('show');
                   }else{
                       alert("查询失败");
                   }
               }
           })
       }
    });

    $('#insertCourese').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#insertCourese .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#updateCourese').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#updateCourese .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#deleteCourese').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#deleteCourese .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#queryCourese').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#queryCourese .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
});