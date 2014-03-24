<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/scripts/include.jsp" flush="true" />

<script type="text/javascript">
function Main()
{
	window.location.href = "searchUserManage.action";
}
//提交表单验证
function validate() {
	return checktb('tablewi4');
}
</script>

<body>
 <form id="form1" name="form1" method="post" action="editadminChPassUserManage.action" onsubmit="return validate();">
    <table border="0" cellspacing="0" cellpadding="0" id="tablewi4"> 
        	<s:hidden type="text" name="tuser.ID" />
            <tr>
				<td>用户名：</td>
				<td>
                    <s:property value="tuser.USERNAME" /> 
				</td>
				
			</tr>
			<tr>
				<td>新密码：</td>
				<td><s:password type="text" name="tuser.PASSWORD"  ck="rq"/></td>
			</tr>
			
    </table>
    <s:actionmessage cssStyle="color:red"/> 
    <input type="submit" name="Submit" value="提交" />
    <input type="button" name="" value="返回" onclick="Main();" />
    </form>
     
</body>
</html>