<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<script language="javascript" type="text/javascript" src="scripts/jquery/jquery-1.8.3.js"></script>
<script src="scripts/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
<script language="javascript" type="text/javascript" src="scripts/artdialog/artDialog.js?skin=chrome"></script>
<script language="javascript" type="text/javascript" src="scripts/artdialog/iframeTools.js"></script>
<jsp:include page="/scripts/pub.jsp" flush="true" />
<jsp:include page="/scripts/utils.jsp" flush="true" />
<jsp:include flush="true" page="/WEB-INF/page/Message.jsp"></jsp:include>
<script src="scripts/jquery.autocomplete.js" type="text/javascript"></script>
<link href="css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
 	//药房名称自动完成配置
 	var DrugAutocompleteSeting = {
 	    minChars: 0,
 	    delay : 10,
 	    width: 600,
 	    matchContains: true,
 	    autoFill: false,
 	    max:4000,
 	    cacheLength:1000,
 	    formatItem: function (row, i, total) {
 	        return i + ": " + row.name + " [" + row.responsibleperson + "]";
	    },
 	    formatMatch: function (row, i, total) {
 	        return row.name+row.py;
 	    },
 	    formatResult: function (row) {
 	        return row.name;
 	    }
 	};
</script>