package com.wildwolf.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ibatis.sqlmap.engine.transaction.Transaction;
import com.wildwolf.dataaccess.MyDaoTemplate;
import com.wildwolf.helper.BusinessFailure;
import com.wildwolf.helper.DataHelper;
import com.wildwolf.helper.HZpy;
import com.wildwolf.helper.MyTransaction;
import com.wildwolf.helper.NoSessionException;
import com.wildwolf.helper.PasswordUtil;
import com.wildwolf.helper.RightsException;
import com.wildwolf.helper.page.PageObject;
import com.wildwolf.model.*;


/**
 * 
 * @author zhanyd
 * 2011-9-2 06:30:02
 */

public class BaseInfoActionBean extends RootAction{
	private List<Drugstore> drugstoreList;
	
	private PageObject pageObject;

	//角色
	private Role role;
	private List<Role> rolelist;
	private Set<String> setPermission;
	
	//用户
	private TuserResult tuserResult;
	private List<TuserResult> tuserResultList;
	private Tuser tuser;

	//用户log
	private Userlog userlog;
	
	//球队管理
	private Team team;
	private List<Tuser> tuserList;
	
	//新用户注册
	private List<Team> teamList;
	
	private String[] rolePermissions;
	private List roleList;
	private String selectAll;
	
	//图片上传
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	//直接在struts.xml文件中配置的保存路径的属性
	private String savePath;
	
	//队员资料修改
	private int pageNow;
	
	//返回json
	private String jsonResult;
	
	//队员页面
	private String submitData;
	private Userrecords userrecords;
	private List<Userrecords> userrecordsList;
	private UserrecordsView userrecordsView;
	//队员详细
	private Teamrecords teamrecords;
	private TeamrecordsView teamrecordsView;

	
	
	public TeamrecordsView getTeamrecordsView() {
		return teamrecordsView;
	}


	public void setTeamrecordsView(TeamrecordsView teamrecordsView) {
		this.teamrecordsView = teamrecordsView;
	}
	public UserrecordsView getUserrecordsView() {
		return userrecordsView;
	}


	public void setUserrecordsView(UserrecordsView userrecordsView) {
		this.userrecordsView = userrecordsView;
	}
	
	public int getPageNow() {
		return pageNow;
	}


	public Teamrecords getTeamrecords() {
		return teamrecords;
	}


	public void setTeamrecords(Teamrecords teamrecords) {
		this.teamrecords = teamrecords;
	}


	public List<Userrecords> getUserrecordsList() {
		return userrecordsList;
	}


	public void setUserrecordsList(List<Userrecords> userrecordsList) {
		this.userrecordsList = userrecordsList;
	}


	public Userrecords getUserrecords() {
		return userrecords;
	}


	public void setUserrecords(Userrecords userrecords) {
		this.userrecords = userrecords;
	}


	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}


	public String getSubmitData() {
		return submitData;
	}


	public void setSubmitData(String submitData) {
		this.submitData = submitData;
	}

	public String getJsonResult() {
		return jsonResult;
	}



	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}



	public List<Tuser> getTuserList() {
		return tuserList;
	}


	public void setTuserList(List<Tuser> tuserList) {
		this.tuserList = tuserList;
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public String getUploadContentType() {
		return uploadContentType;
	}


	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}


	public List<Team> getTeamList() {
		return teamList;
	}


	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}
	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public String getSelectAll() {
		return selectAll;
	}


	public void setSelectAll(String selectAll) {
		this.selectAll = selectAll;
	}


	public Userlog getUserlog() {
		return userlog;
	}


	public void setUserlog(Userlog userlog) {
		this.userlog = userlog;
	}
	
	public Tuser getTuser() {
		return tuser;
	}


	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}


	public List getRoleList() {
		return roleList;
	}


	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}


	public String[] getRolePermissions() {
		return rolePermissions;
	}


	public void setRolePermissions(String[] rolePermissions) {
		this.rolePermissions = rolePermissions;
	}


	public Set<String> getSetPermission() {
		return setPermission;
	}


	public void setSetPermission(Set<String> setPermission) {
		this.setPermission = setPermission;
	}



	public TuserResult getTuserResult() {
		return tuserResult;
	}


	public List<TuserResult> getTuserResultList() {
		return tuserResultList;
	}


	public void setTuserResultList(List<TuserResult> tuserResultList) {
		this.tuserResultList = tuserResultList;
	}


	public void setTuserResult(TuserResult tuserResult) {
		this.tuserResult = tuserResult;
	}


	public List<Role> getRolelist() {
		return rolelist;
	}


	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	public MyDaoTemplate getMyDaoTemplate() {
		return myDaoTemplate;
	}

	public void setMyDaoTemplate(MyDaoTemplate myDaoTemplate) {
		this.myDaoTemplate = myDaoTemplate;
	}
	
	public PageObject getPageObject() {
		return pageObject;
	}

	public void setPageObject(PageObject pageObject) {
		this.pageObject = pageObject;
	}





	
	public List<Drugstore> getDrugstoreList() {
		return drugstoreList;
	}

	public void setDrugstoreList(List<Drugstore> drugstoreList) {
		this.drugstoreList = drugstoreList;
	}

	
	public String goToAddOrderProperty() throws Exception {
		return "addOrderProperty";
	}
	
	public String saveNewOrderProperty() throws Exception {
		return "orderHome";
	}
	
	public String goToUpdateOrderProperty() throws Exception {
		return null;
	}
	
	public String updateOrderProperty() throws Exception {
		return "orderHome";
	}
	
	public String removeOrderProperty() throws Exception {
		return "orderHome";
	}
	
	public String index() throws Exception {
		return "index";
	}   
	
	public String login() throws Exception {
		return "index";
	}
	



