package com.ft.base.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Author: fut
 * Time:   2019-10-19
 * Motto:  Work conscientiously and be a practical man.
 */
public class PagerUtils {

    /**
     * 设置分页和排序参数
     * 按照miui传递的参数进行获取处理
     *
     * @param para 页面ajax传递的参数
     */
    public static final void startPage(Map<String, Object> para) {
        String pageSize1 = (String) para.get("pageSize");
        int pageSize = Integer.parseInt(StringUtils.isEmpty(pageSize1) ? "20" : pageSize1);
        pageSize = pageSize < 0 ? 0 : pageSize;
        //页码从1开始，而不是从0开始。
        String pageIndex1 = (String) para.get("pageIndex");
        int pageIndex = Integer.parseInt(StringUtils.isEmpty(pageIndex1) ? "0" : pageIndex1) + 1;

        /*异步翻页*/
        boolean count = true;
        String synQuery = (String) para.get("synQuery");
        String loadRowCount = (String) para.get("loadRowCount");
        //synQuery不为空， loadRowCount为空，则不执行count
        if (!StringUtils.isEmpty(synQuery) && StringUtils.isEmpty(loadRowCount)) {
            count = false;
        }
        //loadRowCount不为空，则仅执行count
        if (!StringUtils.isEmpty(loadRowCount)) {
            count = true;
            pageIndex = 0;
        }

        //初始化page对象
        Page page = PageHelper.startPage(pageIndex, pageSize, count);
        //排序字段处理
        String sortField = (String) para.get("sortField");//排序字段
        String sortOrder = (String) para.get("sortOrder");//排序的规则  asc desc
        if (!StringUtils.isEmpty(sortField)) {
            PageHelper.orderBy(sortField + " " + sortOrder);
        }
    }


    public static final void startPage(String pageSize1, String pageIndex1, String synQuery, String loadRowCount,
                                       String sortField, String sortOrder) {
//        String pageSize1 = (String) para.get("pageSize");
        int pageSize = Integer.parseInt(StringUtils.isEmpty(pageSize1) ? "20" : pageSize1);
        pageSize = pageSize < 0 ? 0 : pageSize;
        //页码从1开始，而不是从0开始。
//        String pageIndex1 = (String) para.get("pageIndex");
        int pageIndex = Integer.parseInt(StringUtils.isEmpty(pageIndex1) ? "0" : pageIndex1) + 1;
        /*异步翻页*/
        boolean count = true;
//        String synQuery = (String) para.get("synQuery");
//        String loadRowCount = (String) para.get("loadRowCount");
        //synQuery不为空， loadRowCount为空，则不执行count
        if (!StringUtils.isEmpty(synQuery) && StringUtils.isEmpty(loadRowCount)) {
            count = false;
        }
        //loadRowCount不为空，则仅执行count
        if (!StringUtils.isEmpty(loadRowCount)) {
            count = true;
            pageIndex = 0;
        }
        //初始化page对象
        Page page = PageHelper.startPage(pageIndex, pageSize, count);
        //排序字段处理
//        String sortField = (String) para.get("sortField");//排序字段
//        String sortOrder = (String) para.get("sortOrder");//排序的规则  asc desc
        if (!StringUtils.isEmpty(sortField)) {
            PageHelper.orderBy(sortField + " " + sortOrder);
        }
    }
}
