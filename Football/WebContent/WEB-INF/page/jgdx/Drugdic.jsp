<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<jsp:include page="/scripts/include.jsp" flush="true" />
<script type="text/javascript">
$(document).ready(function () {
    $("#DrugdicDRUGSTORENAME").autocomplete(<%= session.getAttribute("jsonresult")%>, DrugAutocompleteSeting)
    .result(function (event, data, formatted) { //回调
        $('#DrugdicDRUGSTORENAME')[0].value = data.name;
    });
});

function showDrugdicDetail(DIC_ID){
	selectbasic("godetailDrugdic.action?drugdic.DIC_ID="+DIC_ID,"详情","700","400");
	}
	
	
function exportExcel()
{
	document.form1.action = "exportExcelDrugdic.action";
	document.form1.submit();
}

function selectbasic(url, tit, wid, hei) {

    //弹出窗口
    art.dialog.open(url, {
        id: 'selectbasic',
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
		selectbasic2("goGetDSPharmacistManage.action","","600","500");
	}
function selectbasic2(url, tit, wid, hei) {

	    //弹出窗口
	    art.dialog.open(url, {
	        id: 'Drugdic',
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
			            $("#DrugdicDRUGSTORENAME").val(str[1]);
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
             	药店名称:<s:textfield type="text" name="drugdic.DRUGSTORENAME" id="DrugdicDRUGSTORENAME" style="width:100px;"/>
             	
            </td>
            <td>
             	<a id="button1" href="#" onclick="getDrugStore();"><span>获取药店名称</span></a>
            </td>
            <td>
                                         药品全名:<s:textfield type="text" name="drugdic.DRUGFULLNAME" style=" width:100px;"/>
            </td> 
         </tr>
         <tr>
             <td>
                                         生产厂商:<s:textfield type="text" name="drugdic.MANUFACTURER" style=" width:100px;"/>
            </td>
			<td></td>
             <td>
                                         上传日期:<s:textfield type="text" name="drugdic.DIC_CREATETIME" style=" width:100px;" onblur="formatDate(this);"/>
            </td> 
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
             <th>药店名字</th>
             <th>药品全名</th>
             <th>生产厂商</th>
             <th>批准文号位</th>
             <th>上传日期</th>
             <th>详细</th>
        </tr> 
        <tr> 
           <s:iterator value="pageObject.objectList">			
			<tr>
				<td width="20%"><s:property value="DRUGSTORENAME" /></td>
				<td><s:property value="DRUGFULLNAME" /></td>
				<td><s:property value="MANUFACTURER" /></td>
				<td><s:property value="APPROVALNUMBER" /></td>
				<td><s:property value="DIC_CREATETIME" /></td>		
				<td>
				<img src="img/3.jpg" onclick="showDrugdicDetail('<s:property value="DIC_ID" />');" style="cursor:pointer;"/>
				
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchDrugdic.action" />
	</jsp:include>
		<p>&nbsp;</p>
    </s:form>
</body>
</html>