package com.wildwolf.model;

import java.util.Date;

public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLE.ID
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    private String ID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLE.ROLENAME
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    private String ROLENAME;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLE.RIGHTS
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    private String RIGHTS;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLE.CREATETIME
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    private Date CREATETIME;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLE.UPDATETIME
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    private Date UPDATETIME;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLE.ID
     *
     * @return the value of ROLE.ID
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public String getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLE.ID
     *
     * @param ID the value for ROLE.ID
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLE.ROLENAME
     *
     * @return the value of ROLE.ROLENAME
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public String getROLENAME() {
        return ROLENAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLE.ROLENAME
     *
     * @param ROLENAME the value for ROLE.ROLENAME
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public void setROLENAME(String ROLENAME) {
        this.ROLENAME = ROLENAME == null ? null : ROLENAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLE.RIGHTS
     *
     * @return the value of ROLE.RIGHTS
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public String getRIGHTS() {
        return RIGHTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLE.RIGHTS
     *
     * @param RIGHTS the value for ROLE.RIGHTS
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public void setRIGHTS(String RIGHTS) {
        this.RIGHTS = RIGHTS == null ? null : RIGHTS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLE.CREATETIME
     *
     * @return the value of ROLE.CREATETIME
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public Date getCREATETIME() {
        return CREATETIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLE.CREATETIME
     *
     * @param CREATETIME the value for ROLE.CREATETIME
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLE.UPDATETIME
     *
     * @return the value of ROLE.UPDATETIME
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public Date getUPDATETIME() {
        return UPDATETIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLE.UPDATETIME
     *
     * @param UPDATETIME the value for ROLE.UPDATETIME
     *
     * @mbggenerated Wed Jan 16 15:56:39 CST 2013
     */
    public void setUPDATETIME(Date UPDATETIME) {
        this.UPDATETIME = UPDATETIME;
    }
}