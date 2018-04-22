package com.book.online.vo;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{
    private static final long serialVersionUID = -1002347819033311814L;
    private Integer pageNow;//当前页
    private Integer pageSize;//每页显示条数
    private Integer pageCounts;//总的页数
    private Integer rows;//总的条数
    private List<T> datas;//存放的对象的集合
    public PageBean() {
        super();
    }
    public PageBean(Integer pageNow, Integer pageSize, Integer pageCounts, Integer rows, List<T> datas) {
        super();
        this.pageNow = pageNow;
        this.pageSize = pageSize;
        this.pageCounts = pageCounts;
        this.rows = rows;
        this.datas = datas;
    }
    public Integer getPageNow() {
        return pageNow;
    }
    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPageCounts() {
        return pageCounts;
    }
    public void setPageCounts(Integer pageCounts) {
        this.pageCounts = pageCounts;
    }
    public Integer getRows() {
        return rows;
    }
    public void setRows(Integer rows) {
        this.rows = rows;
    }
    public List<T> getDatas() {
        return datas;
    }
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
    @Override
    public String toString() {
        return "PageBean [pageNow=" + pageNow + ", pageSize=" + pageSize + ", pageCounts=" + pageCounts + ", rows="
                + rows + ", datas=" + datas + "]";
    }
    
}
