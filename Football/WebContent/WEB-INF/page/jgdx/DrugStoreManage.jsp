<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<jsp:include page="/scripts/include.jsp" flush="true" />

<script type="text/javascript">
$(document).ready(function () {
    $("#DrugStoreManageDRUGSTORENAME").autocomplete(<%= session.getAttribute("jsonresult")%>, DrugAutocompleteSeting)
    .result(function (event, data, formatted) { //回调
        $('#DrugStoreManageDRUGSTORENAME')[0].value = data.name;
    });
});

function add() {
	window.location.href = "goaddDrugStoreManage.action";
}
function edit(DRUGSTOREID) {
	window.location.href = "goeditDrugStoreManage.action?drugstore.DRUGSTOREID="+DRUGSTOREID;
}
function del(DRUGSTOREID) {
	if( confirm("确定删除？"))
		{
			window.location.href = "delDrugStoreManage.action?drugstore.DRUGSTOREID="+DRUGSTOREID;
		}
}
function detial(DRUGSTOREID) {
	window.location.href = "godetailDrugStoreManage.action?drugstore.DRUGSTOREID="+DRUGSTOREID;
}
function exportExcel()
{
	document.form1.action = "exportExcelDrugStoreManage.action";
	document.form1.submit();
}

//获取药店信息弹出框
function getDrugStore(){
		selectbasic("goGetDSPharmacistManage.action","","600","500");
	}
function selectbasic(url, tit, wid, hei) {

	    //弹出窗口
	    art.dialog.open(url, {
	        id: 'DrugStoreManage',
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
			            $("#DrugStoreManageDRUGSTORENAME").val(str[1]);
	            	}
	            
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
             	监管对象名称:<s:textfield type="text" name="drugstore.DSNAME" id="DrugStoreManageDRUGSTORENAME" style=" width:100px;"/>
            </td>
            <td>
             	<a id="button1" href="#" onclick="getDrugStore();"><span>获取药店名称</span></a>
            </td>
			<td width="10">
			</td>
            <td>
                                         地址:<s:textfield type="text" name="drugstore.ADDRESS" style=" width:100px;"/>
            </td>
        </tr>
        <tr> 
            <td>
                                       是否已监管:<s:radio name="drugstore.ISSUPERVISED" list="#{'':'全部','1':'是', '0':'否'}"/>
            </td>
            <td></td>
            <td></td>
            <td></td>
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

	   <div class="tit">
	      <table style="margin-left:5px;">
		      <tr>
			     <td><img src="img/excel.png" border="0" align="bottom" onclick="exportExcel()" style="cursor:pointer;"/></td>
			  </tr>
		  </table>
	   </div>
    <table border="0" cellspacing="1" cellpadding="0" id="tablewi"> 
        <tr class="sty1"> 
             <th>监管对象名称</th>
             <th>经营地址</th>
             <th>许可证号</th>
             <th>联系电话</th>
             <th>企业性质</th>
             <th>企业负责人</th>
<!--              <th>最后考核时间</th> -->
<!--              <th>实时视频</th> -->
             <th>操作</th> 
        </tr> 
        <tr> 
           <s:iterator value="pageObject.objectList">			
			<tr>
				<td><s:property value="DSNAME" /></td>
				<td><s:property value="ADDRESS" /></td>
				<td width="10%"><s:property value="BUSINESSOPERATIONID" /></td>
				<td><s:property value="TEL" /></td>
				<td><s:property value="NATURE" /></td>
				<td><s:property value="RESPONSIBLEPERSON" /></td>
<%-- 				<td><s:property value="LASTGRADEDATE" /></td> --%>
<%-- 				<td><s:property value="VIDEOURL" /></td> --%>
				<td width="12%">
				<img src="img/3.jpg" onclick="detial('<s:property value="DRUGSTOREID" />');" style="cursor:pointer;"/>
				<img src="img/4.jpg" onclick="edit('<s:property value="DRUGSTOREID" />');" style="cursor:pointer;"/>
				<img src="img/5.jpg" onclick="del('<s:property value="DRUGSTOREID" />');" style="cursor:pointer;"/>
			    </td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchDrugStoreManage.action" />
	</jsp:include>
		<p>&nbsp;</p>
    </s:form>
</body>
</html>
