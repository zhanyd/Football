//var submitAction = '<%=request.getParameter("submitAction")%>';
var submitAction;
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

function search() {
     var form = document.getElementById("currentPageNo").form;
        form.action=submitAction;
     document.getElementById("currentPageNo").value=1;
     form.submit();
}
