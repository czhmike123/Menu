package com.mike.commonlib.mvp;

/**
 * 项目名称: Menu
 * 类描述:MvpPresenter
 * 作者: Mike
 * 创建时间: 2018/9/4 9:45
 * 邮箱:2468139903@qq.com
 */
public interface MvpPresenter<V extends MvpView> {

    void onCreateMvpPresenter(V v);

    void onAttachMvpView(V view);

    void onDetachMvpView();

    void onDestroyMvpPresenter();

    V getMvpView();
}
