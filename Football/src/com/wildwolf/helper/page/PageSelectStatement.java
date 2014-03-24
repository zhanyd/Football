package com.wildwolf.helper.page;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

import com.ibatis.common.io.ReaderInputStream;
import com.ibatis.common.jdbc.exception.NestedSQLException;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
import com.ibatis.sqlmap.engine.mapping.result.AutoResultMap;
import com.ibatis.sqlmap.engine.mapping.result.ResultMap;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.DefaultRowHandler;
import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
import com.ibatis.sqlmap.engine.mapping.statement.SelectStatement;
import com.ibatis.sqlmap.engine.mapping.statement.StatementType;
import com.ibatis.sqlmap.engine.scope.ErrorContext;
import com.ibatis.sqlmap.engine.scope.StatementScope;
import com.ibatis.sqlmap.engine.transaction.Transaction;
import com.ibatis.sqlmap.engine.transaction.TransactionException;
import com.ibatis.sqlmap.engine.type.DomTypeMarker;
import com.ibatis.sqlmap.engine.type.XmlTypeMarker;

public class PageSelectStatement {
	private static Log log = LogFactory.getLog(PageSelectStatement.class);

	protected SelectStatement selectStatement;

	public PageSelectStatement(SelectStatement selectStatement) {
		this.selectStatement = selectStatement;
	}

	public StatementType getStatementType() {
		return StatementType.UNKNOWN;
	}

	public int executeUpdate(StatementScope request, Transaction trans,
			Object parameterObject) throws SQLException {
		return selectStatement.executeUpdate(request, trans, parameterObject);
	}

	public Object executeQueryForObject(StatementScope request, Connection conn,
			Object parameterObject, AutoResultMap resultMap)
			throws SQLException {

		Object object = null;

		DefaultRowHandler rowHandler = new DefaultRowHandler();
		/** *********** for page ********************* */
		executeQueryForRowAmount(request, conn, parameterObject, resultMap,
				rowHandler, SqlExecutor.NO_SKIPPED_RESULTS,
				SqlExecutor.NO_MAXIMUM_RESULTS);
		/** ****************************************** */

		List list = rowHandler.getList();

		if (list.size() > 1) {
			throw new SQLException(
					"Error: executeQueryForObject returned too many results.");
		} else if (list.size() > 0) {
			object = list.get(0);
		}

		return object;

	}

	public List executeQueryForList(StatementScope request, Connection conn,
			Object parameterObject, int skipResults, int maxResults,
			Map rownumMap) throws SQLException {

		DefaultRowHandler rowHandler = new DefaultRowHandler();

		executeQueryForObjectList(request, conn, parameterObject, null,
				rowHandler, skipResults, maxResults, rownumMap);
		/** ********************************************** */
		// executeQueryForObjectList(request, trans.getConnection(),
		// parameterObject, null, rowHandler, skipResults, maxResults,
		// rownumMap);
		return rowHandler.getList();

	}

	public void executeQueryWithRowHandler(StatementScope request,
			Transaction trans, Object parameterObject, RowHandler rowHandler)
			throws SQLException {
		try {
			executeQueryWithCallback(request, trans.getConnection(),
					parameterObject, null, rowHandler,
					SqlExecutor.NO_SKIPPED_RESULTS,
					SqlExecutor.NO_MAXIMUM_RESULTS);
		} catch (TransactionException e) {
			throw new NestedSQLException(
					"Error getting Connection from Transaction.  Cause: " + e,
					e);
		}
	}

	//
	// PROTECTED METHODS
	//

	protected void executeQueryForRowAmount(StatementScope request,
			Connection conn, Object parameterObject, AutoResultMap resultMap,
			RowHandler rowHandler, int skipResults, int maxResults)
			throws SQLException {
		ErrorContext errorContext = request.getErrorContext();
		errorContext
				.setActivity("preparing the mapped statement for execution");
		errorContext.setObjectId(selectStatement.getId());
		errorContext.setResource(selectStatement.getResource());

		try {
			parameterObject = validateParameter(parameterObject);

			Sql sql = selectStatement.getSql();

			errorContext.setMoreInfo("Check the parameter map.");
			ParameterMap parameterMap = sql.getParameterMap(request,
					parameterObject);

			errorContext.setMoreInfo("Check the result map.");
			// ResultMap resultMap = sql.getResultMap(request, parameterObject);

			request.setResultMap(resultMap);
			request.setParameterMap(parameterMap);

			errorContext.setMoreInfo("Check the parameter map.");
			Object[] parameters = parameterMap.getParameterObjectValues(
					request, parameterObject);

			errorContext.setMoreInfo("Check the SQL statement.");
			String sqlString = sql.getSql(request, parameterObject);

			/** ************ for page ********************** */
			String preAppend = "select count(*) from (";
			String postAppend = ")";
			String newSql = new StringBuffer().append(preAppend).append(
					sqlString).append(postAppend).toString();
			sqlString = newSql;
			log.debug(sqlString);
			/** **************************************** */

			errorContext.setActivity("executing mapped statement");
			errorContext
					.setMoreInfo("Check the SQL statement or the result map.");
			RowHandlerCallback callback = new RowHandlerCallback(resultMap,
					null, rowHandler);
			sqlExecuteQuery(request, conn, sqlString, parameters, skipResults,
					maxResults, callback);

			errorContext.setMoreInfo("Check the output parameters.");
			if (parameterObject != null) {
				postProcessParameterObject(request, parameterObject, parameters);
			}

			errorContext.reset();
			sql.cleanup(request);
			selectStatement.notifyListeners();
		} catch (SQLException e) {
			errorContext.setCause(e);
			throw new NestedSQLException(errorContext.toString(), e
					.getSQLState(), e.getErrorCode(), e);
		} catch (Exception e) {
			errorContext.setCause(e);
			throw new NestedSQLException(errorContext.toString(), e);
		}
	}

