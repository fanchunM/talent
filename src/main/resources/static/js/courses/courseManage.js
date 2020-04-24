/**
 * 新增课程
 */
function submitCourse() {
    var id = $("#createCourseDialog input[name = 'id']").val();
    var name = $("#createCourseDialog input[name = 'name']").val();
    var code = $("#createCourseDialog input[name = 'code']").val();
    var moudleId = $("#moudleId").combobox("getValue");
    var courseUnitsId = $("#courseUnitsId").combobox("getValue");
    if ($.trim(name) == "" || $.trim(code) == ""|| $.trim(moudleId) == ""|| $.trim(courseUnitsId) == "") {
        alert("必填项不能为空！");
        return;
    }


    $.ajax({
        url : "course/create_course",
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify({
            id : id,
            name : name,
            code : code,
            moudleId : moudleId,
            courseUnitsId : courseUnitsId

        }),
        success : function (data) {
            $.messager.alert("提示",(id == "")?"新建成功":"修改成功","info",function () {
                $("#courseForm").form("clear");
                $("#createCourseDialog").dialog("close");
                $("#dataGridTable").datagrid("reload");
            })
        },
        error : function (data) {
            AjaxErrorHandler(data);
        }
    })
}

function openCreateCourseDialog() {
    $("#courseForm").form("clear");
    $("#createCourseDialog").dialog("open");
}

/**
 * 批量删除课程
 */
function deleteCourse() {
    var checkedItems = $('#dataGridTable').datagrid('getChecked');
    if (checkedItems.length == 0) {
        $.messager.alert("提示", "请选择要删除的课程", "info", function () {
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
                    url: 'course/delete_course',
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
function updateCourse(index) {
    $("#courseForm").form("clear");
    var rows = $("#dataGridTable").datagrid("getRows");
    var data = rows[index];
    $("#courseForm").form("load", data);
    $("#createCourseDialog").dialog("open");
}

$(function(){
    /**
     * 查询课程
     */
    $('#dataGridTable').datagrid({
        url: 'course/course_manage',
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
                    return '<a href="javascript:void(0);" onClick="updateCourse(\''+index+'\');">修改</a> ';
                }},
            {field: 'name',title: '名称'},
            {field: 'code',title: '课程编码'},
            {field: 'platformName',title: '平台'},
            {field: 'moudleName',title: '模块'},
            {field: 'moudleId',hidden:'true'},
            {field: 'courseUnitsName',title: '开课单位'},
            {field: 'courseUnitsId',hidden:'true'}
        ]]
    });
});