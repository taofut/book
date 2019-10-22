package com.ft.book.service.impl;

import com.ft.base.bean.PagerBean;
import com.ft.base.utils.PagerUtils;
import com.ft.book.bean.ReaderType;
import com.ft.book.mapper.ReaderTypeMapper;
import com.ft.book.service.ReaderTypeService;
import com.ft.book.utils.BookResult;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ReaderTypeServiceImpl implements ReaderTypeService {

    @Autowired
    private ReaderTypeMapper readerTypeMapper;

    @Override
    public PagerBean findPageList(Map<String, Object> params) {
//        PagerUtils.startPage((String) params.get("pageSize"), (String) params.get("pageIndex"), (String) params.get("synQuery"),
//                (String) params.get("loadRowCount"), (String) params.get("sortField"), (String) params.get("sortOrder"));
        PagerUtils.startPage((String) params.get("limit"), (String) params.get("page"));
        List<ReaderType> result = readerTypeMapper.findPageList(params);
        return new PagerBean<ReaderType>(result);
    }

    @Override
    public BookResult save(ReaderType readerType) {
        try {
            ReaderType rt = readerTypeMapper.selectByName(readerType.getName());
            if (rt != null) {
                log.error("读者类型已经存在！");
                return BookResult.build(500, "读者类型已经存在！");
            }
            this.readerTypeMapper.insert(readerType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return BookResult.ok();
    }
}
