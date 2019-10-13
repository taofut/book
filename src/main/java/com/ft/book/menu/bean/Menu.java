package com.ft.book.menu.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * 创建人：taofut
 * 创建时间：2019-10-13 21:29
 * 描述：
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Menu {

    // 节点唯一索引值，用于对指定节点进行各类操作
    private String id;
    // 节点标题
    private String title;
    // 节点字段名
    private String field;
    // 子节点。支持设定选项同父节点
    private List<Menu> children;
    // 点击节点弹出新窗口对应的 url。需开启 isJump 参数
    private String href;
    // 节点是否初始展开，默认 false
    private Boolean spread;
    // 节点是否初始为选中状态（如果开启复选框的话），默认 false
    private Boolean checked;
    // 节点是否为禁用状态。默认 false
    private Boolean disabled;

}
