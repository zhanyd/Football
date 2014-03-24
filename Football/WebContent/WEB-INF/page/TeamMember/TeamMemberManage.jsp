<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/scripts/include.jsp" flush="true" />
<link href="scripts/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />

<link href="css/css.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">

    //获取页面列表数据
    var thedata = null;
    $.ajax({
    	  async:false,
    	  url: "getTuserData.action",
    	  success: function(data){
    		  thedata = data;
    	  }
    	});
    
    //构造ligerGrid
         $(f_initGrid);
        var g = null;
        function f_initGrid()
        {
        	 
            g = $("#maingrid").ligerGrid({
                columns: [
                {
                    display: '用户名', 
                    name: 'USERNAME'
                },
                {
                    display: '姓名',  
                    name: 'REALNAME'
                },
                {
                    display: '所属球队',  
                    name: 'TEAMNAME'
                },
                {
                    display: '上场次数',  
                    name: 'PLAYTIMES',
                    editor: { type: 'int' }
                },
                {
                    display: '进球数',  
                    name: 'GOALS',
                    editor: { type: 'int' }
                },
                {
                    display: '助攻数',  
                    name: 'ASSIST',
                    editor: { type: 'int' }
                },
                {
                    display: '扣除队费',  
                    name: 'BALANCE',
                    editor: { type: 'float' }
                }
                ],
                
                //dataAction:'local',
                //url: 'getTuserData.action',
                data:  JSON.parse(thedata),
                //data: thedata,
                enabledEdit: true,
                width: '100%', height: 400
            });
            
        } 
      

        function getData()
        {
            var manager = $("#maingrid").ligerGetGridManager();
            var data = manager.getData();
            $('#submitData').val(JSON.stringify(data));
        } 
    </script>
<form id="form1" name="form1" method="post" action="editTeamMemberManage.action" onsubmit="getData();">

 <input type="hidden" id="submitData" name="submitData"></input>
 <div class="l-clear"></div>
 <div id="maingrid" style="margin-top:20px"></div> <br />

<input type="submit" value="提交" class="l-button"></input>
</form>

