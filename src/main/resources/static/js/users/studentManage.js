/**
 * 新增学生
 */
function submitStudent() {
    var id = $("#createStudentDialog input[name = 'id']").val();
    var userName = $("#createStudentDialog input[name = 'userName']").val();
    var chsName = $("#createStudentDialog input[name = 'chsName']").val();
    var password = $("#createStudentDialog input[name = 'password']").val();
    var gender = $("#createStudentDialog input[name = 'gender']").val();
    //学生
    var isTeacher = "0";
    var position = $("#createStudentDialog input[name = 'position']").val();
    var department = $("#createStudentDialog input[name = 'department']").val();
    if ($.trim(userName) == "" || $.trim(chsName) == "" || $.trim(password) == "" || $.trim(gender) == "" || $.trim(isTeacher) == "" || $.trim(position) == "" || $.trim(department) == "") {
        alert("必填项不能为空！");
        return;
    }

    $.ajax({
        url : "user/create_student",
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify({
            id : id,
            userName : userName,
            chsName : chsName,
            password : password,
            gender : gender,
            isTeacher : isTeacher,
            position : position,
            department : department
        }),
        success : function (data) {
            $.messager.alert("提示",(id == "")?"新建成功":"修改成功","info",function () {
                $("#studentForm").form("clear");
                $("#createStudentDialog").dialog("close");
                $("#dataGridTable").datagrid("reload");
            })
        },
        error : function (data) {
            AjaxErrorHandler(data);
        }
    })
}

function openCreateStudentDialog() {
    $("#studentForm").form("clear");
    $("#createStudentDialog").dialog("open");
}

/**
 * 批量删除学生
 */
function deleteStudent() {
    var checkedItems = $('#dataGridTable').datagrid('getChecked');
    if (checkedItems.length == 0) {
        $.messager.alert("提示", "请选择要删除的学生", "info", function () {
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
                    url: 'user/delete_student_or_teacher',
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
function updateStudentOrTeacher(index) {
    $("#studentForm").form("clear");
    var rows = $("#dataGridTable").datagrid("getRows");
    var data = rows[index];
    $("#studentForm").form("load", data);
    $("#createStudentDialog").dialog("open");
}

$(function(){
    /**
     * 查询学生
     */
    $('#dataGridTable').datagrid({
        url: 'user/student_manage',
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
                    return '<a href="javascript:void(0);" onClick="updateStudentOrTeacher(\''+index+'\');">修改</a> ';
                }},
            {field: 'userName',title: '用户名'},
            {field: 'chsName',title: '中文名'},
            {field: 'gender',title: '性别'},
            {field: 'password',title: '密码'},
            {field: 'department',title: '系别'},
            {field: 'createTimeStr',title: '创建时间'},
            {field: 'createByStr',title: '创建人'}
        ]]
    });
});