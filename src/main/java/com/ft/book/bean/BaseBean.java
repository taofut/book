package com.ft.book.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: fut
 * Time:   2019-10-16
 * Motto:  Work conscientiously and be a practical man.
 */
@Data
public class BaseBean implements Serializable {
    private static final long serialVersionUID = -3047971221154628028L;
    private String isDelete;
    public String pageSize;
    public String pageIndex;
    public String synQuery;
    public String loadRowCount;
    public String sortField;
    public String sortOrder;
}
