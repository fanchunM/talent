<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>专业管理</title>
    <jsp:include page="../lib.jsp"></jsp:include>
    <link rel="stylesheet" href="resources/css/common/common.css">
    <script type="text/javascript" src="js/profession/professionManage.js"></script>
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
        <a href="javascript:void(0);" class="btn btn-info btn-sm" onclick="openCreateProfessionDialog();">新增</a>
        <a href="javascript:void(0);" class="btn btn-danger btn-sm" onclick="deleteProfession();">删除</a>
    </div>
</div>
<div id="createProfessionDialog" title="新增/修改" class="easyui-dialog" data-options="width:500, height:230, closed:true, buttons:'#createProfessionDialogButtons'">
    <div class="container-fluid">
        <form id="professionForm">
            <input id="id" name="id" type="hidden" >
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    专业名
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="name" name="name" class="easyui-validatebox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    校内码
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="codeIn" name="codeIn" class="easyui-validatebox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    校外码
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="codeOut" name="codeOut" class="easyui-validatebox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
        </form>
    </div>
</div>
<div id="createProfessionDialogButtons">
    <button class="btn btn-success" onClick="submitProfession();" style="margin-right: 5px; margin-left: 5px;">
        <i class="fa fa-save align-top bigger-125" style="margin-right: 5px;"></i>保存
    </button>
    <button class="btn btn-warning" onClick="$('#createProfessionDialog').dialog('close');" >
        <i class="fa fa-times bigger-125" style="margin-right: 5px;"></i>关闭
    </button>
</div>
</body>
</html>