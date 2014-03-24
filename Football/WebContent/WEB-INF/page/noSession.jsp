<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<body>

<div>
<input id="message" type="hidden" value="<s:property value='exception.message' />" />

</div>
<script type="text/javascript">
var s = document.getElementById("message");
alert(s.value);
window.history.go(-1);
// window.location.href="UserLogout.action";
</script>

</body>
</html>