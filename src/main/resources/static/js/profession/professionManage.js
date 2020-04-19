/**
 * 新增专业
 */
function submitProfession() {
    var id = $("#createProfessionDialog input[name = 'id']").val();
    var name = $("#createProfessionDialog input[name = 'name']").val();
    var codeIn = $("#createProfessionDialog input[name = 'codeIn']").val();
    var codeOut = $("#createProfessionDialog input[name = 'codeOut']").val();
    if ($.trim(name) == "" || $.trim(codeIn) == ""|| $.trim(codeOut) == "") {
        alert("必填项不能为空！");
        return;
    }

    $.ajax({
        url : "profession/create_profession",
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify({
            id : id,
            name : name,
            codeIn : codeIn,
            codeOut : codeOut
        }),
        success : function (data) {
            $.messager.alert("提示",(id == "")?"新建成功":"修改成功","info",function () {
                $("#professionForm").form("clear");
                $("#createProfessionDialog").dialog("close");
                $("#dataGridTable").datagrid("reload");
            })
        },
        error : function (data) {
            AjaxErrorHandler(data);
        }
    })
}

function openCreateProfessionDialog() {
    $("#professionForm").form("clear");
    $("#createProfessionDialog").dialog("open");
}

/**
 * 批量删除专业
 */
function deleteProfession() {
    var checkedItems = $('#dataGridTable').datagrid('getChecked');
    if (checkedItems.length == 0) {
        $.messager.alert("提示", "请选择要删除的专业", "info", function () {
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
                    url: 'profession/delete_profession',
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
function updateProfession(index) {
    $("#professionForm").form("clear");
    var rows = $("#dataGridTable").datagrid("getRows");
    var data = rows[index];
    $("#professionForm").form("load", data);
    $("#createProfessionDialog").dialog("open");
}

$(function(){
    /**
     * 查询专业
     */
    $('#dataGridTable').datagrid({
        url: 'profession/profession_manage',
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
                    return '<a href="javascript:void(0);" onClick="updateProfession(\''+index+'\');">修改</a> ';
                }},
            {field: 'name',title: '名称'},
            {field: 'codeIn',title: '校内码'},
            {field: 'codeOut',title: '校外码'}
        ]]
    });
});