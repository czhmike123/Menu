package com.mike.commonlib.base;

import android.content.Context;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.utils.ToastUtil;

/**
 * 项目名称: Menu
 * 类描述:LoadingImpl
 * 作者: Mike
 * 创建时间: 2018/8/30 18:13
 * 邮箱:2468139903@qq.com
 */
public class LoadingImpl implements Loading{
    Context context;
    public LoadingImpl(Context context){
        this.context=context;
    }

    @Override
    public void showLoading(Action action) {
        ToastUtil.showToast(context,"开始..");
    }

    @Override
    public void closeLoading(Action action) {
        ToastUtil.showToast(context,"结束");
    }
}
