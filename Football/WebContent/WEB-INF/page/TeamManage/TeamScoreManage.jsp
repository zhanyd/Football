<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/scripts/include.jsp" flush="true" />
<link href="scripts/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />

<link href="css/css.css" rel="stylesheet" type="text/css" />

   <script type="text/javascript">

   //获取页面列表数据
    var thedata = null;
    var teamlist= null;
    $.ajax({
    	  async:false,
    	  url: "getTeamScoreData.action",
    	  success: function(data){
    		  thedata = data;
    	  }
    	});
    
    $.ajax({
  	  async:false,
  	  url: "getTeamListJson.action",
  	  success: function(data){
  		teamlist = JSON.parse(data);
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
                    display: '队名', 
                    name: 'TeamName'
                },
                { display: '对战球队', name: 'OpponentID', width: 120, isSort: false,
                    editor: { type: 'select', data:teamlist, valueField: 'OpponentID', textField: 'TeamName' }, render: function (item)
                    {
                        for (var i = 0; i < teamlist.length; i++)
                        {
                            if (teamlist[i]['OpponentID'] == item.OpponentID)
                                return teamlist[i]['TeamName']
                        }
                        //return item.TeamName;
                    }
                },
                {
                    display: '胜场数',  
                    name: 'Wins',
                    editor: { type: 'int' }
                },
                {
                    display: '败场数',  
                    name: 'Losing',
                    editor: { type: 'int' }
                },
                {
                    display: '平数',  
                    name: 'Draw',
                    editor: { type: 'int' }
                },
                {
                    display: '进球数',  
                    name: 'Goals',
                    editor: { type: 'int' }
                },
                {
                    display: '失球数',  
                    name: 'Lost',
                    editor: { type: 'int' }
                }
                ],
                
                //dataAction:'server',
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
<form id="form1" name="form1" method="post" action="editTeamScoreManage.action" onsubmit="getData();">

 <input type="hidden" id="submitData" name="submitData"></input>
 <div class="l-clear"></div>
 <div id="maingrid" style="margin-top:20px"></div> <br />

<input type="submit" value="提交" class="l-button"></input>
</form>

