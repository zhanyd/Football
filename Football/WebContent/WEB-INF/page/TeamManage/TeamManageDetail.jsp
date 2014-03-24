<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
function Main() {
	window.location.href = "goSearchTeamManage.action";
}
</script>

<body>
    <table border="0" cellspacing="0" cellpadding="0" id="tablewi4"> 
        <s:hidden type="text" name="team.ID" />
			<tr>
				<td>球队名称：</td>
				<td><s:textfield type="text" name="team.teamName"/></td>
				<td>队长：</td>
				<td><s:textfield type="text" name="team.captainName"/></td>
			</tr>
			<tr>
				<td>胜场数：</td>
				<td><s:textfield type="text" name="team.wins"/></td>
				<td>败场数：</td>
				<td><s:textfield type="text" name="team.losing"/></td>
			</tr>
			<tr>
				<td>进球数：</td>
				<td><s:textfield type="text" name="team.goals"/></td>
				<td>队费：</td>
				<td><s:textfield type="text" name="team.balance"/></td>
			</tr>
			
    </table>
	<input type="button" name="" value="返回" onclick="Main();" />
</body>
</html>