	protected void executeQueryForObjectList(StatementScope request,
			Connection conn, Object parameterObject, Object resultObject,
			RowHandler rowHandler, int skipResults, int maxResults,
			Map rownumMap) throws SQLException {
		ErrorContext errorContext = request.getErrorContext();
		errorContext
				.setActivity("preparing the mapped statement for execution");
		errorContext.setObjectId(selectStatement.getId());
		errorContext.setResource(selectStatement.getResource());

		try {
			parameterObject = validateParameter(parameterObject);

			Sql sql = selectStatement.getSql();

			errorContext.setMoreInfo("Check the parameter map.");
			ParameterMap parameterMap = sql.getParameterMap(request,
					parameterObject);

			errorContext.setMoreInfo("Check the result map.");
			ResultMap resultMap = sql.getResultMap(request, parameterObject);

			request.setResultMap(resultMap);
			request.setParameterMap(parameterMap);

			errorContext.setMoreInfo("Check the parameter map.");
			Object[] parameters = parameterMap.getParameterObjectValues(
					request, parameterObject);

			errorContext.setMoreInfo("Check the SQL statement.");
			String sqlString = sql.getSql(request, parameterObject);

			/** ************ for page ********************** */
			String pageStartRowNo = String.valueOf(rownumMap
					.get("pageStartRowNo"));
			String pageEndRowNo = String.valueOf(rownumMap.get("pageEndRowNo"));

			// String pageStartNumber = (String)
			// rownumMap.get("pageStartNumber");
			// String pageEndNumber = (String) rownumMap.get("pageEndNumber");
			String oldSql = sqlString;
			String preParenthesis = "(";
			String postParenthesis = ")";
			String t1 = new StringBuffer().append("t1_").append(
					String.valueOf(System.currentTimeMillis())).toString();
			String t2 = new StringBuffer().append("t2_").append(
					String.valueOf(System.currentTimeMillis())).toString();

			StringBuffer part2 = new StringBuffer().append(preParenthesis)
					.append(oldSql).append(postParenthesis).append(" ").append(
							t1);
			StringBuffer part1 = new StringBuffer().append("select rownumx,")
					.append(t2).append(".* from ").append(
							"(select rownum rownumx,").append(t1).append(
							".* from ");
			StringBuffer part3 = new StringBuffer().append(
					" where rownum<=" + pageEndRowNo + ") ").append(t2).append(
					" where rownumx>=" + pageStartRowNo);

			// String newSql = new
			// StringBuffer().append(part1).append(part2).append(part3).toString();
			sqlString = new StringBuffer().append(part1).append(part2).append(
					part3).toString();
			log.debug(sqlString);
			/** **************************************** */

			errorContext.setActivity("executing mapped statement");
			errorContext
					.setMoreInfo("Check the SQL statement or the result map.");
			RowHandlerCallback callback = new RowHandlerCallback(resultMap,
					resultObject, rowHandler);
			sqlExecuteQuery(request, conn, sqlString, parameters, skipResults,
					maxResults, callback);

			errorContext.setMoreInfo("Check the output parameters.");
			if (parameterObject != null) {
				postProcessParameterObject(request, parameterObject, parameters);
			}

			errorContext.reset();
			sql.cleanup(request);
			selectStatement.notifyListeners();
		} catch (SQLException e) {
			errorContext.setCause(e);
			throw new NestedSQLException(errorContext.toString(), e
					.getSQLState(), e.getErrorCode(), e);
		} catch (Exception e) {
			errorContext.setCause(e);
			throw new NestedSQLException(errorContext.toString(), e);
		}
	}

