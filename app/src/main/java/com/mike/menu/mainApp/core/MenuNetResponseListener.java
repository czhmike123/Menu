package com.mike.menu.mainApp.core;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;
import com.mike.commonlib.exception.ErrorThrowable;
import com.mike.commonlib.mvp.BaseMvpPresenter;
import com.mike.commonlib.mvp.BaseMvpView;
import com.mike.commonlib.network.NetResponse;
import com.mike.commonlib.network.NetResponseListener;

/**
 * 项目名称: Menu
 * 类描述:MenuNetResponseListener
 * 作者: Mike
 * 创建时间: 2018/9/4 12:02
 * 邮箱:2468139903@qq.com
 */
public abstract class MenuNetResponseListener<D extends BaseData,S extends SendData> implements NetResponseListener<NetResponse<D>> {
    BaseMvpPresenter presenter;
    Action<D,S> action;

    public MenuNetResponseListener(BaseMvpPresenter p, Action<D,S> action) {
        this.presenter = p;
        this.action = action;
    }

    @Override
    public void onResponseSuccess(NetResponse<D> response) {
        action.data = response.getData();
        onActionSuccess(action);
        action.setMessage(response.getMessage());
        action.setCode(response.getCode());
        presenter.getMvpView().onActionSuccess(action);
    }

    @Override
    public void onResponseError(ErrorThrowable throwable) {
        action.setMessage(throwable.msg);
        action.setCode(throwable.code);
        presenter.getMvpView().onActionError(action);
    }

    public abstract void onActionSuccess(Action<D,S> action);
}
