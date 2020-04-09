<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>学生管理</title>
    <jsp:include page="../lib.jsp"></jsp:include>
    <link rel="stylesheet" href="resources/css/common/common.css">
    <script type="text/javascript" src="js/users/studentManage.js"></script>
</head>
<style type="text/css">
</style>
<body>
<div  class="easyui-layout" fit="true">
    <div data-options="region:'center',border:false">
        <table id="dataGridTable"></table>
    </div>
    <div id="dataGridTableButtons" class="datagrid-toolbar-style" style="padding: 5px;">
        <a href="javascript:void(0);" class="btn btn-info btn-sm" onclick="openCreateStudentDialog();">新增</a>
        <a href="javascript:void(0);" class="btn btn-danger btn-sm" onclick="deleteStudent();">删除</a>
    </div>
</div>
<div id="createStudentDialog" title="新增/修改" class="easyui-dialog" data-options="width:650, height:350, closed:true, buttons:'#createStudentDialogButtons'">
    <div class="container-fluid">
        <form id="studentForm">

        </form>
    </div>
</div>
<div id="createStudentDialogButtons">
    <button class="btn btn-success" onClick="createAddFailureLevelSubmit();" style="margin-right: 5px; margin-left: 5px;">
        <i class="fa fa-save align-top bigger-125" style="margin-right: 5px;"></i>保存
    </button>
    <button class="btn btn-warning" onClick="$('#createStudentDialog').dialog('close');" >
        <i class="fa fa-times bigger-125" style="margin-right: 5px;"></i>关闭
    </button>
</div>
</body>
</html>