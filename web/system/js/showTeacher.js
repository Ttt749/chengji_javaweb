/**
 * Created by WT on 2017/12/5.
 */
$(function () {
    var role = localStorage.getItem("userRole");
    $('#insert').on('click',function () {
        $('#insertTeacher').modal('show');
    });
    $('#doinsert').on('click',function () {
        var teacher = {
            tId:$('#tIdin').val(),
            tName:$('#tNamein').val(),
            tSex:$('#tSexin').val(),
            tAge:$('#tAgein').val(),
            tSchool:$('#tSchoolin').val(),
            tGraduate:$('#tGraduatein').val(),
            tText:$('#tTextin').val()
        };
        console.log(teacher);
        if(teacher.tId==null||teacher.tId.length<=0||teacher.tName==null||teacher.tName.length<=0||teacher.tSex==null||teacher.tSex.length<=0||teacher.tAge==null||teacher.tAge.length<=0){
            alert("请补全教师信息");
        }else{
            if(role>=3){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/teacher/insertTeacher",
                    data:JSON.stringify(teacher),
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
            }else {
                alert("权限不够");
            }

        }
    });
    $('#doupdate').on('click',function () {
        var teacher = {
            tId:$('#tId').val(),
            tName:$('#tName').val(),
            tSex:$('#tSex').val(),
            tAge:$('#tAge').val(),
            tSchool:$('#tSchool').val(),
            tGraduate:$('#tGraduate').val(),
            tText:$('#tText').val()
        };
        console.log(teacher);
        if(teacher.tId==null||teacher.tId.length<=0||teacher.tName==null||teacher.tName.length<=0||teacher.tSex==null||teacher.tSex.length<=0||teacher.tAge==null||teacher.tAge.length<=0){
            alert("请补全学生信息");
        }else{
            if(role>=2){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/teacher/updateTeacher",
                    data:JSON.stringify(teacher),
                    dataType:"json",
                    success:function (result) {
                        console.log(result);
                        if(result.result.msg=="更新成功"){
                            alert("更新成功");
                        }else{
                            alert("更新失败");
                        }
                        window.location.reload();
                    }
                })
            }else {
                alert("权限不够");
            }
        }
    });
    $('#dodelete').on('click',function () {
        if(role>=3){
            $.ajax({
                type:"post",
                url:"http://localhost:8080/system/teacher/deleteTeacher",
                data:{
                    tId:$('#tdelete').html()
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
                url:"http://localhost:8080/system/teacher/queryTeacher",
                data:{
                    tId:$('#queryCondition').val()
                },
                dataType:"json",
                success:function (result) {
                    console.log(result);
                    if(result.result.msg=="查询成功"){
                        var data = result.result.data;
                        $('#tIdqu').val(data.tId);
                        $('#tNamequ').val(data.tName);
                        $('#tSexqu').val(data.tSex);
                        $('#tAgequ').val(data.tAge);
                        $('#tSchoolqu').val(data.tSchool);
                        $('#tGraduatequ').val(data.tGraduate);
                        $('#tTextqu').val(data.tText);
                        $('#queryTeacher').modal('show');
                    }else{
                        alert("查询失败");
                    }
                }
            })
        }
    });

    $('#insertTeacher').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#insertTeacher .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#updateTeacher').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#updateTeacher .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#deleteTeacher').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#deleteTeacher .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#queryTeacher').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#queryTeacher .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
});