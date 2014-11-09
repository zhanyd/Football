<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="/scripts/include.jsp" flush="true" />
<script type="text/javascript">
	function Main() {
		window.location.href = "searchUserManage.action";
	}
	//提交表单验证
	function validate() {
		return checktb('tablewi4');
	}
</script>

<body>
	<form id="form1" name="form1" method="post" action="addUserManage.action" onsubmit="return validate();">
		<table border="0" cellspacing="0" cellpadding="0" id="tablewi4">
			 <tr>
				<td>用户名：</td>
				<td><s:textfield type="text" name="tuserResult.tuser.USERNAME" ck="rq" /></td>
			    <s:actionmessage cssStyle="color:red"/>
			</tr>
			<tr>
				<td>密码：</td>
				<td><s:password type="text" name="tuserResult.tuser.PASSWORD" ck="rq" /></td>
			</tr>
			<tr>
				<td>真实姓名：</td>
				<td><s:textfield type="text" name="tuserResult.tuser.REALNAME" /></td>
			</tr>
			<tr>
				<td>角色：</td>
				<td><s:select name="tuserResult.tuser.ROLEID" cssClass="txt3" list="rolelist" listKey="ID" listValue="ROLENAME" value="tuserResult.tuser.ROLEID"/></td>
			</tr>
		</table>
		<input type="submit" name="Submit" value="提交" /> 
		<input type="button" name="" value="返回" onclick="Main();" />
	</form>

</body>
</html>
