package com.wildwolf.action;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.wildwolf.dataaccess.MyDaoTemplate;
import com.wildwolf.helper.DataHelper;
import com.wildwolf.helper.HZpy;
import com.wildwolf.helper.NoSessionException;
import com.wildwolf.helper.RightsException;
import com.wildwolf.model.Drugstore;
import com.wildwolf.model.Role;
import com.wildwolf.model.Tuser;
import com.wildwolf.model.Userlog;

import org.json.*;

public abstract class RootAction extends ActionSupport implements
		ServletRequestAware, Preparable, SessionAware, ServletResponseAware {
	protected MyDaoTemplate myDaoTemplate;
	protected Map session;
	protected HttpServletResponse httpServletResponse;
	protected HttpServletRequest httpServletRequest;
	private String[] permissionClassNames = { "BaseInfoActionBean","RightsManageAction" };
	//用户log
	private Userlog userlog;

	public Userlog getUserlog() {
		return userlog;
	}

	public void setUserlog(Userlog userlog) {
		this.userlog = userlog;
	}

	// 导出excel
	public void exportExcel(LinkedHashMap<String, String> objectFieldTitleMap,
			String sqlId, Object paramObject) throws Exception {

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Sheet1");

		HSSFFont font = wb.createFont();
		// font.setFontHeightInPoints((short)24);
		font.setFontName("宋体");
		font.setItalic(false);

		HSSFCellStyle stringCellStyle = wb.createCellStyle();
		stringCellStyle.setFont(font);
		addCellBorderStyle(stringCellStyle);
		stringCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		stringCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		HSSFCellStyle numberCellStyle = wb.createCellStyle();
		numberCellStyle.setFont(font);
		addCellBorderStyle(numberCellStyle);
		numberCellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		numberCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		CreationHelper createHelper = wb
				.getCreationHelper();
		CellStyle dateStyle = wb.createCellStyle();
		dateStyle.setDataFormat(createHelper
				.createDataFormat().getFormat(
						"yyyy-MM-dd HH:mm:ss"));

		/** 生成标题行 ***/
		HSSFRow row0 = sheet.createRow(0);
		int columnCount = objectFieldTitleMap.size();
		Set entrySet = objectFieldTitleMap.entrySet();
		int i = 0;
		Iterator it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it
					.next();
			HSSFCell cell = row0.createCell(i++);
			cell.setCellStyle(stringCellStyle);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(entry
					.getValue())));
		}
		/** 自动调整列宽 **/
		for (int j = 0; j < columnCount; j++) {
			sheet.autoSizeColumn(j);
		}

		/** 生成数据内容行 ****/
		List contentList = myDaoTemplate.queryForList(sqlId, paramObject);
		
		if (contentList == null) {
			contentList = new ArrayList();
		}
		int dataRowCount = contentList.size();
		if(dataRowCount > 30000)
		{
			throw new RightsException("要导出的数据量太大，请添加检索条件！");
		}
		for (int k = 0; k < dataRowCount; k++) {
			Object o = contentList.get(k);
			HSSFRow row = sheet.createRow(k + 1);// 标题占1行

			entrySet = objectFieldTitleMap.entrySet();
			int m = 0;
			Iterator itc = entrySet.iterator();
			while (itc.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) itc
						.next();
				HSSFCell cell = row.createCell(m++);
				cell.setCellStyle(stringCellStyle);
				String myField = entry.getKey();

				Method[] methods = o.getClass().getMethods();
				for (int x = 0; x < methods.length; x++) {
					Method f = methods[x];
					if (f.getName().toLowerCase().contains("get" + myField.toLowerCase())) {
					
								Object result = null;
								try {
									result = f.invoke(o, null);
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
								if(result != null)
								{
									if (result.getClass().getName().equals("java.util.Date")) {
									
										cell.setCellStyle(dateStyle);
	
										if (result != null)
											cell.setCellValue((Date) result);
	
									} else if (result.getClass().getName().equals(
											"java.lang.Number")) {
										cell.setCellStyle(numberCellStyle);
										if (result != null)
											cell.setCellValue(Double.valueOf(String
													.valueOf(result)));
									} else {
										cell.setCellStyle(stringCellStyle);
										if (result != null)
											cell.setCellValue(new HSSFRichTextString(
													String.valueOf(result)));
									}
								}
							
						
					}
				}
			}
		}
		HttpServletResponse response = getServletResponse();
		ServletOutputStream out = response.getOutputStream();
		try {

			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
			String attachmentFileName = sf.format(new Date()) + ".xls";
			response.setContentType("applicationnd.ms-excel");
			response.addHeader("Content-Disposition", "attachment; filename=\""
					+ attachmentFileName + "\"");

			try {
				wb.write(out);
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	/**
	 * 添加Excel单元格的style
	 * 
	 * @param style
	 */
	private void addCellBorderStyle(HSSFCellStyle style) {
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(HSSFColor.BLACK.index);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setTopBorderColor(HSSFColor.BLACK.index);

	}

	public HttpServletResponse getServletResponse() {
		return httpServletResponse;
	}

	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}
	
	
	
		// 导出excel(重载)
		public void exportExcel(LinkedHashMap<String, String> objectFieldTitleMap,List contentList) throws Exception {

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Sheet1");

			HSSFFont font = wb.createFont();
			// font.setFontHeightInPoints((short)24);
			font.setFontName("宋体");
			font.setItalic(false);

			HSSFCellStyle stringCellStyle = wb.createCellStyle();
			stringCellStyle.setFont(font);
			addCellBorderStyle(stringCellStyle);
			stringCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			stringCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

			HSSFCellStyle numberCellStyle = wb.createCellStyle();
			numberCellStyle.setFont(font);
			addCellBorderStyle(numberCellStyle);
			numberCellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			numberCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			
			CreationHelper createHelper = wb
					.getCreationHelper();
			CellStyle dateStyle = wb.createCellStyle();
			dateStyle.setDataFormat(createHelper
					.createDataFormat().getFormat(
							"yyyy-MM-dd HH:mm:ss"));

			/** 生成标题行 ***/
			HSSFRow row0 = sheet.createRow(0);
			int columnCount = objectFieldTitleMap.size();
			Set entrySet = objectFieldTitleMap.entrySet();
			int i = 0;
			Iterator it = entrySet.iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) it
						.next();
				HSSFCell cell = row0.createCell(i++);
				cell.setCellStyle(stringCellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(entry
						.getValue())));
			}
			/** 自动调整列宽 **/
			for (int j = 0; j < columnCount; j++) {
				sheet.autoSizeColumn(j);
			}

			/** 生成数据内容行 ****/
			//List contentList = myDaoTemplate.queryForList(sqlId, paramObject);
			if (contentList == null) {
				contentList = new ArrayList();
			}
			int dataRowCount = contentList.size();
			if(dataRowCount > 30000)
			{
				throw new RightsException("要导出的数据量太大，请添加检索条件！");
			}
			for (int k = 0; k < dataRowCount; k++) {
				Object o = contentList.get(k);
				HSSFRow row = sheet.createRow(k + 1);// 标题占1行

				entrySet = objectFieldTitleMap.entrySet();
				int m = 0;
				Iterator itc = entrySet.iterator();
				while (itc.hasNext()) {
					Map.Entry<String, String> entry = (Map.Entry<String, String>) itc
							.next();
					HSSFCell cell = row.createCell(m++);
					cell.setCellStyle(stringCellStyle);
					String myField = entry.getKey();

					Method[] methods = o.getClass().getMethods();
					for (int x = 0; x < methods.length; x++) {
						Method f = methods[x];
						if (f.getName().toLowerCase().contains("get" + myField.toLowerCase())) {
						
									Object result = null;
									try {
										result = f.invoke(o, null);
									} catch (IllegalAccessException e) {
										e.printStackTrace();
									} catch (IllegalArgumentException e) {
										e.printStackTrace();
									} catch (InvocationTargetException e) {
										e.printStackTrace();
									}
									if(result != null)
									{
										if (result.getClass().getName().equals("java.util.Date")) {
										
											cell.setCellStyle(dateStyle);
		
											if (result != null)
												cell.setCellValue((Date) result);
		
										} else if (result.getClass().getName().equals(
												"java.lang.Number")) {
											cell.setCellStyle(numberCellStyle);
											if (result != null)
												cell.setCellValue(Double.valueOf(String
														.valueOf(result)));
										} else {
											cell.setCellStyle(stringCellStyle);
											if (result != null)
												cell.setCellValue(new HSSFRichTextString(
														String.valueOf(result)));
										}
									}
							
						}
					}
				}
			}
			HttpServletResponse response = getServletResponse();
			ServletOutputStream out = response.getOutputStream();
			try {

				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
				String attachmentFileName = sf.format(new Date()) + ".xls";
				response.setContentType("applicationnd.ms-excel");
				response.addHeader("Content-Disposition", "attachment; filename=\""
						+ attachmentFileName + "\"");

				try {
					wb.write(out);
				} catch (IOException e) {
					e.printStackTrace();
				}
				out.flush();
			} finally {
				if (out != null) {
					out.close();
				}
			}

		}

	// session
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;
	}

	//权限管理
	public void prepare() throws Exception {


		String strMethod = ActionContext.getContext().getActionInvocation().getProxy().getMethod();
		//排除login页面
		if(strMethod.equals("login") || strMethod.equals("loginUserManage") 
				|| strMethod.equals("goMainUserManage") ||strMethod.equals("UserLogout") 
				|| strMethod.equals("JsonDrugStore") || strMethod.equals("goRegister")
				|| strMethod.equals("addRegister"))
		{
			return;
		}
		
		Tuser user = (Tuser)session.get(SysConstant.USER);
		

		if (user == null) {
			throw new NoSessionException("你还没有登录或者长时间没有操作，请重新登录！");
		}
		
		//管理员不验证
		if (user.getUSERNAME().toLowerCase().equals("admin")) {
			return;
		}
		
		boolean hasPermission = false;
		//在session中获取用户信息
		
		Class c = this.getClass();
		Method[] methods = c.getDeclaredMethods();
		for (int y = 0; y < methods.length; y++) {
			Method method = methods[y];
			if (strMethod.equals(method.getName())) {
				hasPermission = true;
				//权限判断
				Role role = new Role();
				
			    if(user != null)
			    {
			    	//获取该用户角色的权限
					role.setID(user.getROLEID());
					Role roleResult = (Role) myDaoTemplate.queryForObject("ROLE.selectByPrimaryKey", role);
					
					if(roleResult != null && roleResult.getRIGHTS() != null)
					{
						String rights = roleResult.getRIGHTS();
						String[] rightArray = rights.split(",");
						Annotation[] as = method.getDeclaredAnnotations();
						if (as != null) {
							for (int i = 0; i < as.length; i++) 
							{
								Annotation a = as[i];
								if (a.annotationType()
										.equals(Class
												.forName("com.wildwolf.action.Permission"))) {
									Permission p = (Permission) a;
									String pn = p.name();
									//添加用户操作到用户log表
									setLog(user,pn);
									
									if(roleResult.getRIGHTS().contains(pn))
									{
										//System.out.println("有权限");
										return;
									}
								}
							}
						}
					}
			    }
			    
			    //System.out.println("没有权限");
			    throw new RightsException("你没有访问该页面的权限");
			}
		}

	
	}
	
	
	//添加用户操作到用户log表
	public void setLog(Tuser user,String method)
	{
		
		//String uri = httpServletRequest.getRequestURI();
		
		if(user != null)
		{
			userlog = new Userlog();
			userlog.setID(DataHelper.CreateID());
			userlog.setUSERNAME(user.getUSERNAME());
			userlog.setOPERATION(method);
			userlog.setOPERATIONTIME(new Date());
			
			myDaoTemplate.create("USERLOG.insertSelective",userlog);
		}
	}
	
	//获取所有权限
	public TreeSet<String> getAllPermission() throws Exception {
		String classDir = "com.wildwolf.action.";	
		
		TreeSet<String> pList = new TreeSet<String>();
		
		for (int x = 0; x < permissionClassNames.length; x++) {
			Class c = Class.forName(classDir + permissionClassNames[x]);
			Method[] methods = c.getDeclaredMethods();
			for (int y = 0; y < methods.length; y++) {
				Method method = methods[y];
				Annotation[] as = method.getDeclaredAnnotations();
				if (as != null) {
					for (int i = 0; i < as.length; i++) {
						Annotation a = as[i];
						if (a.annotationType()
								.equals(Class
										.forName("com.wildwolf.action.Permission"))) {
							//System.out.println("method.getName() = " + method.getName());
							Permission p = (Permission) a;
							String pn = p.name();
							//System.out.println("p.name() = " + p.name());
							pList.add(pn);
						}
					}
				}

			}

		}

		return pList;

	}
	
	

}
