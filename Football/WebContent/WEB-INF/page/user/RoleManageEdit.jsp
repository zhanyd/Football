<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script language="javascript" type="text/javascript" src="scripts/jquery/jquery-1.8.3.js"></script>
<jsp:include page="/scripts/include" flush="true" />
<script type="text/javascript">

function Main() {
	window.location.href = "searchRoleManage.action";
}

function selectAllPer() {
	document.form1.action = "editAllRoleManage.action";
	document.form1.submit();
}
$(document).ready(function(){
	$("#selectAll").click(function(){
	     if($(this).attr("checked") ==  "checked")
	     {
	     	$("input[name='role.RIGHTS']").attr("checked",true);
	     }
	     else
	     {
	     	$("input[name='role.RIGHTS']").attr("checked",false);
	     }
	});

});



</script>

<body>
 <form id="form1" name="form1" method="post" action="editRoleManage.action">
    <table border="0" cellspacing="0" cellpadding="0" id="tablewi4"> 
        	<s:hidden type="text" name="role.ID" />
             <tr>
				<td width="80px">角色名称：</td>
				<td><s:textfield type="text" name="role.ROLENAME" ck="rq" /></td>
			</tr>
			<tr>
				<td width="80px">权限：</td>
				
			</tr>
			<tr>
				<td>
				 <s:checkbox name="selectAll" id="selectAll"></s:checkbox>全选
				</td>
				<td>
				<s:checkboxlist name="role.RIGHTS"  list="setPermission" value="rolePermissions" />
				</td> 
			</tr>
    </table>
    <input type="submit" name="Submit" id="qwe" value="提交" />
	<input type="button" name="" value="返回" onclick="Main();" />
    </form>
    
</body>
</html>


