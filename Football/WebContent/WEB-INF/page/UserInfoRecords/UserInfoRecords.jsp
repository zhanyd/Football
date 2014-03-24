<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/scripts/include.jsp" flush="true" />
<link href="css/css.css" rel="stylesheet" type="text/css" />

<body>

<s:form id="form1" name="form1" method="post" action="">
    <div class="main">
	<table>
        <tr>
            <td>
                                           姓名： <s:textfield type="text" name="userrecordsView.REALNAME" style=" width:100px;"/>
            </td> 
            <td>
                                         所属球队： <s:select name="userrecordsView.TEAMID" id="TEAMID" list="teamList" listKey="ID" listValue="teamName"></s:select>                  
            </td>
            
            <td>
                <label> 
                	<a id="button1" href="#" onclick="pageSearch();"><span>检索</span></a>
				</label>
            </td>
        </tr>
    </table>
    </div>
    <table border="0" cellspacing="1" cellpadding="0" id="tablewi"> 
        <tr class="sty1"> 
             <th>姓名</th>
             <th>所属球队</th>
             <th>上场次数</th>
             <th>进球数</th>
             <th>助攻数</th>
             <th>队费变化</th>
             <th>比赛时间</th>
        </tr> 
        <tr> 
           <s:iterator value="pageObject.objectList">			
			<tr>
				<td><s:property value="REALNAME" /></td>
				<td><s:property value="TeamName" /></td>
				<td><s:property value="playTimes" /></td>
				<td><s:property value="goals" /></td>
				<td><s:property value="assist" /></td>
				<td><s:property value="balance" /></td>
				<td><s:property value="createTime" /></td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchUserInfoRecords.action" />
	</jsp:include>
		<p>&nbsp;</p>
    </s:form>
</body>
</html>
