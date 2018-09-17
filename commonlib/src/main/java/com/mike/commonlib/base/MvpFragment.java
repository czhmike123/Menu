package com.mike.commonlib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.mike.commonlib.logger.Log;
import com.mike.commonlib.mvp.BaseMvpPresenter;
import com.mike.commonlib.mvp.BaseMvpView;
import com.mike.commonlib.mvp.MvpPresenterFactory;
import com.mike.commonlib.mvp.MvpPresenterFactoryImpl;
import com.mike.commonlib.mvp.MvpPresenterProxy;
import com.mike.commonlib.mvp.MvpPresenterProxyImpl;

/**
 * 项目名称: Menu
 * 类描述:MvpActivity
 * 作者: Mike
 * 创建时间: 2018/8/31 18:53
 * 邮箱:2468139903@qq.com
 */
public class MvpFragment<V extends BaseMvpView,P extends BaseMvpPresenter<V>> extends Fragment implements MvpPresenterProxy<V,P> {
    Log log=Log.Factory.getInstance().setTag(getClass().getSimpleName());

    private MvpPresenterProxy<V,P> presenterProxy=new MvpPresenterProxyImpl<>(MvpPresenterFactoryImpl.<V, P>createFactory(getClass()));

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onMvpViewCreate((V) this);
        log.d("oncreate:"+getMvpPresenter().getMvpView());
    }

    @Override
    public void onResume() {
        super.onResume();
        onMvpViewResume((V) this);
        log.d("onResume:"+getMvpPresenter().getMvpView());
    }

    @Override
    public void onPause() {
        super.onPause();
        onMvpViewPause();
        log.d("onPause:"+getMvpPresenter().getMvpView());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        log.d("onDestroy:"+getMvpPresenter().getMvpView());
        onMvpViewDestroy();
    }


    @Override
    public void setPresenterFactory(MvpPresenterFactory<V,P> factory) {
        presenterProxy.setPresenterFactory(factory);
    }

    @Override
    public MvpPresenterFactory<V,P> getPresenterFactory() {
        return presenterProxy.getPresenterFactory();
    }

    @Override
    public P getMvpPresenter() {
        return presenterProxy.getMvpPresenter();
    }

    @Override
    public void onMvpViewCreate(V view) {
        presenterProxy.onMvpViewCreate(view);
    }

    @Override
    public void onMvpViewResume(V view) {
       presenterProxy.onMvpViewResume(view);
    }

    @Override
    public void onMvpViewPause() {
      presenterProxy.onMvpViewPause();
    }

    @Override
    public void onMvpViewDestroy() {
       presenterProxy.onMvpViewDestroy();
    }

}
