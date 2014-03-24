package com.wildwolf.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wildwolf.dataaccess.MyDaoTemplate;
//import com.wildwolf.model.Marketinguploadinfo;
//import com.wildwolf.model.MarketinguploadinfoLog;
//import com.wildwolf.model.MarketinguploadinfoSearch;
//import com.wildwolf.model.Stroageinventory;
//import com.wildwolf.model.StroageinventoryLog;

public class zwtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext a = new ClassPathXmlApplicationContext();
		a.setConfigLocation("classpath:applicationContext.xml");
		a.refresh();
		MyDaoTemplate t = (MyDaoTemplate) a.getBean("myDaoTemplate");
		//销售记录
		//addbuyrecord(t,50);

		//销售修改记录
		//addbuyrecordlog(t,50);
		//销售表报
		//addmarketrecordReport(t,50);
		//销售记录
		//addmarketrecord(t, 50);
		//销售修改记录
		//addmarketrecordlog(t, 50);
		//库存记录
		//addstroagerecord(t, 50);
		//库存修改记录
		//addstroagerecordlog(t, 50);
		
		
	}
	
//	private static void addmarketrecord(MyDaoTemplate t,int num)
//	{
//		
//		for (int i = 0; i < num; i++) {
//			Marketinguploadinfo b =new Marketinguploadinfo();
//			
//			b.setAPPROVALNUMBER(String.valueOf(i));
//			b.setCREATETIME(new Date());
//			b.setCREATEBY("zw");
//			b.setBASICUNITB("11");
//			b.setBASICUNITS("324");
//			b.setBATCHNO(String.valueOf(i));
//			b.setSALECOUNT(new BigDecimal(10));
//			b.setSALETIME(new Date());
//			b.setCARTONSIZE("23432");
//			b.setDRUGFULLNAME("name"+String.valueOf(i));
//			
//			b.setDRUGID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTOREID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTORENAME("423423");
//			b.setID(String.valueOf(System.currentTimeMillis())
//					+ new Random().nextLong());
//			b.setMANUFACTURER("生产单位");
//			b.setSUPPLY("供应商");
//			b.setEXPIRYDATE(new Date());
//			b.setUPDATETIME(new Date());
//			b.setUPDATEBY("ZW");
//			t.create("MARKETINGUPLOADINFO.insertSelective", b);
//
//		}
//		System.out.println("SUCCESS!");
//	}
//	private static void addmarketrecordReport(MyDaoTemplate t,int num)
//	{
//		
//		for (int i = 0; i < num; i++) {
//			MarketinguploadinfoSearch b =new MarketinguploadinfoSearch();
//			
//			b.setAPPROVALNUMBER(String.valueOf(i));
//			b.setCREATETIME(new Date());
//			b.setCREATEBY("zw");
//			b.setBASICUNITB(String.valueOf(i));
//			b.setBASICUNITS(String.valueOf(i));
//			b.setBATCHNO(String.valueOf(i));
//			b.setSALECOUNT(new BigDecimal(10));
//			b.setSALETIME(new Date());
//			b.setCARTONSIZE("23432");
//			b.setDRUGFULLNAME("name"+String.valueOf(i));
//			
//			b.setDRUGID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTOREID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTORENAME("423423");
//			b.setID(String.valueOf(System.currentTimeMillis())
//					+ new Random().nextLong());
//			b.setMANUFACTURER("生产单位");
//			b.setSUPPLY("供应商");
//			b.setEXPIRYDATE(new Date());
//			b.setUPDATETIME(new Date());
//			b.setUPDATEBY("ZW");
//			b.setTableName("MARKETINGUPLOADINFO_201301");
//			t.create("MARKETINGUPLOADINFO.insertReport", b);
//
//		}
//		System.out.println("SUCCESS!");
//	}
//	private static void addmarketrecordlog(MyDaoTemplate t,int num)
//	{
//		
//		for (int i = 0; i < num; i++) {
//			MarketinguploadinfoLog b =new MarketinguploadinfoLog();
//			b.setMARKETINGUPLOADINFOID(String.valueOf(System.currentTimeMillis()));
//			b.setAPPROVALNUMBER("12345");
//			b.setCREATETIME(new Date());
//			b.setCREATEBY("zw");
//			b.setBASICUNITB("11");
//			b.setBASICUNITS("324");
//			b.setBATCHNO("1235fddf");
//			b.setSALECOUNT(new BigDecimal(10));
//			b.setSALETIME(new Date());
//			b.setCARTONSIZE("23432");
//			b.setDRUGFULLNAME("42fsdfd");
//			
//			b.setDRUGID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTOREID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTORENAME("423423");
//			b.setID(String.valueOf(System.currentTimeMillis())
//					+ new Random().nextLong());
//			b.setMANUFACTURER("生产单位");
//			b.setSUPPLY("供应商");
//			b.setEXPIRYDATE(new Date());
//			b.setUPDATE(new Date());
//			b.setUPDATEBY("ZW");
//			t.create("MARKETINGUPLOADINFO_LOG.insertSelective", b);
//
//		}
//		System.out.println("SUCCESS!");
//	}
//	private static void addstroagerecord(MyDaoTemplate t,int num)
//	{
//		
//		for (int i = 0; i < num; i++) {
//			Stroageinventory b=new Stroageinventory();
//			
//			b.setAPPROVALNUMBER("12345");
//			b.setCREATETIME(new Date());
//			b.setCREATEBY("zw");
//			b.setBASICUNITB("11");
//			b.setBASICUNITS("324");
//			b.setBATCHNO("1235fddf");
//			b.setSTROAGECOUNT(new BigDecimal(10));
//			b.setSALETIME(new Date());
//			b.setCARTONSIZE("23432");
//			b.setDRUGFULLNAME("42fsdfd");
//			
//			b.setDRUGID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTOREID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTORENAME("423423");
//			b.setID(String.valueOf(System.currentTimeMillis())
//					+ new Random().nextLong());
//			b.setMANUFACTURER("生产单位");
//			b.setSUPPLY("供应商");
//			b.setEXPIRYDATE(new Date());
//			b.setUPDATETIME(new Date());
//			b.setUPDATEBY("ZW");
//			
//			t.create("STROAGEINVENTORY.insertSelective", b);
//
//		}
//		System.out.println("SUCCESS!");
//	}
//	private static void addstroagerecordlog(MyDaoTemplate t,int num)
//	{
//		
//		for (int i = 0; i < num; i++) {
//			StroageinventoryLog b=new StroageinventoryLog();
//			b.setSTROAGEINVENTORYID(String.valueOf(System.currentTimeMillis()));
//			b.setAPPROVALNUMBER("12345");
//			b.setCREATETIME(new Date());
//			b.setCREATEBY("zw");
//			b.setBASICUNITB("11");
//			b.setBASICUNITS("324");
//			b.setBATCHNO("1235fddf");
//			b.setSTROAGECOUNT(new BigDecimal(10));
//			b.setSALETIME(new Date());
//			b.setCARTONSIZE("23432");
//			b.setDRUGFULLNAME("42fsdfd");
//			
//			b.setDRUGID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTOREID(String.valueOf(System.currentTimeMillis()));
//			b.setDRUGSTORENAME("423423");
//			b.setID(String.valueOf(System.currentTimeMillis())
//					+ new Random().nextLong());
//			b.setMANUFACTURER("生产单位");
//			b.setSUPPLY("供应商");
//			b.setEXPIRYDATE(new Date());
//			b.setUPDATIME(new Date());
//			b.setUPDATEBY("ZW");
//			t.create("STROAGEINVENTORY_LOG.insertSelective", b);
//		}
//		System.out.println("SUCCESS!");
//	}
//	
//	
//	public void excel()
//	{
//	// import org.apache.poi.ss.usermodel.*;
//
////	Workbook[] wbs = new Workbook[] { new HSSFWorkbook(), new XSSFWorkbook() };
////	for(int i=0; i<wbs.length; i++) {
////	   Workbook wb = wbs[i];
////	   CreationHelper createHelper = wb.getCreationHelper();
////
////	   // create a new sheet
////	   Sheet s = wb.createSheet();
////	   // declare a row object reference
////	   Row r = null;
////	   // declare a cell object reference
////	   Cell c = null;
////	   // create 2 cell styles
////	   CellStyle cs = wb.createCellStyle();
////	   CellStyle cs2 = wb.createCellStyle();
////	   DataFormat df = wb.createDataFormat();
////
////	   // create 2 fonts objects
////	   Font f = wb.createFont();
////	   Font f2 = wb.createFont();
////
////	   // Set font 1 to 12 point type, blue and bold
////	   f.setFontHeightInPoints((short) 12);
////	   f.setColor( IndexedColors.RED.getIndex() );
////	   f.setBoldweight(Font.BOLDWEIGHT_BOLD);
////
////	   // Set font 2 to 10 point type, red and bold
////	   f2.setFontHeightInPoints((short) 10);
////	   f2.setColor( IndexedColors.RED.getIndex() );
////	   f2.setBoldweight(Font.BOLDWEIGHT_BOLD);
////
////	   // Set cell style and formatting
////	   cs.setFont(f);
////	   cs.setDataFormat(df.getFormat("#,##0.0"));
////
////	   // Set the other cell style and formatting
////	   cs2.setBorderBottom(cs2.BORDER_THIN);
////	   cs2.setDataFormat(df.getFormat("text"));
////	   cs2.setFont(f2);
////
////
////	   // Define a few rows
////	   for(int rownum = 0; rownum < 30; rownum++) {
////		   Row r = s.createRow(rownum);
////		   for(int cellnum = 0; cellnum < 10; cellnum += 2) {
////			   Cell c = r.createCell(cellnum);
////			   Cell c2 = r.createCell(cellnum+1);
////	   
////			   c.setCellValue((double)rownum + (cellnum/10));
////			   c2.setCellValue(
////			         createHelper.createRichTextString("Hello! " + cellnum)
////			   );
////		   }
////	   }
////	   
////	   // Save
////	   String filename = "workbook.xls";
////	   if(wb instanceof XSSFWorkbook) {
////	     filename = filename + "x";
////	   }
////	 
////	   FileOutputStream out = new FileOutputStream(filename);
////	   wb.write(out);
////	   out.close();
////	}
//	}
//	        
}
