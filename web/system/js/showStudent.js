/**
 * Created by WT on 2017/12/4.
 */
$(function () {
    var role = localStorage.getItem("userRole");
    $('#insert').on('click',function () {
        $('#insertStudent').modal('show');
    });
    $('#doinsert').on('click',function () {
        var student = {
            sID:$('#sIdin').val(),
            sName:$('#sNamein').val(),
            sSex:$('#sSexin').val(),
            sAge:$('#sAgein').val(),
            sClass:$('#sClassin').val()
        };
        if(student.sID==null||student.sID.length<=0||student.sName==null||student.sName.length<=0||student.sSex==null||student.sSex.length<=0||student.sAge==null||student.sAge.length<=0){
            alert("请补全学生信息");
        }else{
            if(role>=3){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/student/insertStudent",
                    data:JSON.stringify(student),
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
        var student = {
            sID:$('#sId').val(),
            sName:$('#sName').val(),
            sSex:$('#sSex').val(),
            sAge:$('#sAge').val(),
            sClass:$('#sClass').val()
        };
        console.log(student);
        if(student.sID==null||student.sID.length<=0||student.sName==null||student.sName.length<=0||student.sSex==null||student.sSex.length<=0||student.sAge==null||student.sAge.length<=0){
            alert("请补全学生信息");
        }else{
            if(role>=3){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/student/updateStudent",
                    data:JSON.stringify(student),
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
                url:"http://localhost:8080/system/student/deleteStudent",
                data:{
                    sId:$('#sdelete').html()
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
            if(role>=3){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/student/queryStudent",
                    data:{
                        sId:$('#queryCondition').val()
                    },
                    dataType:"json",
                    success:function (result) {
                        console.log(result);
                        if(result.result.msg=="查询成功"){
                            var data = result.result.data;
                            $('#sIdqu').val(data.sID);
                            $('#sNamequ').val(data.sName);
                            $('#sSexqu').val(data.sSex);
                            $('#sAgequ').val(data.sAge);
                            $('#sClassqu').val(data.sClass);
                            $('#queryStudent').modal('show');
                        }else{
                            alert("查询失败");
                        }
                    }
                })
            }else {
                alert("权限不够");
            }
        }
    });

    $('#insertStudent').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#insertStudent .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#updateStudent').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#updateStudent .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#deleteStudent').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#deleteStudent .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#queryStudent').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#queryStudent .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
});