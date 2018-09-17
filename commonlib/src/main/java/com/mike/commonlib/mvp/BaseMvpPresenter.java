package com.mike.commonlib.mvp;

/**
 * 项目名称: Menu
 * 类描述:BaseMvpPresenter
 * 作者: Mike
 * 创建时间: 2018/8/30 18:32
 * 邮箱:2468139903@qq.com
 */
public abstract class BaseMvpPresenter<V extends BaseMvpView> implements MvpPresenter<V>{
    private V view;
    @Override
    public void onCreateMvpPresenter(V v){
        this.view=v;
    }
    @Override
    public void onAttachMvpView(V view){
        this.view=view;
    }
    @Override
    public void onDetachMvpView(){
        this.view=null;
    }
    @Override
    public void onDestroyMvpPresenter(){
        this.view=null;
    }

    /**
     * 获取V层接口View
     *
     * @return 返回当前View
     */
    @Override
    public V getMvpView() {
        return view;
    }

}
