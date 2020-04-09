function openIframeUrl(url, supertitle,title, liself){
        var naviBar = '<i class="fa fa-angle-right" style="font-size: larger;"></i>';
        $('#content_frame').attr('src', url);
        title1="<span style='color: #337ab7;'>"+title+"</span>"
        // $('#content_title').html(naviBar+' '+supertitle+' '+naviBar+' '+title1);
        $('#content_title').html(supertitle+' '+naviBar+' '+title1);

        //改变选中字体颜色
        $(".submenu").find("span").removeClass("colorselect");
        $(liself).find("span").addClass("colorselect");
}

function openIframeUrlReturn(url, supertitle, title){
    var naviBar = '<i class="fa fa-angle-right" style="font-size: larger;"></i>';
    $('#content_frame').attr('src', url);
    title1="<span style='color: #337ab7;'>"+title+"</span>"
    // $('#content_title').html(naviBar+' '+supertitle+' '+naviBar+' '+title1);
    $('#content_title').html(supertitle+' '+naviBar+' '+title1);

    //改变选中字体颜色
    $(".submenu").find("span").removeClass("colorselect");

}

function logout(){
    var signOutUrl = '/'
    try {
        document.execCommand("ClearAuthenticationCache");
    }
    catch (e) {
        //
    }
    finally {
        window.location.href = signOutUrl;
    }
}

