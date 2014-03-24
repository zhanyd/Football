<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/scripts/include" flush="true" />

<script type="text/javascript">
	function Main() {
		window.location.href = "goSearchTeamManage.action";
	}
	//提交表单验证
	function validate() {
		return checktb('tablewi4');
	}
</script>

<body>
	<form id="form1" name="form1" method="post" action="addTeamManage.action" onsubmit="return validate();">
		<table border="0" cellspacing="0" cellpadding="0" id="tablewi4">
			<tr>
				<td>球队名称：</td>
				<td><s:textfield type="text" name="team.teamName" ck="rq" /></td>
			</tr>
		</table>
		<input type="submit" name="Submit" value="提交" /> 
		<input type="button" name="" value="返回" onclick="Main();" />
	</form>

</body>
</html>