//			//导出excel
//			@Permission(name="药店导出excel")
//			public void exportExcelDrugStoreManage() throws Exception {
//			      
//				LinkedHashMap map = new LinkedHashMap();
//				map.put("DSNAME", "监管对象名称");
//				map.put("BUSINESSOPERATIONID", "许可证号");
//				map.put("REGION", "所属地区");
//				map.put("ADDRESS", "经营地址");
//				map.put("TEL", "联系电话");
//				map.put("FAX", "传真");
//				map.put("NATURE", "企业性质");
//				map.put("BUSINESSMODEL", "经营模式");
//				map.put("BUSINESSSCOPE", "经营范围");
//				map.put("PEOPLECOUNT", "职工人数");
//				map.put("RESPONSIBLEPERSON", "企业负责人姓名");
//				map.put("RJOBTITLE", "企业负责人职称");
//				map.put("RPHONENO", "企业负责人手机号");
//				map.put("RPOST", "企业负责人职位");
//				map.put("LEGALPERSON", "法定代表人姓名");
//				map.put("LJOBTITLE", "法定代表人职称");
//				map.put("LPHONENO", "法定代表人手机号");
//				map.put("LPOST", "法定代表人职位");
//				map.put("QUALITYPERSON", "质量负责人姓名");
//				map.put("QJOBTITLE", "质量负责人职称");
//				map.put("QPHONENO", "质量负责人手机号");
//				map.put("QPOST", "质量负责人职位");
//				map.put("DRUGCHECKPERSON", "处方药审核人姓名");
//				map.put("DJOBTITLE", "处方药审核人职称");
//				map.put("DPHONENO", "处方药审核人手机号");
//				map.put("DPOST", "处方药审核人职位");
//				map.put("ISSUPERVISED", "监管情况（0:未监管，1:已监管）");
//				map.put("OTHERPEOPLE", "其他人员");
//				map.put("REMARK", "备注");
//				exportExcel(map,"DRUGSTORE.searchDrugStore", drugstore);
//				
//			
//			}
			

			
		
		
			
//-------------------------------角色管理页面--------------------------------------			
		
			
			//角色管理页面
			@Permission(name="角色查询")
			public String searchRoleManage() throws Exception {

				rolelist = myDaoTemplate.queryForList("ROLE.selectAll");
				
				return "index";
			}
			
			
			
			
		   //角色管理添加方法
			@Permission(name="角色添加")
			public String addRoleManage() throws Exception {
				try {
					role.setID(DataHelper.CreateID());
					role.setCREATETIME(new Date());
					myDaoTemplate.create("ROLE.insertSelective",role);
				} catch (Exception e) {			
					e.printStackTrace();
				} 
				return "indexRefresh";
			}
			
			//前往角色管理添加页面
			@Permission(name="角色添加")
			public String goaddRoleManage() throws Exception {
			
				return "addRoleManage";
			}
			
//			//角色管理编辑方法
//			@Permission(name="角色编辑")
//			public String editAllRoleManage() throws Exception {
//					try {
//						
//						if(selectAll.equals("true"))
//						{
//							//获取所有权限
//							setPermission = getAllPermission();
//							StringBuffer strbuff = new StringBuffer();
//							for(String str : setPermission)
//							{
//								strbuff.append(str + ", ");
//							}
//							//删除最后的逗号
//							strbuff.deleteCharAt(strbuff.lastIndexOf(", "));
//							role.setRIGHTS(strbuff.toString());
//						}
//						else
//						{
//							role.setRIGHTS("");
//						}
//						
//						
//						myDaoTemplate.update("ROLE.updateByPrimaryKeySelective", role);
//					} catch (Exception e) {			
//						e.printStackTrace();
//					} 
//					return "indexRefresh";
//				}
//			
			//角色管理编辑方法
			@Permission(name="角色编辑")
			public String editRoleManage() throws Exception {
					try {
						
						myDaoTemplate.update("ROLE.updateByPrimaryKeySelective", role);
					} catch (Exception e) {			
						e.printStackTrace();
					} 
					return "indexRefresh";
				}
			
			//前往角色管理编辑页面
			@Permission(name="角色编辑")
			public String goeditRoleManage() throws Exception {
				//获取所有权限
				setPermission = getAllPermission();
				
				role = (Role) myDaoTemplate.queryForObject("ROLE.selectByPrimaryKey", role);
			
				String right = role.getRIGHTS();
				
				if (right != null && !right.equals(new String())) {
					
					String[] r = right.split(", ");
					rolePermissions = r;
					
				}
				return "editRoleManage";
			}
			
			
			
			
		   //前往角色管理删除页面
			@Permission(name="角色删除")
			public String delRoleManage() throws Exception {
				try
				{
					myDaoTemplate.delete("ROLE.deleteByPrimaryKey", role);
				}catch (Exception e) {			
					e.printStackTrace();
				} 
				
				return "indexRefresh";
			}
			
			
			
			
			
			
