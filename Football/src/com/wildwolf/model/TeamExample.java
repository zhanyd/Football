package com.wildwolf.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    protected List oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public TeamExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    protected TeamExample(TeamExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table team
     *
     * @mbggenerated Thu Jun 06 14:45:21 CST 2013
     */
    protected abstract static class GeneratedCriteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(String value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(String value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(String value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(String value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLike(String value) {
            addCriterion("ID like", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotLike(String value) {
            addCriterion("ID not like", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNull() {
            addCriterion("TeamName is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("TeamName is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("TeamName =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("TeamName <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("TeamName >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("TeamName >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("TeamName <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("TeamName <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("TeamName like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("TeamName not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List values) {
            addCriterion("TeamName in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List values) {
            addCriterion("TeamName not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("TeamName between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("TeamName not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andCaptainIDIsNull() {
            addCriterion("CaptainID is null");
            return (Criteria) this;
        }

        public Criteria andCaptainIDIsNotNull() {
            addCriterion("CaptainID is not null");
            return (Criteria) this;
        }

        public Criteria andCaptainIDEqualTo(String value) {
            addCriterion("CaptainID =", value, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDNotEqualTo(String value) {
            addCriterion("CaptainID <>", value, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDGreaterThan(String value) {
            addCriterion("CaptainID >", value, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDGreaterThanOrEqualTo(String value) {
            addCriterion("CaptainID >=", value, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDLessThan(String value) {
            addCriterion("CaptainID <", value, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDLessThanOrEqualTo(String value) {
            addCriterion("CaptainID <=", value, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDLike(String value) {
            addCriterion("CaptainID like", value, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDNotLike(String value) {
            addCriterion("CaptainID not like", value, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDIn(List values) {
            addCriterion("CaptainID in", values, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDNotIn(List values) {
            addCriterion("CaptainID not in", values, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDBetween(String value1, String value2) {
            addCriterion("CaptainID between", value1, value2, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainIDNotBetween(String value1, String value2) {
            addCriterion("CaptainID not between", value1, value2, "captainID");
            return (Criteria) this;
        }

        public Criteria andCaptainNameIsNull() {
            addCriterion("CaptainName is null");
            return (Criteria) this;
        }

        public Criteria andCaptainNameIsNotNull() {
            addCriterion("CaptainName is not null");
            return (Criteria) this;
        }

        public Criteria andCaptainNameEqualTo(String value) {
            addCriterion("CaptainName =", value, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameNotEqualTo(String value) {
            addCriterion("CaptainName <>", value, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameGreaterThan(String value) {
            addCriterion("CaptainName >", value, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameGreaterThanOrEqualTo(String value) {
            addCriterion("CaptainName >=", value, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameLessThan(String value) {
            addCriterion("CaptainName <", value, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameLessThanOrEqualTo(String value) {
            addCriterion("CaptainName <=", value, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameLike(String value) {
            addCriterion("CaptainName like", value, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameNotLike(String value) {
            addCriterion("CaptainName not like", value, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameIn(List values) {
            addCriterion("CaptainName in", values, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameNotIn(List values) {
            addCriterion("CaptainName not in", values, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameBetween(String value1, String value2) {
            addCriterion("CaptainName between", value1, value2, "captainName");
            return (Criteria) this;
        }

        public Criteria andCaptainNameNotBetween(String value1, String value2) {
            addCriterion("CaptainName not between", value1, value2, "captainName");
            return (Criteria) this;
        }

        public Criteria andWinsIsNull() {
            addCriterion("Wins is null");
            return (Criteria) this;
        }

        public Criteria andWinsIsNotNull() {
            addCriterion("Wins is not null");
            return (Criteria) this;
        }

        public Criteria andWinsEqualTo(Integer value) {
            addCriterion("Wins =", value, "wins");
            return (Criteria) this;
        }

        public Criteria andWinsNotEqualTo(Integer value) {
            addCriterion("Wins <>", value, "wins");
            return (Criteria) this;
        }

        public Criteria andWinsGreaterThan(Integer value) {
            addCriterion("Wins >", value, "wins");
            return (Criteria) this;
        }

        public Criteria andWinsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Wins >=", value, "wins");
            return (Criteria) this;
        }

        public Criteria andWinsLessThan(Integer value) {
            addCriterion("Wins <", value, "wins");
            return (Criteria) this;
        }

        public Criteria andWinsLessThanOrEqualTo(Integer value) {
            addCriterion("Wins <=", value, "wins");
            return (Criteria) this;
        }

        public Criteria andWinsIn(List values) {
            addCriterion("Wins in", values, "wins");
            return (Criteria) this;
        }

        public Criteria andWinsNotIn(List values) {
            addCriterion("Wins not in", values, "wins");
            return (Criteria) this;
        }

        public Criteria andWinsBetween(Integer value1, Integer value2) {
            addCriterion("Wins between", value1, value2, "wins");
            return (Criteria) this;
        }

        public Criteria andWinsNotBetween(Integer value1, Integer value2) {
            addCriterion("Wins not between", value1, value2, "wins");
            return (Criteria) this;
        }

        public Criteria andDrawIsNull() {
            addCriterion("Draw is null");
            return (Criteria) this;
        }

        public Criteria andDrawIsNotNull() {
            addCriterion("Draw is not null");
            return (Criteria) this;
        }

        public Criteria andDrawEqualTo(Integer value) {
            addCriterion("Draw =", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawNotEqualTo(Integer value) {
            addCriterion("Draw <>", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawGreaterThan(Integer value) {
            addCriterion("Draw >", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawGreaterThanOrEqualTo(Integer value) {
            addCriterion("Draw >=", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawLessThan(Integer value) {
            addCriterion("Draw <", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawLessThanOrEqualTo(Integer value) {
            addCriterion("Draw <=", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawIn(List values) {
            addCriterion("Draw in", values, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawNotIn(List values) {
            addCriterion("Draw not in", values, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawBetween(Integer value1, Integer value2) {
            addCriterion("Draw between", value1, value2, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawNotBetween(Integer value1, Integer value2) {
            addCriterion("Draw not between", value1, value2, "draw");
            return (Criteria) this;
        }

        public Criteria andLosingIsNull() {
            addCriterion("Losing is null");
            return (Criteria) this;
        }

        public Criteria andLosingIsNotNull() {
            addCriterion("Losing is not null");
            return (Criteria) this;
        }

        public Criteria andLosingEqualTo(Integer value) {
            addCriterion("Losing =", value, "losing");
            return (Criteria) this;
        }

        public Criteria andLosingNotEqualTo(Integer value) {
            addCriterion("Losing <>", value, "losing");
            return (Criteria) this;
        }

        public Criteria andLosingGreaterThan(Integer value) {
            addCriterion("Losing >", value, "losing");
            return (Criteria) this;
        }

        public Criteria andLosingGreaterThanOrEqualTo(Integer value) {
            addCriterion("Losing >=", value, "losing");
            return (Criteria) this;
        }

        public Criteria andLosingLessThan(Integer value) {
            addCriterion("Losing <", value, "losing");
            return (Criteria) this;
        }

        public Criteria andLosingLessThanOrEqualTo(Integer value) {
            addCriterion("Losing <=", value, "losing");
            return (Criteria) this;
        }

        public Criteria andLosingIn(List values) {
            addCriterion("Losing in", values, "losing");
            return (Criteria) this;
        }

        public Criteria andLosingNotIn(List values) {
            addCriterion("Losing not in", values, "losing");
            return (Criteria) this;
        }

        public Criteria andLosingBetween(Integer value1, Integer value2) {
            addCriterion("Losing between", value1, value2, "losing");
            return (Criteria) this;
        }

        public Criteria andLosingNotBetween(Integer value1, Integer value2) {
            addCriterion("Losing not between", value1, value2, "losing");
            return (Criteria) this;
        }

        public Criteria andGoalsIsNull() {
            addCriterion("Goals is null");
            return (Criteria) this;
        }

        public Criteria andGoalsIsNotNull() {
            addCriterion("Goals is not null");
            return (Criteria) this;
        }

        public Criteria andGoalsEqualTo(Integer value) {
            addCriterion("Goals =", value, "goals");
            return (Criteria) this;
        }

        public Criteria andGoalsNotEqualTo(Integer value) {
            addCriterion("Goals <>", value, "goals");
            return (Criteria) this;
        }

        public Criteria andGoalsGreaterThan(Integer value) {
            addCriterion("Goals >", value, "goals");
            return (Criteria) this;
        }

        public Criteria andGoalsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Goals >=", value, "goals");
            return (Criteria) this;
        }

        public Criteria andGoalsLessThan(Integer value) {
            addCriterion("Goals <", value, "goals");
            return (Criteria) this;
        }

        public Criteria andGoalsLessThanOrEqualTo(Integer value) {
            addCriterion("Goals <=", value, "goals");
            return (Criteria) this;
        }

        public Criteria andGoalsIn(List values) {
            addCriterion("Goals in", values, "goals");
            return (Criteria) this;
        }

        public Criteria andGoalsNotIn(List values) {
            addCriterion("Goals not in", values, "goals");
            return (Criteria) this;
        }

        public Criteria andGoalsBetween(Integer value1, Integer value2) {
            addCriterion("Goals between", value1, value2, "goals");
            return (Criteria) this;
        }

        public Criteria andGoalsNotBetween(Integer value1, Integer value2) {
            addCriterion("Goals not between", value1, value2, "goals");
            return (Criteria) this;
        }

        public Criteria andLostIsNull() {
            addCriterion("Lost is null");
            return (Criteria) this;
        }

        public Criteria andLostIsNotNull() {
            addCriterion("Lost is not null");
            return (Criteria) this;
        }

        public Criteria andLostEqualTo(Integer value) {
            addCriterion("Lost =", value, "lost");
            return (Criteria) this;
        }

        public Criteria andLostNotEqualTo(Integer value) {
            addCriterion("Lost <>", value, "lost");
            return (Criteria) this;
        }

        public Criteria andLostGreaterThan(Integer value) {
            addCriterion("Lost >", value, "lost");
            return (Criteria) this;
        }

        public Criteria andLostGreaterThanOrEqualTo(Integer value) {
            addCriterion("Lost >=", value, "lost");
            return (Criteria) this;
        }

        public Criteria andLostLessThan(Integer value) {
            addCriterion("Lost <", value, "lost");
            return (Criteria) this;
        }

        public Criteria andLostLessThanOrEqualTo(Integer value) {
            addCriterion("Lost <=", value, "lost");
            return (Criteria) this;
        }

        public Criteria andLostIn(List values) {
            addCriterion("Lost in", values, "lost");
            return (Criteria) this;
        }

        public Criteria andLostNotIn(List values) {
            addCriterion("Lost not in", values, "lost");
            return (Criteria) this;
        }

        public Criteria andLostBetween(Integer value1, Integer value2) {
            addCriterion("Lost between", value1, value2, "lost");
            return (Criteria) this;
        }

        public Criteria andLostNotBetween(Integer value1, Integer value2) {
            addCriterion("Lost not between", value1, value2, "lost");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("Balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("Balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("Balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("Balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("Balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("Balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List values) {
            addCriterion("Balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List values) {
            addCriterion("Balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List values) {
            addCriterion("CreateTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List values) {
            addCriterion("CreateTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List values) {
            addCriterion("UpdateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List values) {
            addCriterion("UpdateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table team
     *
     * @mbggenerated do_not_delete_during_merge Thu Jun 06 14:45:21 CST 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}