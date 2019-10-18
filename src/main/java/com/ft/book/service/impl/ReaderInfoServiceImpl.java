package com.ft.book.service.impl;

import com.ft.book.bean.ReaderInfo;
import com.ft.book.mapper.ReaderInfoMapper;
import com.ft.book.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: fut
 * Time:   2019-10-18
 * Motto:  Work conscientiously and be a practical man.
 */
@Service
public class ReaderInfoServiceImpl implements ReaderInfoService{

    @Autowired
    private ReaderInfoMapper readerInfoMapper;


    @Override
    public ReaderInfo findReader() {
        return readerInfoMapper.selectByPrimaryKey(1);
    }
}
