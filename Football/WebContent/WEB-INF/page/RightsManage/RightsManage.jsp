<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
    <title></title>
<jsp:include page="/scripts/include.jsp" flush="true" />
<link href="scripts/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />

	<style type="text/css">
	#treeDiv{
	  position: absolute;
	  left:20%;
	  top:5%;
	}
	
	li:hover
	{
		background-color:whiteSmoke;
	}
	
	</style>

    <script type="text/javascript">
        var tree = null;
        //获取页面列表数据
        var thedata = null;
        
        
//      $(function ()
//      {
//     	 alert('<s:property value = "RoleID"/>');
    	 
// //     	 if( $('#submitData').val() == '<s:property value = "RoleID"/>')
// //     		 {
    		 
// //     		 }
//           });


//         $.ajax({
//         	  async:false,
//         	  url: "getRightsData.action",
//         	  success: function(data){
//         		  thedata = data;
//         	  }
//         	});
        
//         $(function ()
//         {
//             tree = $("#tree1").ligerTree({  
//             //url:'getRightsData.action'
//             data: JSON.parse(thedata)
//             });
//     	});

	//全选
    function f_selectNode()
    {

    	 var parm = function (data)
         {
             return true;
         };

         tree.selectNode(parm);
    }

    //反向选择
    function f_cancelSelect()
    {
        var parm = function (data)
        {
            return false;
        };

        tree.selectNode(parm);
    }
    
    function getData()
    {
    	//获取选择的项
    	var data = tree.getChecked(); 
    	var submitData = "";
        for (var i = 0; i < data.length; i++)
        {
        	//获取选中的文本
        	submitData += data[i]['data']['text'];
        	if(i != data.length - 1)
        		{
        			submitData += ",";
        		}
        }
        
        $('#submitData').val(submitData);
    } 
    
    //选择角色事件
    function roleSelect(ID,obj)
    {
   	 
    	
    	//获取ID传到后台
    	$('#RoleID').val(ID);
    	if(tree != null)
    		{
    			tree.clear();
    		}
    	
    	 $.ajax({
       	  async:false,
       	  url: "getRightsData.action?RoleID=" + ID,
       	  success: function(data){
       		     //构造树
       		 	 tree = $("#tree1").ligerTree({  
   	             data: JSON.parse(data)
   	             });
       	  }
       	});
    	 
    	 
    	//设置选中的颜色
     	var lis=document.getElementsByTagName("li");
		 
	   	 for(var i=0;i<lis.length;i++)
	   	 {
		   	 if(lis[i] != obj)
		   	 {
		   	 	lis[i].style.background = null;
		   	 }
		   	 else
		     {
		   	 	lis[i].style.background = "#5886D6";
		     }
	  	}
    	 

    	 
    }
    </script>
</head>

<form id="form1" name="form1" method="post" action="editRightsManage.action" onsubmit="getData();">
<input type="hidden" id="submitData" name="submitData"></input>
<input type="hidden" id="RoleID" name="RoleID"></input>


<div>
<a class="l-button" style="width:80px; margin-left:10px; float:left;" onclick="f_selectNode()">全选</a>
<a class="l-button" style="width:80px; margin-left:10px; float:left;" onclick="f_cancelSelect()">全不选</a>
<input type="submit" style="width:80px; margin-left:10px; float:left; height:25px;" value="提交" class="l-button"></input>
</div>

  <div style="width:100px; height:150px; margin:10px; float:left; clear:both; border:1px solid #ccc; overflow:auto;">

    <!-- 角色框 -->
	<ul id="tree2"></ul>
    <ul id="list" style="cursor: pointer; overflow:auto;">
      <s:iterator value="rolelist">
         <li id='<s:property value = "ID"/>' onclick="roleSelect('<s:property value = "ID"/>',this)"><s:property value = "ROLENAME"/> </li>
      </s:iterator>
    </ul>
    </div>
    
    
    <!-- 权限树 -->
    <div id="treeDiv" style="width:300px; height:400px; margin:10px; float:left; clear:both; border:1px solid #ccc; overflow:auto;  ">


    <ul id="tree1"></ul>
    </div> 
 
        <div style="display:none">
     
    </div>

</form>
</html>
