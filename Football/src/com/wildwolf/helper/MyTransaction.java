package com.wildwolf.helper;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author ÍõÑÞÏ¼
 * 2011-8-17 ÏÂÎç08:58:09
 */
public class MyTransaction {	
	
	/**
	 * start transaction
	 * @throws BusinessFailure
	 */
	public static void startTransaction() throws BusinessFailure {
		//get or generate database connection
		Connection conn = MyConnection.getThreadLocalConnection();
		
		if (conn == null) {
			throw new BusinessFailure("Can not get database connection!");
		}
		
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new BusinessFailure(e.getMessage());
		}
	}
	
	/**
	 * start read only  transaction
	 * @throws BusinessFailure
	 */
	public static void startReadOnlyTransaction() throws BusinessFailure {
		//get or generate database connection
		Connection conn = MyConnection.getThreadLocalConnection();
		
		if (conn == null) {
			throw new BusinessFailure("Can not get database connection!");
		}

	}
	
	/**
	 * end read only transaction
	 * @throws BusinessFailure
	 */
	public static void endReadOnlyTransaction() throws BusinessFailure {
		Connection conn = MyConnection.getThreadLocalConnection();

		try {
			conn.close();
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new BusinessFailure(e.getMessage());
		}
	}
	
	/**
	 * commit transaction
	 * @throws BusinessFailure
	 */
	public static void commitTransaction() throws BusinessFailure {
		Connection conn = MyConnection.getThreadLocalConnection();
		try {			
			conn.commit();
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new BusinessFailure(e.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new BusinessFailure(e.getMessage());
		}
	}
	
	/**
	 * rollback transaction
	 * @throws BusinessFailure
	 */
	public static void rollbackTransaction() throws BusinessFailure {
		Connection conn = MyConnection.getThreadLocalConnection();
		try {
			conn.rollback();
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new BusinessFailure(e.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new BusinessFailure(e.getMessage());
		}
		
	}

}
