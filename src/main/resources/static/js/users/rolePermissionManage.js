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


function openLinkUserDialog() {

    $("#addUserDialog").dialog("open");

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
                    var userStr = '<a href="javascript:void(0);" onClick="openLinkUserDialog();">关联用户</a> ';
                    var menuStr = '<a href="javascript:void(0);" onClick="updateRole(\''+index+'\');">关联菜单</a>';
                    return updateStr + userStr + menuStr;
                }},
            {field: 'roleName',title: '角色名'},
        ]]
    });
});