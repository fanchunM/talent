function openCreateRoleDialog() {
    $("#roleForm").form("clear");
    $("#createRoleDialog").dialog("open");
}

/**
 * 新增角色
 */
function submitRole() {
    var id = $("#createRoleDialog input[name = 'id']").val();
    var roleName = $("#createRoleDialog input[name = 'roleName']").val();
    if ($.trim(roleName) == "") {
        alert("必填项不能为空！");
        return;
    }

    $.ajax({
        url : "user/create_role",
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify({
            id : id,
            roleName : roleName
        }),
        success : function (data) {
            $.messager.alert("提示",(id == "")?"新建成功":"修改成功","info",function () {
                $("#roleForm").form("clear");
                $("#createRoleDialog").dialog("close");
                $("#dataGridTable").datagrid("reload");
            })
        },
        error : function (data) {
            AjaxErrorHandler(data);
        }
    })
}

/**
 * 修改数据
 */
function updateRole(index) {
    $("#roleForm").form("clear");
    var rows = $("#dataGridTable").datagrid("getRows");
    var data = rows[index];
    $("#roleForm").form("load", data);
    $("#createRoleDialog").dialog("open");
}

/**
 * 批量删除角色
 */
function deleteRole() {
    var checkedItems = $('#dataGridTable').datagrid('getChecked');
    if (checkedItems.length == 0) {
        $.messager.alert("提示", "请选择要删除的角色", "info", function () {
            return;
        })
    } else {
        var ids = [];
        $.each(checkedItems, function () {
            ids.push(this.id);
        });
        $.messager.confirm('确定', '确定要删除吗?', function(r) {
            if (r) {
                $.ajax({
                    url: 'user/delete_role',
                    type: 'POST',
                    data: JSON.stringify(ids),
                    contentType : "application/json",
                    dataType : "json",
                    success: function (data) {
                        $.messager.alert('提示', '删除成功!', 'info',function() {
                            $('#dataGridTable').datagrid('reload');
                        });
                    },
                    error: function (data) {
                        AjaxErrorHandler(data);
                    }
                });
            }
        });
    }
}

function openLinkUserDialog(roleId) {
    $("#addUserDialog input[name='roleId']").val(roleId);
    $("#userId").combobox("reload");
    $('#roleUserDataGridTable').datagrid({
        url: 'user/get_role_user',
        method: 'GET',
        toolbar: '#roleUserDataGridTableButtons',
        fit: true,
        striped: true,
        rowNumbers: true,
        singleSelect: false,
        pagination: true,
        pageSize: 20,
        loadMsg: '程序处理中，请稍等...',
        queryParams : {
            roleId : roleId
        },
        columns:[[
            {field:'id',title:'操作', formatter: function(value, row, index){
                    var deleteStr = '<a href="javascript:void(0);" onClick="deleteRoleUser(\''+value+'\');">删除</a> ';
                    return deleteStr;
                }},
            {field: 'userName',title: '用户名'},
            {field: 'chsName',title: '中文名'},
            {field: 'gender',title: '性别'},
            {field: 'department',title: '系别'}
        ]]
    });
    $("#addUserDialog").dialog("open");
}

/**
 * 删除角色用户
 */
function deleteRoleUser(id) {
    var roleId = $("#addUserDialog input[name='roleId']").val();
    $.ajax({
        url : "user/delete_role_user",
        type : "POST",
        data : {userId :id, roleId : roleId},
        success : function (data) {
            $('#roleUserDataGridTable').datagrid("reload");
        },
        error : function (data) {
            AjaxErrorHandler(data);
        }
    })
}

/**
 * 添加用户
 */
function addRoleUser() {
    var roleId = $("#addUserDialog input[name='roleId']").val();
    var userId = $("#userId").combobox("getValue");
    if (userId.trim() == "") {
        $.messager.alert("提示", "请选择用户", "info", function () {
            return;
        })
    } else {
        $.ajax({
            url : "user/add_role_user",
            type : "POST",
            dataType : "json",
            data : {roleId : roleId, userId : userId},
            success : function (data) {
                $("#userId").combobox("reload");
                $('#roleUserDataGridTable').datagrid("reload");
            },
            error : function (data) {
                AjaxErrorHandler(data);
            }
        })
    }
}

function openLinkMenuDialog(roleId) {
    $("#addMenuDialog input[name='roleId']").val(roleId);
    $('#menuTree').tree({
        url: 'user/get_role_menu?roleId=' + roleId,
        method:"GET",
        checkbox:true,
        onClick: function(node){
        },
    });
    $("#addMenuDialog").dialog("open");
}

function submitRoleMenu() {
    var set = new Set();
    var nodes = $('#menuTree').tree('getChecked');

    for(var node in nodes){
        var parentNode = $('#menuTree').tree('getParent', nodes[node].target);
        if(parentNode)
            set.add(parentNode.id);
        set.add(nodes[node].id);
    }

    var roleId = $('#addMenuDialog input[name="roleId"]').val();
    var menuIdArray = Array.from(set);
    $.ajax({
        url: 'user/add_role_menu',
        type: 'POST',
        data: {
            menuIdArray: JSON.stringify(menuIdArray),
            roleId: roleId
        },
        success: function(){
            $.messager.alert('提示', '变更成功！', 'info',function(){
                top.location.reload();
            });
        },
        error: function(data){
            AjaxErrorHandler(data);
        }
    });
}

$(function(){
    $('#dataGridTable').datagrid({
        url: 'user/role_manage',
        method: 'GET',
        toolbar: '#dataGridTableButtons',
        fit: true,
        striped: true,
        rowNumbers: true,
        singleSelect: false,
        pagination: true,
        pageSize: 20,
        loadMsg: '程序处理中，请稍等...',
        columns:[[
            {field: 'ck',checkbox: 'true'},
            {field:'id',title:'操作', formatter: function(value, row, index){
                    var updateStr = '<a href="javascript:void(0);" onClick="updateRole(\''+index+'\');">修改</a> ';
                    var userStr = '<a href="javascript:void(0);" onClick="openLinkUserDialog(\''+value+'\');">关联用户</a> ';
                    var menuStr = '<a href="javascript:void(0);" onClick="openLinkMenuDialog(\''+value+'\');">关联菜单</a>';
                    return updateStr + userStr + menuStr;
                }},
            {field: 'roleName',title: '角色名'},
        ]]
    });
});