package com.ft.book.controller;

import com.ft.book.bean.ReaderInfo;
import com.ft.book.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: fut
 * Time:   2019-10-18
 * Motto:  Work conscientiously and be a practical man.
 */
@RestController
public class HelloController {

    @Autowired
    private ReaderInfoService readerInfoService;

    @RequestMapping("/hello")
    public ReaderInfo hello(){
        return readerInfoService.findReader();
    }
}
