package com.ft.book.mapper;

import com.ft.book.bean.ReaderInfo;

public interface ReaderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReaderInfo record);

    int insertSelective(ReaderInfo record);

    ReaderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReaderInfo record);

    int updateByPrimaryKey(ReaderInfo record);
}