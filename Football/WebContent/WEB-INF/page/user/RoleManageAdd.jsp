<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="/scripts/include.jsp" flush="true" />
<script type="text/javascript">
	function Main() {
		window.location.href = "searchRoleManage.action";
	}
	//提交表单验证
	function validate() {
		return checktb('tablewi4');
	}
</script>

<body>
	<form id="form1" name="form1" method="post" action="addRoleManage.action" onsubmit="return validate();">
		<table border="0" cellspacing="0" cellpadding="0" id="tablewi4">
			<tr>
				<td>角色名称：</td>
				<td><s:textfield type="text" name="role.ROLENAME" ck="rq" /></td>
			</tr>
		</table>
		<input type="submit" name="Submit" value="提交" /> 
		<input type="button" name="" value="返回" onclick="Main();" />
	</form>

</body>
</html>


