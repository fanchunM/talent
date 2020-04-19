<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>专业课程管理</title>
    <jsp:include page="../lib.jsp"></jsp:include>
    <link rel="stylesheet" href="resources/css/common/common.css">
    <script type="text/javascript" src="js/profession/professionCourseManage.js"></script>
</head>
<style type="text/css">
    .add-div {
        margin-top: 10px;
    }
    .add-div-width {
        width:100%;
    }
    .add-div-font {
        font-size: 16px;
    }
</style>
<body>
<div  class="easyui-layout" fit="true">
    <div data-options="region:'center',border:false">
        <table id="dataGridTable"></table>
    </div>
    <div id="dataGridTableButtons" class="datagrid-toolbar-style" style="padding: 5px;">
        <a href="javascript:void(0);" class="btn btn-info btn-sm" onclick="openCreateProfessionCourseDialog();">新增</a>
        <a href="javascript:void(0);" class="btn btn-danger btn-sm" onclick="deleteProfessionCourse();">删除</a>
    </div>
</div>
<div id="createProfessionCourseDialog" title="新增/修改" class="easyui-dialog" data-options="width:500, height:500, closed:true, buttons:'#createProfessionCourseDialogButtons'">
    <div class="container-fluid">
        <form id="professionCourseForm">
            <input id="id" name="id" type="hidden" >
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    专业
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="professionId" name="professionId" class="easyui-combobox" data-options="url:'profession/get_profession',method:'GET', mode :'remote',valueField: 'value',textField: 'text'"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    课程
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="courseId" name="courseId" class="easyui-combobox" data-options="url:'course/get_course',method:'GET', mode :'remote',valueField: 'value',textField: 'text'"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    课程性质
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="courseNature" name="courseNature" class="textbox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    课内学分
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="courseInCredits" name="courseInCredits" class="textbox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    课内总学时
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="courseToalHours" name="courseToalHours" class="textbox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    授课
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="teaching" name="teaching" class="textbox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    上机
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="onbroad" name="onbroad" class="textbox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    课内实践
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="practice" name="practice" class="textbox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    实验室实验
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="laboratory" name="laboratory" class="textbox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>
            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    课外学分
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="courseOutCredits" name="courseOutCredits" class="textbox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div>




            <div class=" row add-div">
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                    第一学期
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                    <input id="term1" name="term1" class="textbox add-div-width" data-options="required:true"/>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            </div><div class=" row add-div">
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                第二学期
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                <input id="term2" name="term2" class="textbox add-div-width" data-options="required:true"/>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
        </div><div class=" row add-div">
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                第三学期
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                <input id="term3" name="term3" class="textbox add-div-width" data-options="required:true"/>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
        </div><div class=" row add-div">
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                第四学期
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                <input id="term4" name="term4" class="textbox add-div-width" data-options="required:true"/>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
        </div><div class=" row add-div">
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                第五学期
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                <input id="term5" name="term5" class="textbox add-div-width" data-options="required:true"/>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
        </div><div class=" row add-div">
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                第六学期
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                <input id="term6" name="term6" class="textbox add-div-width" data-options="required:true"/>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
        </div><div class=" row add-div">
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                第七学期
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                <input id="term7" name="term7" class="textbox add-div-width" data-options="required:true"/>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
        </div><div class=" row add-div">
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-center add-div-font">
                第八学期
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 text-left">
                <input id="term8" name="term8" class="textbox add-div-width" data-options="required:true"/>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 text-center"></div>
        </div>
        </form>
    </div>
</div>
<div id="createProfessionCourseDialogButtons">
    <button class="btn btn-success" onClick="submitProfessionCourse();" style="margin-right: 5px; margin-left: 5px;">
        <i class="fa fa-save align-top bigger-125" style="margin-right: 5px;"></i>保存
    </button>
    <button class="btn btn-warning" onClick="$('#createProfessionCourseDialog').dialog('close');" >
        <i class="fa fa-times bigger-125" style="margin-right: 5px;"></i>关闭
    </button>
</div>
</body>
</html>