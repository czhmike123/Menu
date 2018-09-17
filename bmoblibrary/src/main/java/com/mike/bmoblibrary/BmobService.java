package com.mike.bmoblibrary;

import android.content.Context;

import cn.bmob.v3.Bmob;

/**
 * 项目名称: Menu
 * 类描述:BmobService
 * 作者: Mike
 * 创建时间: 2018/9/14 14:36
 * 邮箱:2468139903@qq.com
 */
public class BmobService {
    public static void init(Context context){
        Bmob.initialize(context,"09290e6a523856afd2a08a81f8f80007");
    }
}
