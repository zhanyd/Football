<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery/jquery-1.8.3.js" type="text/javascript"></script>

<body>
<s:form id="form1" name="form1" method="post" action="searchGetDSPharmacistManage.action">
	<table>
        <tr>
            <td>
             	监管对象名称：<s:textfield type="text" name="drugstore.DSNAME" style=" width:100px;"/>
            </td>
           
            <td>
                <label> <input type="submit" name="" value="检索"/>
				</label>
			
            </td>
        </tr>
    </table>
    <table border="0" cellspacing="1" cellpadding="0" id=""> 
        <tr class="sty1"> 
             <th>监管对象名称</th>
             <th>经营地址</th> 
            
        </tr> 
        <tr> 
           <s:iterator value="drugstoreList">			
			<tr>
				<td><s:property value="DSNAME" /></td>
				<td><s:property value="ADDRESS" /></td>
			    <td><input type="radio" name="radioselect" value="<s:property value="DRUGSTOREID" />,<s:property value="DSNAME" />"/> </td>
			</tr>
			</s:iterator>
        </tr> 
    </table>

    </s:form>
</body>
</html>
