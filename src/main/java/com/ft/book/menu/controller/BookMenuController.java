package com.ft.book.menu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ft.book.menu.bean.Menu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/getMenuTree")
    public String getMenuTree(HttpServletRequest request){

        JSONObject menuNode9 = new JSONObject();
        JSONObject menuNode10 = new JSONObject();

        menuNode10.put("nodeId", "ZTBGL");
        menuNode10.put("name", "主题表管理");
        menuNode10.put("url", request.getContextPath() + "/tzzk/html/ztb/ztbgl.html");
        menuNode10.put("nodeType", "LEAF");
        menuNode9.put("nodeId", "ZBGL");
        menuNode9.put("name", "指标管理");
        menuNode9.put("url", request.getContextPath() + "/tzzk/html/zbgl/zbgl.html");
        menuNode9.put("nodeType", "LEAF");

        JSONArray menuNodeListJspzgl = new JSONArray();
        menuNodeListJspzgl.add(menuNode10);
        menuNodeListJspzgl.add(menuNode9);
        JSONObject menuNode0 = new JSONObject();
        menuNode0.put("nodeId", "JSPZGL");
        menuNode0.put("name", "计算配置管理");
        menuNode0.put("nodeType", "GROUP");
        menuNode0.put("children", menuNodeListJspzgl);

        JSONArray menuRootList = new JSONArray();
        menuRootList.add(menuNode0);
        JSONObject result = new JSONObject();
        result.put("data", menuRootList);

        return result.toJSONString();
    }

}
