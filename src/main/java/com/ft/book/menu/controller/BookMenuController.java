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

        JSONObject menuNodeTsgl0 = new JSONObject();
        JSONObject menuNodeTsgl1 = new JSONObject();
        menuNodeTsgl0.put("nodeId", "TSLXGL");
        menuNodeTsgl0.put("name", "图书类型管理");
        menuNodeTsgl0.put("url", request.getContextPath() + "/book/tsgl/tslxgl.html");
        menuNodeTsgl0.put("nodeType", "LEAF");
        menuNodeTsgl1.put("nodeId", "TSDAGL");
        menuNodeTsgl1.put("name", "图书档案管理");
        menuNodeTsgl1.put("url", request.getContextPath() + "/book/tsgl/tsdagl.html");
        menuNodeTsgl1.put("nodeType", "LEAF");

        JSONObject menuNodeDzgl0 = new JSONObject();
        JSONObject menuNodeDzgl1 = new JSONObject();
        menuNodeDzgl0.put("nodeId", "DZLXGL");
        menuNodeDzgl0.put("name", "读者类型管理");
        menuNodeDzgl0.put("url", request.getContextPath() + "/book/dzgl/dzlxgl.html");
        menuNodeDzgl0.put("nodeType", "LEAF");
        menuNodeDzgl1.put("nodeId", "DZDAGL");
        menuNodeDzgl1.put("name", "读者档案管理");
        menuNodeDzgl1.put("url", request.getContextPath() + "/book/dzgl/dzdagl.html");
        menuNodeDzgl1.put("nodeType", "LEAF");

        //读者管理
        JSONArray menuNodeList0 = new JSONArray();
        menuNodeList0.add(menuNodeDzgl0);
        menuNodeList0.add(menuNodeDzgl1);
        JSONObject menuNode0 = new JSONObject();
        menuNode0.put("nodeId", "DZGL");
        menuNode0.put("name", "读者管理");
        menuNode0.put("nodeType", "GROUP");
        menuNode0.put("children", menuNodeList0);

        //图书管理
        JSONArray menuNodeList1 = new JSONArray();
        menuNodeList1.add(menuNodeTsgl0);
        menuNodeList1.add(menuNodeTsgl1);
        JSONObject menuNode1 = new JSONObject();
        menuNode1.put("nodeId", "TSGL");
        menuNode1.put("name", "图书管理");
        menuNode1.put("nodeType", "GROUP");
        menuNode1.put("children", menuNodeList1);

        JSONArray menuRootList = new JSONArray();
        menuRootList.add(menuNode0);
        menuRootList.add(menuNode1);
        JSONObject result = new JSONObject();
        result.put("data", menuRootList);

        return result.toJSONString();
    }

}
