function AjaxErrorHandler(data, callback) {
    var result = $.parseJSON(data.responseText);
    $.messager.alert('错误', result.message, 'error', function(){
        if(callback) callback();
    });
}