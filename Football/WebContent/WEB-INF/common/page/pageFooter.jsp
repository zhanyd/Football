<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<style type="text/css">
* { margin:0; padding:0;}
body { font-size:12px; font-family:Verdana;}
a { color:#333; text-decoration:none;}
ul { list-style:none;}
#pagelist {width:100%; margin:3px auto; padding:6px 0px; height:20px;}
#pagelist ul li { float:left; border:1px solid #5d9cdf; height:20px; line-height:20px; margin:0px 2px;}
#pagelist ul li a, .pageinfo { display:block; padding:0px 6px; background:#e6f2fe;}
.pageinfo  { color:#555;}
.current { background:#a9d2ff; display:block; padding:0px 6px; font-weight:bold;}
</style>
<script type='text/javascript'>
 submitAction = '<%=request.getParameter("submitAction")%>';
 if (submitAction == null || submitAction=="") {
   submitAction="<s:property value='submitAction' />";
 }
 
 function goToNext() {  
	   var form = document.getElementById("currentPageNo").form;
	   var currentPageNo = document.getElementById("currentPageNo");   
	   currentPageNo.value = parseInt(currentPageNo.value)+1;   
	   form.action=submitAction;
	   form.submit();  
	}


	function goToPrevious() { 
	   var form = document.getElementById("currentPageNo").form;
	   var currentPageNo = document.getElementById("currentPageNo");  
	   var temp = parseInt(currentPageNo.value);
	   if (temp <= 1) {
	     currentPageNo.value = 1;
	   }
	   else {
	     currentPageNo.value = temp-1;   
	   }
	      form.action=submitAction;
	   form.submit();   
	}

	function gotoPage(pageNo) {
	   var form = document.getElementById("currentPageNo").form;
	   var currentPageNo = document.getElementById("currentPageNo");  
	   currentPageNo.value=pageNo;
	      form.action=submitAction;
	   form.submit();
	}

	function first() {
	   var form = document.getElementById("currentPageNo").form;
	   var currentPageNo = document.getElementById("currentPageNo");  
	   currentPageNo.value=1;
	      form.action=submitAction;
	   form.submit();
	}

	function pageSearch() {
	     var form = document.getElementById("currentPageNo").form;
	        form.action=submitAction;
	     document.getElementById("currentPageNo").value=1;
	     form.submit();
	}
</script>


<input id="currentPageNo" type="hidden" name="pageObject.currentPageNo"
	value='<s:property value="pageObject.currentPageNo"/>'>
<s:if test="pageObject.rowAmount > 0">
<div id="pagelist">
	<ul>
				<s:if test="pageObject.previous == true">
					<li><a href='#' onclick='javascript:first();'>首页</a></li>
				</s:if>

				<s:if test="pageObject.previous == true">
					<li><a href='#' onclick='javascript:goToPrevious();'>上页</a></li>
				</s:if>

				<s:if test="pageObject != null">
					<s:iterator value="pageObject.pageIndexList">
						<li><a href='#' onclick='javascript:gotoPage(<s:property />);'><s:property />
						</a></li>
					</s:iterator>
				</s:if>
				<s:if test="pageObject.next == true">
					<li><a href='#' onclick='javascript:goToNext();'>下页</a></li>
				</s:if>

				<s:if test="pageObject.next == true">
					<li><a href='#' onclick='javascript:gotoPage(<s:property value="pageObject.pageAmount"/>);'>末页</a></li>
				</s:if>
				<s:if test="pageObject != null">
			       <li class="pageinfo">当前页:<s:property value="pageObject.currentPageNo" /></li>
			       <li class="pageinfo">总页数:<s:property value="pageObject.pageAmount" /></li>
			       <li style="border:0px">共有<s:property value="pageObject.rowAmount" />条记录</li>
				</s:if>
	</ul>
</div>
</s:if>

<s:if test="pageObject.rowAmount <= 0">
	<table>
		<tr>
			<td>
				找不到符合检索条件的记录！
			</td>
		</tr>
	</table>
</s:if>
