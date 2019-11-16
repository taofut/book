package com.ft.book.service;

import com.ft.base.bean.PagerBean;
import com.ft.book.bean.ReaderInfo;
import com.ft.book.utils.BookResult;

import java.util.Map;

/**
 * Author: fut
 * Time:   2019-10-18
 * Motto:  Work conscientiously and be a practical man.
 */
public interface ReaderInfoService {

    PagerBean findPageList(Map<String, Object> params);

    BookResult save(ReaderInfo readerInfo);

    BookResult update(ReaderInfo readerInfo);

}
