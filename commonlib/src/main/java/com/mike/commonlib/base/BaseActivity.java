package com.mike.commonlib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.logger.Log;
import com.mike.commonlib.mvp.BaseMvpPresenter;
import com.mike.commonlib.mvp.BaseMvpView;

/**
 * 项目名称: Menu
 * 类描述:BaseActivity
 * 作者: Mike
 * 创建时间: 2018/8/30 18:08
 * 邮箱:2468139903@qq.com
 */
public abstract class BaseActivity<V extends BaseMvpView,P extends BaseMvpPresenter<V>> extends MvpActivity<V,P> implements BaseMvpView {
   protected Loading mLoading;
   protected View mRootView;
   protected Log log=Log.Factory.getInstance().setTag("BaseActivity_"+getClass().getSimpleName());
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootView= inflateRootView(LayoutInflater.from(this));
        setContentView(mRootView);
        mLoading =Loading.Factory.getInstance(this);
        initUI();
        initData();
    }

    public View getRootView(){
        return mRootView;
    }

    protected View inflateRootView(LayoutInflater inflater){
        return inflater.inflate(getRootViewLayoutId(),null);
    }


    public abstract void initUI();

    public abstract void initData();

    public abstract int getRootViewLayoutId();

    @Override
    public void onActionPrepare(Action action) {
        mLoading.showLoading(action);
    }

    @Override
    public void onActionProgress(Action action) { }

    @Override
    public void onActionError(Action action) {
       mLoading.closeLoading(action);
    }

    @Override
    public void onActionSuccess(Action action) {
        mLoading.closeLoading(action);
    }
}
