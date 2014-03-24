<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="description" content="保单在线销售系统" />
		<meta name="keywords" content="保单在线销售" />
		<meta name="author" content="luotao@lifeisgreat.com.cn" />
		<title>在线销售系统</title>
		<link href="<s:url value='/styles/style.css'/>" rel="stylesheet"
			type="text/css" />
		<link href="<s:url value='/styles/forms.css'/>" rel="stylesheet"
			type="text/css" />
		<link href="<s:url value='/styles/default.css'/>" rel="stylesheet"
			type="text/css" />
		<link href="<s:url value='/styles/alphacube.css'/>" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript"
			src="<c:url value="/scripts/utils.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/scripts/prototype.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/scripts/window.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/scripts/effects.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/scripts/nb/policyEntry.js"/>"></script>
		<s:include value="/WEB-INF/common/windowjs.jsp"></s:include>
	</head>
	<body onload="formatMoney();">
		<div id="content">
			<s:include value="/WEB-INF/common/passwordForm.jsp"></s:include>
			<div id="main">
				<div class="left">
					<s:include value="/WEB-INF/common/menu.jsp" />
				</div>
				<div class="rightdiv">
					<div class="wrapper">
						<s:form id="policyDetail" action="" method="post">
							<table width="100%">
								<caption>
									航意险保单信息
								</caption>

								<tr>
									<td>
										<fieldset>
											<legend>
												保单信息
											</legend>
											<table width="100%">
												<tr>
													<th width="20%">
														网点
													</th>
													<td width="30%">
														<input id="orgName" type="text"
															value='<s:property value="policyDetail.orgName" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
													<th width="20%">
														保险单号
													</th>
													<td width="30%">
														<input id="policyCode" type="text"
															value='<s:property value="policyDetail.policyCode" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														凭证号码
													</th>
													<td>
														<input id="voucherCode" type="text"
															value='<s:property value="policyDetail.voucherCode" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
													<th>
														保单状态
													</th>
													<td>
														<input id="policyStatus" type="text"
															value='<s:property value="policyDetail.policyStatusName" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														被保险人姓名
													</th>
													<td>
														<input id="insuredName" type="text"
															value='<s:property value="policyDetail.insuredName" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
													<th>
														被保险人证件类型
													</th>
													<td>
														<input id="insuredCertiTypeName" type="text"
															value='<s:property value="policyDetail.insuredCertiTypeName" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														被保险人证件号码
													</th>
													<td>
														<input id="insuredCertiCode" type="text"
															value='<s:property value="policyDetail.insuredCertiCode" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
													<th>
														被保险人联系电话
													</th>
													<td>
														<input id="insuredTelephone" type="text"
															value='<s:property value="policyDetail.insuredTelephone" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														航班号
													</th>
													<td>
														<input id="flightNumber" type="text"
															value='<s:property value="policyDetail.flightNumber" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
													<th>
														登机日期
													</th>
													<td>
														<input id="boardingTime" type="text"
															value='<s:property value="policyDetail.boardingTime" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														受益人姓名
													</th>
													<td>
														<input id="beneficiaryName" type="text"
															value='<s:property value="policyDetail.beneficiaryName" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
													<th>
														受益人与被保险人关系
													</th>
													<td>
														<input id="beneficiaryRelationInsuredName" type="text"
															value='<s:property value="policyDetail.beneficiaryRelationInsuredName" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														份数
													</th>
													<td>
														<input id="count" type="text"
															value='<s:property value="policyDetail.count" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
													<th>
														保费
													</th>
													<td>
														<input id="premium" type="text"
															value='<s:property value="policyDetail.premium" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														保险金额
													</th>
													<td>
														<input id="amount" type="text"
															value='<s:property value="policyDetail.amount" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
													<th>
														出单日期
													</th>
													<td>
														<input id="effectiveDate" type="text"
															value="<s:date name='policyDetail.effectiveDate' format='yyyy-MM-dd HH:mm:ss'/>"
															disabled="disabled" class="disabled inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														操作人员
													</th>
													<td>
														<input id="createUserName" type="text"
															value='<s:property value="policyDetail.createUserName" />'
															disabled="disabled" class="disabled inputlong" />
													</td>
													<th>
														&nbsp;
													</th>
													<td>
														&nbsp;
													</td>
												</tr>
											</table>
										</fieldset>
									</td>
								</tr>
								<tr>
									<td>
										<table width="100%" class="right">
											<tr>
												<td>
													<input name="back" type="button" class="inputmin"
														value="返回" onclick="backToSearch();" />
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</s:form>
					</div>
				</div>
			</div>

		</div>
		<div class="footer">
			<p>
				Copyright © 2008 Great Eastern Life Assurance (China) Co.,Ltd. All
				Rights Reserved.
			</p>
			<p>
				中新大东方人寿保险有限公司 版权所有
			</p>
		</div>
	</body>
</html>
