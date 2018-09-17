package com.mike.commonlib.network;

import com.mike.commonlib.exception.ErrorThrowable;

/**
 * 项目名称: Menu
 * 类描述:NetResponseListener
 * 作者: Mike
 * 创建时间: 2018/8/31 10:20
 * 邮箱:2468139903@qq.com
 */
public interface NetResponseListener<R extends NetResponse> {
    void onResponseSuccess(R response);
    void onResponseError(ErrorThrowable throwable);
}
