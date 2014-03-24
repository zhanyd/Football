<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />


<body>
    <table border="0" cellspacing="0" cellpadding="0" class="tbv"> 
        <tr > 
             <td >已上传药品信息库记录条数： </td>
             <td><s:label name="drugStoreUploadState.drugdicCount" /></td>
         </tr>
         <tr>
             <td >已上传药品购进记录条数： </td>
             <td><s:label  name="drugStoreUploadState.buyrecordCount" /></td>
        </tr>
        <tr > 
             <td>已上传药品销售记录条数： </td>
             <td><s:label  name="drugStoreUploadState.marketingCount" /></td>
         </tr>
         <tr>
             <td>已上传药品库存记录条数： </td>
             <td><s:label  name="drugStoreUploadState.stroageinventoryCount" /></td>
        </tr>
        
    </table>
    
</body>
</html>


