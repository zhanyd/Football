package com.wildwolf.model;

import java.math.BigDecimal;
import java.util.Date;

import com.wildwolf.helper.page.Page;

public class Userrecords extends Page{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrecords.ID
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    private String ID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrecords.UserID
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    private String userID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrecords.Goals
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    private Integer goals;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrecords.Assist
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    private Integer assist;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrecords.PlayTimes
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    private Integer playTimes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrecords.Balance
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    private BigDecimal balance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrecords.CreateTime
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrecords.UpdateTime
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrecords.ID
     *
     * @return the value of userrecords.ID
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public String getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrecords.ID
     *
     * @param ID the value for userrecords.ID
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrecords.UserID
     *
     * @return the value of userrecords.UserID
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public String getUserID() {
        return userID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrecords.UserID
     *
     * @param userID the value for userrecords.UserID
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public void setUserID(String userID) {
        this.userID = userID == null ? null : userID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrecords.Goals
     *
     * @return the value of userrecords.Goals
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public Integer getGoals() {
        return goals;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrecords.Goals
     *
     * @param goals the value for userrecords.Goals
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrecords.Assist
     *
     * @return the value of userrecords.Assist
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public Integer getAssist() {
        return assist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrecords.Assist
     *
     * @param assist the value for userrecords.Assist
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public void setAssist(Integer assist) {
        this.assist = assist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrecords.PlayTimes
     *
     * @return the value of userrecords.PlayTimes
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public Integer getPlayTimes() {
        return playTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrecords.PlayTimes
     *
     * @param playTimes the value for userrecords.PlayTimes
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public void setPlayTimes(Integer playTimes) {
        this.playTimes = playTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrecords.Balance
     *
     * @return the value of userrecords.Balance
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrecords.Balance
     *
     * @param balance the value for userrecords.Balance
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrecords.CreateTime
     *
     * @return the value of userrecords.CreateTime
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrecords.CreateTime
     *
     * @param createTime the value for userrecords.CreateTime
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrecords.UpdateTime
     *
     * @return the value of userrecords.UpdateTime
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrecords.UpdateTime
     *
     * @param updateTime the value for userrecords.UpdateTime
     *
     * @mbggenerated Sun May 26 12:24:36 CST 2013
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}