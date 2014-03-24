<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="/scripts/include.jsp" flush="true" />

<script type="text/javascript">
function Main() {
	window.location.href = "goSearchTeamManage.action";
}
function validate() {
	return checktb('tablewi4');
}
</script>

<body>
<div id="centerDiv">
  <form id="form1" name="form1" method="post" action="editTeamManage.action" onsubmit="return validate();">
    <table border="0" cellspacing="0" cellpadding="0" id="tablewi4"> 
        <s:hidden type="text" name="team.ID" />
			<tr>
				<td>球队名称：</td>
				<td><s:textfield type="text" name="team.teamName" ck="rq"/></td>
				<td>队长：</td>
				<td><s:select name="team.captainID" list="tuserList" listKey="ID" listValue="REALNAME"/></td>
				
			</tr>
			<tr>
				<td>胜场数：</td>
				<td><s:textfield type="text" name="team.wins" ck="int" /></td>
				<td>败场数：</td>
				<td><s:textfield type="text" name="team.losing" ck="int" /></td>
			</tr>
			<tr>
				<td>平数：</td>
				<td><s:textfield type="text" name="team.draw" ck="int"/></td>
				<td>进球数：</td>
				<td><s:textfield type="text" name="team.goals" ck="int"/></td>
			</tr>
			<tr>
				<td>失球数：</td>
				<td><s:textfield type="text" name="team.Lost" ck="int"/></td>
				<td>队费：</td>
				<td><s:textfield type="text" name="team.balance" ck="int"/></td>
			</tr>
			
    </table>
    <input type="submit" name="Submit" value="提交" />
	<input type="button" name="" value="返回" onclick="Main();" />
    </form>
    </div>
</body>
</html>


