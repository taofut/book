package com.ft.base.bean;

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Author: fut
 * Time:   2019-10-19
 * Motto:  Work conscientiously and be a practical man.
 */
@Data
public class PagerBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private long total; //总记录数
    private List<T> data; //结果集
    private int pageNum; //第几页
    private int pageIndex; //第几页
    private int pageSize; //每页记录数
    private int pages; // 总页数
    private int size; //当前页的数量<=pageSize

    //layui要求返回的参数
    private String code="0";
    private String msg;
    private long count;

    public PagerBean(List<T> list) {
        if(list instanceof Page) {
            Page<T> page = (Page)list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.data = page;
            this.size = page.size();
            this.pageIndex = page.getPageNum();
            this.count=page.getTotal();
        }
    }
}
