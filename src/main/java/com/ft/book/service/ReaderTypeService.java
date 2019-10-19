package com.ft.book.service;

import com.ft.base.bean.PagerBean;
import com.ft.book.bean.ReaderType;

import java.util.Map;

/**
 * Author: fut
 * Time:   2019-10-19
 * Motto:  Work conscientiously and be a practical man.
 */
public interface ReaderTypeService {

    PagerBean findPageList(Map<String, Object> params);

}
