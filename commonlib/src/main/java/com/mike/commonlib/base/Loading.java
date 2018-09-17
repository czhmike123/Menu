package com.mike.commonlib.base;

import android.content.Context;

import com.mike.commonlib.acmodel.Action;

/**
 * 项目名称: Menu
 * 类描述:Loading
 * 作者: Mike
 * 创建时间: 2018/8/30 18:11
 * 邮箱:2468139903@qq.com
 */
public interface Loading {
    void showLoading(Action aciton);
    void closeLoading(Action aciton);
    class Factory{
        public static Loading getInstance(Context context){
          return new LoadingImpl(context) ;
        }
    }
}
