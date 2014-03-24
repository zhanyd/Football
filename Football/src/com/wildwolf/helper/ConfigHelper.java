package com.wildwolf.helper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * 
 * @author oujianhua 2011-8-18 下午01:00:46
 */
public class ConfigHelper {
	private static Map<String, String> sqlMap = new HashMap<String, String>();
	static {
		try {
			readSqls();
		} catch (BusinessFailure e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在生产环境上由系统初始化Servlet调用
	 * @throws BusinessFailure
	 */
	public static void readSqls() throws BusinessFailure {
		String sqlClassPath = "config.xml";
		InputStream is = ConfigHelper.class.getResourceAsStream(sqlClassPath);
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(is);
			Element root = document.getRootElement();
			for (Iterator<Element> i = root.elementIterator(); i.hasNext();) {
				Element element =  i.next();
				String sqlId = element.attributeValue("id");
				if (sqlId == null) {
					throw new BusinessFailure("没有定义sql id!");
				}
				String sql = element.getText();
				if (sqlMap.get(sqlId) != null) {
					throw new BusinessFailure("sqlid重复！");
				}
				sqlMap.put(sqlId, sql);
			}

		} catch (DocumentException e) {			
			e.printStackTrace();
			throw new BusinessFailure(e.getMessage());
		}

	}

	public static String getSql(String sqlId) {
		return sqlMap.get(sqlId);
	}
	
	public static void main(String[] args) {
		try {
			ConfigHelper.readSqls();
			System.out.println(ConfigHelper.getSql("t_organization_insert"));
			System.out.println(ConfigHelper.getSql("t_organization_update"));
		} catch (BusinessFailure e) {
			e.printStackTrace();
		}
		
	}

}
