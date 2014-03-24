<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />


<body>
<s:actionmessage/>
<s:form id="form1" name="form1" method="post" action="">
	
	<table>
        <tr>
            <td>
             	用户名：<s:textfield type="text" name="userlog.USERNAME" style=" width:100px;"/>
            </td>
          
            <td>
                <label> <input type="button" name="" value="检索"
					onclick="pageSearch();" />
				</label>
            </td>
        </tr>
    </table>
	
	
    <table border="0" cellspacing="1" cellpadding="0" id="tablewi"> 
        <tr class="sty1"> 
             <th>用户名称</th>
             <th>用户操作</th>
             <th>操作时间</th>
        </tr> 
        <tr> 
           <s:iterator value="pageObject.objectList">			
			<tr>
				<td><s:property value="USERNAME" /></td>
				<td><s:property value="OPERATION" /></td>
				<td><s:date name="OPERATIONTIME" format="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchUserLog.action" />
	</jsp:include>
    </s:form>
</body>
</html>
