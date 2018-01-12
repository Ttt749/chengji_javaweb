/**
 * Created by WT on 2017/12/5.
 */
$(function () {
    var role =localStorage.getItem("userRole");
    $('#insert').on('click',function () {
        $('#insertTeacou').modal('show');
    });
    $('#doinsert').on('click',function () {
        var teacou = {
            tId:$('#tIdin').val(),
            cId:$('#cIdin').val()
        };
        console.log(teacou);
        if(teacou.tId==null||teacou.tId.length<=0||teacou.cId==null||teacou.cId.length<=0){
            alert("请补全信息");
        }else{
            if(role>=3){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/teacou/insertTeacou",
                    data:JSON.stringify(teacou),
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
        var teacou = {
            tId:$('#tId').val(),
            cId:$('#cId').val()
        };
        console.log(teacou);
        if(teacou.tId==null||teacou.tId.length<=0||teacou.cId==null||teacou.cId.length<=0){
            alert("请补全信息");
        }else{
            if(role>=3){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/teacou/updateTeacou",
                    data:JSON.stringify(teacou),
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
                url:"http://localhost:8080/system/teacou/deleteTeacou",
                data:{
                    tId:$('#tcdelete1').html(),
                    cId:$('#tcdelete2').html()
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
                url:"http://localhost:8080/system/teacou/queryTeacou",
                data:{
                    tId:$('#queryCondition').val()
                },
                dataType:"json",
                success:function (result) {
                    console.log(result);
                    if(result.result.msg=="查询成功"){
                        var data = result.result.data;
                        $('#tIdqu').val(data.tId);
                        $('#cIdqu').val(data.cId);
                        $('#queryteacou').modal('show');
                    }else{
                        alert("查询失败");
                    }
                }
            })
        }
    });

    $('#insertTeacou').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#insertTeacou .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#updateTeacou').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#updateTeacou .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#deleteTeacou').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#deleteteacou .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#queryTeacou').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#queryteacou .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
});