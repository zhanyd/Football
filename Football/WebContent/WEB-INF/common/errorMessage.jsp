<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="taglibs.jsp"%>

<div id="errorArea">
</div>
<div id="messageArea">
</div>
<s:if test="hasActionErrors()">
	<p style="color: red;">
	<ul>
		<s:iterator value="actionErrors">
			<li style="color: red;">
				<s:property />
			</li>
		</s:iterator>
	</ul>
	</p>
</s:if>
<s:actionmessage />