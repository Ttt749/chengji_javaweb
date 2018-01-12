/**
 * Created by WT on 2017/12/2.
 */
$(function () {
    var role = localStorage.getItem("userRole");
    $('#insert').on('click',function () {
        $('#insertUser').modal('show');
    });
    $('#doinsert').on('click',function () {
        var user = {
            userId:$('#userIdin').val(),
            userName:$('#userNamein').val(),
            userPassword:$('#userPasswordin').val(),
            userRole:$('#userRolein').val()
        };
        console.log(user);
        if(user.userId==null||user.userId.length<=0||user.userName==null||user.userName.length<=0||user.userPassword==null||user.userPassword.length<=0||user.userRole==null||user.userRole.length<=0){
            alert("请补全课程信息");
        }else{
            if(role>=4){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/user/insertUser",
                    data:JSON.stringify(user),
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
        var user = {
            userId:$('#userId').val(),
            userName:$('#userName').val(),
            userPassword:$('#userPassword').val(),
            userRole:$('#userRole').val()
        };
        console.log(user);
        if(user.userId==null||user.userId.length<=0||user.userName==null||user.userName.length<=0||user.userPassword==null||user.userPassword.length<=0||user.userRole==null||user.userRole.length<=0){
            alert("请补全课程信息");
        }else{
            if(role>=4){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/user/updateUser",
                    data:JSON.stringify(user),
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
        if(role>=4){
            $.ajax({
                type:"post",
                url:"http://localhost:8080/system/user/deleteUser",
                data:{
                    userId:$('#udelete').html()
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
            if(role>=4){
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/system/user/queryUser",
                    data:{
                        userName:$('#queryCondition').val()
                    },
                    dataType:"json",
                    success:function (result) {
                        console.log(result);
                        if(result.result.msg=="查询成功"){
                            var data = result.result.data;
                            $('#userIdqu').val(data.userId);
                            $('#userNamequ').val(data.userName);
                            $('#userPasswordqu').val(data.userPassword);
                            $('#userRolequ').val(data.userRole);
                            $('#queryUser').modal('show');
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

    $('#insertUser').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#insertUser .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#updateUser').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#updateUser .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#deleteUser').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#deleteUser .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
    $('#queryUser').on('shown.bs.modal', function (e) {
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
        $(this).css('display', 'block');
        var modalHeight=$(window).height() / 2 - $('#queryUser .modal-dialog').height() / 2;
        $(this).find('.modal-dialog').css({
            'margin-top': modalHeight
        });
    });
});