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
		<link href="/styles/style.css" rel="stylesheet"
			type="text/css" />
		<link href="/styles/forms.css" rel="stylesheet"
			type="text/css" />
		<link href="/styles/default.css" rel="stylesheet"
			type="text/css" />
		<link href="/styles/alphacube.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript"
			src="/scripts/utils.js"></script>
		<script type="text/javascript"
			src="/scripts/prototype.js"></script>
		<script type="text/javascript"
			src="/scripts/window.js"></script>
		<script type="text/javascript"
			src="/scripts/effects.js"></script>
		<script type="text/javascript"
			src="/scripts/nb/policyEntry.js"></script>
		<jsp:include page="/WEB-INF/common/windowjs.jsp" flush="true"></jsp:include>
		<script type="text/javascript">
			Event.observe(window, 'load', function() {
				$('voucherCode').focus();
			});
		</script>

	</head>
	<body onload="adjustAmountAndPremium();">
		<div id="content">
			<jsp:include page="/WEB-INF/common/passwordForm.jsp" flush="true"></jsp:include>
			<div id="main">
				<div class="left">
					<jsp:include page="/WEB-INF/common/menu.jsp"  flush="true"/>
				</div>
				<div class="rightdiv">
					<div class="wrapper">
						<form id="policyEntry" name="policyEntry" action=""
							method="post">
							<table width="100%">
								<caption>
									航意险保单信息录入
								</caption>
								<tr>
									<td>
										<jsp:include page="../common/errorMessage.jsp"  flush="true"/>
										<fieldset>
											<legend></legend>
											<table width="100%" cellpadding="2" cellspacing="2">
												<tr>
													<th>
														当前操作人员
													</th>
													<td>
														<input id="userName" type="text" disabled="disabled"
															value='oujianhua'
															class="disabled" />
													</td>
													<th>
														网点
													</th>
													<td>
														<input id="orgName" type="text" disabled="disabled"
															value='oujianhua'
															class="disabled" />
													</td>
													<th>
														<span class="required">*</span>凭证号码
													</th>
													<td>
														<input id="voucherCode" name="policyInfo.voucherCode"
															value='1234'
															type="text" onblur="fillLength();" />
													</td>
												</tr>
											</table>
										</fieldset>
									</td>
								</tr>
								<tr>
									<td>
										<fieldset>
											<legend>
												保单信息
											</legend>
											<table width="100%">
												<tr>
													<th width="20%">
														<span class="required">*</span>被保险人姓名
													</th>
													<td width="30%">
														<input id="insuredName" name="policyInfo.insuredName"
															value='ssss'
															type="text" class=" inputlong" />
													</td>
													<th width="20%">
														<span class="required">*</span>航班号
													</th>
													<td width="30%">
														<input id="flightNumber" name="policyInfo.flightNumber"
															value='sss'
															type="text" class=" inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														<span class="required">*</span>登机日期
													</th>
													<td>
														<input id="boardingTime" name="policyInfo.boardingTime"
															value='2010-1-1'
															type="text" onblur="formatDate(boardingTime)"
															class=" inputlong" />
													</td>
													<th>
														<span class="required">*</span>份数
													</th>
													<td>
													<select id="count" name="" class=""inputlong>
													  <option>111</option>		
													  <option>111</option>		
													  <option>111</option>		
													  <option>111</option>													
													</select>
<%-- 														<s:select id="count" label="" name="policyInfo.count" --%>
<!-- 															list="counts" listKey="code" listValue="name" -->
<!-- 															value="policyInfo.count" -->
<!-- 															onchange="adjustAmountAndPremium();" cssClass="inputlong" /> -->
													</td>
												</tr>
												<tr>
													<th>
														<span class="required">*</span>被保险人证件类型
													</th>
													<td>
													<select id="count" name="" class=""inputlong>
													  <option>111</option>		
													  <option>111</option>		
													  <option>111</option>		
													  <option>111</option>													
													</select>
<%-- 														<s:select id="insuredCertiType" label="" --%>
<!-- 															name="policyInfo.insuredCertiType" list="identifies" -->
<!-- 															listKey="code" listValue="name" -->
<!-- 															value="policyInfo.insuredCertiType" emptyOption="true" -->
<!-- 															cssClass="inputlong" /> -->
													</td>
													<th>
														<span class="required">*</span>被保险人证件号码
													</th>
													<td>
														<input id="insuredCertiCode"
															name="policyInfo.insuredCertiCode"
															value='2233'
															type="text" class="inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														<span class="required">*</span>受益人是否法定
													</th>
													<td>
														
															<input id="legalBeneficiary1"
																name="policyInfo.legalBeneficiary" type="radio"
																value="Y" checked="checked"
																onclick="beneficiaryInfoDisabled();" />
														是
														<input id="legalBeneficiary2"
																name="policyInfo.legalBeneficiary" type="radio"
																value="N" onclick="beneficiaryInfoEnabled();" />
														否
														
													</td>
													<th>
														被保险人联系电话
													</th>
													<td>
														<input id="insuredTelephone"
															value='2222'
															name="policyInfo.insuredTelephone" type="text"
															class="inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														受益人姓名
													</th>
													<td>
														<input id="beneficiaryName"
															name="policyInfo.beneficiaryName"
															value='2222'
															type="text" class="inputlong" />
													</td>
													<th>
														受益人与被保险人关系
													</th>
													<td>
													<select id="count" name="" class=""inputlong>
													  <option>111</option>		
													  <option>111</option>		
													  <option>111</option>		
													  <option>111</option>													
													</select>
<%-- 														<s:select id="relationshipId" label="" --%>
<!-- 															name="policyInfo.beneficiaryRelationInsured" -->
<!-- 															list="relationship" listKey="code" listValue="name" -->
<!-- 															value="policyInfo.beneficiaryRelationInsured" -->
<!-- 															emptyOption="true" cssClass="inputlong" /> -->
													</td>
												</tr>
												<tr>
													<th>
														保险金额
													</th>
													<td>
														<input id="amount" name="policyInfo.amount"
															value='323'
															type="text" value="" disabled="true"
															class="disabled inputlong" />
													</td>
													<th>
														保费
													</th>
													<td>
														<input id="premium" name="policyInfo.premium"
															value='323'
															type="text" value="" disabled="true"
															class="disabled inputlong" />
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
													<input id="entryPolicy" name="entryPolicy" type="button"
														class="button" onclick="savePolicy();" value="确认收费并打印" />
													<input id="reset" name="reset" type="button" class="button"
														onclick="resetForm();" value="重置" />
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<input id="saved" name="saved" type="hidden"
								value='323>' />
						</form>
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
