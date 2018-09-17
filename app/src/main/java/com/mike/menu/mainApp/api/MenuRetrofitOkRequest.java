package com.mike.menu.mainApp.api;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;
import com.mike.commonlib.exception.ErrorThrowable;
import com.mike.commonlib.network.NetOption;
import com.mike.commonlib.network.NetResponseListener;
import com.mike.commonlib.network.retrofit.RetrofitOkRequest;
import com.mike.menu.mainApp.common.bean.MenuList;
import com.mike.menu.mainApp.core.MenuNetResponse;

import java.util.Map;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 项目名称: Menu
 * 类描述:MenuRetrofitOkRequest
 * 作者: Mike
 * 创建时间: 2018/8/31 10:50
 * 邮箱:2468139903@qq.com
 */
public class MenuRetrofitOkRequest extends RetrofitOkRequest<MenuApiService,MenuNetResponse> {
    @Override
    public Class getApiServiceClass() {
        return MenuApiService.class;
    }

    @Override
    public String getBaseUrl() {
        return MenuApiService.BASE_URL;
    }

    @Override
    public <D extends BaseData,S extends SendData> void doNetworkRequest(Action<D,S> action, NetOption option, final NetResponseListener<MenuNetResponse> listener) {
        apiService.getMenuList(action.getActionUrl(),"","",1,1,"蛋类").flatMap(new Func1<Response<MenuNetResponse<MenuList>>, Observable<MenuNetResponse<MenuList>>>() {
            @Override
            public Observable<MenuNetResponse<MenuList>> call(retrofit2.Response<MenuNetResponse<MenuList>> menuNetResponseResponse) {
                return Observable.just(menuNetResponseResponse.body());
            }
        }) .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<MenuNetResponse<MenuList>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                log.d(e);
                log.e(e.toString(),e);
                listener.onResponseError(new ErrorThrowable(100,e.getMessage()));
            }

            @Override
            public void onNext(MenuNetResponse<MenuList> menuNetResponse) {
                listener.onResponseSuccess(menuNetResponse);
            }
        });

//        apiService.getMenuType("").flatMap(new Func1<Response<MenuNetResponse<MenuType>>, Observable<MenuNetResponse<MenuType>>>() {
//            @Override
//            public Observable<MenuNetResponse<MenuType>> call(retrofit2.Response<MenuNetResponse<MenuType>> menuNetResponseResponse) {
//                return Observable.just(menuNetResponseResponse.body());
//            }
//        }) .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<MenuNetResponse<MenuType>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                log.d(e);
//                log.e(e.toString(),e);
//                listener.onResponseError(new ErrorThrowable(100,e.getMessage()));
//            }
//
//            @Override
//            public void onNext(MenuNetResponse<MenuType> menuNetResponse) {
//                listener.onResponseSuccess(menuNetResponse);
//            }
//        });


    }
}
