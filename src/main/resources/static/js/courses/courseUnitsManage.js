/**
 * 新增开课单位
 */
function submitCourseUnits() {
    var id = $("#createCourseUnitsDialog input[name = 'id']").val();
    var name = $("#createCourseUnitsDialog input[name = 'name']").val();
    if ($.trim(name) == "") {
        alert("必填项不能为空！");
        return;
    }

    $.ajax({
        url : "course/create_course_units",
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify({
            id : id,
            name : name
        }),
        success : function (data) {
            $.messager.alert("提示",(id == "")?"新建成功":"修改成功","info",function () {
                $("#courseUnitsForm").form("clear");
                $("#createCourseUnitsDialog").dialog("close");
                $("#dataGridTable").datagrid("reload");
            })
        },
        error : function (data) {
            AjaxErrorHandler(data);
        }
    })
}

function openCreateCourseUnitsDialog() {
    $("#courseUnitsForm").form("clear");
    $("#createCourseUnitsDialog").dialog("open");
}

/**
 * 批量删除开课单位
 */
function deleteCourseUnits() {
    var checkedItems = $('#dataGridTable').datagrid('getChecked');
    if (checkedItems.length == 0) {
        $.messager.alert("提示", "请选择要删除的开课单位", "info", function () {
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
                    url: 'course/delete_course_units',
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
function updateCourseUnits(index) {
    $("#courseUnitsForm").form("clear");
    var rows = $("#dataGridTable").datagrid("getRows");
    var data = rows[index];
    $("#courseUnitsForm").form("load", data);
    $("#createCourseUnitsDialog").dialog("open");
}

$(function(){
    /**
     * 查询开课单位
     */
    $('#dataGridTable').datagrid({
        url: 'course/course_units',
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
                    return '<a href="javascript:void(0);" onClick="updateCourseUnits(\''+index+'\');">修改</a> ';
                }},
            {field: 'name',title: '名称'}
        ]]
    });
});