package com.mike.commonlib.network;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;

/**
 * 项目名称: Menu
 * 类描述:NetRequest
 * 作者: Mike
 * 创建时间: 2018/8/31 10:15
 * 邮箱:2468139903@qq.com
 */
public interface NetRequest<R extends NetResponse> {
    <D extends BaseData,S extends SendData> void  doNetworkRequest(Action<D,S> action, NetOption option, NetResponseListener<R> response);
}
