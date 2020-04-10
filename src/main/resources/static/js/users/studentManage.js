function submitStudent() {
    var userName = $("#createStudentDialog input[name = 'userName']").val();
    var chsName = $("#createStudentDialog input[name = 'chsName']").val();
    var password = $("#createStudentDialog input[name = 'password']").val();
    var gender = $("#createStudentDialog input[name = 'gender']").val();
    var isTeacher = $("#createStudentDialog input[name = 'isTeacher']").val();
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
            userName : userName,
            chsName : chsName,
            password : password,
            gender : gender,
            isTeacher : isTeacher,
            position : position,
            department : department
        }),
        success : function (data) {
            $.messager.alert("提示","新建成功","info",function () {
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

function deleteStudent() {
    var checkedItems = $('#dataGridTable').datagrid('getChecked');
    if (checkedItems.length == 0) {
        $.messager.alert("提示", "请选择要删除的学生", "info", function () {
            return;
        })
    }
}

$(function(){
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
            {field:'id',title:'操作', formatter: function(value,row){
                    return '<a href="javascript:void(0);" onClick="resetPwd(\''+value+'\');">修改</a> ';
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