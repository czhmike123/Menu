package com.mike.menu.mainApp.api;

import com.mike.menu.mainApp.common.bean.MenuList;
import com.mike.menu.mainApp.common.bean.MenuType;
import com.mike.menu.mainApp.core.MenuNetResponse;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 项目名称: Menu
 * 类描述:ApiRequest
 * 作者: Mike
 * 创建时间: 2018/8/31 11:58
 * 邮箱:2468139903@qq.com
 */
public interface MenuApiService{

    //String BASE_URL="http://caipu.market.alicloudapi.com/";
    String BASE_URL="http://toutiao-ali.juheapi.com/toutiao/index";
    String AUTHORIZATION_APPCODE="Authorization:APPCODE 059fbae46c294b3ba8682995adf2b655";

//    cpName	STRING	可选	菜谱名称
//    id	STRING	可选	菜谱标识,查询具体某个菜谱信息.当传递该参数的时候,type参数将无效
//    maxResults	INT	可选	每次请求返回的最大数据集,取值范围1-50之间
//    page	INT	可选	分页的当前页数
//    type	STRING	必选	菜谱的分类

    // 获取菜谱列表
    @Headers(AUTHORIZATION_APPCODE)
    @GET(BASE_URL+"{actionUrl}")
    Observable<Response<MenuNetResponse<MenuList>>> getMenuList(
            @Path("actionUrl") String actionUrl,
            @Query("cpName") String cpName,
            @Query("id") String id,
            @Query("maxResults") int maxResults,
            @Query("page") int page,
            @Query("type") String type);

    // 获取菜谱分类
    @Headers(AUTHORIZATION_APPCODE)
    @GET(BASE_URL+"showapi_cpType")
    Observable<Response<MenuNetResponse<MenuType>>> getMenuType(
            @Query("type") String type);
}
