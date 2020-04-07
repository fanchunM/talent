<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>

    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="common/ace/css/bootstrap.min.css" />
    <link rel="stylesheet" href="common/fontawesome/css/font-awesome.min.css"/>

    <!-- text fonts -->
    <link rel="stylesheet" href="common/ace/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="common/ace/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="common/ace/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="common/ace/css/ace-skins.min.css" />
    <link rel="stylesheet" href="common/ace/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="common/ace/css/ace-ie.min.css" />
    <![endif]-->

    <!-- ace settings handler -->
    <script src="common/ace/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="common/ace/js/html5shiv.min.js"></script>
    <script src="common/ace/js/respond.min.js"></script>
    <![endif]-->
</head>
<style type="text/css">
    .colorselect {
        color: #3bb6f9;
    }
</style>
<body class="no-skin">
<%--<input id="isDutymanager" type="hidden" value="${isDutymanager }">--%>
<%--<input id="loginUserId" type="hidden" value="${userInfoDto.loginedUserId}">--%>
<div id="navbar" class="navbar navbar-default ace-save-state navbar-fixed-top">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <!-- logo -->
        <div class="navbar-header pull-left">
            <img src="pic/logo.png" style="padding-top:5px; height: 55px;"></img>
        </div>
        <!-- 快捷菜单 -->
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);" onclick="logout();">
                        <span class="ace-icon fa fa-power-off"></span>
                        <span>登出</span>
                    </a>
                </li>
            </ul>
        </div>
    </div><!-- /.navbar-container -->
</div>
<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <div id="sidebar" class="sidebar responsive ace-save-state sidebar-fixed">
        <script type="text/javascript">
            try{ace.settings.loadState('sidebar')}catch(e){}
        </script>

        <ul class="nav nav-list">
            <li class="active">
                <a href="index.html">
                    <i class="fa fa-user-circle-o bigger-125" aria-hidden="true"></i>
                    <span class="menu-text">&nbsp;&nbsp;欢迎您， ${loginUserDto.chsName }</span>
                </a>
            </li>
            <!-- 动态菜单 -->
            <li class="">
                <a href="javascript:void(0);" class="dropdown-toggle" onclick="changeArrow(this);" >
                    <span class="menu-text"><i class="fa fa-question-circle" style="margin-right: 5px;"></i>专业信息管理</span>
                    <b class="arrow fa fa-angle-right"></b>
                </a>
                <ul class="submenu nav-hide" style="display: none;">
                    <li class="">
                        <a onclick="openIframeUrl('issue_all', '专业信息管理','计算机科学与技术', this);" style="cursor: pointer;">
                            <span class="menu-text colorselect"><i class="fa fa-list" style="margin-right: 5px;"></i>计算机科学与技术</span>
                        </a>
                    </li>
                    <li class="">
                        <a onclick="openIframeUrl('issue_mine', '专业信息管理','软件工程', this);" style="cursor: pointer;">
                            <span class="menu-text"><i class="fa fa-transgender" style="margin-right: 5px;"></i>软件工程</span>
                        </a>
                    </li>
                    <li class="">
                        <a onclick="openIframeUrl('issue_mine', '专业信息管理','网路工程', this);" style="cursor: pointer;">
                            <span class="menu-text"><i class="fa fa-transgender" style="margin-right: 5px;"></i>网路工程</span>
                        </a>
                    </li>
                    <li class="">
                        <a onclick="openIframeUrl('issue_mine', '专业信息管理','网路空间安全', this);" style="cursor: pointer;">
                            <span class="menu-text"><i class="fa fa-transgender" style="margin-right: 5px;"></i>网路空间安全</span>
                        </a>
                    </li>
                </ul>
            </li>

            <%--课程信息管理--%>
            <li class="">
                <a href="javascript:void(0);" class="dropdown-toggle" onclick="changeArrow(this);" >
                    <span class="menu-text"><i class="fa fa-question-circle" style="margin-right: 5px;"></i>课程信息管理</span>
                    <b class="arrow fa fa-angle-right"></b>
                </a>
                <ul class="submenu nav-hide" style="display: none;">
                    <li class="">
                        <a onclick="openIframeUrl('issue_all', '课程信息管理','查看所有问题', this);" style="cursor: pointer;">
                            <span class="menu-text colorselect"><i class="fa fa-list" style="margin-right: 5px;"></i>查看所有问题</span>
                        </a>
                    </li>
                    <li class="">
                        <a onclick="openIframeUrl('issue_mine', '课程信息管理','与我相关问题', this);" style="cursor: pointer;">
                            <span class="menu-text"><i class="fa fa-transgender" style="margin-right: 5px;"></i>与我相关问题</span>
                        </a>
                    </li>
                </ul>
            </li>

            <%--用户信息管理--%>
            <li class="">
                <a href="javascript:void(0);" class="dropdown-toggle" onclick="changeArrow(this);" >
                    <span class="menu-text"><i class="fa fa-question-circle" style="margin-right: 5px;"></i>用户信息管理</span>
                    <b class="arrow fa fa-angle-right"></b>
                </a>
                <ul class="submenu nav-hide" style="display: none;">
                    <li class="">
                        <a onclick="openIframeUrl('issue_all', '用户信息管理','学生管理', this);" style="cursor: pointer;">
                            <span class="menu-text colorselect"><i class="fa fa-list" style="margin-right: 5px;"></i>学生管理</span>
                        </a>
                    </li>
                    <li class="">
                        <a onclick="openIframeUrl('issue_mine', '用户信息管理','教师管理', this);" style="cursor: pointer;">
                            <span class="menu-text"><i class="fa fa-transgender" style="margin-right: 5px;"></i>教师管理</span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <div class="page-header" style="position: absolute;left: 20px;right: 20px;">
                    <div>
                        <%--<span style="font-size: 18px; color: #C70039;">--%>
                        <%--<i class="fa fa-home bigger-125"></i>--%>
                        <%--</span>--%>
                        <%--<span style="font-size: 15px;">主页</span>--%>
                        <i class="ace-icon fa fa-map-marker" style="margin-right: 3px;color: #ccc;font-size: 16px;"></i>
                        <span id="content_title"></span>
                    </div>
                </div><!-- /.page-header -->

                <div style="height: 100%;padding-bottom: 20px;padding-top: 50px;">
                    <iframe id="content_frame" class="embed-responsive-item" src="" style="width: 100%;height: 100%;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe>
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
				<span class="bigger-80">
					Copyright 2020 三江学院 技术支持：网络工程-孟凡春(12016054002)
				</span>
            </div>
        </div>
    </div>
</div><!-- /.main-container -->

<!-- basic scripts -->
<!--[if !IE]> -->
<script src="common/ace/js/jquery-2.1.4.min.js"></script>
<!-- <![endif]-->

<!--[if IE]>
<script src="common/ace/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="common/ace/js/bootstrap.min.js"></script>

<!-- ace scripts -->
<script src="common/ace/js/ace-elements.min.js"></script>
<script src="common/ace/js/ace.min.js"></script>

<script src="js/main.js"></script>
</body>
<script type="text/javascript">
    // 点击改变当前fa-angle-right的方向
    function changeArrow(arrow){
        if ($(arrow).find('b').attr("class") == "arrow fa fa-angle-down") {
            $(arrow).find('b').attr("class", "arrow fa fa-angle-right");
        } else {
            $("#sidebar").find('b').attr("class", "arrow fa fa-angle-right");
            $(arrow).find('b').attr("class", "arrow fa fa-angle-down");
        }
    }
</script>
</html>