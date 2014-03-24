package com.wildwolf.helper.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wildwolf.dataaccess.MyDaoTemplate;


/**
 * 分页对象
 * @author：欧健华 工号：itd043 分机号：3143
 * update 2012-12-30 17:29
 */
public class PageObject {
	
	//	private static final long pageSize = 20;
	private long pageSize = 20;
	
	private long realPageSize; //页面实际显示的记录数目

	private long pageAmount;

	private long rowAmount;

	private long currentPageNo;

	private long pageStartRowNo;

	private long pageEndRowNo;

	private long nextPageNo;

	private static final long pageIndexAmount = 5L;

	private ArrayList pageIndexList;

	private List objectList;

	private boolean previous;

	private boolean next;
	
	private Map criteriaMap;
	
	private String statement;
	
	private Page criteria;
	
	private List propertyObjectList;
	
	private MyDaoTemplate myDaoTemplate;
	
//	private PageDataAccess pageDataAccess;

	public MyDaoTemplate getMyDaoTemplate() {
		return myDaoTemplate;
	}

	public void setMyDaoTemplate(MyDaoTemplate myDaoTemplate) {
		this.myDaoTemplate = myDaoTemplate;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Page getCriteria() {
		return criteria;
	}

	public void setCriteria(Page criteria) {
		this.criteria = criteria;
	}

	/**
	 * This method is used in service implementation class if the service implementation class's scope is singleton, 
	 * In the Struts 2 Action, it may use pageObject injection.
	 * @param pageDataAccess
	 * @return
	 */
//	public static PageObject getNewInstance(PageDataAccess pageDataAccess) {
//		PageObject newPageObject = new PageObject();
//		newPageObject.setPageDataAccess(pageDataAccess);
//		return newPageObject;
//	}
	
	public PageObject() {
		currentPageNo = 1L;
	}

	public boolean isNext() {
		return next;
	}

	public boolean isPrevious() {
		return previous;
	}

	public boolean hasPrevious() {
		return pageAmount != 0L && currentPageNo != 1L;
	}

	public boolean hasNext() {
		return pageAmount != 0L && currentPageNo != pageAmount;
	}

	public void calculateRowNo(long pageNo) {
		if (pageNo < 1L)
			pageNo = 1L;
		pageEndRowNo = pageSize * pageNo;
		if (pageEndRowNo > rowAmount)
			pageEndRowNo = rowAmount;
		pageStartRowNo = pageSize * (pageNo - 1L) + 1L;
	}

	public long getPageEndRowNo() {
		return pageEndRowNo;
	}

	public long getPageStartRowNo() {
		return pageStartRowNo;
	}

	public List getObjectList() {
		return objectList;
	}

	public void setObjectList(List objectList) {
		this.objectList = objectList;
	}

	public long getCurrentPageNo() {
		if (currentPageNo < 1L)
			currentPageNo = 1L;
		return currentPageNo;
	}

	public void setCurrentPageNo(long currentPageNo) {
		if (currentPageNo < 1) {
			currentPageNo=1;
		}
		this.currentPageNo = currentPageNo;
	}

	public long getPageAmount() {
		return pageAmount;
	}

	public void setPageAmount(long pageAmount) {
		this.pageAmount = pageAmount;
	}

	public long getRowAmount() {
		return rowAmount;
	}

	public void populateRowAmount(long rowAmount) {
		this.rowAmount = rowAmount;
		pageAmount = (long) Math.ceil((double) rowAmount / pageSize);
	}

	public long getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(long nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public static long getPageIndexAmount() {
		return 5L;
	}

	public ArrayList getPageIndexList() {
		return pageIndexList;
	}

	public void populateIndexList() {
		long size = pageIndexAmount;
		if (getPageAmount() < pageIndexAmount)
			size = getPageAmount();
		long pageMaxIndex = (currentPageNo + pageIndexAmount) - 1;
		if ((currentPageNo + pageIndexAmount) - 1 > pageAmount)
			pageMaxIndex = pageAmount;
		pageIndexList = new ArrayList();
		for (int i = 0; (long) i < size; i++)
			pageIndexList.add(i, Long.valueOf((pageMaxIndex - (size - 1L))
					+ (long) i));

	}

	public void pageCalculate(long rowAmount, long pageNo) {
		populateRowAmount(rowAmount);
		setCurrentPageNo(pageNo);
		calculateRowNo(pageNo);
		populateIndexList();
		previous = hasPrevious();
		next = hasNext();
	}
	
	public void calculate(long rowAmount) {
		pageCalculate(rowAmount, this.currentPageNo);
	}

	public Map getCriteriaMap() {
		return criteriaMap;
	}

	public void setCriteriaMap(Map criteriaMap) {
		this.criteriaMap = criteriaMap;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

//	public PageDataAccess getPageDataAccess() {
//		return pageDataAccess;
//	}
//
//	public void setPageDataAccess(PageDataAccess pageDataAccess) {
//		this.pageDataAccess = pageDataAccess;
//	}

//	/**
//	 * 请使用#executePagination方法来代替此方法.
//	 * 执行分页查询.
//	 * @param selectStatement 分页查询sql语句
//	 * @param criteriaMap 查询条件
//	 * @deprecated
//	 */
//	public void execute(String selectStatement, Map criteriaMap) {
//		rowAmount = pageDataAccess.queryForRowAmount(selectStatement,criteriaMap);
//		pageCalculate(rowAmount, this.currentPageNo);
//		Map rownumMap = new HashMap();
//		rownumMap.put("pageEndRowNo", Long.valueOf(this.getPageEndRowNo()));
//		rownumMap.put("pageStartRowNo", Long.valueOf(this.getPageStartRowNo()));		
//		objectList = pageDataAccess.queryForObjectList(selectStatement, criteriaMap, rownumMap);
//	}
//	
//	/**
//	 * 执行分页查询
//	 * @param statement 分页查询语句
//	 * @param criteria  查询条件，可以是Map，也可以是任何查询条件对象
//	 *  @deprecated
//	 */
//	public void executePagination(String statement,Object criteria) {
//		rowAmount = pageDataAccess.queryForRowAmount(statement,criteria);
//		pageCalculate(rowAmount, this.currentPageNo);
//		Map rownumMap = new HashMap();
//		rownumMap.put("pageEndRowNo", Long.valueOf(this.getPageEndRowNo()));
//		rownumMap.put("pageStartRowNo", Long.valueOf(this.getPageStartRowNo()));		
//		objectList = pageDataAccess.queryForObjectList(statement, criteria, rownumMap);
//	}
	
	/**
	 * 执行分页查询
	 * @param statement 查询语句
	 * @param criteria  查询条件，必须继承Page 
	 */
	public void executePagination(String countStatement,String objectStatement,Page criteria) {
//		rowAmount = pageDataAccess.queryForRowAmount(statement,criteria);		
//		pageCalculate(rowAmount, this.currentPageNo);
//		Map rownumMap = new HashMap();
//		rownumMap.put("pageEndRowNo", Long.valueOf(this.getPageEndRowNo()));
//		rownumMap.put("pageStartRowNo", Long.valueOf(this.getPageStartRowNo()));		
//		objectList = pageDataAccess.queryForObjectList(statement, criteria, rownumMap);
	
		criteria.setPage(true);
		rowAmount = (Long) myDaoTemplate.queryForObject(countStatement,criteria);
		pageCalculate(rowAmount, this.currentPageNo);
		criteria.setBeginRow(Long.valueOf(this.getPageStartRowNo()));
		criteria.setEndRow(Long.valueOf(this.getPageEndRowNo()));
		objectList = myDaoTemplate.queryForList(objectStatement, criteria);
	
	}

	public List getPropertyObjectList() {
		return propertyObjectList;
	}

	public void setPropertyObjectList(List propertyObjectList) {
		this.propertyObjectList = propertyObjectList;
	}
	
	public void calcRealPageSize(){
		if(currentPageNo<pageAmount){
			realPageSize = pageSize;
		}else{
			realPageSize = rowAmount-20*(pageAmount-1);
		}
	}

	/**
	 * @return the realPageSize
	 */
	public long getRealPageSize() {
		return realPageSize;
	}

	/**
	 * @param realPageSize the realPageSize to set
	 */
	public void setRealPageSize(long realPageSize) {
		this.realPageSize = realPageSize;
	}	

//	public List next(long currentPageNo) {
//		this.currentPageNo = currentPageNo;
//		executePagination(statement,criteria);
//		return getObjectList();
//	}
	
//	public boolean next() {
//		if (pageAmount == 0) {
//			executePagination(statement,criteria);
//			if (currentPageNo <= pageAmount) {
//				currentPageNo++;
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
		
		
//		if (currentPageNo <= pageAmount) {
//			executePagination(statement,criteria);
//			currentPageNo++;
//			return true;
//		}
//		else {
//			return false;
//		}		
//	}
	
	public void setSearchCriteriaAndSize(String statement,Page criteria, long pageSize) {
		this.statement = statement;
		this.criteria = criteria;
		this.pageSize = pageSize;
	}

	
}