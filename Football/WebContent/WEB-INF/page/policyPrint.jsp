<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="保单在线销售系统" />
<meta name="keywords" content="保单在线销售" />
<meta name="author" content="luotao@lifeisgreat.com.cn" />
<title>在线销售系统</title>
<link href="<s:url value='/styles/style.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/styles/forms.css'/>" rel="stylesheet" type="text/css"/>
</head>
<script type="text/javascript"
		src="<c:url value="/scripts/prototype.js"/>"></script>
	<script type="text/JavaScript">
	  
		function checkDays(srcName){
			var Date1;
			var Date2;
			if (srcName == 'board')
			{
				 Date1 = $('startAbordDate').value;
				 Date2 = $('endAbordDate').value;
			 }
			else if (srcName == 'effect')
			{
				Date1 = $('effectiveStartDate').value;
			 	Date2 = $('effectiveEndDate').value;
			}
			if(null==Date1 || ''==Date1 || "undefined"==Date1+"" || null==Date2 || ''==Date2 || "undefined"==Date2+""){
				return;
			}
			if(Date1>Date2){			
				alert("起始日期应小于等于终止日期");
				window.event.srcElement.focus();
				return;
			}
		}
		function TestChecked(){
			var aa = document.getElementsByName('policyCode');
			var control = false;
         	for (var i=0;i<aa.length;i++){
           		if(aa[i].checked){
            	    control = true;
            		break;
           		}
           	}
           	return control;
		}
		
		function formatDate(/*Element*/field) {
			var sDate = field.value;
			
			if (!sDate || (sDate == "")) {//undefined or length of zero
				return "";
			}
			
			//date format: yyyyMMdd or yyyy-MM-dd or yyyy/MM/dd
			if ((sDate.length != 8) && (sDate.length != 10)) {
				alert("日期长度非法！");
				field.focus();
				return;
			}
			
			var year;
			var month;
			var date;
			
			if (sDate.length == 8) {
				year = sDate.substring(0, 4);
				month = sDate.substring(4, 6);
				date = sDate.substring(6, 8);
			}
		
			if (sDate.length == 10) {
				year = sDate.substring(0, 4);
				month = sDate.substring(5, 7);
				date = sDate.substring(8);
			}
			
			if (!isValidDate(year, month, date)) {
				alert("日期非法!");
				field.focus();
				return;
			}
			
			var full = year + "-" + month + "-" + date;
			field.value = full;
		}
		function isValidDate(year, month, date) {
			if (month < 1 || month > 12 ) {
				return false;
			}
			
		  	// 闰年的条件: 
		  	//    1. 能被4整除, 但不能被100整除; 
		 	//    2. 能被400整除.
		  	var leapyear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		  
		  	// 30天的月份但有31天
		  	if (date == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
		  		return false; 
		  	}
		  	
		  	// 二月份有30天或者31天
		  	if (date >= 30 && month == 2) {
		  		return false; 
		  	}
		  	
		  	// 平年二月份有29天
		  	if (date == 29 && month == 2 && !leapyear) {
		  		return false; 
		  	}
		  
		  	return true;
		}    
	  	function next() {  
		   var form = document.form1;
		   var pageNo = parseInt(form.pageNo.value);
		   form.pageNo.value = pageNo+1;   
		   submiter("search");
		}
		function previous() { 
		   var form = document.form1;
		   var pageNo = parseInt(form.pageNo.value);
		   if (pageNo <= 1) {
		     form.pageNo.value = 1;
		   }
		   else {
		     form.pageNo.value = pageNo-1;   
		   }
		  submiter("search");
		}
		
		function goto(pageNo) {
		   var form = document.form1;
		   form.pageNo.value=pageNo;
		   submiter("search");
		}
		
		function first() {
		   var form = document.form1;
		   form.pageNo.value=1;
		   submiter("search");
		}	
		
		function submiter(value) {
		var form1=document.form1;
		        if(form1.pageNo.value<1){
		    form1.pageNo.value=1;
		    }
		    if(value=="print")
		    {   
			     if (!TestChecked())
			     {
			     	alert("没有选中保单！");
			     }else{
			       form1.action="print.jspa"
			       form1.target="__blank";
			       form1.submit();
			       }
		    }
		    else if(value=="backToMain")
		    {   
		       form1.action="main.jspa"
		       form1.target="_self";
		       form1.submit();
		    } else if(value == "search") {
		    	form1.action = 'search.jspa';
		    	form1.submit();
		    } else {
		    	return true;
		    }
		}
		
	  function searchPolicysToPrint(){
	    var searchForm=document.form1;
	    searchForm.pageNo.value=1;
	    searchForm.target="_self";
	  	searchForm.action="search.jspa";
	  	searchForm.submit();
	  }
	</script>

<body>
<div id="content">
  <s:include value="/WEB-INF/common/passwordForm.jsp"></s:include>
  <div id="main">
    <div class="left">
    	<s:include value="/WEB-INF/common/menu.jsp"/>
    </div>
    <div class="rightdiv">
      <div class="wrapper">
        <s:form id="form1" name="form1">
          <table width="100%">
            <caption>
            航意险保单补打
            </caption>
            
            <tr>
              <td><fieldset>
                <legend>查询条件</legend>
                <table width="100%" >
                  <tr>
                    <th width="20%">网点</th>
                    <td width="30%">
                    <s:hidden name="printSearchAndShowBean.orgId" value="%{#session['cn.com.lifeisgreat.gims.fdm.struts2.action.User'].organization.orgId}"></s:hidden>
				    <s:textfield
						value="%{#session['cn.com.lifeisgreat.gims.fdm.struts2.action.User'].organization.orgName}"
						disabled="true" cssClass="disabled inputlong" />
                   
