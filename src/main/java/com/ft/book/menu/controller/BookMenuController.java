package com.ft.book.menu.controller;

import com.alibaba.fastjson.JSONObject;
import com.ft.book.menu.bean.Menu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人：taofut
 * 创建时间：2019-10-13 17:45
 * 描述：
 */
@RestController
@RequestMapping("/menu")
public class BookMenuController {

    @RequestMapping("/getAllMenu")
    public List<Menu> getAllMenu(){
        List<Menu> menuList=new ArrayList<>();
        Menu menu0=new Menu();

        List<Menu> menu00=new ArrayList<>();
        Menu menu01=new Menu();
        menu01.setTitle("java");
        Menu menu02=new Menu();
        menu02.setTitle("c语言");
        menu00.add(menu01);
        menu00.add(menu02);

        menu0.setTitle("我的图书");
        menu0.setChildren(menu00);
        menuList.add(menu0);
        return menuList;
    }

}
