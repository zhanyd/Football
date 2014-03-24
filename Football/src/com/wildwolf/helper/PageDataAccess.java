package com.wildwolf.helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

/**
 * 用于分页时的数据访问
 * 
 * author 欧健华
 */
public interface PageDataAccess {

	/**
	 * 获取当前分页所需的记录list
	 * @param id SQL语句名称，该名称必须是唯一的
	 * @param parameterObject 查询条件
	 * @return 当前分页所需的记录集合
	 */
	public List queryForObjectList(String id, Object parameterObject, Map rownumMap) throws DataAccessException ;
	
	/**
	 * 获取查询记录总数
	 * @param id SQL语句名称，该名称必须是唯一的
	 * @param parameterObject 查询条件
	 * @return 查询记录总数
	 */
	public Long queryForRowAmount(String id, Object parameterObject) throws DataAccessException ;
}
