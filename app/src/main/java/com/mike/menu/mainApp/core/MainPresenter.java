package com.mike.menu.mainApp.core;

import com.mike.commonlib.acmodel.Action;
import com.mike.menu.mainApp.common.bean.MenuList;
import com.mike.menu.mainApp.common.bean.MenuType;
import com.mike.menu.mainApp.common.bean.User;

/**
 * 项目名称: Menu
 * 类描述:MainPresenter
 * 作者: Mike
 * 创建时间: 2018/9/3 9:49
 * 邮箱:2468139903@qq.com
 */
public class MainPresenter extends MenuBasePresenter<MainView> {


    public void getMenuList(Action<MenuList,MenuList.Send> action){
        doNetAction1(action,new MenuNetResponseListener<MenuList,MenuList.Send>(this,action) {
            @Override
            public void onActionSuccess(Action<MenuList,MenuList.Send> action) {
                if(!checkNullView()){
                    return;
                }
                getMvpView().onGetMenuListSuccess(action);
            }
        });
    }
    public void getMenuType(final Action<MenuType,MenuType.Send> action){
         doNetAction1(action,new MenuNetResponseListener<MenuType,MenuType.Send>(this,action) {

            @Override
            public void onActionSuccess(Action<MenuType,MenuType.Send> action) {
                if(!checkNullView()){
                    return;
                }
                getMvpView().onGetMenuTypeSuccess(action);
            }
        });
    }

    public void register(final Action<User,User.Send> action){
        doNetAction2(action,new MenuNetResponseListener<User,User.Send>(this,action) {
            @Override
            public void onActionSuccess(Action<User,User.Send> action) {
                if(!checkNullView()){
                    return;
                }
                log.d(action.getData().username);
                getMvpView().onRegisterSuccess(action);
            }
        });
    }
}
