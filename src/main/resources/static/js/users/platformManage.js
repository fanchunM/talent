/**
 * 新增学生
 */
function submitPlatform() {
    var id = $("#createPlatformDialog input[name = 'id']").val();
    var name = $("#createPlatformDialog input[name = 'name']").val();
    if ($.trim(name) == "") {
        alert("必填项不能为空！");
        return;
    }

    $.ajax({
        url : "user/create_platform",
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify({
            id : id,
            name : name
        }),
        success : function (data) {
            $.messager.alert("提示",(id == "")?"新建成功":"修改成功","info",function () {
                $("#platForm").form("clear");
                $("#createPlatformDialog").dialog("close");
                $("#dataGridTable").datagrid("reload");
            })
        },
        error : function (data) {
            AjaxErrorHandler(data);
        }
    })
}

function openCreatePlatformDialog() {
    $("#platForm").form("clear");
    $("#createPlatformDialog").dialog("open");
}

/**
 * 批量删除平台
 */
function deletePlatform() {
    var checkedItems = $('#dataGridTable').datagrid('getChecked');
    if (checkedItems.length == 0) {
        $.messager.alert("提示", "请选择要删除的平台", "info", function () {
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
                    url: 'user/delete_platform',
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

/**
 * 修改数据
 */
function updatePlatform(index) {
    $("#platForm").form("clear");
    var rows = $("#dataGridTable").datagrid("getRows");
    var data = rows[index];
    $("#platForm").form("load", data);
    $("#createPlatformDialog").dialog("open");
}

$(function(){
    /**
     * 查询平台
     */
    $('#dataGridTable').datagrid({
        url: 'user/platform_manage',
        method: 'GET',
        toolbar: '#dataGridTableButtons',
        fit: true,
        striped: true,
        rowNumbers: true,
        singleSelect: false,
        pagination: true,
        pageSize: 20,
        queryParams: {
            type : '0'
        },
        loadMsg: '程序处理中，请稍等...',
        columns:[[
            {field: 'ck',checkbox: 'true'},
            {field:'id',title:'操作', formatter: function(value, row, index){
                    return '<a href="javascript:void(0);" onClick="updatePlatform(\''+index+'\');">修改</a> ';
                }},
            {field: 'name',title: '名称'}
        ]]
    });
});