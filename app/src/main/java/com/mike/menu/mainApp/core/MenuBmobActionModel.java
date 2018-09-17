package com.mike.menu.mainApp.core;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.mvp.BaseMvpModel;
import com.mike.commonlib.mvp.model.BmobActionModel;
import com.mike.commonlib.network.NetManager;
import com.mike.commonlib.network.NetRequest;
import com.mike.commonlib.network.NetResponseListener;
import com.mike.commonlib.network.bmob.BmobRequest;
import com.mike.menu.mainApp.api.MenuBmobRequest;
import com.mike.menu.mainApp.api.MenuRetrofitOkRequest;

/**
 * 项目名称: Menu
 * 类描述:MenuRetrofitOkActionModel
 * 作者: Mike
 * 创建时间: 2018/9/4 10:49
 * 邮箱:2468139903@qq.com
 */
public class MenuBmobActionModel extends BmobActionModel<MenuBmobRequest> {

    @Override
    public Class<MenuBmobRequest> getNetRequestClass() {
        return MenuBmobRequest.class;
    }
}
