package com.mike.commonlib.mvp.model;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;
import com.mike.commonlib.mvp.BaseMvpModel;
import com.mike.commonlib.network.NetManager;
import com.mike.commonlib.network.NetResponseListener;
import com.mike.commonlib.network.retrofit.RetrofitOkRequest;

/**
 * 项目名称: Menu
 * 类描述:RetrofitOkActionModel
 * 作者: Mike
 * 创建时间: 2018/8/30 18:52
 * 邮箱:2468139903@qq.com
 */
public abstract class RetrofitOkActionModel<N extends RetrofitOkRequest> implements BaseMvpModel<N>{
    public RetrofitOkActionModel(){
    }
    @Override
    public <D extends BaseData,S extends SendData> void doNetAction(Action<D,S> action, NetResponseListener listener) {
        NetManager.getNetworkRequest(getNetRequestClass()).doNetworkRequest(action,null,listener);
    }

    @Override
    public <D extends BaseData,S extends SendData> void doLocalAction(Action<D,S> action) {

    }

}
