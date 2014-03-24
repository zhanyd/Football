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
		<script type="text/javascript"
			src="<c:url value="/scripts/page/page.js"/>"></script>
		<s:include value="/WEB-INF/common/windowjs.jsp"></s:include>
	</head>
	<body>
		<div id="content">
			<s:include value="/WEB-INF/common/passwordForm.jsp"></s:include>
			<div id="main">
				<div class="left">
					<s:include value="/WEB-INF/common/menu.jsp" />
				</div>
				<div class="rightdiv">
					<div class="wrapper">
						<s:form action="" method="post">
							<table width="100%">
								<caption>
									航意险保单信息查询
								</caption>
								<tr>
									<td>
										<fieldset>
											<legend>
												查询条件
											</legend>
											<table width="100%">
												<tr>
													<th width="20%">
														网点
													</th>
													<td width="30%">
													<s:if test="#session['cn.com.lifeisgreat.gims.fdm.struts2.action.User'].organization.orgType == 2">
													   <s:hidden name="policyQueryCondition.orgId" value="%{#session['cn.com.lifeisgreat.gims.fdm.struts2.action.User'].organization.orgId}"></s:hidden>
													   <s:textfield 															
															value="%{#session['cn.com.lifeisgreat.gims.fdm.struts2.action.User'].organization.orgName}"
															 disabled="true" cssClass="disabled inputlong" />
															
<%--													   <s:select id="orgId" label=""--%>
<%--															name="policyQueryCondition.orgId" list="organizations"--%>
<%--															listKey="orgId" listValue="orgName"--%>
<%--															value="policyQueryCondition.orgId" cssClass="inputlong" />--%>
													</s:if>
													<s:if test="#session['cn.com.lifeisgreat.gims.fdm.struts2.action.User'].organization.orgType == 1">
													   <s:select id="orgId" label=""
															name="policyQueryCondition.orgId" list="organizations"
															listKey="orgId" listValue="orgName"
															value="policyQueryCondition.orgId" cssClass="inputlong" />
														</s:if>
													</td>
													<th width="20%">
														凭证号码
													</th>
													<td width="30%">
														<input id="voucherCode"
															name="policyQueryCondition.voucherCode"
															value='<s:property value="policyQueryCondition.voucherCode"/>'
															onblur="fillLength();" type="text" class=" inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														被保险人姓名
													</th>
													<td>
														<input id="insuredName"
															name="policyQueryCondition.insuredName"
															value='<s:property value="policyQueryCondition.insuredName"/>'
															type="text" class=" inputlong" />
													</td>
													<th>
														航班号
													</th>
													<td>
														<input id="flightNumber"
															name="policyQueryCondition.flightNumber"
															value='<s:property value="policyQueryCondition.flightNumber"/>'
															type="text" class=" inputlong" />
													</td>
												</tr>
												<tr>
													<th>
														保单状态
													</th>
													<td>
														<s:select id="policyStatus" label=""
															name="policyQueryCondition.policyStatus"
															list="policyStatus" listKey="code" listValue="name"
															value="policyQueryCondition.policyStatus"
															emptyOption="true" cssClass="inputlong" />
													</td>
													<th>
														登机时间(yyyymmdd)
													</th>
													<td>
														<input id="boardingTime"
															name="policyQueryCondition.boardingTime"
															value='<s:property value="policyQueryCondition.boardingTime"/>'
															onblur="checkAndFormatDate(boardingTime, boardingEndTime)"
															type="text" class=" inputshort" />
														-
														<input id="boardingEndTime"
															name="policyQueryCondition.boardingEndTime"
															value='<s:property value="policyQueryCondition.boardingEndTime"/>'
															onblur="checkAndFormatDate(boardingTime, boardingEndTime)"
															type="text" class=" inputshort" />
													</td>
												</tr>
												<tr>
													<th>
														出单时间(yyyymmdd)
													</th>
													<td>
														<input id="effectiveDate"
															name="policyQueryCondition.effectiveDate"
															value='<s:property value="policyQueryCondition.effectiveDate"/>'
															onblur="checkAndFormatDate(effectiveDate, effectiveEndDate)"
															class=" inputshort" type="text" />
														-
														<input id="effectiveEndDate"
															name="policyQueryCondition.effectiveEndDate"
															value='<s:property value="policyQueryCondition.effectiveEndDate"/>'
															onblur="checkAndFormatDate(effectiveDate, effectiveEndDate)"
															class=" inputshort" type="text" />
													</td>
													<td>
														&nbsp;
													</td>
													<td>
														&nbsp;
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<table width="100%" class="right">
															<tr>
																<td>
																	<input name="search1" type="button" onclick="search();"
																		class="inputmin" value="查询" />
																</td>
															</tr>
														</table>
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
												查询结果
											</legend>
											<table width="100%" class="border">
												<thead>
													<tr>
														<td>
															网点
														</td>
														<td>
															凭证号码
														</td>
														<td>
															被保险人姓名
														</td>
														<td>
															航班号
														</td>
														<td>
															登机时间
														</td>
														<td>
															出单时间
														</td>
														<td>
															保单状态
														</td>
													</tr>
												</thead>
												<tbody>
													<s:iterator value="pageObject.objectList" status="status">
														<s:url id="link" value="detail.jspa">
															<s:param name="policyQueryCondition.policyId"
																value="%{policyId}" />
														</s:url>
														<tr>
															<td>
																<s:a href="%{link}">
																	<s:property value="orgName" />
																</s:a>
															</td>
															<td>
																<s:a href="%{link}">
																	<s:property value="voucherCode" />
																</s:a>
															</td>
															<td>
																<s:a href="%{link}">
																	<s:property value="insuredName" />
																</s:a>
															</td>
															<td>
																<s:a href="%{link}">
																	<s:property value="flightNumber" />
																</s:a>
															</td>
															<td>
																<s:a href="%{link}">
																	<s:property value="boardingTime" />
																</s:a>
															</td>
															<td>
																<s:a href="%{link}">
																	<s:date name="effectiveDate"
																		format="yyyy-MM-dd HH:mm:ss" />
																</s:a>
															</td>
															<td>
																<s:a href="%{link}">
																	<s:property value="policyStatusName" />
																</s:a>
															</td>
														</tr>
													</s:iterator>
												</tbody>
											</table>
											<jsp:include flush="true"
												page="/WEB-INF/common/page/pageFooter.jsp">
												<jsp:param name="submitAction" value="list.jspa" />
											</jsp:include>
										</fieldset>
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
