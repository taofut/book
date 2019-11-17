package com.ft.book.service.impl;

import com.ft.base.bean.PagerBean;
import com.ft.base.utils.PagerUtils;
import com.ft.book.bean.ReaderInfo;
import com.ft.book.mapper.ReaderInfoMapper;
import com.ft.book.service.ReaderInfoService;
import com.ft.book.utils.BookResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: fut
 * Time:   2019-10-18
 * Motto:  Work conscientiously and be a practical man.
 */
@Service
@Slf4j
public class ReaderInfoServiceImpl implements ReaderInfoService{

    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    @Override
    public PagerBean findPageList(Map<String, Object> params) {
        PagerUtils.startPage((String) params.get("limit"), (String) params.get("page"));
        List<Map> result = readerInfoMapper.findPageList(params);
        for (Map map : result) {
            convertFormat(map);
        }
        return new PagerBean<Map>(result);
    }

    private void convertFormat(Map map) {
        Date createTime = (Date) map.get("create_time");
        if (createTime != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            map.put("createTime", sdf.format(createTime));
        }
    }

    @Override
    public BookResult save(ReaderInfo readerInfo) {
        try {
            ReaderInfo read = readerInfoMapper.selectByPaperno(readerInfo.getPaperno());
            if (read != null) {
                log.error("读者档案信息已存在！");
                return BookResult.build(500, "读者档案信息已存在！");
            }
            readerInfo.setCreateTime(new Date());
            readerInfo.setUpdateTime(new Date());
            readerInfoMapper.insert(readerInfo);
        } catch (Exception e) {
            log.error("读者档案添加失败！");
            throw new RuntimeException(e);
        }
        return BookResult.ok();
    }

    @Override
    public BookResult update(ReaderInfo readerInfo) {
        try {
            readerInfo.setUpdateTime(new Date());
            readerInfoMapper.updateByPrimaryKey(readerInfo);
        } catch (Exception e) {
            log.error("档案信息更新失败！");
            throw new RuntimeException(e);
        }
        return BookResult.ok();
    }

    @Override
    public BookResult delete(List<Integer> ids) {
        try {
            for (Integer id : ids) {
                readerInfoMapper.deleteByPrimaryKey(id);
            }
        } catch (Exception e) {
            log.error("读者档案删除失败！");
            throw new RuntimeException(e);
        }
        return BookResult.ok();
    }
}