<%--                    <s:select id="organName" name="printSearchAndShowBean.orgId" list="orgList" --%>
<%--											listKey="orgId" listValue="orgName"--%>
<%--											cssClass="inputlong"/>--%>
											
					</td>
                    <th width="20%">保险单号</th>
                    <td width="30%"><s:textfield id="spolicyCode" name="printSearchAndShowBean.policyCode" cssClass="inputlong"/></td>
                  </tr>
                  <tr>
                    <th>凭证号码</th>
                    <td><s:textfield id="vocherCode" name="printSearchAndShowBean.vocherCode" cssClass="inputlong"/></td>
                    <th>被保险人姓名</th>
                    <td><s:textfield id="insuredName" name="printSearchAndShowBean.insuredName" cssClass="inputlong"/></td>
                  </tr>
                  <tr>
                    <th>航班号</th>
                    <td><s:textfield id="flightNumbe" name="printSearchAndShowBean.flightNumber" cssClass="inputlong"/></td>
                    <th>登机时间(yyyymmdd)</th>
                    <td><s:textfield id="startAbordDate" name="printSearchAndShowBean.boardStartDate" cssClass="inputshort" onblur="formatDate(this);checkDays('board')" />
                    -
                    <s:textfield id="endAbordDate" name="printSearchAndShowBean.boardEndDate" cssClass="inputshort" onblur="formatDate(this);checkDays('board')" /></td>
                  </tr>
                  <tr>
                    <th>出单时间(yyyymmdd)</th>
                    <td><s:textfield id="effectiveStartDate" name="printSearchAndShowBean.effectiveStartDate" cssClass="inputshort" onblur="formatDate(this);checkDays('effect')" />
                      -
                      <s:textfield id="effectiveEndDate" name="printSearchAndShowBean.effectiveEndDate" cssClass="inputshort" onblur="formatDate(this);checkDays('effect')" /></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td colspan="4"><table width="100%" class="right">
                  <tr>
                    <td><input type="button" class="inputmin" value="查询" onclick="searchPolicysToPrint()"/>
                      </td>
                  </tr>
              </table></td>
                  </tr>
                </table>
              </fieldset>
              </td>
            </tr>
            <tr>
              <td><fieldset>
                <legend>查询结果</legend>
                <table width="100%" class="border"><thead>
                  <tr>
                    <td width="5%">选择</td>
                    <td>网点</td>
                    <td>保险单号</td>
                    <td>凭证号码</td>
                    <td>被保险人姓名</td>
                    <td>航班号</td>
                    <td>登机时间</td>
                    <td>出单时间</td>
                    <td>打印次数</td>
                  </tr></thead><tbody>
                  <s:if test="pageObject != null">
					<s:iterator value="pageObject.objectList">
                  <tr>
                    <td><label>
                    <input type="checkbox" id="policyCodeCheck" name=policyCode value="<s:property value="policyCode"/>" />
                    </label></td>
                    <td><s:property value="orgName" /></td>
                    <td><s:property value="policyCode" /></td>
                    <td><s:property value="vocherCode" /></td>
                    <td><s:property value="insuredName" /></td>
                    <td><s:property value="flightNumber" /></td>
                    <td><s:property value="boardDate" /></td>
                    <td><s:date name="effectiveDate" format="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><s:property value="printCount" /></td>
                  </tr>
                   </s:iterator>
                  </s:if>
                  </tbody>
                </table>
                <table>
                	 <tr>
						<td><s:actionmessage />
						<font color="red"><s:actionerror /></font>
						</td>
					</tr>
                </table>
                <s:if test="pageObject.rowAmount > 0">
                <table width="100%" class="right">
								<tr>
									<td><s:if test="pageObject.previous == true">
									    <a href='#' onclick='javascript:first();'>首页</a>
									</s:if> <s:if test="pageObject.previous == true">
										<a href='#' onclick='javascript:previous();'>上页</a>
									</s:if> <s:if test="pageObject != null">
										<s:iterator value="pageObject.pageIndexList">
											<a href='#' onclick='javascript:goto(<s:property />);'><s:property />
											</a>
										</s:iterator>
									</s:if> <s:if test="pageObject.next == true">
										<a href='#' onclick='javascript:next();'>下页</a>
									</s:if> <s:if test="pageObject.next == true">
										<a href='#'
											onclick='javascript:goto(<s:property value="pageObject.pageAmount"/>);'>
										末页</a>
									</s:if> <s:if test="pageObject != null">
								       &nbsp;
								       当前页：<s:property value="pageObject.currentPageNo" />，&nbsp;
								       总页数: <s:property value="pageObject.pageAmount" />，&nbsp;
								       总记录: <s:property value="pageObject.rowAmount" />
									</s:if></td>
								</tr>
							</table>
						</s:if>	
              </fieldset></td>
            </tr>
           
            <tr>
              <td><table width="100%" class="right">
                  <tr>
                    <td><input  type="button" class="inputmin" value="打印" onclick="submiter('print')"/>
                      <input  type="button" class="inputmin" value="退出" onclick="submiter('backToMain')"/></td>
                  </tr>
              </table>
              <input type="hidden" name="pageNo" id="pageNo"
							value='<s:property value="pageObject.currentPageNo"/>'/></td>
            </tr>
          </table>
        </s:form>
      </div>
    </div>
  </div>
  
</div><div class="footer">
    <p>Copyright © 2008 Great Eastern Life Assurance (China) Co.,Ltd. All Rights Reserved. </p>
    <p>中新大东方人寿保险有限公司 版权所有</p>
  </div>
</body>
</html>
