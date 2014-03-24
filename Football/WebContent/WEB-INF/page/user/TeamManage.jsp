<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<jsp:include page="/scripts/include.jsp" flush="true" />

<script type="text/javascript">

function add() {
	window.location.href = "goaddTeamManage.action";
}
function edit(ID) {
	window.location.href = "goeditTeamManage.action?team.ID="+ID;
}
function del(ID) {
	if( confirm("确定删除？"))
		{
			window.location.href = "delTeamManage.action?team.ID="+ID;
		}
}
function detial(ID) {
	window.location.href = "godetailTeamManage.action?team.ID="+ID;
}

function opration(double1,double2)
{
	alert(parseFloat(double1)/parseFloat(double2));
	return parseFloat(double1)/parseFloat(double2);
}

	
</script>

<body>
<s:form id="form1" name="form1" method="post" action="">
    <div class="main">
<table>
        <tr>
            <td>
             	球队名称:<s:textfield type="text" name="team.teamName" style=" width:100px;"/>
            </td>
			
       
            <td>
                <label> 
                	<a id="button1" href="#" onclick="pageSearch();"><span>检索</span></a>
				</label>
				<label>
					<a id="button1" href="#" onclick="add();"><span>新增</span></a>
				</label>
            </td>
        </tr> 
    </table>
    </div>

	
    <table border="0" cellspacing="1" cellpadding="0" id="tablewi"> 
        <tr class="sty1"> 
             <th>球队名称</th>
             <th>队长</th>
             <th>胜场数</th>
             <th>败场数</th>
             <th>平数</th>
             <th>进球数</th>
             <th>胜率</th>
             <th>剩余队费</th>
             <th>操作</th> 
        </tr> 
        <tr> 
         
           <s:iterator value="pageObject.objectList">	
          		
			<tr>
				<td><s:property value="teamName" /></td>
				<td><s:property value="CaptainName" /></td>
				<td><s:property value="wins" /></td>
				<td><s:property value="losing" /></td>
				<td><s:property value="draw" /></td>
				<td><s:property value="goals" /></td>
				<td><s:property value="opration(losing,wins)"/></td>
				<td><s:property value="balance" /></td>
				<td width="12%">
<%-- 				<img src="img/3.jpg" onclick="detial('<s:property value="ID" />');" style="cursor:pointer;"/> --%>
				<img src="img/4.jpg" onclick="edit('<s:property value="ID" />');" style="cursor:pointer;"/>
				<img src="img/5.jpg" onclick="del('<s:property value="ID" />');" style="cursor:pointer;"/>
			    </td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="SearchTeamManage.action" />
	</jsp:include>
		<p>&nbsp;</p>
    </s:form>
</body>
</html>
