<%@page import="com.wildwolf.model.Tuser"%>

<%@ page language="java" import="com.wildwolf.action.SysConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>三溪足球网</title>
   <link href="scripts/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <script src="scripts/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>    
    <script src="scripts/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
    <script src="scripts/utils.js" type="text/javascript"></script> 
   
        <script type="text/javascript">
        var tab = null;
        var accordion = null;
        var tree = null;
        $(function () {
            //布局
            $("#layout1").ligerLayout({ leftWidth: 190, height: '100%', heightDiff: -22, space: 4, onHeightChanged: f_heightChanged });
            var height = $(".l-layout-center").height();
            //Tab
            $("#framecenter").ligerTab({ height: height });
            //面板
            $("#accordion1").ligerAccordion({ height: height - 24, speed: null });
            $(".l-link").hover(function () {
                $(this).addClass("l-link-over");
            }, function () {
                $(this).removeClass("l-link-over");
            });
            tab = $("#framecenter").ligerGetTabManager();
            accordion = $("#accordion1").ligerGetAccordionManager();
            $("#pageloading").hide();

        });
        function f_heightChanged(options) {
            if (tab)
                tab.addHeight(options.diff);
            if (accordion && options.middleHeight - 24 > 0)
                accordion.setHeight(options.middleHeight - 24);
        }
        function f_addTab(tabid, text, url) {
            tab.addTabItem({ tabid: tabid, text: text, url: url });
        }
        $(document).ready(function () {
            $("#home").attr("src", "welcome.jsp");
        })
        
        
       
     </script> 
<style type="text/css"> 
    body,html{height:100%;}
    body{ padding:0px; margin:0;   overflow:hidden;}  
    .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
    .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
    .l-layout-top{background:#102A49; color:White;}
    .l-layout-bottom{ background:#E5EDEF; text-align:center;}
    #pageloading{position:absolute; left:0px; top:0px; background:white url('loading.gif') no-repeat center; width:100%; height:100%;z-index:99999;}
    .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px;}
    .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00;} 
    .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
    .space{ color:#E7E7E7;}
    /* 顶部 */ 
    .l-topmenu{ margin:0; padding:0; height:62px; line-height:31px; background:url('scripts/images/top2.jpg') repeat-x bottom;  position:relative; border-top:1px solid #1D438B;  }
    .l-topmenu-logo{ color:#E7E7E7; padding-left:55px;  line-height:36px;background:url('img/football.png') no-repeat;}
    .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:30px; top:2px;color:#070A0C;}
    .l-topmenu-welcome a{ color:#E7E7E7; text-decoration:underline} 
    #accordion1 a{ text-decoration:none;}
 </style>
</head>
<body style="padding:0px;background:#EAEEF5;">  
<div id="pageloading">
    </div>
    <div id="topmenu" class="l-topmenu" >
        <div class="l-topmenu-logo" style="font-size:16px;margin-top: 10px;" >
        	三溪足球网
        </div>
        <div class="l-topmenu-welcome">
            
            <a href="UserLogout.action" class="l-link2">登出</a> <span class="space">|<%=((Tuser)session.getAttribute(SysConstant.USER)) == null ? "" : ((Tuser)session.getAttribute(SysConstant.USER)).getREALNAME()%></span>
        </div>
    </div>
    <div id="layout1" style="width: 99.2%; margin: 0 auto; margin-top: 4px;">
        <div position="left" title="主菜单" id="accordion1" style="cursor:text;" >
            
             <div title="队员页面" class="l-scroll">
               <div style="height: 7px;"></div>
                <a class="l-link" href="javascript:f_addTab('goUserInfo','队员一览','goUserInfo.action')">队员一览</a>  
                <a class="l-link" href="javascript:f_addTab('goSearchTeamManage','球队一览','goSearchTeamList.action')">球队一览</a>
                <a class="l-link" href="javascript:f_addTab('goUserInfoRecords','队员明细','goUserInfoRecords.action')">队员明细</a> 
                <a class="l-link" href="javascript:f_addTab('goTeamRecords','球队明细','goTeamRecords.action')">球队明细</a>  
            </div>
            
            <div title="队长页面" class="l-scroll">
               <div style="height: 7px;"></div>
                <a class="l-link" href="javascript:f_addTab('goTeamMemberManage','队员战绩管理','goTeamMemberManage.action')">队员战绩管理</a>  
                <a class="l-link" href="javascript:f_addTab('goTeamScoreManage','球队战绩管理','goTeamScoreManage.action')">球队战绩管理</a>
            </div>
            
             <div title="基础管理" class="l-scroll" id="m1">
               <div style="height: 7px;">
                </div>
<%--                 <% if(session.getAttribute(SysConstant.USER) != null && ((Tuser)session.getAttribute(SysConstant.USER)).getUSERNAME().equals("admin")) --%>

				
                <a class="l-link" href="javascript:f_addTab('searchUserManage','用户管理','searchUserManage.action?pageObject.currentPageNo=1')">用户管理</a>
                <a class="l-link" href="javascript:f_addTab('searchRoleManage','角色管理','searchRoleManage.action?pageObject.currentPageNo=1')">角色管理</a>

                <a class="l-link" href="javascript:f_addTab('searchPassUserManage','用户修改密码','searchPassUserManage.action')">用户修改密码</a>
                <a class="l-link" href="javascript:f_addTab('SearchTeamManage2','球队管理','SearchTeamManage.action?pageObject.currentPageNo=1')">球队管理</a>
                <a class="l-link" href="javascript:f_addTab('goRightsManage','权限管理','goRightsManage.action')">权限管理</a>
                <a class="l-link" href="javascript:f_addTab('searchUserLog','用户操作日志','searchUserLog.action?pageObject.currentPageNo=1')">用户操作日志</a>

            </div>

        </div>
        <div position="center" id="framecenter">
            <div tabid="home" title="我的主页" style="height: 300px">
                <iframe frameborder="0" name="home" id="home"></iframe>
            </div>
        </div>
    </div>
    <div style="height: 22px; line-height: 22px; text-align: center;">
       Copyright © 2013 詹应达
    </div>
    <div style="display: none">
    </div>
</body>
</html>