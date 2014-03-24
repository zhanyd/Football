package com.wildwolf.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * 
 * @author 王艳霞
 * 2011-11-6 下午12:31:57
 */
public class FileUploadHelper {
	
	private static String storeDir = "D:\nt3c";
	private static int maxSize = 2000000;  //2M

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public static String fileUpload(HttpServletRequest request) throws BusinessFailure {
		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

//		// maximum size that will be stored in memory
		factory.setSizeThreshold(4096);
//		// the location for saving data that is larger than getSizeThreshold()
		factory.setRepository(new File("/tmp"));

		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum size before a FileUploadException will be thrown
		upload.setSizeMax(maxSize);
//		try {
//			upload.setSizeMax(maxSize);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			throw new BusinessFailure("上传文件失败，上传文件大小不能超过2M");
//		}
//		

		// Parse the request
		 InputStream uploadedStream = null;
		 FileOutputStream fos = null;
		 
		try {
			List<FileItem>items = upload.parseRequest(request);
			// Process the uploaded items
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
			    FileItem item = (FileItem) iter.next();
			    if (item.isFormField()) {
//			    	String name = item.getFieldName();
//			        String value = item.getString();

			    } else {
			    	String fieldName = item.getFieldName();
			        String fileName = item.getName();
			        String contentType = item.getContentType();
			        boolean isInMemory = item.isInMemory();
			        long sizeInBytes = item.getSize();
			        
			        if (sizeInBytes > maxSize) {
			        	throw new BusinessFailure("上传文件失败，上传文件大小不能超过2M");
			        }
			        
			        int index = fileName.lastIndexOf(".");
			        String extendName = new String();
			        if (index >= 0) {
			        	 extendName = fileName.substring(index);
			        }
			       
			        String storeFileName = Long.valueOf(System.currentTimeMillis()).toString() + extendName;

			    	 uploadedStream = item.getInputStream();
			    	 String path = getRealPath(request, storeDir);
			    	 File writeToFile = new File(path + "/" + storeFileName);
			    	
			    	 writeToFile.createNewFile();
			    	 
			    	 fos = new FileOutputStream(writeToFile);
			    	 byte[] tempbytes = new byte[1024];  
			    	 int byteread = 0;  
			    	 while ((byteread = uploadedStream.read(tempbytes)) != -1){  
			    		 fos.write(tempbytes, 0, byteread);  
			    	 }  
			    	 
			    	 fos.flush();
			    	 
			    	 return storeFileName;
			    }			    
			}			
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new BusinessFailure("上传文件失败，上传文件大小不能超过2M");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			 try {
				 if (uploadedStream != null) {
					 uploadedStream.close();
				 }
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	 try {
	    		 if (fos != null) {
	    			 fos.close(); 
	    		 }
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		return null;
	}
	
	private static String getRealPath(HttpServletRequest request, String path) {
		String realPath = request.getSession().getServletContext().getRealPath(path);
		
		return realPath;
		
	}
	

	/**
	 * 
	 * @return
	 */
//	private static String getWebContextPath() {
//		String webContextPath = getHttpServletRequest().getContextPath();
//		return webContextPath;
//	}
	
	public static String getOrderPropertyImagePath(String fileName) {
		return storeDir + "/" + fileName;
	}


}
