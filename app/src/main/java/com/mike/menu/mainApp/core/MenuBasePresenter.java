package com.mike.menu.mainApp.core;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;
import com.mike.commonlib.logger.Log;
import com.mike.commonlib.mvp.BaseMvpModel;
import com.mike.commonlib.mvp.BaseMvpPresenter;
import com.mike.commonlib.mvp.BaseMvpView;
import com.mike.commonlib.utils.ToastUtil;

/**
 * 项目名称: Menu
 * 类描述:MenuBasePresenter
 * 作者: Mike
 * 创建时间: 2018/9/4 10:54
 * 邮箱:2468139903@qq.com
 */
public class MenuBasePresenter<V extends BaseMvpView>  extends BaseMvpPresenter<V>{
    protected Log log=Log.Factory.getInstance().setTag("MenuBasePresenter_"+getClass().getSimpleName());
    BaseMvpModel model;
    public MenuBasePresenter(){
        model=new MenuRetrofitOkActionModel();
    }

    protected  <D extends BaseData,S extends SendData> void doNetAction1(Action<D,S> action , MenuNetResponseListener<D,S> menuNetResponseListener){
        if(model==null||!(model instanceof MenuRetrofitOkActionModel)){
            model=new MenuRetrofitOkActionModel();
        }
        if(!checkNullView()){
            return;
        }
        getMvpView().onActionPrepare(action);
        model.<D,S>doNetAction(action, menuNetResponseListener);
    }
    protected  <D extends BaseData,S extends SendData> void doNetAction2(Action<D,S> action , MenuNetResponseListener<D,S> menuNetResponseListener){
        if(model==null||!(model instanceof MenuBmobActionModel)){
            model=new MenuBmobActionModel();
        }
        if(!checkNullView()){
            return;
        }
        getMvpView().onActionPrepare(action);
        model.<D,S>doNetAction(action, menuNetResponseListener);
    }

    protected boolean checkNullView(){
        if(getMvpView()==null){
            log.d("Mvp view is null");
            return false;
        }
        return true;
    }
}
