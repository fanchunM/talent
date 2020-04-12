<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>角色权限管理</title>
    <jsp:include page="../lib.jsp"></jsp:include>
    <link rel="stylesheet" href="resources/css/common/common.css">
    <script type="text/javascript" src="js/users/rolePermissionManage.js"></script>
</head>
<style type="text/css">
    .add-div {
        margin-top: 10px;
    }
    .add-div-width {
        width:100%;
    }
    .add-div-font {
        font-size: 16px;
    }
</style>
<body>
<div  class="easyui-layout" fit="true">
    <div data-options="region:'center',border:false">
        <table id="dataGridTable"></table>
    </div>
    <div id="dataGridTableButtons" class="datagrid-toolbar-style" style="padding: 5px;">
        <a href="javascript:void(0);" class="btn btn-info btn-sm" onclick="openCreateRoleDialog();">新增</a>
        <a href="javascript:void(0);" class="btn btn-danger btn-sm" onclick="deleteRole();">删除</a>
    </div>
</div>

<%--新增和修改--%>
<div id="createRoleDialog" title="新增/修改" class="easyui-dialog" data-options="width:500, height:150, closed:true, buttons:'#createRoleDialogButtons'">
    <div class="container-fluid">
        <form id="roleForm">
            <input id="id" name="id" type="hidden" >
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    角色名
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="roleName" name="roleName" class="easyui-validatebox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
        </form>
    </div>
</div>
<div id="createRoleDialogButtons">
    <button class="btn btn-success" onClick="submitRole();" style="margin-right: 5px; margin-left: 5px;">
        <i class="fa fa-save align-top bigger-125" style="margin-right: 5px;"></i>保存
    </button>
    <button class="btn btn-warning" onClick="$('#createRoleDialog').dialog('close');" >
        <i class="fa fa-times bigger-125" style="margin-right: 5px;"></i>关闭
    </button>
</div>

<%--添加用户--%>
<div id="addUserDialog" title="添加用户" class="easyui-dialog" data-options="width:500, height:150, closed:true, buttons:'#addUserDialogButtons'">
    <div class="container-fluid">
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    选择用户
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="userId" class="easyui-combobox" data-options="url:'user/get_user',method:'GET', mode :'remote',
                    valueField: 'value',
                    textField: 'text'"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
    </div>
</div>
<div id="addUserDialogButtons">
    <button class="btn btn-success" onClick="submitRole();" style="margin-right: 5px; margin-left: 5px;">
        <i class="fa fa-save align-top bigger-125" style="margin-right: 5px;"></i>保存
    </button>
    <button class="btn btn-warning" onClick="$('#addUserDialog').dialog('close');" >
        <i class="fa fa-times bigger-125" style="margin-right: 5px;"></i>关闭
    </button>
</div>
</body>
</html>