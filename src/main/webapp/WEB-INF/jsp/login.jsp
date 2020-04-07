<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="./lib.jsp"></jsp:include>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="js/login.js"></script>
    <title>test</title>
</head>
<script type="text/javascript">
    function submit() {
        var name = $("#name").val();
        var password = $("#password").val();
        $.ajax({
            url : 'user/login',
            type : "POST",
            data : JSON.stringify({
                name : name,
                password :password
            }),
            contentType : "application/json",
            dataType:"json",
            success : function (data) {
                $.messager.alert("提示","登陆成功！","info",function (data) {
                    location.href = "index";
                })
            },
            error : function (data) {
                AjaxErrorHandler(data);
            }
        })
    }
</script>
<body>
<div style="padding: 40px;margin-top: 10%;text-align: center;background-color: #1587e8">
    <div style="color: #ffffff;font-size: 36px;margin-bottom: 15px;">人才培养方案编制系统</div>
    <div style="border-radius: 10px; width: 500px;margin: 0 auto;background-color: #ffffff;padding: 50px;">
        <div>
            <div class="form-group">
                <input type="text" class="form-control" id="name" style="width: 80%; margin: 0 auto;" placeholder="用户名">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" style="width: 80%; margin: 0 auto;" placeholder="密码">
            </div>
            <div class="form-group">
                <select id="sideType" class="form-control" style="width: 80%; margin: 0 auto;">
                    <option value = "0" selected = "selected">学生</option>
                    <option value = "1">教师</option>
                    <option value = "1">管理员</option>
                </select>
            </div>
            <button id="login" class="btn btn-success" style="width: 80%;" onclick="submit()" onkeydown="enterLogin();">登&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;录</button>
        </div>
    </div>
</div>
</body>
