package com.mike.commonlib.mvp;

/**
 * 项目名称: Menu
 * 类描述:MvpPresenterProxyImpl
 * 作者: Mike
 * 创建时间: 2018/8/31 17:50
 * 邮箱:2468139903@qq.com
 */
public class MvpPresenterProxyImpl<V extends BaseMvpView,P extends BaseMvpPresenter<V>> implements MvpPresenterProxy<V,P> {

    private MvpPresenterFactory<V, P> factory;
    private P presnter;
    private boolean isAttachView;

    public MvpPresenterProxyImpl(MvpPresenterFactory<V, P> presenterMvpFactory) {
        this.factory = presenterMvpFactory;
    }

    @Override
    public void setPresenterFactory(MvpPresenterFactory<V, P> factory) {
        if (presnter != null) {
            throw new IllegalArgumentException("这个方法只能在onPresenterCreate()之前调用，如果Presenter已经创建则不能再修改");
        }
        this.factory = factory;
    }

    @Override
    public MvpPresenterFactory<V, P> getPresenterFactory() {
        return factory;
    }

    @Override
    public P getMvpPresenter() {
        return presnter;
    }

    @Override
    public void onMvpViewCreate(V v) {
        if (factory != null && presnter == null) {
            presnter = factory.createMvpPresenter();
            presnter.onCreateMvpPresenter(v);
            isAttachView=true;
        }
    }

    @Override
    public void onMvpViewResume(V v) {
        if (presnter != null && !isAttachView) {
            presnter.onAttachMvpView(v);
            isAttachView = true;
        }
    }

    @Override
    public void onMvpViewPause() {
        if(presnter!=null&&isAttachView){
            presnter.onDetachMvpView();
            isAttachView=false;
        }
    }

    @Override
    public void onMvpViewDestroy() {
        if(presnter!=null){
            presnter.onDestroyMvpPresenter();
            isAttachView=false;
            presnter=null;
        }
    }
}
