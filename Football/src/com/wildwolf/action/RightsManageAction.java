package com.wildwolf.action;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import com.wildwolf.dataaccess.MyDaoTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

import com.wildwolf.model.Role;

public class RightsManageAction extends RootAction{

	private TreeSet<String> allRights;
	private String submitData;
	
	//返回json
	private String jsonResult;
	
	private List<Role> rolelist;
	
	private String RoleID;
	
	public String getJsonResult() {
		return jsonResult;
	}


	public String getRoleID() {
		return RoleID;
	}


	public void setRoleID(String roleID) {
		RoleID = roleID;
	}


	public List<Role> getRolelist() {
		return rolelist;
	}


	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}


	public String getSubmitData() {
		return submitData;
	}


	public void setSubmitData(String submitData) {
		this.submitData = submitData;
	}


	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}


	public TreeSet<String> getAllRights() {
		return allRights;
	}


	public void setAllRights(TreeSet<String> allRights) {
		this.allRights = allRights;
	}

	public MyDaoTemplate getMyDaoTemplate() {
		return myDaoTemplate;
	}

	public void setMyDaoTemplate(MyDaoTemplate myDaoTemplate) {
		this.myDaoTemplate = myDaoTemplate;
	}
	

	@Permission(name="权限管理查看")
	public String goRightsManage() throws Exception {
		
		rolelist = myDaoTemplate.queryForList("ROLE.selectAll");
		return "index";
	}
	
	
	public String getRightsData() throws Exception {

		String rights = "";
        StringBuilder strb = new StringBuilder();
        //获取所有权限
        allRights = getAllPermission();
        
        //获取页面制定角色的权限
        Role roleIn = new Role(); 
        roleIn.setID(RoleID);
        Role roleOut = (Role)myDaoTemplate.queryForObject("ROLE.selectByPrimaryKey",roleIn);
        if(roleOut != null && roleOut.getRIGHTS() != null)
        {
        	rights = roleOut.getRIGHTS();
        }
        
       //构造json格式的字符串
		strb.append("[");
        for(String str:allRights)
        {
        	if(rights.contains(str))
        	{
        		str = "{ \"text\": \"" + str + "\",\"ischecked\": \"true\"  },";
        	}
        	else
        	{
        		str = "{ \"text\": \"" + str + "\" },";
        	}

        	strb.append(str);
        }
        
        if (strb.length() > 0)
	       {
			   jsonResult = strb.toString();
	           //去尾
			   jsonResult = jsonResult.substring(0,jsonResult.length() - 1);
			   jsonResult = jsonResult + "]";
	       }
        
        return "success";
	}
	
	
	
	@Permission(name="权限管理编辑")
	public String editRightsManage() throws Exception {

		//获取页面传进来的数据，然后保存到数据库
		if(submitData != null)		
		{
			
			//获取role对象
			Role roleIn = new Role(); 
		    roleIn.setID(RoleID);
		    Role roleOut = (Role)myDaoTemplate.queryForObject("ROLE.selectByPrimaryKey",roleIn);
			if(roleOut != null)
			{
				//更新权限列表
				roleOut.setRIGHTS(submitData);
				roleOut.setUPDATETIME(new Date());
				//修改记录
				myDaoTemplate.update("ROLE.updateByPrimaryKeySelective", roleOut);
				
			}
		}
		
		session.put(SysConstant.MESSAGE, "编辑成功！");
		rolelist = myDaoTemplate.queryForList("ROLE.selectAll");
		
		return "index";
	}
}