//-------------------------------用户管理页面--------------------------------------			
		
			
			//用户管理页面
			@Permission(name="用户查询")
			public String searchUserManage() throws Exception {
				//页面显示的list
				tuserResultList = new ArrayList();
				List<Tuser> tuserList = myDaoTemplate.queryForList("tuser.selectAll");
				//判断是否有用户数据
				if(tuserList != null && tuserList.size() > 0)
				{
					for(int i = 0; i < tuserList.size(); i++)
					{
						  //根据roleid获取rolename
						  Role param = new Role();
						  param.setID(tuserList.get(i).getROLEID());
						  role = (Role) myDaoTemplate.queryForObject("ROLE.selectByPrimaryKey", param);
						  //添加到list
						  TuserResult result = new TuserResult();
						  result.setTuser(tuserList.get(i));
						  result.setRoleName(role.getROLENAME());
						  tuserResultList.add(result);
					}
				}
				
				return "index";
			}
			
			
			
			
		   //用户管理添加方法
			@Permission(name="用户添加")
			public String addUserManage() throws Exception {
				try {
					
					//检查用户是否已存在
				    Tuser tuser = (Tuser)myDaoTemplate.queryForObject("tuser.selectByUser",tuserResult.getTuser());
				    if(tuser != null)
				    {
				    	addActionMessage("用户名已存在");
				    	return "goaddUserManage";
				    }
				    tuserResult.getTuser().setPASSWORD(PasswordUtil.encrypt(tuserResult.getTuser().getPASSWORD()));
					tuserResult.getTuser().setID(DataHelper.CreateID());
					tuserResult.getTuser().setCREATETIME(new Date());
					myDaoTemplate.create("tuser.insertSelective",tuserResult.getTuser());
				} catch (Exception e) {			
					e.printStackTrace();
				} 
				return "indexRefresh";
			}
			
			//前往用户管理添加页面
			@Permission(name="用户添加")
			public String goaddUserManage() throws Exception {
				rolelist = myDaoTemplate.queryForList("ROLE.selectAll");
				return "addUserManage";
			}
			
			//用户管理编辑方法
			@Permission(name="用户编辑")
			public String editUserManage() throws Exception {
					try {
						
						myDaoTemplate.update("tuser.updateByPrimaryKeySelective", tuserResult.getTuser());
						
					} catch (Exception e) {			
						e.printStackTrace();
					} 
					return "indexRefresh";
				}
			
			//前往用户管理编辑页面
			@Permission(name="用户编辑")
			public String goeditUserManage() throws Exception {

				Tuser tuser =  (Tuser) myDaoTemplate.queryForObject("tuser.selectByPrimaryKey", tuserResult.getTuser());
				tuserResult.setTuser(tuser);
				rolelist = myDaoTemplate.queryForList("ROLE.selectAll");
				
				return "editUserManage";
			}
			
			
			//管理员重置密码
			@Permission(name="管理员重置密码")
			public String adminChPassUserManage() throws Exception {
				tuser =  (Tuser) myDaoTemplate.queryForObject("tuser.selectByPrimaryKey", tuserResult.getTuser());

				return "adminChPasswprd";
				
			}
			//管理员重置密码编辑方法
			@Permission(name="管理员重置密码编辑")
			public String editadminChPassUserManage() throws Exception {
					try {
						//密码加密
						tuser.setPASSWORD(PasswordUtil.encrypt(tuser.getPASSWORD()));
						myDaoTemplate.update("tuser.updateByPrimaryKeySelective", tuser);
						
					} catch (Exception e) {			
						e.printStackTrace();
					} 
					
					session.put(SysConstant.MESSAGE, "密码修改成功！");
					return "indexRefresh";
				}
			
			
			
			
		   //前往用户管理删除页面
			@Permission(name="用户删除")
			public String delUserManage() throws Exception {
				try
				{
					myDaoTemplate.delete("tuser.deleteByPrimaryKey", tuserResult.getTuser());
				}catch (Exception e) {			
					e.printStackTrace();
				} 
				
				return "indexRefresh";
			}
			
			//登陆页面
			public String loginUserManage() throws Exception {
				try
				{
					//过滤通过URL直接进入页面
					if(tuser == null)
					{
						return "Login";
					}
					//判断用户名密码
				    Tuser tuserlogin = (Tuser)myDaoTemplate.queryForObject("tuser.selectByUserPassword",tuser);
					if(tuserlogin == null)
					{
						addActionMessage("用户名不存在！");
						return "Login";
					}
					if (PasswordUtil.checkPassword(tuser.getPASSWORD(), tuserlogin.getPASSWORD()) == false ) {
						addActionMessage("密码不正确！");
						return "Login";
					   }
					
					//session
					session.put(SysConstant.USER, tuserlogin);
					//获取药店列表，放到session里供页面调用
					//JsonDrugStore();
					
				}
				 catch (Exception e) {			
						e.printStackTrace();
					} 
				
				
				return "mainIndex";
			}
			
