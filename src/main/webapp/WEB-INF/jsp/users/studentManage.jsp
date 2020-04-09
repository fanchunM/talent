<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>查看所有问题</title>
    <jsp:include page="../lib.jsp"></jsp:include>
    <link rel="stylesheet" href="resources/css/common/common.css">
    <script type="text/javascript" src="js/users/studentManage.js"></script>
</head>
<style type="text/css">
</style>
<body>
<div  class="easyui-layout" fit="true">
    <div data-options="region:'center',border:false">
        <table id="dataGridTable"></table>i
    </div>
    <div id="dataGridTableButtons" class="datagrid-toolbar-style">
        <a href="javascript:void(0);" class="easyui-linkbutton">搜索</a>
        <a href="javascript:void(0);" class="easyui-linkbutton">新增</a>
    </div>
</div>
</body>
</html>