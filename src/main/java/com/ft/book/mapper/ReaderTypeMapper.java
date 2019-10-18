package com.ft.book.mapper;

import com.ft.book.bean.ReaderType;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReaderType record);

    int insertSelective(ReaderType record);

    ReaderType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReaderType record);

    int updateByPrimaryKey(ReaderType record);
}