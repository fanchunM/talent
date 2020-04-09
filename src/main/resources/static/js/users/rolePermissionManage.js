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
            {field: 'password',title: '密码'},
            {field: 'department',title: '系别'},
            {field: 'createTime',title: '创建时间'},
            {field: 'createBy',title: '创建人'},
            {field: 'gender',title: '性别'},
        ]]
    });
});