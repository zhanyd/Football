<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>


<jsp:include page="/scripts/include" flush="true" />
<jsp:include page="/WEB-INF/page/Message.jsp" flush="true"></jsp:include>

<script type="text/javascript">
	function Main() {
		window.location.href = "login.action";
	}
	//提交表单验证
	function validate() {
		return checktb('tablewi4');
	}
</script>

<style type="text/css">
body{ 
	width:100%;
}

.l-topmenu{ margin:0; padding:0; height:62px; line-height:31px; background:url('scripts/images/top2.jpg') repeat-x bottom;  position:relative; border-top:1px solid #1D438B;  }
.l-topmenu-logo{ color:#E7E7E7; padding-left:55px;  line-height:36px;background:url('img/football.png') no-repeat;}
#form1{
 	position:absolute; 
	left:30%; 
}
</style>


</head>

<body>
<div id="topmenu" class="l-topmenu" >
    <div class="l-topmenu-logo" style="font-size:16px;margin-top: 10px;" >
    	三溪足球网
    </div>

</div>
	<form id="form1" name="form1" method="post" action="addRegister.action" onsubmit="return validate();">
		<p style="font-size: 30">新用户注册</p>
		<table border="0" cellspacing="0" cellpadding="0" id="tablewi4">
			
			 <tr>
				<td><font style="color:Red">*</font>用户名：</td>
				<td><s:textfield type="text" name="tuser.USERNAME" ck="rq" /></td>
			    <s:actionmessage cssStyle="color:red"/>
			</tr>
			<tr>
				<td><font style="color:Red">*</font>密码：</td>
				<td><s:password type="text" name="tuser.PASSWORD" ck="rq" /></td>
			</tr>
			<tr>
				<td><font style="color:Red">*</font>真实姓名：</td>
				<td><s:textfield type="text" name="tuser.REALNAME" ck="rq"/></td>
			</tr>
			<tr>
				<td>所属球队：</td>
				<td><s:select name="tuser.TEAMID" cssClass="txt3" list="teamList" listKey="ID" listValue="teamName"/></td>
			</tr>
			<tr>
				<td>住址：</td>
				<td><s:textfield type="text" name="tuser.ADDRESS" /></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><s:textfield type="text" name="tuser.TEL" ck="int"/></td>
			</tr>
			<tr>
				<td>出生年月：</td>
				<td><s:textfield type="text" name="tuser.BIRTHDAY" onblur="formatDate(this);"/><font style="color:Red">(YYYY/MM/DD)</font></td>
			</tr>
			
		</table>
		<input type="submit" name="Submit" value="提交" /> 
		<input type="button" name="" value="返回" onclick="Main();" />
	</form>
</body>

</html>
