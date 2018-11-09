package com.lmeng.pojo;

import java.util.Date;
import javax.persistence.*;

public class Menu {
    @Id
    @Column(name = "menuId")
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuname;

    /**
     * 菜单链接
     */
    private String menulink;

    /**
     * 父节点ID
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 备注
     */
    private String message;

    /**
     * 状态： 1，启用； 2，禁用
     */
    @Column(name = "statusId")
    private Integer statusId;

    /**
     * @return menuId
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * @param menuid
     */
    public void setMenuId(Integer menuid) {
        this.menuId = menuid;
    }

    /**
     * 获取菜单名称
     *
     * @return menuname - 菜单名称
     */
    public String getMenuname() {
        return menuname;
    }

    /**
     * 设置菜单名称
     *
     * @param menuname 菜单名称
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    /**
     * 获取菜单链接
     *
     * @return menulink - 菜单链接
     */
    public String getMenulink() {
        return menulink;
    }

    /**
     * 设置菜单链接
     *
     * @param menulink 菜单链接
     */
    public void setMenulink(String menulink) {
        this.menulink = menulink;
    }

    /**
     * 获取父节点ID
     *
     * @return parentId - 父节点ID
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 设置父节点ID
     *
     * @param parentid 父节点ID
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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
     * 获取备注
     *
     * @return message - 备注
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置备注
     *
     * @param message 备注
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取状态： 1，启用； 2，禁用
     *
     * @return statusId - 状态： 1，启用； 2，禁用
     */
    public Integer getStatusId() {
        return statusId;
    }

    /**
     * 设置状态： 1，启用； 2，禁用
     *
     * @param statusId 状态： 1，启用； 2，禁用
     */
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}