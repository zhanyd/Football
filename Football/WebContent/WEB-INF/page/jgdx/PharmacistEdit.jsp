<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="/scripts/include.jsp" flush="true" />
<script type="text/javascript">

$(document).ready(function () {
    $("#PharmacistEditDRUGSTORENAME").autocomplete(<%= session.getAttribute("jsonresult")%>, DrugAutocompleteSeting)
    .result(function (event, data, formatted) { //回调
        $('#PharmacistEditDRUGSTORENAME')[0].value = data.name;
    });
});
function Main() {
	window.location.href = "goPharmacistManage.action";
}
//提交表单验证
function validate() {
	return checktb('tablewi4');
}
function getDrugStore(){
	selectbasic("goGetDSPharmacistManage.action","","500","500");
	}
	
	
function selectbasic(url, tit, wid, hei) {

    //弹出窗口
    art.dialog.open(url, {
        id: 'PharmacistEdit',
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
		            $("#PharmacistEditDRUGSTORENAME").val(str[1]);
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
 <form id="form1" name="form1" method="post" action="editPharmacistManage.action" onsubmit="return validate();">
    <table border="0" cellspacing="0" cellpadding="0" id="tablewi4"> 
        <s:hidden type="text" name="pharmacist.USERID" />
        <s:hidden type="text" name="pharmacist.DRUGSTOREID" id="DRUGSTOREID"/>
			<tr>
				<td><font style="color:Red">*</font>姓名：</td>
				<td><s:textfield type="text" name="pharmacist.PHNAME"
						id="PHNAME"  ck="rq"/></td>
				<td><font style="color:Red">*</font>所属单位：</td>
				<td>
					<s:textfield type="text" name="pharmacist.DRUGSTORENAME" id="PharmacistEditDRUGSTORENAME" ck="rq" />
					<input type="button" name="" value="获取药店名称"
						onclick="getDrugStore();" />
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><s:select name="pharmacist.SEX"
				cssClass="txt3" list="#{'1':'男', '0':'女'}"
				value="pharmacist.SEX" /></td>
				<td>岗位：</td>
				<td><s:textfield type="text" name="pharmacist.POSITION" /></td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td><s:textfield type="text" name="pharmacist.TEL" ck="int" /></td>
				<td>联系地址：</td>
				<td><s:textfield type="text" name="pharmacist.ADDRESS" /></td>
			</tr>
			<tr>
				<td>出生年月(yyyyMMdd)</td>
				<td><s:textfield type="text" name="pharmacist.BIRTHDAY"
						onblur="formatDate(this);" /></td>
				<td>籍贯：</td>
				<td><s:textfield type="text" name="pharmacist.NATIVEPLACE" /></td>
			</tr>
			<tr>
				<td>学历：</td>
				<td><s:textfield type="text" name="pharmacist.EDUCATION" /></td>
				<td>毕业院校：</td>
				<td><s:textfield type="text" name="pharmacist.GRADUATE" /></td>
			</tr>
			<tr>
				<td><font style="color:Red">*</font>身份证号码：</td>
				<td><s:textfield type="text" name="pharmacist.IDCARDNO" ck="rq"/></td>
				<td>药师资格证编号：</td>
				<td><s:textfield type="text" name="pharmacist.CERTIFICATEID" /></td>
			</tr>
			<tr>
				<td>职业资格：</td>
				<td><s:textfield type="text" name="pharmacist.QUALIFICATION" /></td>
				<td>发证单位：</td>
				<td><s:textfield type="text" name="pharmacist.LSSUEUNIT" /></td>
			</tr>
        
    </table>
    <input type="submit" name="Submit" value="提交" />
	<input type="button" name="" value="返回" onclick="Main();" />
    </form>
    
</body>
</html>
