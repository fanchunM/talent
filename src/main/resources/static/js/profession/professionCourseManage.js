/**
 * 新增专业课程
 */
function submitProfessionCourse() {
    var id = $("#createProfessionCourseDialog input[name = 'id']").val();
    var professionId = $("#professionId").combobox("getValue");
    var courseId = $("#courseId").combobox("getValue");

    var courseNature = $("#createProfessionCourseDialog input[name = 'courseNature']").val();
    var courseInCredits = $("#createProfessionCourseDialog input[name = 'courseInCredits']").val();
    var courseToalHours = $("#createProfessionCourseDialog input[name = 'courseToalHours']").val();
    var teaching = $("#createProfessionCourseDialog input[name = 'teaching']").val();
    var onbroad = $("#createProfessionCourseDialog input[name = 'onbroad']").val();
    var practice = $("#createProfessionCourseDialog input[name = 'practice']").val();
    var laboratory = $("#createProfessionCourseDialog input[name = 'laboratory']").val();
    var courseOutCredits = $("#createProfessionCourseDialog input[name = 'courseOutCredits']").val();
    var term1 = $("#createProfessionCourseDialog input[name = 'term1']").val();
    var term2 = $("#createProfessionCourseDialog input[name = 'term2']").val();
    var term3 = $("#createProfessionCourseDialog input[name = 'term3']").val();
    var term4 = $("#createProfessionCourseDialog input[name = 'term4']").val();
    var term5 = $("#createProfessionCourseDialog input[name = 'term5']").val();
    var term6 = $("#createProfessionCourseDialog input[name = 'term6']").val();
    var term7 = $("#createProfessionCourseDialog input[name = 'term7']").val();
    var term8 = $("#createProfessionCourseDialog input[name = 'term8']").val();
    if ($.trim(professionId) == "" || $.trim(courseId) == "") {
        alert("必填项不能为空！");
        return;
    }

    $.ajax({
        url : "profession/create_profession_course",
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify({
            id : id,
            professionId : professionId,
            courseId : courseId,
            courseNature : courseNature,
            courseInCredits : courseInCredits,
            courseToalHours : courseToalHours,
            teaching : teaching,
            onbroad : onbroad,
            practice : practice,
            laboratory : laboratory,
            courseOutCredits : courseOutCredits,
            term1 : term1,
            term2 : term2,
            term3 : term3,
            term4 : term4,
            term5 : term5,
            term6 : term6,
            term7 : term7,
            term8 : term8
        }),
        success : function (data) {
            $.messager.alert("提示",(id == "")?"新建成功":"修改成功","info",function () {
                $("#professionCourseForm").form("clear");
                $("#createProfessionCourseDialog").dialog("close");
                $("#dataGridTable").datagrid("reload");
            })
        },
        error : function (data) {
            AjaxErrorHandler(data);
        }
    })
}

function openCreateProfessionCourseDialog() {
    $("#professionCourseForm").form("clear");
    $("#createProfessionCourseDialog").dialog("open");
}

/**
 * 批量删除专业
 */
function deleteProfessionCourse() {
    var checkedItems = $('#dataGridTable').datagrid('getChecked');
    if (checkedItems.length == 0) {
        $.messager.alert("提示", "请选择要删除的专业课程", "info", function () {
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
                    url: 'profession/delete_profession_course',
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
function updateProfessionCourse(index) {
    $("#professionCourseForm").form("clear");
    var rows = $("#dataGridTable").datagrid("getRows");
    var data = rows[index];
    $("#professionCourseForm").form("load", data);
    $("#createProfessionCourseDialog").dialog("open");
}

$(function(){
    /**
     * 查询课程专业
     */
    $('#dataGridTable').datagrid({
        url: 'profession/profession_course_manage',
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
            {field: 'platformName',title: '平台'},
            {field: 'moudleName',title: '模块'},
            {field: 'courseCode',title: '课程代码'},
            {field: 'professionName',title: '专业名称'},
            {field: 'courseName',title: '课程名称'},
            {field: 'courseNature',title: '课程性质'},
            {field: 'courseInCredits',title: '课内学分'},
            {field: 'courseToalHours',title: '课内总学时'},
            {field: 'teaching',title: '授课'},
            {field: 'onbroad',title: '上机'},
            {field: 'practice',title: '课内实践'},
            {field: 'laboratory',title: '实验室实验'},
            {field: 'courseOutCredits',title: '课外学分'},
            {field: 'term1',title: '第一学期'},
            {field: 'term2',title: '第二学期'},
            {field: 'term3',title: '第三学期'},
            {field: 'term4',title: '第四学期'},
            {field: 'term5',title: '第五学期'},
            {field: 'term6',title: '第六学期'},
            {field: 'term7',title: '第七学期'},
            {field: 'term8',title: '第八学期'}
        ]]
    });
});