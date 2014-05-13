package com.wildwolf.dataaccess;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;


/**
 * @author oujianhua
 *
 */


public class MyDaoTemplate extends SqlMapClientDaoSupport {	
	
	public Object queryForObject(String statementName) {
		return getSqlMapClientTemplate().queryForObject(statementName);
	}
	
	public Object queryForObject(String statementName, Object parameterObject) {
		return getSqlMapClientTemplate().queryForObject(statementName, parameterObject);
	}
	
	public Object queryForObject(
			String statementName, Object parameterObject, Object resultObject) {
		return getSqlMapClientTemplate().queryForObject(statementName, parameterObject, resultObject);
	}
	
	public List queryForList(String statementName) {
		return getSqlMapClientTemplate().queryForList(statementName);
	}
	
	public List queryForList(String statementName, Object parameterObject) {
		return getSqlMapClientTemplate().queryForList(statementName, parameterObject);
	}
	
	public Object create(String statementName) {
		return getSqlMapClientTemplate().insert(statementName);
	}
	
	public Object create(String statementName, Object parameterObject) {
		return getSqlMapClientTemplate().insert(statementName, parameterObject);
	}
	
	public void createByBatch(final String statementName, final List parameterObjectList) {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
			executor.startBatch();
			
			if (parameterObjectList != null && parameterObjectList.size() > 0) {
				for (int i = 0; i < parameterObjectList.size(); i++) {
					executor.insert(statementName, parameterObjectList.get(i));
				}
			}		
			
			return executor.executeBatch();
			}
			});
	}
	
	public int update(String statementName) {
		return getSqlMapClientTemplate().update(statementName);
	}
	
	public int update(String statementName, Object parameterObject) {
		return getSqlMapClientTemplate().update(statementName, parameterObject);
	}
	
	public void update(String statementName, Object parameterObject, int requiredRowsAffected) {
		getSqlMapClientTemplate().update(statementName, parameterObject, requiredRowsAffected);
	}
	
	public void updateByBatch(final String statementName, final List parameterObjectList) {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
			executor.startBatch();
			
			if (parameterObjectList != null && parameterObjectList.size() > 0) {
				for (int i = 0; i < parameterObjectList.size(); i++) {
					executor.update(statementName, parameterObjectList.get(i));
				}
			}		
			
			return executor.executeBatch();
			}
			});
	}
	
	
	
	public int delete(String statementName) {
		return getSqlMapClientTemplate().delete(statementName);
	}
	
	public int delete(String statementName, Object parameterObject) {
		return getSqlMapClientTemplate().delete(statementName, parameterObject);
	}
	
	public void delete(String statementName, Object parameterObject, int requiredRowsAffected) {
		getSqlMapClientTemplate().delete(statementName, parameterObject, requiredRowsAffected);
	}
	
	public void deleteByBatch(final String statementName, final List parameterObjectList) {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
			executor.startBatch();
			
			if (parameterObjectList != null && parameterObjectList.size() > 0) {
				for (int i = 0; i < parameterObjectList.size(); i++) {
					executor.delete(statementName, parameterObjectList.get(i));
				}
			}		
			
			return executor.executeBatch();
			}
			});
	}
	

}
