package com.ft.book.service.impl;

import com.ft.base.bean.PagerBean;
import com.ft.base.utils.PagerUtils;
import com.ft.book.bean.ReaderType;
import com.ft.book.mapper.ReaderTypeMapper;
import com.ft.book.service.ReaderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: fut
 * Time:   2019-10-19
 * Motto:  Work conscientiously and be a practical man.
 */
@Service
public class ReaderTypeServiceImpl implements ReaderTypeService {

    @Autowired
    private ReaderTypeMapper readerTypeMapper;

    @Override
    public PagerBean findPageList(Map<String, Object> params) {
        PagerUtils.startPage((String) params.get("pageSize"), (String) params.get("pageIndex"), (String) params.get("synQuery"),
                (String) params.get("loadRowCount"), (String) params.get("sortField"), (String) params.get("sortOrder"));
        List<ReaderType> result = readerTypeMapper.findPageList(params);
        return new PagerBean<ReaderType>(result);
    }
}
