package com.mike.commonlib.mvp;

/**
 * 项目名称: Menu
 * 类描述:MvpPresenterFactory
 * 作者: Mike
 * 创建时间: 2018/8/31 17:04
 * 邮箱:2468139903@qq.com
 */
public interface MvpPresenterFactory<V extends BaseMvpView, P extends BaseMvpPresenter<V>> {
    P createMvpPresenter();
}
