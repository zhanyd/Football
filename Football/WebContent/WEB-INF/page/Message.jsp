<%@ page language="java" import="com.wildwolf.action.SysConstant"%>
<script type="text/javascript">

<%
if(session.getAttribute(SysConstant.MESSAGE) != null)
{
	%>
	alert("<%= session.getAttribute(SysConstant.MESSAGE)%>")
	<%
	session.removeAttribute(SysConstant.MESSAGE);
}

%>
</script>

