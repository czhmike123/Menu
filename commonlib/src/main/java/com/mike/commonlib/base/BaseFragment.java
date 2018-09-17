package com.mike.commonlib.base;

import com.mike.commonlib.mvp.BaseMvpPresenter;
import com.mike.commonlib.mvp.BaseMvpView;

/**
 * 项目名称: Menu
 * 类描述:BaseFragment
 * 作者: Mike
 * 创建时间: 2018/9/4 11:10
 * 邮箱:2468139903@qq.com
 */
public class BaseFragment<V extends BaseMvpView,P extends BaseMvpPresenter<V>> extends MvpFragment <V,P>{

}
