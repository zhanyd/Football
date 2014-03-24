<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function add() {
	window.location.href = "goaddUserManage.action";
}
function resetpw(ID) {
	window.location.href = "adminChPassUserManage.action?tuserResult.tuser.ID="+ID;
}
function edit(ID) {
	window.location.href = "goeditUserManage.action?tuserResult.tuser.ID="+ID;
}
function del(ID) {
	if( confirm("确定删除？"))
		{
	window.location.href = "delUserManage.action?tuserResult.tuser.ID="+ID;
		}
}

</script>

<label> <input type="button" name="" value="新增"
					onclick="add();" /></label>

<body>
<s:actionmessage/>
<s:form id="form1" name="form1" method="post" action="">
	
    <table border="0" cellspacing="1" cellpadding="0" id="tablewi"> 
        <tr class="sty1"> 
             <th>用户名</th>
             <th>真实姓名</th>
             <th>角色</th>
             <th>操作</th> 
        </tr> 
        <tr> 
           <s:iterator value="tuserResultList">			
			<tr>
				<td><s:property value="tuser.USERNAME" /></td>
				<td><s:property value="tuser.REALNAME" /></td>
				<td><s:property value="roleName" /></td>
				
				<td>
					
				<input type="button" name="" value="编辑"
					onclick="edit('<s:property value="tuser.ID" />');" />
				<input type="button" name="" value="重置密码"
					onclick="resetpw('<s:property value="tuser.ID" />');" />	
				<input type="button" name="" value="删除"
					onclick="del('<s:property value="tuser.ID" />');" />
			    </td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/page/Message.jsp"></jsp:include>
    </s:form>
</body>
</html>
