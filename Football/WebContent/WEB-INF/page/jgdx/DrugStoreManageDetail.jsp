<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function Main() {
	window.location.href = "goDrugStoreManage.action";
}
</script>

<body>
    <table border="0" cellspacing="0" cellpadding="0" id="tablewi4"> 
       <tr>
				<td>监管对象名称：</td>
				<td><s:textfield type="text" name="drugstore.DSNAME" ck="rq" /></td>
				<td>许可证号：</td>
				<td><s:textfield type="text"
						name="drugstore.BUSINESSOPERATIONID" /></td>
			</tr>
			<tr>
				<td>所属地区：</td>
				<td><s:textfield type="text" name="drugstore.REGION" /></td>
				<td>经营地址：</td>
				<td><s:textfield type="text" name="drugstore.ADDRESS" /></td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td><s:textfield type="text" name="drugstore.TEL"
						onblur="checkNumber(this);" /></td>
				<td>传真：</td>
				<td><s:textfield type="text" name="drugstore.FAX"
						onblur="checkNumber(this);" /></td>
			</tr>
			<tr>
				<td>企业性质：</td>
				<td><s:textfield type="text" name="drugstore.NATURE" /></td>
				<td>经营模式：</td>
				<td><s:textfield type="text" name="drugstore.BUSINESSMODEL" /></td>
			</tr>
			<tr>
				<td>经营范围：</td>
				<td><s:textfield type="text" name="drugstore.BUSINESSSCOPE" /></td>
				<td>职工人数：</td>
				<td><s:textfield type="text" name="drugstore.PEOPLECOUNT" /></td>
			</tr>
			<tr>
				<td>视频连接地址： </td>
				<td><s:textfield type="text" name="drugstore.VIDEOURL" /></td>

			</tr>
			<tr>
				<td>企业负责人姓名：</td>

				<td><s:textfield type="text" name="drugstore.RESPONSIBLEPERSON" />
				</td>
				<td>企业负责人职称：</td>
				<td><s:textfield type="text" name="drugstore.RJOBTITLE" /></td>
			</tr>
			<tr>

				<td>企业负责人手机号：</td>
				<td><s:textfield type="text" name="drugstore.RPHONENO" /></td>
				<td>企业负责人职位：</td>
				<td><s:textfield type="text" name="drugstore.RPOST" /></td>
			</tr>



			<tr>
				<td>法定代表人姓名：</td>
				<td><s:textfield type="text" name="drugstore.LEGALPERSON" /></td>
				<td>法定代表人职称：</td>
				<td><s:textfield type="text" name="drugstore.LJOBTITLE" /></td>
			</tr>
			<tr>

				<td>法定代表人手机号：</td>
				<td><s:textfield type="text" name="drugstore.LPHONENO" /></td>
				<td>法定代表人职位：</td>
				<td><s:textfield type="text" name="drugstore.LPOST" /></td>
			</tr>

			<tr>
				<td>质量负责人姓名：</td>
				<td><s:textfield type="text" name="drugstore.QUALITYPERSON" />
				</td>
				<td>质量负责人职称：</td>
				<td><s:textfield type="text" name="drugstore.QJOBTITLE" /></td>
			</tr>
			<tr>

				<td>质量负责人手机号：</td>
				<td><s:textfield type="text" name="drugstore.QPHONENO" /></td>
				<td>质量负责人职位：</td>
				<td><s:textfield type="text" name="drugstore.QPOST" /></td>
			</tr>

			<tr>
				<td>处方药审核人姓名：</td>
				<td><s:textfield type="text" name="drugstore.DRUGCHECKPERSON" />
				</td>
				<td>处方药审核人职称：</td>
				<td><s:textfield type="text" name="drugstore.DJOBTITLE" /></td>
			</tr>
			<tr>

				<td>处方药审核人手机号：</td>
				<td><s:textfield type="text" name="drugstore.DPHONENO" /></td>
				<td>处方药审核人职位：</td>
				<td><s:textfield type="text" name="drugstore.DPOST" /></td>
			</tr>
			<tr>
				<td>是否已监管：</td> 
				<td><s:select name="drugstore.ISSUPERVISED"
						cssClass="txt3" list="#{'1':'是', '0':'否'}"
						value="drugstore.ISSUPERVISED" /></td>

			</tr>

			<tr>
				<td><label>其他人员：</label></td>
				<td><s:textarea rows="3" type="text"
						name="drugstore.OTHERPEOPLE" /></td>
				<td><label>备注：</label></td>
				<td><s:textarea rows="3" type="text" name="drugstore.REMARK" />

				</td>

			</tr>

    </table>
	<input type="button" name="" value="返回" onclick="Main();" />
    
</body>
</html>


