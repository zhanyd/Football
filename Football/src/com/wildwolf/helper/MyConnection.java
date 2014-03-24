package com.wildwolf.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

/**
 * 
 * @author ����ϼ
 * 2011-8-17 ����09:27:01
 */
public class MyConnection {

	private static ThreadLocal<Connection> currentThreadConn = new ThreadLocal<Connection>() {
		protected Connection initialValue() {
			try {
				//mysql
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/football", "root", "root");
				
				//sql server
//				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
//				   "databaseName=training;user=sa;password=sa123456;";
//				Connection conn = DriverManager.getConnection(connectionUrl);
				
				return conn;
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
			return null;
		}
	};
	
	/**
	 * get database connection
	 * @return Connections
	 */
	public static Connection getThreadLocalConnection() {
		return currentThreadConn.get();
	}
	
	 /**
     * Creates a <code>PreparedStatement</code> object that will generate
     * <code>ResultSet</code> objects with the given type, concurrency,
     * and holdability.
     * <P>
     * This method is the same as the <code>prepareStatement</code> method
     * above, but it allows the default result set
     * type, concurrency, and holdability to be overridden.
     *
     * @param sql a <code>String</code> object that is the SQL statement to
     *            be sent to the database; may contain one or more '?' IN
     *            parameters
     * @param resultSetType one of the following <code>ResultSet</code>
     *        constants:
     *         <code>ResultSet.TYPE_FORWARD_ONLY</code>,
     *         <code>ResultSet.TYPE_SCROLL_INSENSITIVE</code>, or
     *         <code>ResultSet.TYPE_SCROLL_SENSITIVE</code>
     * @param resultSetConcurrency one of the following <code>ResultSet</code>
     *        constants:
     *         <code>ResultSet.CONCUR_READ_ONLY</code> or
     *         <code>ResultSet.CONCUR_UPDATABLE</code>
     * @param resultSetHoldability one of the following <code>ResultSet</code>
     *        constants:
     *         <code>ResultSet.HOLD_CURSORS_OVER_COMMIT</code> or
     *         <code>ResultSet.CLOSE_CURSORS_AT_COMMIT</code>
     * @return a new <code>PreparedStatement</code> object, containing the
     *         pre-compiled SQL statement, that will generate
     *         <code>ResultSet</code> objects with the given type,
     *         concurrency, and holdability
     * @exception SQLException if a database access error occurs, this
     * method is called on a closed connection
     *            or the given parameters are not <code>ResultSet</code>
     *            constants indicating type, concurrency, and holdability
      * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
     * this method or this method is not supported for the specified result
     * set type, result set holdability and result set concurrency.
     * @see ResultSet
     * @since 1.4
     */
    public static PreparedStatement prepareStatement(String sql, int resultSetType,
                                       int resultSetConcurrency, int resultSetHoldability)
        throws SQLException {
    	Connection con = getThreadLocalConnection();
    	return con.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }
    
    /**
     * Creates a <code>PreparedStatement</code> object for sending
     * parameterized SQL statements to the database.
     * <P>
     * A SQL statement with or without IN parameters can be
     * pre-compiled and stored in a <code>PreparedStatement</code> object. This
     * object can then be used to efficiently execute this statement
     * multiple times.
     *
     * <P><B>Note:</B> This method is optimized for handling
     * parametric SQL statements that benefit from precompilation. If
     * the driver supports precompilation,
     * the method <code>prepareStatement</code> will send
     * the statement to the database for precompilation. Some drivers
     * may not support precompilation. In this case, the statement may
     * not be sent to the database until the <code>PreparedStatement</code>
     * object is executed.  This has no direct effect on users; however, it does
     * affect which methods throw certain <code>SQLException</code> objects.
     * <P>
     * Result sets created using the returned <code>PreparedStatement</code>
     * object will by default be type <code>TYPE_FORWARD_ONLY</code>
     * and have a concurrency level of <code>CONCUR_READ_ONLY</code>.
     * The holdability of the created result sets can be determined by
     * calling {@link #getHoldability}.
     *
     * @param sql an SQL statement that may contain one or more '?' IN
     * parameter placeholders
     * @return a new default <code>PreparedStatement</code> object containing the
     * pre-compiled SQL statement
     * @exception SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public static PreparedStatement prepareStatement(String sql)
        throws SQLException {
    	Connection con = getThreadLocalConnection();
    	return con.prepareStatement(sql);
    }
    
    /**
     * Creates a default <code>PreparedStatement</code> object that has
     * the capability to retrieve auto-generated keys. The given constant
     * tells the driver whether it should make auto-generated keys
     * available for retrieval.  This parameter is ignored if the SQL statement
     * is not an <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     * <P>
     * <B>Note:</B> This method is optimized for handling
     * parametric SQL statements that benefit from precompilation. If
     * the driver supports precompilation,
     * the method <code>prepareStatement</code> will send
     * the statement to the database for precompilation. Some drivers
     * may not support precompilation. In this case, the statement may
     * not be sent to the database until the <code>PreparedStatement</code>
     * object is executed.  This has no direct effect on users; however, it does
     * affect which methods throw certain SQLExceptions.
     * <P>
     * Result sets created using the returned <code>PreparedStatement</code>
     * object will by default be type <code>TYPE_FORWARD_ONLY</code>
     * and have a concurrency level of <code>CONCUR_READ_ONLY</code>.
     * The holdability of the created result sets can be determined by
     * calling {@link #getHoldability}.
     *
     * @param sql an SQL statement that may contain one or more '?' IN
     *        parameter placeholders
     * @param autoGeneratedKeys a flag indicating whether auto-generated keys
     *        should be returned; one of
     *        <code>Statement.RETURN_GENERATED_KEYS</code> or
     *        <code>Statement.NO_GENERATED_KEYS</code>
     * @return a new <code>PreparedStatement</code> object, containing the
     *         pre-compiled SQL statement, that will have the capability of
     *         returning auto-generated keys
     * @exception SQLException if a database access error occurs, this
     *  method is called on a closed connection
     *         or the given parameter is not a <code>Statement</code>
     *         constant indicating whether auto-generated keys should be
     *         returned
     * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
     * this method with a constant of Statement.RETURN_GENERATED_KEYS
     * @since 1.4
     */
    public static PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
        throws SQLException {
    	Connection con = getThreadLocalConnection();
    	return con.prepareStatement(sql,autoGeneratedKeys);
    }
    
    /**
    *
    * Creates a <code>PreparedStatement</code> object that will generate
    * <code>ResultSet</code> objects with the given type and concurrency.
    * This method is the same as the <code>prepareStatement</code> method
    * above, but it allows the default result set
    * type and concurrency to be overridden.
    * The holdability of the created result sets can be determined by
    * calling {@link #getHoldability}.
    *
    * @param sql a <code>String</code> object that is the SQL statement to
    *            be sent to the database; may contain one or more '?' IN
    *            parameters
    * @param resultSetType a result set type; one of
    *         <code>ResultSet.TYPE_FORWARD_ONLY</code>,
    *         <code>ResultSet.TYPE_SCROLL_INSENSITIVE</code>, or
    *         <code>ResultSet.TYPE_SCROLL_SENSITIVE</code>
    * @param resultSetConcurrency a concurrency type; one of
    *         <code>ResultSet.CONCUR_READ_ONLY</code> or
    *         <code>ResultSet.CONCUR_UPDATABLE</code>
    * @return a new PreparedStatement object containing the
    * pre-compiled SQL statement that will produce <code>ResultSet</code>
    * objects with the given type and concurrency
    * @exception SQLException if a database access error occurs, this
    * method is called on a closed connection
    *         or the given parameters are not <code>ResultSet</code>
    *         constants indicating type and concurrency
    * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
    * this method or this method is not supported for the specified result
    * set type and result set concurrency.
    * @since 1.2
    */
   public static PreparedStatement prepareStatement(String sql, int resultSetType,
                                      int resultSetConcurrency)
       throws SQLException {
	   Connection con = getThreadLocalConnection();
	   return con.prepareStatement(sql, resultSetType, resultSetConcurrency);
   }
   
   /**
    * Creates a default <code>PreparedStatement</code> object capable
    * of returning the auto-generated keys designated by the given array.
    * This array contains the indexes of the columns in the target
    * table that contain the auto-generated keys that should be made
    * available.  The driver will ignore the array if the SQL statement
    * is not an <code>INSERT</code> statement, or an SQL statement able to return
    * auto-generated keys (the list of such statements is vendor-specific).
    *<p>
    * An SQL statement with or without IN parameters can be
    * pre-compiled and stored in a <code>PreparedStatement</code> object. This
    * object can then be used to efficiently execute this statement
    * multiple times.
    * <P>
    * <B>Note:</B> This method is optimized for handling
    * parametric SQL statements that benefit from precompilation. If
    * the driver supports precompilation,
    * the method <code>prepareStatement</code> will send
    * the statement to the database for precompilation. Some drivers
    * may not support precompilation. In this case, the statement may
    * not be sent to the database until the <code>PreparedStatement</code>
    * object is executed.  This has no direct effect on users; however, it does
    * affect which methods throw certain SQLExceptions.
    * <P>
    * Result sets created using the returned <code>PreparedStatement</code>
    * object will by default be type <code>TYPE_FORWARD_ONLY</code>
    * and have a concurrency level of <code>CONCUR_READ_ONLY</code>.
    * The holdability of the created result sets can be determined by
    * calling {@link #getHoldability}.
    *
    * @param sql an SQL statement that may contain one or more '?' IN
    *        parameter placeholders
    * @param columnIndexes an array of column indexes indicating the columns
    *        that should be returned from the inserted row or rows
    * @return a new <code>PreparedStatement</code> object, containing the
    *         pre-compiled statement, that is capable of returning the
    *         auto-generated keys designated by the given array of column
    *         indexes
    * @exception SQLException if a database access error occurs
    * or this method is called on a closed connection
    * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
    * this method
    *
    * @since 1.4
    */
   public static PreparedStatement prepareStatement(String sql, int columnIndexes[])
       throws SQLException {
	   Connection con = getThreadLocalConnection();
	   return con.prepareStatement(sql, columnIndexes);
   }
   
   /**
    * Creates a default <code>PreparedStatement</code> object capable
    * of returning the auto-generated keys designated by the given array.
    * This array contains the names of the columns in the target
    * table that contain the auto-generated keys that should be returned.
    * The driver will ignore the array if the SQL statement
    * is not an <code>INSERT</code> statement, or an SQL statement able to return
    * auto-generated keys (the list of such statements is vendor-specific).
    * <P>
    * An SQL statement with or without IN parameters can be
    * pre-compiled and stored in a <code>PreparedStatement</code> object. This
    * object can then be used to efficiently execute this statement
    * multiple times.
    * <P>
    * <B>Note:</B> This method is optimized for handling
    * parametric SQL statements that benefit from precompilation. If
    * the driver supports precompilation,
    * the method <code>prepareStatement</code> will send
    * the statement to the database for precompilation. Some drivers
    * may not support precompilation. In this case, the statement may
    * not be sent to the database until the <code>PreparedStatement</code>
    * object is executed.  This has no direct effect on users; however, it does
    * affect which methods throw certain SQLExceptions.
    * <P>
    * Result sets created using the returned <code>PreparedStatement</code>
    * object will by default be type <code>TYPE_FORWARD_ONLY</code>
    * and have a concurrency level of <code>CONCUR_READ_ONLY</code>.
    * The holdability of the created result sets can be determined by
    * calling {@link #getHoldability}.
    *
    * @param sql an SQL statement that may contain one or more '?' IN
    *        parameter placeholders
    * @param columnNames an array of column names indicating the columns
    *        that should be returned from the inserted row or rows
    * @return a new <code>PreparedStatement</code> object, containing the
    *         pre-compiled statement, that is capable of returning the
    *         auto-generated keys designated by the given array of column
    *         names
    * @exception SQLException if a database access error occurs
    * or this method is called on a closed connection
    * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
    * this method
    *
    * @since 1.4
    */
   public static PreparedStatement prepareStatement(String sql, String columnNames[])
       throws SQLException {
	   Connection con = getThreadLocalConnection();
	   return con.prepareStatement(sql, columnNames);
   }

}
