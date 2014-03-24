<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<jsp:include page="/scripts/include" flush="true" />
<jsp:include page="/WEB-INF/page/Message.jsp" flush="true"></jsp:include>

<script type="text/javascript">
	function Main() {
		//关闭当前窗口
		//parent.tab.removeTabItem('goeditUserInfo');
		
		//跳转到管理页面
		window.location.href = "goUserInfo.action";
		
	}
	//提交表单验证
	function validate() {
		return checktb('tablewi4');
	}
</script>

</head>

<body>
   <div style="color:red" align="center">
	  	<s:fielderror></s:fielderror>
   </div>
	<form id="form1" name="form1" method="post" action="editUserInfo.action"  enctype="multipart/form-data" onsubmit="return validate();">
		<table border="0" cellspacing="0" cellpadding="0" id="tablewi4">
			<s:hidden type="text" name="tuser.ID" />
		    <s:hidden type="text" name="tuser.PICURL" />
		    
		    
		     <tr>
				<td>我的头像：</td>
				<td><img src="<s:property value='tuser.PICURL'/>" alt="请稍候刷新页面" width="150" height="150"/></td>
			</tr>
		    <tr>
	  			<td>更改头像:</td>
	  			<td> <s:file name="upload" /></td>
  			</tr>
			 <tr>
				<td>用户名：</td>
				<td><s:textfield type="text" name="tuser.USERNAME" readonly="true"/></td>
			</tr>

			<tr>
				<td><font style="color:Red">*</font>真实姓名：</td>
				<td><s:textfield type="text" name="tuser.REALNAME" ck="rq"/></td>
			</tr>
			<tr>
				<td>所属球队：</td>
				<td><s:select name="tuser.TEAMID" cssClass="txt3" list="teamList" listKey="ID" listValue="teamName"/></td>
			</tr>
			<tr>
				<td>住址：</td>
				<td><s:textfield type="text" name="tuser.ADDRESS" /></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><s:textfield type="text" name="tuser.TEL" ck="int"/></td>
			</tr>
			<tr>
				<td>出生年月：</td>
				<td><s:textfield type="text" name="tuser.BIRTHDAY" onblur="formatDate(this);"/><font style="color:Red">(YYYY/MM/DD)</font></td>
			</tr>
		
			
		</table>
		<input type="submit" name="Submit" value="提交" /> 
		<input type="button" name="" value="返回" onclick="Main();" />
	</form>
</body>

</html>