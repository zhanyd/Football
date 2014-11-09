<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function Main() {
	window.location.href = "goPharmacistManage.action";
}
</script>

<body>

    <table border="0" cellspacing="0" cellpadding="0" id="tablewi4"> 
     
        <tr > 
             <td >姓名： </td>
             <td><s:textfield type="text" name="pharmacist.PHNAME" /></td>
             <td >所属单位： </td>
             <td><s:textfield type="text" name="pharmacist.DRUGSTORENAME" /></td>
        </tr>
        <tr > 
             <td>性别： </td>
        	 <td><s:select name="pharmacist.SEX"
				cssClass="txt3" list="#{'1':'男', '0':'女'}"
				value="pharmacist.SEX" /></td>
             <td>岗位： </td>
             <td><s:textfield type="text" name="pharmacist.POSITION" /></td>
        </tr>
        <tr > 
             <td>联系电话： </td>
             <td><s:textfield type="text" name="pharmacist.TEL" /></td>
             <td>联系地址： </td>
             <td><s:textfield type="text" name="pharmacist.ADDRESS" /></td>
        </tr>
        <tr > 
             <td>出生年月： </td>
             <td><s:textfield type="text" name="pharmacist.BIRTHDAY" /></td>
             <td>籍贯： </td>
             <td><s:textfield type="text" name="pharmacist.NATIVEPLACE" /></td>
        </tr> 
        <tr > 
             <td>学历： </td>
             <td><s:textfield type="text" name="pharmacist.EDUCATION" /></td>
             <td>毕业院校： </td>
             <td><s:textfield type="text" name="pharmacist.GRADUATE" /></td>
        </tr>
        <tr > 
             <td>身份证号码： </td>
             <td><s:textfield type="text" name="pharmacist.IDCARDNO" /></td>
             <td>药师资格证编号： </td>
             <td><s:textfield type="text" name="pharmacist.CERTIFICATEID" /></td>
        </tr>
        <tr > 
             <td>职业资格： </td>
             <td><s:textfield type="text" name="pharmacist.QUALIFICATION" /></td>
             <td>发证单位： </td>
             <td><s:textfield type="text" name="pharmacist.LSSUEUNIT" /></td>
        </tr> 
        <tr > 
             <td>注册日期： </td>
             <td><s:textfield type="text" name="pharmacist.CREATEDATE" /></td>
             <td>指纹注册</td>
             <s:if test="pharmacist.FINGERPRINT != null && pharmacist.FINGERPRINT != ''" >
				<td width="6%">是</td>
				</s:if>
				<s:else>
				<td width="6%">否</td>
			 </s:else>
        </tr> 
        <tr>
            <td>药师指纹</td>
            <td><s:textfield type="text" name="pharmacist.FINGERPRINT" /></td>
        </tr>
       
    </table>
	<input type="button" name="" value="返回" onclick="Main();" />

    
</body>
</html>
