package com.mike.menu.mainApp.core;

import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.network.NetResponse;

/**
 * 项目名称: Menu
 * 类描述:MenuNetResponse
 * 作者: Mike
 * 创建时间: 2018/9/4 14:11
 * 邮箱:2468139903@qq.com
 */
public class MenuBmobResponse<D extends BaseData> implements NetResponse<D> {
    public int code=0;
    public String message="Success";
    public D data;

    public MenuBmobResponse setData(D data) {
        this.data = data;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public D getData() {
        return data;
    }
}
