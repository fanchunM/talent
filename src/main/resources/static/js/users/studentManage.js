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
            type : '2'
        },
        loadMsg: '程序处理中，请稍等...',
        columns:[[
            {field:'id',title:'操作', formatter: function(value,row){
                    var lookStr = '<a href="javascript:void(0);" onClick="look(\''+value+'\');">查看</a> ';
                    var resetStr = '<a href="javascript:void(0);" onClick="resetPwd(\''+value+'\');">修改</a> ';
                    var deleteStr = '<a href="javascript:void(0);" onClick="resetPwd(\''+value+'\');">删除</a> ';
                    var returnStr = lookStr + resetStr + deleteStr;
                    return returnStr;
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