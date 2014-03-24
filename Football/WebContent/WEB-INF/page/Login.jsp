<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/scripts/include.jsp" flush="true" />

<style type="text/css">
body{ background:url(img/bj.jpg);background-repeat:no-repeat; background-attachment:fixed; background-position:top; }
.login form{ padding:80px 0 0 45px; width:300px;}
.text_3{width:162px; height:23px;border:1px  #c1c1c1 solid;}
</style>
</head>

<script type="text/javascript">

	//提交表单验证
	function validate() {
		return checktb('tablewi4');
	}
	function register() {
		window.location.href = "goRegister.action";
	}
</script>

<body>
	<div style="text-align: center; font-size: 19pt; margin-top: 400px;">
	   <s:form id="tablewi4" name="form1" method="post" action="loginUserManage.action" onsubmit="return validate();">
	   <div style="margin-top: 30px; height: 200px;width: 100%">
	   		<div style="text-align: center; background: url(img/bg_2.gif); margin: 0 auto;
                border-color: black; height: 200px; width: 400px; border: 1px #000000 solid;
                background-color: #eaeaea; filter: progid:DXImageTransform.Microsoft.Shadow (Color=#333333,Direction=135,strength=3)">
	   			<div style="margin-top: 30px;">
	   				<table align="center" style="text-align: center; font-size: 10pt" cellpadding="0" cellspacing="0" border="0">
                        <tbody><tr>
                            <td align="right" height="28" width="70px">
                                <label for="UserName">用户名：</label>
                            </td>
                            <td align="left" colspan="2">
                                <s:textfield type="text" name="tuser.USERNAME" cssClass="text_3" ck="rq"/>
                                
                            </td>
                        </tr>
                        <tr>
                            <td align="right" height="28">
                                <label for="Password">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                            </td>
                            <td align="left" colspan="2">
                                <s:password type="text" name="tuser.PASSWORD" cssClass="text_3" ck="rq"/>
                            </td>
                        </tr>
                    </tbody>
                    </table>
                    <s:actionmessage  cssStyle="color:red; font-size: 10pt;"/>
                    <p align="center">
                        <input name="dl" type="submit" value="登录" style="height:30px;width:55px;cursor:pointer;"/>
                        <input nane="zc" type="button" value="注册" style="height:30px;width:55px;cursor:pointer;" onclick="register();"/>
                    </p>
	   			</div>
	   			
	   		</div>
	   
	   </div>
	   </s:form>
	   <div id="footer" style=" text-align:center;font-size:18px">
        Copyright © 2013 詹应达
    </div>
	</div>


</body>

