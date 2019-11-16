package com.ft.book.controller;

import com.alibaba.fastjson.JSON;
import com.ft.base.bean.PagerBean;
import com.ft.book.bean.ReaderInfo;
import com.ft.book.bean.ReaderType;
import com.ft.book.service.ReaderInfoService;
import com.ft.book.service.ReaderTypeService;
import com.ft.book.utils.BookResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: fut
 * Time:   2019-10-18
 * Motto:  Work conscientiously and be a practical man.
 */
@RestController
@RequestMapping("readerInfo")
public class ReaderInfoController {

    @Autowired
    private ReaderInfoService readerInfoService;
    @Autowired
    private ReaderTypeService readerTypeService;

    @RequestMapping("/queryReaderInfo")
    public PagerBean queryReaderType(@RequestParam Map<String, Object> params){
        return readerInfoService.findPageList(params);
    }

    @RequestMapping("/save_add")
    public BookResult saveAdd(@RequestParam Map<String, Object> params) {
        ReaderInfo readerInfo = JSON.parseObject((String) params.get("json"), ReaderInfo.class);
        return readerInfoService.save(readerInfo);
    }

    @RequestMapping("/save_update")
    public BookResult saveUpdate(@RequestParam Map<String, Object> params) {
        ReaderInfo readerInfo = JSON.parseObject((String) params.get("json"), ReaderInfo.class);
        return readerInfoService.update(readerInfo);
    }

    @RequestMapping(value = "reader_type", method = RequestMethod.POST)
    public List<ReaderType> findReaderType() {
        return readerTypeService.findReaderType();
    }

    @RequestMapping(value = "/initBarcode", method = RequestMethod.GET)
    public String initBarcode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String barcode = sdf.format(new Date());
        return barcode;
    }

}
