<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/scripts/include.jsp" flush="true" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
// $(document).ready(function () {
// 	$("#TEAMID").prepend("<option value=''>全部</option>");
// 	$("#TEAMID").find("option:first").attr("selected",true);
// });

//获取队员信息弹出框
function detial(ID){
		selectbasic("godetailUserInfo.action?tuser.ID="+ID,"","400","470");
	}
function selectbasic(url, tit, wid, hei) {

	    //弹出窗口
	    art.dialog.open(url, {
	        id: 'godetailUserInfo',
	        title: tit, lock: false, width: wid, height: hei,
	        ok: function () {
// 	            var win = art.dialog.open.origin;//来源页面
// 	            var iframe = this.iframe.contentWindow;

	            //关闭弹出窗口
	            this.close();
	            return false;
	        },
	        cancel: true
	    });
	}


</script>

<body>

<s:form id="form1" name="form1" method="post" action="">
    <div class="main">
	<table>
        <tr>
            <td>
                                           用户名：<s:textfield type="text" name="tuser.USERNAME" style=" width:100px;"/>
            </td>
            <td>
                                           姓名： <s:textfield type="text" name="tuser.REALNAME" style=" width:100px;"/>
            </td> 
            <td>
                                         所属球队： <s:select name="tuser.TEAMID" id="TEAMID" list="teamList" listKey="ID" listValue="teamName"></s:select>                  
            </td>
            
            <td>
                <label> 
                	<a id="button1" href="#" onclick="pageSearch();"><span>检索</span></a>
				</label>
            </td>
            <td><a href="goeditUserInfo.action" style=" text-decoration: underline;">个人资料修改</a></td>
       
        </tr>
    </table>
    </div>
    <table border="0" cellspacing="1" cellpadding="0" id="tablewi"> 
        <tr class="sty1"> 
             <th>用户名</th>
             <th>姓名</th>
<!--              <th>电话</th> -->
<!--              <th>地址</th> -->
<!--              <th>出生年月</th> -->
<!--              <th>性别</th> -->
             <th>所属球队</th>
             <th>上场次数</th>
             <th>进球数</th>
             <th>助攻数</th>
             <th>剩余队费</th>
             <th>详细</th>
        </tr> 
        <tr> 
           <s:iterator value="pageObject.objectList">			
			<tr>
				<td><s:property value="USERNAME" /></td>
				<td width="8%"><s:property value="REALNAME" /></td>
<%-- 				<td><s:property value="TEL" /></td> --%>
<%-- 				<td><s:property value="ADDRESS" /></td> --%>
<%-- 				<td><s:property value="BIRTHDAY" /></td> --%>
<%-- 				<s:if test="SEX==0" > --%>
<!-- 				<td width="5%">女</td> -->
<%-- 				</s:if> --%>
<%-- 				<s:else> --%>
<!-- 				<td width="5%">男</td> -->
<%-- 				</s:else> --%>
				<td><s:property value="TEAMNAME" /></td>
				<td><s:property value="PLAYTIMES" /></td>
				<td><s:property value="GOALS" /></td>
				<td><s:property value="ASSIST" /></td>
				<td><s:property value="BALANCE" /></td>
				<td><img src="img/3.jpg" onclick="detial('<s:property value="ID" />');" alt="查看" style="cursor:pointer;"/></td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchUserInfo.action" />
	</jsp:include>
		<p>&nbsp;</p>
    </s:form>
</body>
</html>
