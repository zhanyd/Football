<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
	
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

      <ul id="menu_left">
        <s:if test="#session['cn.com.lifeisgreat.gims.fdm.struts2.action.User'].organization.orgType == 2">
        <li><a href="<s:url action='form' namespace='/policy'/>" >在线投保</a></li>
        </s:if>

        
        <li><a href="<s:url action='search' namespace='/policy'/>" >保单查询</a></li>
     

        <s:if test="#session['cn.com.lifeisgreat.gims.fdm.struts2.action.User'].organization.orgType == 2">       
        <li><a href="<s:url action='form' namespace='/print'/>" >保单补打</a></li>        
        </s:if>
      </ul>