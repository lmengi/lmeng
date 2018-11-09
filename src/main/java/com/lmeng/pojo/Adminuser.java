package com.lmeng.pojo;

import java.util.Date;
import javax.persistence.*;

public class Adminuser {
    @Id
    @Column(name = "adminUserId")
    private Integer adminuserid;

    /**
     * 用户在entryDb.user表中的ID（如果有app账号）
     */
    @Column(name = "entryUserId")
    private Integer entryuserid;

    /**
     * 用户姓名
     */
    @Column(name = "userName")
    private String username;

    /**
     * mobile
     */
    private String mobile;

    /**
     * 隐藏第4到第七位的手机号码
     */
    @Column(name = "partMobile")
    private String partmobile;

    /**
     * 注册时随机10位数字
     */
    private String salt;

    /**
     * 登录密码,md5(password)
     */
    private String password;

    /**
     * 0=no,1=yes
     */
    @Column(name = "superAdmin")
    private Integer superadmin;

    /**
     * 0=禁用,1=有效
     */
    @Column(name = "statusId")
    private Integer statusid;

    /**
     * 0=unknow,1=male,2=female
     */
    private Integer gender;

    /**
     * 创建人id
     */
    @Column(name = "createId")
    private Integer createid;

    /**
     * 角色id
     */
    private Integer roleid;

    /**
     * 创建人姓名
     */
    @Column(name = "createUser")
    private String createuser;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 最后修改人id
     */
    @Column(name = "lastUpdateId")
    private Integer lastupdateid;

    /**
     * 最后修改人
     */
    @Column(name = "lastUpdateUser")
    private String lastupdateuser;

    /**
     * 最后修改时间
     */
    @Column(name = "lastUpdateTime")
    private Date lastupdatetime;

    /**
     * @return adminUserId
     */
    public Integer getAdminuserid() {
        return adminuserid;
    }

    /**
     * @param adminuserid
     */
    public void setAdminuserid(Integer adminuserid) {
        this.adminuserid = adminuserid;
    }

    /**
     * 获取用户在entryDb.user表中的ID（如果有app账号）
     *
     * @return entryUserId - 用户在entryDb.user表中的ID（如果有app账号）
     */
    public Integer getEntryuserid() {
        return entryuserid;
    }

    /**
     * 设置用户在entryDb.user表中的ID（如果有app账号）
     *
     * @param entryuserid 用户在entryDb.user表中的ID（如果有app账号）
     */
    public void setEntryuserid(Integer entryuserid) {
        this.entryuserid = entryuserid;
    }

    /**
     * 获取用户姓名
     *
     * @return userName - 用户姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户姓名
     *
     * @param username 用户姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取mobile
     *
     * @return mobile - mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置mobile
     *
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取隐藏第4到第七位的手机号码
     *
     * @return partMobile - 隐藏第4到第七位的手机号码
     */
    public String getPartmobile() {
        return partmobile;
    }

    /**
     * 设置隐藏第4到第七位的手机号码
     *
     * @param partmobile 隐藏第4到第七位的手机号码
     */
    public void setPartmobile(String partmobile) {
        this.partmobile = partmobile;
    }

    /**
     * 获取注册时随机10位数字
     *
     * @return salt - 注册时随机10位数字
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置注册时随机10位数字
     *
     * @param salt 注册时随机10位数字
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取登录密码,md5(password)
     *
     * @return password - 登录密码,md5(password)
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码,md5(password)
     *
     * @param password 登录密码,md5(password)
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取0=no,1=yes
     *
     * @return superAdmin - 0=no,1=yes
     */
    public Integer getSuperadmin() {
        return superadmin;
    }

    /**
     * 设置0=no,1=yes
     *
     * @param superadmin 0=no,1=yes
     */
    public void setSuperadmin(Integer superadmin) {
        this.superadmin = superadmin;
    }

    /**
     * 获取0=禁用,1=有效
     *
     * @return statusId - 0=禁用,1=有效
     */
    public Integer getStatusid() {
        return statusid;
    }

    /**
     * 设置0=禁用,1=有效
     *
     * @param statusid 0=禁用,1=有效
     */
    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    /**
     * 获取0=unknow,1=male,2=female
     *
     * @return gender - 0=unknow,1=male,2=female
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置0=unknow,1=male,2=female
     *
     * @param gender 0=unknow,1=male,2=female
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取创建人id
     *
     * @return createId - 创建人id
     */
    public Integer getCreateid() {
        return createid;
    }

    /**
     * 设置创建人id
     *
     * @param createid 创建人id
     */
    public void setCreateid(Integer createid) {
        this.createid = createid;
    }

    /**
     * 获取角色id
     *
     * @return roleid - 角色id
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 设置角色id
     *
     * @param roleid 角色id
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取创建人姓名
     *
     * @return createUser - 创建人姓名
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     * 设置创建人姓名
     *
     * @param createuser 创建人姓名
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取最后修改人id
     *
     * @return lastUpdateId - 最后修改人id
     */
    public Integer getLastupdateid() {
        return lastupdateid;
    }

    /**
     * 设置最后修改人id
     *
     * @param lastupdateid 最后修改人id
     */
    public void setLastupdateid(Integer lastupdateid) {
        this.lastupdateid = lastupdateid;
    }

    /**
     * 获取最后修改人
     *
     * @return lastUpdateUser - 最后修改人
     */
    public String getLastupdateuser() {
        return lastupdateuser;
    }

    /**
     * 设置最后修改人
     *
     * @param lastupdateuser 最后修改人
     */
    public void setLastupdateuser(String lastupdateuser) {
        this.lastupdateuser = lastupdateuser;
    }

    /**
     * 获取最后修改时间
     *
     * @return lastUpdateTime - 最后修改时间
     */
    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    /**
     * 设置最后修改时间
     *
     * @param lastupdatetime 最后修改时间
     */
    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}