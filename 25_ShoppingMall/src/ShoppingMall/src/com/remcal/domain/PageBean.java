package com.remcal.domain;

import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public class PageBean<T> {
    //分页属性
    //页码
    private int pageNum;
    //页大小
    private int pageSize;
    //总的数据个数
    private long totalSize;
    //总页数
    private int pageCount;
    //数据
    private List<T> data;

    //添加开始页码和结束页码
    private int startPage;
    private int endPage;


    public PageBean(int pageNum, int pageSize, long totalSize, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.data = data;
        //计算pageCount
        pageCount= (int) (totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1);

        //设置开始页码和结束页码
        //1正常
        startPage=pageNum-4;
        endPage=pageNum+5;
        //2当前页码小于5
        if(pageNum<5){
            startPage=1;
            endPage=10;
        }
        //3当前页码大于总页数-5
        if(pageNum>pageCount-5){
            startPage=pageCount-9;
            endPage=pageCount;
        }
        //4如果小于10页
        if(pageCount<10){
            startPage=1;
            endPage=pageCount;
        }

    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
