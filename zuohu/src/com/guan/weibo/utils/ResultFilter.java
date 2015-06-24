package com.guan.weibo.utils;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ResultFilter<T> implements Serializable{  
	  
    private static final long serialVersionUID = 5472321653620726832L;  
  
    private final static int DEFAULT_NAVIGATOR_SIZE = 5;  
  
    //当前页  
    private int currentPage = 1;  
    //每页显示数量  
    private int pageSize = 5;  
      
    //总条数  
    private int totalCount;  
  
    private boolean havaNextPage;  
  
    private boolean havePrePage;  
  
    //导航条索引
    private int navigatorSize;  
      
    //存放查询结果用的list  
    private List<T> items;  
      
    public ResultFilter(){  
          
    }  
      
    public ResultFilter(int totalCount, int pageSize, int currentPage) {  
        this(totalCount, pageSize, currentPage, DEFAULT_NAVIGATOR_SIZE);  
    }  
  
    public ResultFilter(int totalCount, int pageSize, int currentPage,  
                        int navigatorSize) {  
        this.totalCount = totalCount;  
        this.pageSize = pageSize;  
        this.currentPage = currentPage;  
        this.navigatorSize = navigatorSize;  
    }  
      
    //获取总页数
    public int getPageCount() {  
        int pageCount = 0;  
        if (pageSize != 0) {  
            pageCount = totalCount / pageSize;  
            if (totalCount % pageSize != 0)  
                pageCount++;  
        }  
  
        return pageCount;  
    }  
  
    //获取当期页
    public int getCurrentPage() {  
        currentPage = currentPage < getPageCount() ? currentPage :  
                      getPageCount();  
        currentPage = currentPage < 1 ? 1 : currentPage;  
  
        return currentPage;  
    }  
  
    //获取单页显示条数
    public int getPageSize() {  
        return pageSize;  
    }  
  
    //获取总条数
    public int getTotalCount() {  
        return totalCount;  
    }  
  
  
    //是否有下一页
    public boolean isHaveNextPage() {  
        havaNextPage = false;  
        if ((getPageCount() > 1) && (getPageCount() > getCurrentPage()))  
            havaNextPage = true;  
        return havaNextPage;  
    }  
  
    //是否有上一页
    public boolean isHavePrePage() {  
        havePrePage = false;  
        if ((getPageCount() > 1) && (currentPage > 1))  
            havePrePage = true;  
        return havePrePage;  
    }  
  
    //活动导航条索引
    private int getNavigatorIndex(boolean isBegin) {  
        int beginNavigatorIndex = getCurrentPage() - navigatorSize / 2;  
        int endNavigatorIndex = getCurrentPage() + navigatorSize / 2;  
        beginNavigatorIndex = beginNavigatorIndex < 1 ? 1 : beginNavigatorIndex;  
        endNavigatorIndex = endNavigatorIndex < getPageCount() ?  
                            endNavigatorIndex :  
                            getPageCount();  
        while ((endNavigatorIndex - beginNavigatorIndex) < navigatorSize &&  
               (beginNavigatorIndex != 1 || endNavigatorIndex != getPageCount())) {  
            if (beginNavigatorIndex > 1)  
                beginNavigatorIndex--;  
            else if (endNavigatorIndex < getPageCount())  
                endNavigatorIndex++;  
        }  
  
        if(isBegin)  
            return beginNavigatorIndex;  
        else  
            return endNavigatorIndex;  
    }  
  
    //获取开始导航条索引
    public int getBeginNavigatorIndex() {  
        return getNavigatorIndex(true);  
    }  
  
    //获取结束导航条索引
    public int getEndNavigatorIndex() {  
        return getNavigatorIndex(false);  
    }  
  
    //获取所条目
    public List<T> getItems() {  
        return items;  
    }  
  
    //设置条目
    public void setItems(List<T> items) {  
        this.items = items;  
    }  
      
    public void setCurrentPage(int currentPage) {  
        this.currentPage = currentPage;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public void setTotalCount(int totalCount) {  
        this.totalCount = totalCount;  
    }  
  
    @Override  
    public String toString() {  
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);  
    }  
  
}  