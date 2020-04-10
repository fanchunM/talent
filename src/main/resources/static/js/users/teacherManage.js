function openCreateTeacherDialog() {
    $("#teacherForm").form("clear");
    $("#createTeacherDialog").dialog("open");
}

function deleteTeacher() {
    var checkedItems = $('#dataGridTable').datagrid('getChecked');
    if (checkedItems.length == 0) {
        $.messager.alert("提示", "请选择要删除的教师", "info", function () {
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
            type : '1'
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