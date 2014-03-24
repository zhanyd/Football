<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
function add() {
	window.location.href = "goAddOrder.action";
}
</script>
<body>
	<s:form id="form1" name="form1" method="post" action="">
  订单代码：
    <label> <s:textfield type="text" name="order.code" />
		</label>
订单名称：
<label> <s:textfield type="text" name="order.name" />
		</label>
		<label> <input type="button" name="" value="检索"
			onclick="pageSearch();" />
		</label>
		<label> <input type="button" name="" value="新增"
			onclick="add();" />
		</label>
		<table width="200" border="0">
		
			<tr>
				<td>订单代码</td>
				<td>订单名称</td>
			</tr>
			<s:iterator value="pageObject.objectList">			
			<tr>
				<td><s:property value="code" /></td>
				<td><s:property value="name" /></td>
			</tr>
			</s:iterator>
		</table>
		<jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchOrder.action" />
		</jsp:include>
		<p>&nbsp;</p>
	</s:form>
</body>
</html>
