<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="header">
<h1 class="STYLE1">Internet Marketing System</h1>
<div id="sub">
<ul>
	<li>
	<s:url id="logout" action="logout" namespace="/"/>	
	<s:a href="%{logout}" title="退出登录">退出</s:a></li>
	<li>
	<s:url id="goToChangePassword" action="goToChangePassword" namespace="/nb"/>	
	<s:a href="%{goToChangePassword}" title="修改密码" >修改密码</s:a>
	</li>
	<!-- <div id="content3" style="display:none">
	<form id="form1" name="form1" method="post" action="">
	<table width="240">
		<tr>
			<th>用户名:</th>
			<td><input name="textfield" type="text" /></td>
		</tr>
		<tr>
			<th>原密码:</th>
			<td><input type="text" name="textfield2" /></td>
		</tr>
		<tr>
			<th>新密码:</th>
			<td><input type="text" name="textfield3" /></td>
		</tr>
		<tr>
			<th>新密码确认:</th>
			<td><input type="text" name="textfield4" /></td>
		</tr>
		<tr>
			<td colspan="2" style="padding-top:10px;text-align:center;"><input
				type="submit" class="inputmin" name="Submit" value="确定" /> <input
				type="submit" id="pwdCancel" class="inputmin" name="Submit2"
				value="退出" onclick="closeAllModalWindows()" /></td>
		</tr>
	</table>
	</form>
	</div> -->
<%--	<s:url id="index" action="index" namespace="/"/>--%>
<%--	<li style="width: 50px"><s:a href="%{index}" title="返回首页">首页</s:a></li>--%>
    <li style="width: 130px">当前用户：<s:property value="#session['cn.com.lifeisgreat.gims.fdm.struts2.action.User'].userName" /></li>
</ul>
</div>
</div>
