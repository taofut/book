package com.ft.base.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: fut
 * Time:   2019-10-16
 * Motto:  Work conscientiously and be a practical man.
 */
@Data
public class BaseBean implements Serializable {
    private static final long serialVersionUID = -3047971221154628028L;

    private Date createTime;
    private Date updateTime;

}