//			//获取药店列表，放到session里调用自动完成功能时使用
//			public void JsonDrugStore() throws Exception
//			{
//				HZpy topy = new HZpy();
//				String result = "",str,py;
//		        StringBuilder strb = new StringBuilder();
//		        
//		        
//				drugstoreList = myDaoTemplate.queryForList("DRUGSTORE.searchDrugStore");
//				if(drugstoreList.size() > 0)
//				{  
//					//构造json格式的字符串
//					strb.append("[");
//					for(Drugstore ds : drugstoreList)
//					{
//						  //获取汉字的拼音
//						  py = topy.String2Alpha(ds.getDSNAME());
//			              str = "{" + MessageFormat.format(
//			                                 "\"py\":{0},\"to\":{1},\"name\":{2},\"responsibleperson\":{3}",
//			                                 "\""+py+"\"", "\""+ds.getDRUGSTOREID()+"\"", "\""+ds.getDSNAME()+"\"", "\""+ds.getRESPONSIBLEPERSON()+"\"" ) +
//			                                 "},";
//
//			              
//			              strb.append(str);
//					}
//					
//				}
//				
//			   if (strb.length() > 0)
//		       {
//		           result = strb.toString();
//		           //去尾
//		           result = result.substring(0,result.length() - 1);
//		           result = result + "]";
//		       }
//				
//				session.put("jsonresult", result);
//				
//			}
			
			
			
			
			
			//登陆页面跳转
			public String goMainUserManage() throws Exception {
				return "main";
			}
			
			
			
			//用户修改密码编辑方法
			@Permission(name="用户修改密码")
			public String chPassUserManage() throws Exception {
					try {
						//密码加密
						tuser.setPASSWORD(PasswordUtil.encrypt(tuser.getPASSWORD()));
						myDaoTemplate.update("tuser.updateByPrimaryKeySelective", tuser);
						
					} catch (Exception e) {			
						e.printStackTrace();
					} 
					
					session.put(SysConstant.MESSAGE, "密码修改成功！");
					return "indexRefreshPass";
				}
			
			//用户修改密码编辑页面
			@Permission(name="用户修改密码")
			public String searchPassUserManage() throws Exception {
				tuser = (Tuser)session.get(SysConstant.USER);
			    tuser =  (Tuser) myDaoTemplate.queryForObject("tuser.selectByPrimaryKey", tuser);

				return "changePasswprd";
				
			}
			
			
//			//随机生成密码
//			private String setpassword()
//			{
//				List<Tuser> tuserList = myDaoTemplate.queryForList("tuser.selectAll");
//				String pass = "";
//				StringBuffer buff= new StringBuffer();
//				//判断是否有用户数据
//				if(tuserList != null && tuserList.size() > 0)
//				{
//					for(int i = 0; i < tuserList.size(); i++)
//					{
//						if(tuserList.get(i).getUSERNAME().equals("admin"))
//						{
//							continue;
//						}
//						pass = PasswordUtil.generateRandomPassword(6);
//						
//						tuserList.get(i).setPASSWORD(PasswordUtil.encrypt(pass));
//						tuserList.get(i).setUPDATETIME(new Date());
//						
//						buff.append(" 用户名：" + tuserList.get(i).getUSERNAME() + " 密码：" + pass);
//						System.out.println("用户名：" + tuserList.get(i).getUSERNAME() + " 密码：" + pass);
//					}
//					myDaoTemplate.createByBatch("tuser.updateByPrimaryKeySelective", tuserList);
//					
//					System.out.println("保存成功");
//					
//					
//				}
//				return buff.toString();
//			}
//			
			
			
			
				
				
			
			
//-------------------------------用户日志查询页面--------------------------------------
			

			//用户日志查询
			@Permission(name="用户日志查询")
			public String searchUserLog() throws Exception {
				try {
					if (userlog == null) {
						userlog = new Userlog();
					}
				  pageObject.executePagination("USERLOG.searchUSERLOGSCount","USERLOG.searchUSERLOGS", userlog);
				}catch (Exception e) { 
					e.printStackTrace();
				}
				
				return "index";
			}	
		
//-------------------------------用户登出--------------------------------------
			

			//用户登出
			@Permission(name="用户登出")
			public String UserLogout() throws Exception {
				
				session.clear();
				return "index";
			}	
			
			
			
//-----------------------------球队一览-----------------------------------------
			
			//球队管理页面
			@Permission(name="球队一览")
			public String goSearchTeamList() throws Exception {
				return "indexRefresh";
			}
			
			
			@Permission(name="球队一览")
			public String SearchTeamList() throws Exception {
				try {
					if (team == null) {
						team = new Team();
					}
				  pageObject.executePagination("team.searchTeamManageCount","team.searchTeamManage", team);
				}catch (Exception e) {
					e.printStackTrace();
				}
				return "index";
			}
			
