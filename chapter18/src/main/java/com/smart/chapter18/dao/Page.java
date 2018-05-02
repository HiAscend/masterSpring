package com.smart.chapter18.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Page
 * 分页对象. 包含当前页数据及分页信息如总记录数.
 *
 * @author zziaa
 * @date 2018/04/24 21:41
 */
public class Page implements Serializable {
    private static int DEFAULT_PAGE_SIZE = 20;

    private int pageSize = DEFAULT_PAGE_SIZE;
    /**
     * 本页第一条数据在数据库中的起始位置
     */
    private long start;
    /**
     * 当前页中存放的记录，类型一般为List
     */
    private List<?> data;

    /**
     * 总记录数
     */
    private long totalCount;


    /**
     * 构造方法，构造空页
     */
    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<>());
    }

    /**
     * 默认构造方法
     *
     * @param start      本页第一条数据在数据库中的起始位置
     * @param totalCount 数据库中总记录条数
     * @param pageSize   本页容量
     * @param data       本页包含的数据
     */
    public Page(long start, long totalCount, int pageSize, List<?> data) {
        this.start = start;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;
    }

    /**
     * 取总纪录数
     *
     * @return long
     */
    public long getTotalCount() {
        return this.totalCount;
    }

    /**
     * 取总页数
     *
     * @return long
     */
    public long getTotalPageCount() {
        if (totalCount % pageSize == 0) {
            return totalCount / pageSize;
        } else {
            return totalCount / pageSize + 1;
        }
    }

    /**
     * 取每页数据容量
     *
     * @return int
     */
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * 取当前页中的记录
     *
     * @return List
     */
    public List<?> getData() {
        return this.data;
    }

    /**
     * 取该页当前页码，页码从1开始
     *
     * @return long
     */
    public long getCurrentPageNo() {
        return start / pageSize + 1;
    }

    /**
     * 该页是否有下一页
     *
     * @return boolean
     */
    public boolean isHasNextPage() {
        return getCurrentPageNo() < getTotalCount();
    }

    /**
     * 该页是否有上一页
     *
     * @return boolean
     */
    public boolean isHasPreviousPage() {
        return getCurrentPageNo() > 1;
    }

    /**
     * 获取任一页第一条数据在数据集的位置.每页大小使用默认值.
     *
     * @param pageNo 页码
     * @return int
     * @see #getStartOfPage(int, int)
     */
    public static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    /**
     * 获取任一页第一条数据在数据集的位置.
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return int
     */
    public static int getStartOfPage(int pageNo, int pageSize) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize < 1) {
            pageSize = 0;
        }
        return (pageNo - 1) * pageSize;
    }

}
