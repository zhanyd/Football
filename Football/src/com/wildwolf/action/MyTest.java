package com.wildwolf.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wildwolf.dataaccess.MyDaoTemplate;

public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext a = new ClassPathXmlApplicationContext();
		a.setConfigLocation("classpath:applicationContext.xml");
		a.refresh();
		MyDaoTemplate t = (MyDaoTemplate) a.getBean("myDaoTemplate");

//		//需要修改
//		for (int i = 0; i < 1000; i++) {
//			Buyrecord b = new Buyrecord();
//			b.setAPPROVALNUMBER("12345");
//			b.setAUDITDATE(new Date());
//			b.setAUDITOR("11");
//			b.setBASICUNITB("11");
//			b.setBASICUNITS("324");
//			b.setBATCHNO("1235fddf");
//			b.setBUYCOUNT(10);
//			b.setBUYTIME(new Date());
//			b.setCARTONSIZE("23432");
//			b.setDRUGFULLNAME("42fsdfd");
//			b.setDRUGID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTOREID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTORENAME("423423");
//			b.setID(String.valueOf(System.currentTimeMillis())+ new Random().nextLong());
//			b.setMANUFACTURER("生行");
//
//			t.create("BUYRECORD.insertSelective", b);
//		}
		System.out.println("SUCCESS!");
	}

}
