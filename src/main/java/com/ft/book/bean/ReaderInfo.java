package com.ft.book.bean;

import com.ft.base.bean.BaseBean;
import lombok.Data;

import java.util.Date;

@Data
public class ReaderInfo extends BaseBean{
    private Integer id;

    private String name;

    private String sex;

    private String barcode;

    private String vocation;

    private Date birthday;

    private String papertype;

    private String paperno;

    private String tel;

    private String email;

    private Date createdate;

    private String operator;

    private String remark;

    private Integer typeid;

}