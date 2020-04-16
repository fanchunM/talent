<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>平台管理</title>
    <jsp:include page="../lib.jsp"></jsp:include>
    <link rel="stylesheet" href="resources/css/common/common.css">
    <script type="text/javascript" src="js/users/platformManage.js"></script>
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
        <a href="javascript:void(0);" class="btn btn-info btn-sm" onclick="openCreatePlatformDialog();">新增</a>
        <a href="javascript:void(0);" class="btn btn-danger btn-sm" onclick="deletePlatform();">删除</a>
    </div>
</div>
<div id="createPlatformDialog" title="新增/修改" class="easyui-dialog" data-options="width:500, height:150, closed:true, buttons:'#createPlatformDialogButtons'">
    <div class="container-fluid">
        <form id="platForm">
            <input id="id" name="id" type="hidden" >
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    名称
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="name" name="name" class="easyui-validatebox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
        </form>
    </div>
</div>
<div id="createPlatformDialogButtons">
    <button class="btn btn-success" onClick="submitPlatform();" style="margin-right: 5px; margin-left: 5px;">
        <i class="fa fa-save align-top bigger-125" style="margin-right: 5px;"></i>保存
    </button>
    <button class="btn btn-warning" onClick="$('#createPlatformDialog').dialog('close');" >
        <i class="fa fa-times bigger-125" style="margin-right: 5px;"></i>关闭
    </button>
</div>
</body>
</html>