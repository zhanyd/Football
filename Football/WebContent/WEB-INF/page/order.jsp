<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function orderMain() {
	location.href="index.action";
}
</script>
<body>
<form id="form1" name="form1" method="post" action="addOrder.action">
<s:actionmessage/>
<br>
  订单代码：
    <label>
  <s:textfield type="text" name="order.code" />
  </label>
订单名称：
<label>
<s:textfield type="text" name="order.name" />
</label>
<label>
<input type="submit" name="Submit" value="提交" />
<input type="button" name="" value="返回" onclick="orderMain();" />
</label>
</form>

</body>
</html>
