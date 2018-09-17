package com.mike.commonlib.mvp;

import com.mike.commonlib.acmodel.Action;

/**
 * 项目名称: Menu
 * 类描述:BaseMvpView
 * 作者: Mike
 * 创建时间: 2018/8/30 18:29
 * 邮箱:2468139903@qq.com
 */
public interface BaseMvpView extends MvpView {

    void onActionPrepare(Action action);

    void onActionProgress(Action action);

    void onActionError(Action action);

    void onActionSuccess(Action action);
}
