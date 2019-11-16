package com.ft.book.mapper;

import com.ft.book.bean.ReaderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReaderInfoMapper {

    List<Map> findPageList(Map<String, Object> params);

    int deleteByPrimaryKey(Integer id);

    int insert(ReaderInfo record);

    int insertSelective(ReaderInfo record);

    ReaderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReaderInfo record);

    int updateByPrimaryKey(ReaderInfo record);

    ReaderInfo selectByPaperno(String barcode);
}