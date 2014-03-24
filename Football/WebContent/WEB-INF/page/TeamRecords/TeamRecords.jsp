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
                                         球队： <s:select name="teamrecordsView.teamID" id="TEAMID" list="teamList" listKey="ID" listValue="teamName"></s:select>                  
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
             <th>球队名称</th>
             <th>对手名称</th>
             <th>胜场数</th>
             <th>平数</th>
             <th>败场数</th>
             <th>进球数</th>
             <th>失球数</th>
             <th>比赛时间</th>
        </tr> 
        <tr> 
           <s:iterator value="pageObject.objectList">			
			<tr>
				<td><s:property value="TeamName" /></td>
				<td><s:property value="OpponentName" /></td>
				<td><s:property value="wins" /></td>
				<td><s:property value="draw" /></td>
				<td><s:property value="losing" /></td>
				<td><s:property value="goals" /></td>
				<td><s:property value="lost" /></td>
				<td><s:property value="createTime" /></td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchTeamRecords.action" />
	</jsp:include>
		<p>&nbsp;</p>
    </s:form>
</body>
</html>