	protected void executeQueryWithCallback(StatementScope request,
			Connection conn, Object parameterObject, Object resultObject,
			RowHandler rowHandler, int skipResults, int maxResults)
			throws SQLException {
		ErrorContext errorContext = request.getErrorContext();
		errorContext
				.setActivity("preparing the mapped statement for execution");
		errorContext.setObjectId(selectStatement.getId());
		errorContext.setResource(selectStatement.getResource());

		try {
			parameterObject = validateParameter(parameterObject);

			Sql sql = selectStatement.getSql();

			errorContext.setMoreInfo("Check the parameter map.");
			ParameterMap parameterMap = sql.getParameterMap(request,
					parameterObject);

			errorContext.setMoreInfo("Check the result map.");
			ResultMap resultMap = sql.getResultMap(request, parameterObject);

			request.setResultMap(resultMap);
			request.setParameterMap(parameterMap);

			errorContext.setMoreInfo("Check the parameter map.");
			Object[] parameters = parameterMap.getParameterObjectValues(
					request, parameterObject);

			errorContext.setMoreInfo("Check the SQL statement.");
			String sqlString = sql.getSql(request, parameterObject);

			/** ************ for page ********************** */
			String preAppend = "select count(*) from (";
			String postAppend = ")";
			String newSql = new StringBuffer().append(preAppend).append(
					sqlString).append(postAppend).toString();
			sqlString = newSql;
			log.debug(sqlString);
			/** **************************************** */

			errorContext.setActivity("executing mapped statement");
			errorContext
					.setMoreInfo("Check the SQL statement or the result map.");
			RowHandlerCallback callback = new RowHandlerCallback(resultMap,
					resultObject, rowHandler);
			sqlExecuteQuery(request, conn, sqlString, parameters, skipResults,
					maxResults, callback);

			errorContext.setMoreInfo("Check the output parameters.");
			if (parameterObject != null) {
				postProcessParameterObject(request, parameterObject, parameters);
			}

			errorContext.reset();
			sql.cleanup(request);
			selectStatement.notifyListeners();
		} catch (SQLException e) {
			errorContext.setCause(e);
			throw new NestedSQLException(errorContext.toString(), e
					.getSQLState(), e.getErrorCode(), e);
		} catch (Exception e) {
			errorContext.setCause(e);
			throw new NestedSQLException(errorContext.toString(), e);
		}
	}

	protected void postProcessParameterObject(StatementScope request,
			Object parameterObject, Object[] parameters) {
	}

	protected int sqlExecuteUpdate(StatementScope request, Connection conn,
			String sqlString, Object[] parameters) throws SQLException {
		if (request.getSession().isInBatch()) {
			selectStatement.getSqlExecutor().addBatch(request, conn, sqlString,
					parameters);
			return 0;
		} else {
			return selectStatement.getSqlExecutor().executeUpdate(request,
					conn, sqlString, parameters);
		}
	}

	protected void sqlExecuteQuery(StatementScope request, Connection conn,
			String sqlString, Object[] parameters, int skipResults,
			int maxResults, RowHandlerCallback callback) throws SQLException {
		selectStatement.getSqlExecutor().executeQuery(request, conn, sqlString,
				parameters, skipResults, maxResults, callback);
	}

	protected Object validateParameter(Object param) throws SQLException {
		Object newParam = param;
		Class parameterClass = selectStatement.getParameterClass();
		if (newParam != null && parameterClass != null) {
			if (DomTypeMarker.class.isAssignableFrom(parameterClass)) {
				if (XmlTypeMarker.class.isAssignableFrom(parameterClass)) {
					if (!(newParam instanceof String)
							&& !(newParam instanceof Document)) {
						throw new SQLException(
								"Invalid parameter object type.  Expected '"
										+ String.class.getName() + "' or '"
										+ Document.class.getName()
										+ "' but found '"
										+ newParam.getClass().getName() + "'.");
					}
					if (!(newParam instanceof Document)) {
						newParam = stringToDocument((String) newParam);
					}
				} else {
					if (!Document.class.isAssignableFrom(newParam.getClass())) {
						throw new SQLException(
								"Invalid parameter object type.  Expected '"
										+ Document.class.getName()
										+ "' but found '"
										+ newParam.getClass().getName() + "'.");
					}
				}
			} else {
				if (!parameterClass.isAssignableFrom(newParam.getClass())) {
					throw new SQLException(
							"Invalid parameter object type.  Expected '"
									+ parameterClass.getName()
									+ "' but found '"
									+ newParam.getClass().getName() + "'.");
				}
			}
		}
		return newParam;
	}

	private Document stringToDocument(String s) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			return documentBuilder.parse(new ReaderInputStream(
					new StringReader(s)));
		} catch (Exception e) {
			throw new RuntimeException("Error occurred.  Cause: " + e, e);
		}
	}
}
