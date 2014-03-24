<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function Main() {
	window.location.href = "godetailDrugStoreLoginRecord.action";
}
</script>

<body>
    <table border="0" cellspacing="0" cellpadding="0" id="tablewi4"> 
        <tr > 
             <td >监管对象名称： </td>
             <td></td>
             <td >许可证号： </td>
             <td><s:textfield type="text" name="drugstore.BUSINESSOPERATIONID" /></td>
        </tr>
        <tr > 
             <td>所属地区： </td>
             <td><s:textfield type="text" name="drugstore.REGION" /></td>
             <td>经营地址： </td>
             <td><s:textfield type="text" name="drugstore.ADDRESS" /></td>
        </tr>
        <tr > 
             <td>联系电话： </td>
             <td><s:textfield type="text" name="drugstore.TEL" /></td>
             <td>传真： </td>
             <td><s:textfield type="text" name="drugstore.FAX" /></td>
        </tr>
        <tr > 
             <td>企业性质： </td>
             <td><s:textfield type="text" name="drugstore.NATURE" /></td>
             <td>经营模式： </td>
             <td><s:textfield type="text" name="drugstore.BUSINESSMODEL" /></td>
        </tr> 
        <tr > 
             <td>经营范围： </td>
             <td><s:textfield type="text" name="drugstore.BUSINESSSCOPE" /></td>
             <td>企业负责人：</td>
             <td><s:textfield type="text" name="drugstore.RESPONSIBLEPERSON" /></td>
        </tr>
        <tr > 
             <td>视频连接地址： </td>
             <td><s:textfield type="text" name="drugstore.VIDEOURL" /></td>
          
        </tr>
      
        
    </table>
	<input type="button" name="" value="返回" onclick="Main();" />
    
</body>
</html>


