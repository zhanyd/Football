<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />

<body>

    <table border="0" cellspacing="0" cellpadding="0" class="tbv"> 
     
        <tr> 
             <td >药店名： </td>
             <td><s:label name="drugdic.DRUGSTORENAME" />
       </tr>
        <tr>
             <td >药品名： </td>
             <td><s:label name="drugdic.DRUGFULLNAME" />
        </tr>
        <tr> 
             <td>规格： </td>
             <td><s:label name="drugdic.STANDARD" />
        </tr>
        <tr>
             <td>剂型： </td>
             <td><s:label name="drugdic.DRUGFORM" />
        </tr>
        <tr>
             <td>批准文号： </td>
             <td><s:label name="drugdic.APPROVALNUMBER" />
        </tr>
        <tr>     
             <td>生产厂商： </td>
             <td><s:label name="drugdic.MANUFACTURER" />
        </tr>
        <tr>
             <td>条形码： </td>
             <td><s:label name="drugdic.BARCODE" />
         </tr>
        <tr>
             <td>是否处方药： </td>
             <td><s:label name="drugdic.ISRX" />
        </tr>
        <tr> 
             <td>上传日期： </td>
             <td><s:label name="drugdic.DIC_CREATETIME" />
       </tr>    
        
    </table>


    
</body>
</html>
