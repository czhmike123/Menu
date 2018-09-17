package com.mike.menu.mainApp.common.bean;

import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;

import java.util.List;

/**
 * 项目名称: Menu
 * 类描述:Menu
 * 作者: Mike
 * 创建时间: 2018/9/4 11:34
 * 邮箱:2468139903@qq.com
 */
public class Menu implements BaseData{
    public String des;
    public List<Steps> steps;
    public String id;
    public String largeImg;
    public String smallImg;
    public String type_v3;
    public String cpName;
    public String type_v2;
    public String tip;
    public List<Yl> yl;
    public String type_v1;
    public String type;


    public class Steps {
        public String imgUrl;
        public int orderNum;
        public String content;
    }

    public class Yl {
        public String ylName;
        public String ylUnit;
    }
    public static class Send implements SendData {}
}
