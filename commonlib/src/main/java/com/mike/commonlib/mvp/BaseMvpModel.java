package com.mike.commonlib.mvp;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;
import com.mike.commonlib.network.NetRequest;
import com.mike.commonlib.network.NetResponse;
import com.mike.commonlib.network.NetResponseListener;

/**
 * 项目名称: Menu
 * 类描述:BaseMvpModel
 * 作者: Mike
 * 创建时间: 2018/8/30 18:41
 * 邮箱:2468139903@qq.com
 */
public interface BaseMvpModel<N extends NetRequest> {
    <D extends BaseData,S extends SendData> void doNetAction(Action<D,S> action, NetResponseListener listener);
    <D extends BaseData,S extends SendData> void doLocalAction(Action<D,S> action);
     Class<N> getNetRequestClass();
}
