package com.mike.commonlib.mvp;

/**
 * 项目名称: Menu
 * 类描述:MvpPresenterProxy
 * 作者: Mike
 * 创建时间: 2018/8/31 17:46
 * 邮箱:2468139903@qq.com
 */
public interface MvpPresenterProxy<V extends BaseMvpView, P extends BaseMvpPresenter<V>> {

    void setPresenterFactory(MvpPresenterFactory<V, P> factory);

    MvpPresenterFactory<V, P> getPresenterFactory();

    P getMvpPresenter();

    void onMvpViewCreate(V v);

    void onMvpViewResume(V v);

    void onMvpViewPause();

    void onMvpViewDestroy();
}
