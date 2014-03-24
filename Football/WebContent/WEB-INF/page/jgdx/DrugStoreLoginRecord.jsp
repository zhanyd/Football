<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<jsp:include page="/scripts/include.jsp" flush="true" />
<script type="text/javascript">
$(document).ready(function () {
    $("#drugstoreloginrecordDRUGSTORENAME").autocomplete(<%= session.getAttribute("jsonresult")%>, DrugAutocompleteSeting)
    .result(function (event, data, formatted) { //回调
        $('#drugstoreloginrecordDRUGSTORENAME')[0].value = data.name;
    });
});

function exportExcel()
{
	document.form1.action = "exportExcelDrugStoreLoginRecord.action";
	document.form1.submit();

}
//获取药店信息弹出框
function getDrugStore(){
		selectbasic("goGetDSPharmacistManage.action","","600","500");
	}
function selectbasic(url, tit, wid, hei) {

	    //弹出窗口
	    art.dialog.open(url, {
	        id: 'drugstoreloginrecord',
	        title: tit, lock: false, width: wid, height: hei,
	        ok: function () {
	            var win = art.dialog.open.origin;//来源页面
	            var iframe = this.iframe.contentWindow;
	            var checkboxes = iframe.document.getElementsByName('radioselect');
	            var selectvalue = "";
				//去掉最后面的逗号
	            for (var i = 0; i < checkboxes.length; i++) {
	                if (checkboxes[i].checked) {
	                    selectvalue += checkboxes[i].value + ",";
	                }
	            }
	            if (selectvalue.length > 0)
	            	{
		                selectvalue = selectvalue.substr(0, selectvalue.length - 1);
		                //赋值：药店名称和药店ID
			            var str = selectvalue.split(',');
			            $("#DRUGSTOREID").val(str[0]);
			            $("#drugstoreloginrecordDRUGSTORENAME").val(str[1]);
	            	}
	            
	            //关闭弹出窗口
	            this.close();
	            return false;
	        },
	        cancel: true
	    });
	}

</script>

<%-- <%
session.removeValue("");
%> --%>
<body>

<s:form id="form1" name="form1" method="post" action="">
    <div class="main">
	<table>
        <tr>
            <td>
             	药店名称：<s:textfield type="text" name="drugstoreloginrecordSearch.DRUGSTORENAME" id="drugstoreloginrecordDRUGSTORENAME" style=" width:100px;"/>
        
            </td>
            <td>
             	<a id="button1" href="#" onclick="getDrugStore();"><span>获取药店名称</span></a>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                上传时间：<s:textfield type="text" name="drugstoreloginrecordSearch.beginDate" style=" width:100px;" onblur="formatDate(this);"/>
               	至  <s:textfield type="text" name="drugstoreloginrecordSearch.endDate" style=" width:100px;" onblur="formatDate(this);"/>
            </td> 
            <td></td>
            <td width="80px">
                <label>
					<a style="float:right;" id="button1" href="#" onclick="pageSearch();"><span>检索</span></a>
				</label>
            </td>
        </tr>
    </table>
    </div>
   <div class="tit">
	      <table style="margin-left:5px;">
		      <tr>
			     <td><img src="img/excel.png" border="0" align="bottom" onclick="exportExcel()" style="cursor:pointer;"/></td>

			  </tr>
		  </table>
	   </div>
    <table border="0" cellspacing="1" cellpadding="0" id="tablewi"> 
        <tr class="sty1"> 
             <th>药店名称</th>
             <th>上传内容</th>
             <th>上传时间</th>
        </tr> 
        <tr> 
           <s:iterator value="pageObject.objectList">			
			<tr>
				<td width="20%"><s:property value="DRUGSTORENAME" /></td>
				<td width="10%"><s:property value="UPLOADTYPE" /></td>
				<td width="10%"><s:property value="CREATETIME" /></td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchDrugStoreLoginRecord.action" />
	</jsp:include>
		<p>&nbsp;</p>
    </s:form>
</body>
