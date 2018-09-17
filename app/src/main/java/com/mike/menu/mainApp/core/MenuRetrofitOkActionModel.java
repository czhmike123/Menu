package com.mike.menu.mainApp.core;

import com.mike.commonlib.mvp.model.RetrofitOkActionModel;
import com.mike.menu.mainApp.api.MenuRetrofitOkRequest;

/**
 * 项目名称: Menu
 * 类描述:MenuRetrofitOkActionModel
 * 作者: Mike
 * 创建时间: 2018/9/4 10:49
 * 邮箱:2468139903@qq.com
 */
public class MenuRetrofitOkActionModel extends RetrofitOkActionModel<MenuRetrofitOkRequest>{

    @Override
    public Class<MenuRetrofitOkRequest> getNetRequestClass() {
        return MenuRetrofitOkRequest.class;
    }
}
