package main.snnu.utils;

import java.util.List;

/**
 * Created by WT on 2017/11/30.
 */
public class Page<T> {
    private int currentPage;//当前页;
    private int totalPage;//总页数
    private int count;//每页数量
    private int startIndex;//开始查询的地方
    private int totalCount;//一共条数
    private List<T> tList;//内容

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", count=" + count +
                ", startIndex=" + startIndex +
                ", totalCount=" + totalCount +
                ", tList=" + tList +
                '}';
    }

    public Page(int currentPage, int count, int totalCount) {
        this.currentPage = currentPage;
        this.count = count;
        this.totalCount = totalCount;
        if(totalCount%count==0){
            this.totalPage=totalCount/count;
        }else{
            this.totalPage=totalCount/count+1;
        }
        this.startIndex=(currentPage-1)*count;
    }

    public int getStartIndex() {

        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }
}
