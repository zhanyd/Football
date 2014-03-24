<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />


<body>
    <table border="0" cellspacing="0" cellpadding="0" class="tbv"> 
        <tr > 
             <td width="100px">监管对象名称： </td>
             <td><s:label name="drugstore.DSNAME" /></td>
             <td width="100px">许可证号： </td>
             <td><s:label  name="drugstore.BUSINESSOPERATIONID" /></td>
        </tr>
        <tr > 
             <td>所属地区： </td>
             <td><s:label name="drugstore.REGION" /></td>
             <td>经营地址： </td>
             <td><s:label  name="drugstore.ADDRESS" /></td>
        </tr>
        <tr > 
             <td>联系电话： </td>
             <td><s:label  name="drugstore.TEL" /></td>
             <td>传真： </td>
             <td><s:label  name="drugstore.FAX" /></td>
        </tr>
        <tr > 
             <td>企业性质： </td>
             <td><s:label  name="drugstore.NATURE" /></td>
             <td>经营模式： </td>
             <td><s:label  name="drugstore.BUSINESSMODEL" /></td>
        </tr> 
        <tr > 
             <td>经营范围： </td>
             <td><s:label  name="drugstore.BUSINESSSCOPE" /></td>
             <td>企业负责人：</td>
             <td><s:label  name="drugstore.RESPONSIBLEPERSON" /></td>
        </tr>
        
    </table>
    
</body>
</html>


