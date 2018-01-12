/**
 * Created by WT on 2017/12/5.
 */
$(function () {
    var role = localStorage.getItem("userRole");
    $('#insert').on('click',function () {
        $('#insertStucou').modal('show');
    });
    $('#doinsert').on('click',function () {
        var stucou = {
            sId:$('#sIdin').val(),
            cId:$('#cIdin').val(),
            scScore:$('#scScorein').val()
        };
        console.log(stucou);
        if(stucou.sId==null||stucou.sId.length<=0||stucou.cId==null||stucou.cId.length<=0||stucou.scScore==null||stucou.scScore.length<=0){
            alert("请补全信息");
        }else{
            if(role>=1){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/stucou/insertStucou",
                    data:JSON.stringify(stucou),
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
        var stucou = {
            sId:$('#sId').val(),
            cId:$('#cId').val(),
            scScore:$('#scScore').val()
        };
        if(stucou.sId==null||stucou.sId.length<=0||stucou.cId==null||stucou.cId.length<=0||stucou.scScore==null||stucou.scScore.length<=0){
            alert("请补全信息");
        }else{
            if(role>=2){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/stucou/updateStucou",
                    data:JSON.stringify(stucou),
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
        if(role>=2) {
            $.ajax({
                type:"post",
                url:"http://localhost:8080/system/stucou/deleteStucou",
                data:{
                    sId:$('#scdelete1').html(),
                    cId:$('#scdelete2').html()
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
                url:"http://localhost:8080/system/stucou/queryStucou",
                data:{
                    sId:$('#queryCondition').val()
                },
                dataType:"json",
                success:function (result) {
                    console.log(result);
                    if(result.result.msg=="查询成功"){
                        var data = result.result.data;
                        $('#sIdqu').val(data.sId);
                        $('#cIdqu').val(data.cId);
                        $('#scScorequ').val(data.scScore);
                        $('#queryStucou').modal('show');
                    }else{
                        alert("查询失败");
                    }
                }
            })
        }
    });

    $('#insertStucou').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#insertStucou .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#updateStucou').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#updateStucou .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#deleteStucou').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#deleteStucou .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#queryStucou').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#queryStucou .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
});