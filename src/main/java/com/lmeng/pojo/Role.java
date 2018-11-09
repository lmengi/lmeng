package com.lmeng.pojo;

import java.util.Date;
import javax.persistence.*;

public class Role {
    @Id
    @Column(name = "roleId")
    private Integer roleid;

    /**
     * 角色名称
     */
    @Column(name = "roleName")
    private String rolename;

    /**
     * 是否是超级管理员,0=no,1=yes
     */
    @Column(name = "superAdminFlag")
    private Integer superadminflag;

    /**
     * 1=系统角色(禁止修改),2=自定义的角色
     */
    @Column(name = "publicFlag")
    private Integer publicflag;

    private String remark;

    /**
     * 创建人姓名
     */
    @Column(name = "createUser")
    private String createuser;

    /**
     * 菜单项
     */
    private String menus;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

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
     * @return roleId
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取角色名称
     *
     * @return roleName - 角色名称
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 设置角色名称
     *
     * @param rolename 角色名称
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * 获取是否是超级管理员,0=no,1=yes
     *
     * @return superAdminFlag - 是否是超级管理员,0=no,1=yes
     */
    public Integer getSuperadminflag() {
        return superadminflag;
    }

    /**
     * 设置是否是超级管理员,0=no,1=yes
     *
     * @param superadminflag 是否是超级管理员,0=no,1=yes
     */
    public void setSuperadminflag(Integer superadminflag) {
        this.superadminflag = superadminflag;
    }

    /**
     * 获取1=系统角色(禁止修改),2=自定义的角色
     *
     * @return publicFlag - 1=系统角色(禁止修改),2=自定义的角色
     */
    public Integer getPublicflag() {
        return publicflag;
    }

    /**
     * 设置1=系统角色(禁止修改),2=自定义的角色
     *
     * @param publicflag 1=系统角色(禁止修改),2=自定义的角色
     */
    public void setPublicflag(Integer publicflag) {
        this.publicflag = publicflag;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * 获取菜单项
     *
     * @return menus - 菜单项
     */
    public String getMenus() {
        return menus;
    }

    /**
     * 设置菜单项
     *
     * @param menus 菜单项
     */
    public void setMenus(String menus) {
        this.menus = menus;
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