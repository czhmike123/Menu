package com.mike.commonlib.network;

/**
 * 项目名称: Menu
 * 类描述:NetResponse
 * 作者: Mike
 * 创建时间: 2018/8/31 11:07
 * 邮箱:2468139903@qq.com
 */
public interface NetResponse<D> {
   String getMessage();
   int getCode();
   D getData();
}