//-----------------------------球队管理-----------------------------------------			
			
			//球队管理页面
			@Permission(name="球队管理查询")
			public String goSearchTeamManage() throws Exception {
				return "indexRefresh";
			}
			
			
			//球队管理页面
			@Permission(name="球队管理查询")
			public String SearchTeamManage() throws Exception {
				try {
					if (team == null) {
						team = new Team();
					}
				  pageObject.executePagination("team.searchTeamManageCount","team.searchTeamManage", team);
				}catch (Exception e) {
					e.printStackTrace();
				}
				return "index";
			}
			
			
			
			//前往球队管理管理添加页面
			@Permission(name="球队新增")
			public String goaddTeamManage() throws Exception {
			
				return "addTeamManage";
			}
			
			
			
			
			@Permission(name="球队新增")
			public String addTeamManage() throws Exception{
				try {
					
					//检查该球队是否已经存在
				    Team team2 = (Team)myDaoTemplate.queryForObject("team.teamManageExist",team);
				    if(team2 != null)
				    {
				    	session.put(SysConstant.MESSAGE, "用户名已存在！");
				    	return "indexRefresh";
				    }
					
				    team.setBalance(BigDecimal.valueOf(0));
				    team.setGoals(0);
				    team.setLosing(0);
				    team.setWins(0);
				    team.setDraw(0);
				    team.setLost(0);
					team.setID(DataHelper.CreateID());
					team.setCreateTime(new Date());

					myDaoTemplate.create("team.insertSelective",team);
				} catch (Exception e) {			
					e.printStackTrace();
				} 
				return "indexRefresh";
		   }
			
			
			//前往球队管理编辑页面
			@Permission(name="球队编辑")
			public String goeditTeamManage() throws Exception {

				team = (Team) myDaoTemplate.queryForObject("team.selectByPrimaryKey", team);
				Tuser tuserInput = new Tuser();
				tuserInput.setTEAMID(team.getID());
				//获取球员列表
				tuserList = myDaoTemplate.queryForList("tuser.selectByTeam",tuserInput);
				
				return "editTeamManage";
			}
			
			
			//球队管理添加方法
			@Permission(name="球队编辑")
			public String editTeamManage() throws Exception {
					try {
						team.setUpdateTime(new Date());
						myDaoTemplate.update("team.updateByPrimaryKeySelective", team);
					} catch (Exception e) {			
						e.printStackTrace();
					} 
					
					session.put(SysConstant.MESSAGE, "编辑成功！");
					return "indexRefresh";
				}
			
			
			//前往球队管理详情页面
			@Permission(name="球队详情")
			public String godetailTeamManage() throws Exception {

				team = (Team) myDaoTemplate.queryForObject("team.teamManageDetail", team);
				return "detailTeamManage";
			}
			
			 //前往球队管理删除页面
			@Permission(name="球队删除")
			public String delTeamManage() throws Exception {
				try
				{
					myDaoTemplate.delete("team.deleteByPrimaryKey", team);
				}catch (Exception e) {			
					e.printStackTrace();
				} 
				
				session.put(SysConstant.MESSAGE, "删除成功！");
				
				return "indexRefresh";
			}
			
			
//-----------------------------新用户注册-----------------------------------------		
			 
			//前往新用户注册页面
			@Permission(name="新用户注册")
			public String goRegister() throws Exception {
				//获取球队列表
				teamList = myDaoTemplate.queryForList("team.selectAll");
				return "addRegister";
			}
				
			
			//新用户注册
			@Permission(name="新用户注册")
			public String addRegister() throws Exception {
				try {
					
					//检查用户是否已存在
				    Tuser tuser2 = (Tuser)myDaoTemplate.queryForObject("tuser.selectByUser",tuser);
				    if(tuser2 != null)
				    {
				    	session.put(SysConstant.MESSAGE, "用户名已存在！");
				    	return "indexRefresh";
				    }
				    tuser.setPASSWORD(PasswordUtil.encrypt(tuser.getPASSWORD()));
				    tuser.setID(DataHelper.CreateID());
				    //默认设置查看权限
				    tuser.setROLEID(SysConstant.ROLEVIEW);
				    tuser.setASSIST(0);
				    tuser.setBALANCE(BigDecimal.valueOf(0));
				    tuser.setGOALS(0);
				    tuser.setPLAYTIMES(0);
				    
				    tuser.setCREATETIME(new Date());
					myDaoTemplate.create("tuser.insertSelective",tuser);
					
					//session
					session.put(SysConstant.USER, tuser);
				} catch (Exception e) {			
					e.printStackTrace();
				} 
				return "mainIndex";
			}


