<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>个人信息管理</title>
    <jsp:include page="../lib.jsp"></jsp:include>
    <link rel="stylesheet" href="resources/css/common/common.css">
    <script type="text/javascript" src="js/users/personalManage.js"></script>
</head>
<style type="text/css">
</style>
<body>
<div  class="easyui-layout" fit="true">
    <div data-options="region:'center',border:false" style="font-size: large">
        <form id="pwdForm">
            <div class="row" style="text-align: center">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-right">
                    原密码:
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="oldPwd" type="password" class="textbox">
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>

            <div class="row" style="text-align: center;margin-top: 20px;">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-right">
                    新密码:
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="newPwd" type="password" class="textbox">
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class="row" style="text-align: center;margin-top: 20px;">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-right">
                    再次输入:
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="multiPwd" type="password" class="textbox">
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class="row" style="text-align: center;margin-top: 20px;">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-8 col-sm-8 col-md-8 text-center">
                    <input type="button" class="btn btn-success btn-lg" onclick="updatePwd();" value="保存"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>