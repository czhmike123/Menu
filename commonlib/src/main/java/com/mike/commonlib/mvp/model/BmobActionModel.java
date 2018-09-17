package com.mike.commonlib.mvp.model;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;
import com.mike.commonlib.mvp.BaseMvpModel;
import com.mike.commonlib.network.NetManager;
import com.mike.commonlib.network.NetResponseListener;
import com.mike.commonlib.network.bmob.BmobRequest;

/**
 * 项目名称: Menu
 * 类描述:BmobActionModel
 * 作者: Mike
 * 创建时间: 2018/9/14 19:18
 * 邮箱:2468139903@qq.com
 */
public abstract class BmobActionModel<N extends BmobRequest> implements BaseMvpModel<N> {
    @Override
    public <D extends BaseData,S extends SendData> void doNetAction(Action<D,S> action, NetResponseListener listener) {
        NetManager.getNetworkRequest(getNetRequestClass()).doNetworkRequest(action,null,listener);
    }

    @Override
    public <D extends BaseData,S extends SendData> void doLocalAction(Action<D,S> action) {

    }

}
