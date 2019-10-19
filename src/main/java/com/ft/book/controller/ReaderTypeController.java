package com.ft.book.controller;

import com.ft.base.bean.PagerBean;
import com.ft.book.service.ReaderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Author: fut
 * Time:   2019-10-18
 * Motto:  Work conscientiously and be a practical man.
 */
@RestController
@RequestMapping("readerType")
public class ReaderTypeController {

    @Autowired
    private ReaderTypeService readerTypeService;

    @RequestMapping("/queryReaderType")
    public PagerBean queryReaderType(@RequestParam Map<String, Object> params){
        return readerTypeService.findPageList(params);
    }
}
