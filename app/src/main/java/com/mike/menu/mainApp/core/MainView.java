package com.mike.menu.mainApp.core;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.mvp.BaseMvpView;
import com.mike.menu.mainApp.common.bean.MenuData;
import com.mike.menu.mainApp.common.bean.MenuList;
import com.mike.menu.mainApp.common.bean.MenuType;
import com.mike.menu.mainApp.common.bean.User;

/**
 * 项目名称: Menu
 * 类描述:MainView
 * 作者: Mike
 * 创建时间: 2018/9/3 9:50
 * 邮箱:2468139903@qq.com
 */
public interface MainView extends BaseMvpView {
   void onGetMenuListSuccess(Action<MenuList,MenuList.Send> action);

    void onGetMenuTypeSuccess(Action<MenuType,MenuType.Send> action);

    void onRegisterSuccess(Action<User,User.Send> action);
}
