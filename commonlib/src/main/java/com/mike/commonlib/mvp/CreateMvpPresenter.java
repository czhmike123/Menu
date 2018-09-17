package com.mike.commonlib.mvp;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 项目名称: Menu
 * 类描述:CreateMvpPresenter
 * 作者: Mike
 * 创建时间: 2018/8/31 17:07
 * 邮箱:2468139903@qq.com
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateMvpPresenter {
    Class<? extends BaseMvpPresenter> value();
}
