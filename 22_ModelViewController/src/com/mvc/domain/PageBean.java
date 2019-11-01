package com.mvc.domain;

import java.util.List;

/**
 * @ClassName: PageBean
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 10/30/2019 3:56 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class PageBean<T> {
    private Integer pageNum;//设定目标查询页码
    private Integer pageSize;//设定一页显示数据量
    private Long totalDataSize;//数据总量
    private Integer pageCount;//当前页面总数
    private List<T> data;//当前页的列表数据

    public PageBean() {
    }

    public PageBean(Integer pageNum, Integer pageSize, long totalDataSize, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalDataSize = totalDataSize;
        this.data = data;
        this.pageCount =(int)(this.totalDataSize%pageSize==0?this.totalDataSize/pageSize:this.totalDataSize/pageSize+1);
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalDataSize() {
        return totalDataSize;
    }

    public void setTotalDataSize(long totalDataSize) {
        this.totalDataSize = totalDataSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalDataSize=" + totalDataSize +
                ", pageCount=" + pageCount +
                ", data=" + data +
                '}';
    }
}
