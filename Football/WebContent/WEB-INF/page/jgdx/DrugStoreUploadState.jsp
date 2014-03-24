<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<jsp:include page="/scripts/include.jsp" flush="true" />
<script type="text/javascript">
$(document).ready(function () {
    $("#DrugStoreUploadStateDSNAME").autocomplete(<%= session.getAttribute("jsonresult")%>, DrugAutocompleteSeting)
    .result(function (event, data, formatted) { //回调
        $('#DrugStoreUploadStateDSNAME')[0].value = data.name;
    });
});

function showDrugStroreDetail(drugStoreID){
	selectbasic2("godetailDSDrugStoreUploadState.action?drugstore.DRUGSTOREID="+drugStoreID,"药店信息","850","350");
	}
	
function showCountDetail(drugStoreID){
	selectbasic2("godetailUPCountDrugStoreUploadState.action?drugStoreUploadState.drugStoreID="+drugStoreID,"详情内容","650","200");
	}

function selectbasic2(url, tit, wid, hei) {

    //弹出窗口
    art.dialog.open(url, {
        id: 'DrugStoreUploadStateDetail',
        left: '50%',
    	top: '5%',
        title: tit, lock: false, width: wid, height: hei,
         ok: function () {
            
            //关闭弹出窗口
            this.close();
            return true;
        }

    });
}

//获取药店信息弹出框
function getDrugStore(){
		selectbasic("goGetDSPharmacistManage.action","","600","500");
	}
function selectbasic(url, tit, wid, hei) {

	    //弹出窗口
	    art.dialog.open(url, {
	        id: 'DrugStoreUploadState',
	        left: '50%',
	    	top: '5%',
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
			            $("#DrugStoreUploadStateDSNAME").val(str[1]);
	            	}
	            
	            //关闭弹出窗口
	            this.close();
	            return false;
	        },
	        cancel: true
	    });
	}


function exportExcel()
{
	document.form1.action = "exportExcelDrugStoreUploadState.action";
	document.form1.submit();
	//重新定向action使搜索正常
	document.form1.action = "searchDrugStoreUploadState.action";
}
function sub(){
	document.form1.submit();
	
}
</script>



<body>
<s:form id="form1" name="form1" method="post" action="searchDrugStoreUploadState.action">
    <div class="main">
	<table>
        <tr>
            <td>
             	药店名称：<s:textfield type="text" name="drugStoreUploadStateSearch.DRUGSTORENAME" id="DrugStoreUploadStateDSNAME" style=" width:100px;"/>
            </td>
            <td>
             	<a id="button1" href="#" onclick="getDrugStore();"><span>获取药店名称</span></a>
            </td>
            <td>
                上传时间：<s:textfield type="text" name="drugStoreUploadStateSearch.beginDate" style=" width:100px;" onblur="formatDate(this);"/>
               	至  <s:textfield type="text" name="drugStoreUploadStateSearch.endDate" style=" width:100px;" onblur="formatDate(this);"/>
            </td> 
        </tr>
        <tr>
            <td colspan="3">
<!--                 <input type="radio" name="drugStoreUploadStateSearch.IsUpload" value="" /> 全部 -->
<!--                 <input type="radio" name="drugStoreUploadStateSearch.IsUpload" value="1" /> 已上传 -->
<!--                 <input type="radio" name="drugStoreUploadStateSearch.IsUpload" value="0" />未上传 -->
                上传情况:<s:radio name="drugStoreUploadStateSearch.IsUpload" list="#{'-1':'全部','1':'已上传', '0':'未上传'}"/>
               
            </td>
            <td width="80px">
                <label>
					<a style="float:right;" id="button1" href="#" onclick="sub();"><span>检索</span></a>
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
             <th>上传状态</th>
             <th>最近上传时间</th>
             <th>药店详情</th>
             <th>上传详情</th>
        </tr> 
        <tr> 
           <s:iterator value="drugStoreUploadStateList">			
			<tr>
				<td><s:property value="drugStoreName" /></td>
				<td><s:property value="state" /></td>
				<td><s:property value="uploadTime" /></td>
				<td width="8%">
				<img src="img/3.jpg" onclick="showDrugStroreDetail('<s:property value="drugStoreID" />');" style="cursor:pointer;"/>
				</td>
				<td width="8%">
				<img src="img/3.jpg" onclick="showCountDetail('<s:property value="drugStoreID" />');" style="cursor:pointer;"/>
                </td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <%-- <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchDrugStoreUploadState.action" />
	</jsp:include>
		<p>&nbsp;</p> --%>
    </s:form>
</body>
</html>