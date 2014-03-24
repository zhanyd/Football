<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<style type="text/css">

/* .pageinfo{padding:0px 6px; color: black} */
</style>


<body>
<div align="center">
    <table border="0" cellspacing="0" cellpadding="0" id="tablewi4"> 
			<tr>
				<td><s:label name="tuser.USERNAME"/></td>
				<td><img src="<s:property value='tuser.PICURL'/>"  width="150" height="150"/></td>
			</tr>	
			<tr>
				<td>姓名：</td>
				<td><s:textfield type="text" name="tuser.REALNAME"/></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><s:textfield type="text" name="tuser.TEL"/></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><s:textfield type="text" name="tuser.ADDRESS"/></td>
			</tr>
			<tr>
				<td>出生年月：</td>
				<td><s:textfield type="text" name="tuser.BIRTHDAY"/></td>
			</tr>
			<tr>
				<td>性别：</td>
				<s:if test="tuser.SEX==0" > 
 				<td><s:textfield type="text" value="女"/></td>
 				</s:if> 
				<s:else> 
				<td><s:textfield type="text" value="男"/></td>
				</s:else> 
			</tr>
			<tr>
				<td>球队：</td>
				<td><s:textfield type="text" name="tuser.TEAMNAME"/></td>
			<tr>	

			<tr>
				<td>上场次数：</td>
				<td><s:textfield type="text" name="tuser.PLAYTIMES"/></td>
			</tr>
			<tr>
				<td>进球数：</td>
				<td><s:textfield type="text" name="tuser.GOALS"/></td>
			</tr>
			<tr>
				<td>助攻数：</td>
				<td><s:textfield type="text" name="tuser.ASSIST"/></td>
			</tr>
			<tr>
				<td>剩余队费：</td>
				<td><s:textfield type="text" name="tuser.BALANCE"/></td>
			</tr>
			
    </table>
	<s:url id="url_pre" value="godetailUserInfo.action">
         <s:param name="pageNow" value="pageNow-1"></s:param>
     </s:url>
     <s:url id="url_next" value="godetailUserInfo.action">
         <s:param name="pageNow" value="pageNow+1"></s:param>
     </s:url>  
     <p>
     	<s:a href="%{url_pre}" cssClass="pageinfo">上一页</s:a>
     	<s:a href="%{url_next}" cssClass="pageinfo">下一页</s:a> <br>
     </p>
</div>
</body>
</html>
