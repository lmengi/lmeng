package com.lmeng.model;

import java.util.*;

/**
 * @author LSK
 * @Description 菜单的节点
 * @date 2018年12月1日 上午11:34:17
 */
public class MenuModel implements Comparable{

    /**
     * 节点id
     */
    private Integer id;

    /**
     * 父节点
     */
    private Integer parentId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 按钮级别
     */
    private Integer levels;

    /**
     * 节点的url
     */
    private String url;

    /**
     * 节点图标
     */
    private String icon;

    /**
     * 子节点的集合
     */
    private List<MenuModel> children;

    /**
     * 查询子节点时候的临时集合
     */
    private List<MenuModel> linkedList = new ArrayList<MenuModel>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuModel> getChildren() {
        return children;
    }

    public void setChildren(List<MenuModel> children) {
        this.children = children;
    }

    public List<MenuModel> getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(List<MenuModel> linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public String toString() {
        return "MenuNode{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", levels=" + levels +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", children=" + children +
                ", linkedList=" + linkedList +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        MenuModel menuModel = (MenuModel) o;
        Integer levels = menuModel.getLevels();
        if (levels == null) {
            levels = 0;
        }
        return this.levels.compareTo(levels);
    }

    /**
     * 构建页面菜单列表
     */
    public static List<MenuModel> buildTitle(List<MenuModel> nodes) {
        if (nodes.size() <= 0) {
            return nodes;
        }
        //对菜单排序，返回列表按菜单等级，序号的排序方式排列
        Collections.sort(nodes);
        return mergeList(nodes, nodes.get(nodes.size() - 1).getLevels(), null);
    }

    /**
     * 递归合并数组为子数组，最后返回第一层
     *
     * @param menuList
     * @param listMap
     * @return
     */
    private static List<MenuModel> mergeList(List<MenuModel> menuList, int rank, Map<Integer, List<MenuModel>> listMap) {
        //保存当次调用总共合并了多少元素
        int n;
        //保存当次调用总共合并出来的list
        Map<Integer, List<MenuModel>> currentMap = new HashMap<>();
        //由于按等级从小到大排序，需要从后往前排序
        //判断该节点是否属于当前循环的等级,不等于则跳出循环
        for (n = menuList.size() - 1; n >=0&&menuList.get(n).getLevels() == rank; n--) {
            //判断之前的调用是否有返回以该节点的id为key的map，有则设置为children列表。
            if (listMap != null && listMap.get(menuList.get(n).getId()) != null) {
                menuList.get(n).setChildren(listMap.get(menuList.get(n).getId()));
            }
            if (menuList.get(n).getParentId()!=null&&menuList.get(n).getParentId()!=0) {
                //判断当前节点所属的pid是否已经创建了以该pid为key的键值对，没有则创建新的链表
                currentMap.computeIfAbsent( menuList.get(n).getParentId(), k -> new LinkedList<>());
                //将该节点插入到对应的list的头部
                currentMap.get(menuList.get(n).getParentId()).add(0, menuList.get(n));
            }
        }
        if (n <0) {
            return menuList;
        } else {
            return mergeList(menuList.subList(0, n+1), menuList.get(n).getLevels(), currentMap);
        }
    }

}
