<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function add() {
	window.location.href = "goaddRoleManage.action";
}
function edit(ID) {
	window.location.href = "goeditRoleManage.action?role.ID="+ID;
}
function del(ID) {
	if( confirm("确定删除？"))
		{
	window.location.href = "delRoleManage.action?role.ID="+ID;
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
             <th width="80px">角色名称</th>
             <th>权限</th>
             <th width="60px">创建时间</th>
             <th>操作</th> 
        </tr> 
        <tr> 
           <s:iterator value="rolelist">			
			<tr>
				<td><s:property value="ROLENAME" /></td>
				<td><s:property value="RIGHTS" /></td>
				<td><s:property value="CREATETIME" /></td>
				
				<td>
					
				<input type="button" name="" value="编辑"
					onclick="edit('<s:property value="ID" />');" />
					
					<input type="button" name="" value="删除"
					onclick="del('<s:property value="ID" />');" />
			    </td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
  
    </s:form>
</body>
</html>
