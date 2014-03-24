<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/scripts/include.jsp" flush="true" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function () {
    $("#PharmacistManageDRUGSTORENAME").autocomplete(<%= session.getAttribute("jsonresult")%>, DrugAutocompleteSeting)
    .result(function (event, data, formatted) { //回调
        $('#PharmacistManageDRUGSTORENAME')[0].value = data.name;
    });
});

function PhRegister() {
	window.location.href = "registerPharmacistManage.action";
}
function add() {
	window.location.href = "goaddPharmacistManage.action";
}
function edit(USERID) {
	window.location.href = "goeditPharmacistManage.action?pharmacist.USERID="+USERID;
}
function del(USERID) {
	if( confirm("确定删除？"))
		{
			window.location.href = "delPharmacistManage.action?pharmacist.USERID="+USERID;
		}
}
function detial(USERID) {
	window.location.href = "godetailPharmacistManage.action?pharmacist.USERID="+USERID;
}
function exportExcel()
{
	document.form1.action = "exportExcelPharmacistManage.action";
	document.form1.submit();
}
//获取药店信息弹出框
function getDrugStore(){
		selectbasic("goGetDSPharmacistManage.action","","600","500");
	}
function selectbasic(url, tit, wid, hei) {

	    //弹出窗口
	    art.dialog.open(url, {
	        id: 'PharmacistManage',
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
			            $("#PharmacistManageDRUGSTORENAME").val(str[1]);
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
             	所属单位名称：<s:textfield type="text" name="pharmacist.DRUGSTORENAME" id="PharmacistManageDRUGSTORENAME" style=" width:100px;"/>
            </td>
            <td>
             	<a id="button1" href="#" onclick="getDrugStore();"><span>获取药店名称</span></a>
            </td>
            <td>
                                         药师姓名： <s:textfield type="text" name="pharmacist.PHNAME" style=" width:100px;"/>
            </td> 
        </tr>
        <tr>
        	<td>
        		<label> 
					<a id="button1" href="#" onclick="PhRegister()"><span>药师指纹注册</span></a>
				</label>
        	</td>
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
             <th>所属单位</th>
             <th>姓名</th>
             <th>性别</th>
             <th>岗位</th>
             <th>联系电话</th>
             <th>地址</th>
             <th>注册日期</th>
             <th>资格证编号</th>
             <th>指纹注册</th>
             <th>操作</th> 
        </tr> 
        <tr> 
           <s:iterator value="pageObject.objectList">			
			<tr>
				<td><s:property value="DRUGSTORENAME" /></td>
				<td width="8%"><s:property value="PHNAME" /></td>
				
				<s:if test="SEX==1" >
				<td width="5%">男</td>
				</s:if>
				<s:else>
				<td width="5%">女</td>
				</s:else>

				<td><s:property value="POSITION" /></td>
				<td><s:property value="TEL" /></td>
				<td><s:property value="ADDRESS" /></td>
				<td width="8%"><s:property value="CREATEDATE" /></td>
				<td><s:property value="CERTIFICATEID" /></td>
				
				<s:if test="FINGERPRINT != null && FINGERPRINT != ''" >
				<td width="6%">是</td>
				</s:if>
				<s:else>
				<td width="6%">否</td>
				</s:else>
				
				<td width="12%">
				<img src="img/3.jpg" onclick="detial('<s:property value="USERID" />');" style="cursor:pointer;"/>
				<img src="img/4.jpg" onclick="edit('<s:property value="USERID" />');" style="cursor:pointer;"/>
				<img src="img/5.jpg" onclick="del('<s:property value="USERID" />');" style="cursor:pointer;"/>
			    </td>
			</tr>
			</s:iterator>
        </tr> 
    </table>
    <jsp:include flush="true" page="/WEB-INF/common/page/pageFooter.jsp">
			<jsp:param name="submitAction" value="searchPharmacistManage.action" />
	</jsp:include>
		<p>&nbsp;</p>
    </s:form>
</body>
</html>
