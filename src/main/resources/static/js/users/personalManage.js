function updatePwd() {
    var oldPwd = $("#oldPwd").val();
    var newPwd = $("#newPwd").val();
    var multiPwd = $("#multiPwd").val();
    if (oldPwd.trim() == "" || newPwd.trim() == "" || multiPwd.trim() == "") {
        $.messager.alert("提示", "必输项不能为空！", "info", function () {
            return;
        })
    } else if (newPwd != multiPwd) {
        $.messager.alert("提示", "两次密码输入不能相同！", "info", function () {
            return;
        })
    } else {
        $.ajax({
            url : "user/update_pwd",
            type : "POST",
            data : {
                oldPwd : oldPwd,
                newPwd : newPwd,
            },
            dataType : "json",
            success : function (data) {
                $.messager.alert("提示", "修改成功！请重新登录", "info", function () {
                    window.location.href = "logout";
                })
            },
            error : function (data) {
                AjaxErrorHandler(data);
            }
        })
    }
}