package com.mike.menu.mainApp.common.bean;

import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;

import java.util.List;

/**
 * 项目名称: Menu
 * 类描述:MenuList
 * 作者: Mike
 * 创建时间: 2018/9/5 9:44
 * 邮箱:2468139903@qq.com
 */
public class MenuList implements BaseData{

    public int allNum;
    public String remark;
    public int allPage;
    public String msg;
    public boolean flag;
    public List<Menu> datas;
    public int page;
    public int ret_code;

    public class Menu {
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
    }

    public static class Send implements SendData{}

}