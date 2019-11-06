package com.ft.book.mapper;

import com.ft.book.bean.ReaderType;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReaderTypeMapper {

    List<ReaderType> findPageList(Map<String, Object> params);

    int deleteByPrimaryKey(Integer id);

    int insert(ReaderType record);

    int insertSelective(ReaderType record);

    ReaderType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReaderType record);

    int updateByPrimaryKey(ReaderType record);

    ReaderType selectByName(String name);

    List<ReaderType> findReaderType();
}