//-----------------------------队员页面-----------------------------------------	
			//队员一览页面
			@Permission(name="队员一览查询")
			public String goUserInfo() throws Exception {
				
				return "indexRefresh";
				}
			
			
			//队员一览页面
			@Permission(name="队员一览查询")
			public String searchUserInfo() throws Exception {
				
				try {
					if (tuser == null) {
						tuser = new Tuser();
					}
					
			      //获取球队列表
				  teamList = getAllTeamList();
				  pageObject.executePagination("tuser.searchTuserCount","tuser.searchTuser", tuser);
				 				  
				  
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				return "index";
				}
			
			
			
			//队员资料修改
			@Permission(name="队员资料修改")
			public String goeditUserInfo() throws Exception {
				
				tuser = (Tuser)session.get(SysConstant.USER);
				//获取球队列表
				teamList = myDaoTemplate.queryForList("team.selectAll");
				
				return "editUserInfo";
				}
		
			//队员资料修改
			@Permission(name="队员资料修改")
			public String editUserInfo() throws Exception {
				try {
				
					String imagUrl = null;
					if(upload != null)
					{
						//判断图片格式
						if(!(uploadContentType.equals("image/jpg") || uploadContentType.equals("image/jpeg") 
								|| uploadContentType.equals("image/gif") || uploadContentType.equals("image/bmp") 
								|| uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")
								|| uploadContentType.equals("image/raw")))
						{
							session.put(SysConstant.MESSAGE, "图片格式不正确！");
							//获取球队列表
							teamList = myDaoTemplate.queryForList("team.selectAll");
							
							return "editUserInfo";
						}
						
						//输入流
						FileInputStream fis = new FileInputStream(upload);
						//限制上传图片的大小
						if(fis.available() > SysConstant.PICSIZE)
						{
							session.put(SysConstant.MESSAGE, "图片太大了！");
							//获取球队列表
							teamList = myDaoTemplate.queryForList("team.selectAll");
							
							return "editUserInfo";
						}
						
						//上传头像
						//设置放置图片的服务器路径和文件名，文件名格式为username_filenamee
						//输出流
						
						FileOutputStream fos = new FileOutputStream(getSavePath() + "img\\upload\\" + tuser.getUSERNAME() + "_" + uploadFileName);
						byte[] buffer = new byte[1024];
						int len = 0;
						while((len = fis.read(buffer)) > 0)
						{
							fos.write(buffer, 0, len);
						}
						
						//删除原来的头像
						if(tuser.getPICURL() != null && tuser.getPICURL() != "")
						{
							File file = new File(getSavePath() + tuser.getPICURL());
							if(file.exists())
							{
								file.delete();
							}
						}
						

						//设置数据库要保存的文件名
						imagUrl = "img\\upload\\" + tuser.getUSERNAME() + "_" + uploadFileName;
					}
					
					
					Tuser tuser2 = (Tuser) myDaoTemplate.queryForObject("tuser.selectByPrimaryKey", tuser);
					tuser2.setREALNAME(tuser.getREALNAME());
					tuser2.setTEAMID(tuser.getTEAMID());
					tuser2.setADDRESS(tuser.getADDRESS());
					tuser2.setTEL(tuser.getTEL());
					tuser2.setBIRTHDAY(tuser.getBIRTHDAY());
					if(imagUrl != null)
					{
						tuser2.setPICURL(imagUrl);
					}
					tuser2.setUPDATETIME(new Date());
					
					//获取球队列表
					teamList = myDaoTemplate.queryForList("team.selectAll");
					
					myDaoTemplate.update("tuser.updateByPrimaryKey",tuser2);
					//更新session
					session.put(SysConstant.USER, tuser2);
					
					session.put(SysConstant.MESSAGE, "修改成功！");

				} catch (Exception e) {			
					e.printStackTrace();
				} 
				
				return "indexRefresh";
			}
			
			
			
			//队员资料详情改
			@Permission(name="队员资料详情")
			public String godetailUserInfo() throws Exception {
				
			    tuserList = myDaoTemplate.queryForList("tuser.selectAll");

				int pageTotal = tuserList.size();
				if(pageTotal > 0)
				{
					//点详细按钮进来的id不为空，首先显示当前用户信息
					if(tuser != null && tuser.getID() != "")
					{
						for(int i = 0; i < tuserList.size(); i++)
						{
							if(tuserList.get(i).getID().equals(tuser.getID()))
							{
								pageNow = i;
								tuser = tuserList.get(i);
							}
						}
					}
					//点上一页下一页进来的
					else
					{
						//如果下标到头就循环
						if(pageNow < 0)
						{
							pageNow = pageTotal - 1;
						}
						else if(pageNow > (pageTotal - 1))
						{
							pageNow = 0;
						}
						
						//获取当前的user对象，每次只取一个对象
						tuser = tuserList.get(pageNow);
					}
				}
				
				return "detailUserInfo";
				}
			
			
			
			
			//队员记录明细页面
			@Permission(name="队员记录明细页面")
			public String goUserInfoRecords() throws Exception {
				
				return "indexRefresh";
				}
			
			
			
			
			//队员记录明细页面
			@Permission(name="队员记录明细页面")
			public String searchUserInfoRecords() throws Exception {
				
				try {
					if (userrecordsView == null) {
						userrecordsView = new UserrecordsView();
					}
					
			      //获取球队列表
				  teamList = getAllTeamList();
				  
				  pageObject.executePagination("userrecords.searchuserrecordsViewCount","userrecords.searchuserrecordsView", userrecordsView);
				 				  
				  
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				return "index";
				}
			
			
			
			
			//球队记录明细页面
			@Permission(name="球队记录明细页面")
			public String goTeamRecords() throws Exception {
				
				return "indexRefresh";
				}
			
			
			
			
			//球队记录明细页面
			@Permission(name="球队记录明细页面")
			public String searchTeamRecords() throws Exception {
				
				try {
					if (teamrecordsView == null) {
						teamrecordsView = new TeamrecordsView();
					}
					
			      //获取球队列表
				  teamList = getAllTeamList();
				  
				  pageObject.executePagination("teamrecords.searchTeamrecordsViewCount","teamrecords.searchTeamrecordsView", teamrecordsView);
				 				  
				  
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				return "index";
				}
			
			
			
			
//----------------------------------队长页面--------------------------------------------------
	
			//队员战绩管理页面
			@Permission(name="队员战绩管理查询")
			public String  goTeamMemberManage() throws Exception {

				return "index";
			}
			
			
			//队员战绩管理页面
			@Permission(name="队员战绩管理查询")
			public String getTuserData() throws Exception {
				
				String str;
		        StringBuilder strb = new StringBuilder();
		        
		      //判读是否为队长
				tuser = (Tuser)session.get(SysConstant.USER);
				team = new Team();
				team.setID(tuser.getTEAMID());
				Team teamResult = (Team) myDaoTemplate.queryForObject("team.selectByPrimaryKey", team);
			    if(teamResult != null)
			    {
			    	//如果不是队长
			    	if(!tuser.getID().equals(teamResult.getCaptainID()))
			    	{
			    		 throw new RightsException("你没有访问该页面的权限");
			    	}
			    	
			    	
			    	//是队长
			    	tuserList = myDaoTemplate.queryForList("tuser.selectByTeam",tuser);
			    	
			    }

				if(tuserList.size() > 0)
				{  
					//构造json格式的字符串
					strb.append("{ \"Rows\": [");
					for(Tuser tuser : tuserList)
					{
						  
			              str = "{" + MessageFormat.format(
			                                 "\"USERNAME\":{0},\"REALNAME\":{1},\"TEAMNAME\":{2},\"PLAYTIMES\":{3},\"GOALS\":{4},\"ASSIST\":{5},\"BALANCE\":{6},\"ID\":{7}",
			                                 "\""+tuser.getUSERNAME()+"\"", "\""+tuser.getREALNAME()+"\"", "\""+tuser.getTEAMNAME()+"\"", "0","0", "0", "0","\""+tuser.getID()+"\"" ) +
			                                 "},";

			              
			              strb.append(str);
					}
					
				}
				
			   if (strb.length() > 0)
		       {
				   jsonResult = strb.toString();
		           //去尾
				   jsonResult = jsonResult.substring(0,jsonResult.length() - 1);
				   jsonResult = jsonResult + "]}";
		       }

				return "success";
		}
			
			
			
			//队员战绩管理页面
			@Permission(name="队员战绩管理编辑")
			public String  editTeamMemberManage() throws Exception {
				try {
					userrecordsList = new ArrayList<Userrecords>();
					//获取更新前的数据
					tuser = (Tuser)session.get(SysConstant.USER);
					tuserList = myDaoTemplate.queryForList("tuser.selectByTeam",tuser);
					
					ArrayList<Tuser> tuserListForUpdate = new ArrayList<Tuser>();
					Userrecords tempUserrecords;
					JSONObject jsonObject;
					//解析页面传进来的json数据，然后保存到数据库
					if(submitData != null && !submitData.equals(""))		
					{
						JSONArray jsonArry = new JSONArray(submitData);
						for(int i = 0; i < jsonArry.length(); i++)
						{
							tempUserrecords = new Userrecords();
							
							jsonObject = jsonArry.getJSONObject(i);
							//添加到队员记录明细表
							tempUserrecords.setID(DataHelper.CreateID());
							tempUserrecords.setUserID(jsonObject.getString("ID"));
							tempUserrecords.setPlayTimes(jsonObject.getInt("PLAYTIMES"));
							tempUserrecords.setGoals(jsonObject.getInt("GOALS"));
							tempUserrecords.setAssist(jsonObject.getInt("ASSIST"));
							tempUserrecords.setBalance(BigDecimal.valueOf(jsonObject.getDouble("BALANCE")));
							tempUserrecords.setCreateTime(new Date());
							userrecordsList.add(tempUserrecords);
							
							//修改队员总表记录
							for(Tuser tuser : tuserList)
							{
								if(tuser.getID().equals(jsonObject.getString("ID")))
								{
									tuser.setPLAYTIMES(tuser.getPLAYTIMES() + jsonObject.getInt("PLAYTIMES"));
									tuser.setGOALS(tuser.getGOALS() + jsonObject.getInt("GOALS"));
									tuser.setASSIST(tuser.getASSIST() + jsonObject.getInt("ASSIST"));
									tuser.setBALANCE(tuser.getBALANCE().subtract(BigDecimal.valueOf(jsonObject.getDouble("BALANCE"))));
									tuser.setUPDATETIME(new Date());
									tuserListForUpdate.add(tuser);
									//如果找到终止该循环
									break;
								}
							}

						}
						//***********需要加上事务处理*******************
						//修改队员总表记录
						myDaoTemplate.updateByBatch("tuser.updateByPrimaryKeySelective", tuserListForUpdate);
						//添加到队员记录明细表
						myDaoTemplate.createByBatch("userrecords.insertSelective", userrecordsList);
					}
				} catch (Exception e) {			
					e.printStackTrace();
				} 
				
				session.put(SysConstant.MESSAGE, "编辑成功！");
				return "index";

			}


					
			
			//球队战绩管理页面
			@Permission(name="球队战绩管理查询")
			public String  goTeamScoreManage() throws Exception {

				return "index";
			}
			
			
			//球队战绩管管理页面
			@Permission(name="球队战绩管理查询")
			public String getTeamScoreData() throws Exception {
				
				String str;
		        StringBuilder strb = new StringBuilder();
		        
		        //判读是否为队长
				tuser = (Tuser)session.get(SysConstant.USER);
				team = new Team();
				team.setID(tuser.getTEAMID());
				Team teamResult = (Team) myDaoTemplate.queryForObject("team.selectByPrimaryKey", team);
			    if(teamResult != null)
			    {
			    	//如果不是队长
			    	if(!tuser.getID().equals(teamResult.getCaptainID()))
			    	{
			    		 throw new RightsException("你没有访问该页面的权限");
			    	}
			    	
			    }

			    jsonResult = "{ \"Rows\": [{\"ID\": \"" + teamResult.getID() + "\",\"TeamName\": \"" + teamResult.getTeamName() + "\",\"Wins\": 0 ,\"Draw\":0,\"Losing\":0,\"Goals\":0,\"Lost\":0}]}";

				return "success";
		}
			
			
			
			//获取json格式球队列表
			@Permission(name="球队战绩管理查询")
			public String getTeamListJson() {
				
	         String str;
		     StringBuilder strb = new StringBuilder();
		     
		     tuser = (Tuser)session.get(SysConstant.USER);
		     
			 teamList = myDaoTemplate.queryForList("team.selectAll");
			 
			  
				if(teamList.size() > 0)
				{  
					//构造json格式的字符串
					strb.append("[");
					for(Team team : teamList)
					{
						  //排除本队
						  if(tuser.getID().equals(team.getCaptainID()))
						  {
							  continue;
						  }
			              str = "{" + MessageFormat.format(
			                                 "\"OpponentID\":{0},\"TeamName\":{1}",
			                                 "\""+team.getID()+"\"", "\""+team.getTeamName()+"\"") +
			                                 "},";

			              strb.append(str);
					}
					
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
			
			
			
			//球队战绩管理页面
			@Permission(name="球队战绩管理编辑")
			public String  editTeamScoreManage() throws BusinessFailure {
				try {
					
					JSONObject jsonObject;
					//解析页面传进来的json数据，然后保存到数据库
					if(submitData != null && !submitData.equals(""))		
					{
						JSONArray jsonArry = new JSONArray(submitData);
						for(int i = 0; i < jsonArry.length(); i++)
						{
							
							jsonObject = jsonArry.getJSONObject(i);
							
							//添加到球队记录明细表
							teamrecords = new Teamrecords();
							teamrecords.setID(DataHelper.CreateID());
							teamrecords.setTeamID(jsonObject.getString("ID"));
							teamrecords.setOpponentID(jsonObject.getString("OpponentID"));
							teamrecords.setWins(jsonObject.getInt("Wins"));
							teamrecords.setDraw(jsonObject.getInt("Draw"));
							teamrecords.setLosing(jsonObject.getInt("Losing"));
							teamrecords.setGoals(jsonObject.getInt("Goals"));
							teamrecords.setLost(jsonObject.getInt("Lost"));
							teamrecords.setCreateTime(new Date());
							
							
							//修改球队总表记录
							team = new Team();
							team.setID(jsonObject.getString("ID"));
							Team teamResult = (Team) myDaoTemplate.queryForObject("team.selectByPrimaryKey", team);
							
							teamResult.setWins(teamResult.getWins() + jsonObject.getInt("Wins"));
							teamResult.setDraw(teamResult.getDraw() + jsonObject.getInt("Draw"));
							teamResult.setLosing(teamResult.getLosing() + jsonObject.getInt("Losing"));
							teamResult.setGoals(teamResult.getGoals() + jsonObject.getInt("Goals"));
							teamResult.setLost(teamResult.getLost() + jsonObject.getInt("Lost"));
							teamResult.setUpdateTime(new Date());
							

							//添加记录
							myDaoTemplate.create("teamrecords.insertSelective", teamrecords);
							//修改记录
							myDaoTemplate.update("team.updateByPrimaryKeySelective", teamResult);
						}
						
					}
				} catch (Exception e) {			
					e.printStackTrace();
				} 
				
				session.put(SysConstant.MESSAGE, "编辑成功！");
				return "index";

			}


			

		
			//获取球队列表
			private List<Team> getAllTeamList()
			{
				  teamList = myDaoTemplate.queryForList("team.selectAll");
				  //手动添加‘全部’选项
				  Team teamItem = new Team();
				  teamItem.setTeamName("全部");
				  teamItem.setID("");
				  teamList.add(0,teamItem);
				  
				  return teamList;
			}

}
