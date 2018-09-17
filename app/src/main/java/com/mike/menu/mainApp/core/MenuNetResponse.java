package com.mike.menu.mainApp.core;

import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.network.NetResponse;

/**
 * 项目名称: Menu
 * 类描述:MenuNetResponse
 * 作者: Mike
 * 创建时间: 2018/9/4 14:11
 * 邮箱:2468139903@qq.com
 */
public class MenuNetResponse<D extends BaseData> implements NetResponse<D> {
    public String showapi_res_error;
    public String showapi_res_id;
    public int showapi_res_code;
    private D showapi_res_body;

    @Override
    public String getMessage() {
        return showapi_res_error;
    }

    @Override
    public int getCode() {
        return showapi_res_code;
    }

    @Override
    public D getData() {
        return showapi_res_body;
    }
}
