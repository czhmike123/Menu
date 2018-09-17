package com.mike.commonlib.network;

import com.mike.commonlib.logger.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: Menu
 * 类描述:NetManager
 * 作者: Mike
 * 创建时间: 2018/8/31 10:30
 * 邮箱:2468139903@qq.com
 */
public class NetManager {
 private   static Log log = Log.Factory.getInstance().setTag(NetManager.class.getSimpleName());

    static Map<String,NetRequest> requestMap=new HashMap<>();

    public static <T extends NetRequest> NetRequest getNetworkRequest(Class<T> clazz) {

        if(clazz==null){
            return null;
        }
        NetRequest request = requestMap.get(clazz.getSimpleName());
        if(request!=null){
             log.d(request);
            return request;
        }
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            request = constructor.newInstance();
            requestMap.put(clazz.getSimpleName(),request);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        log.d(request);
        return request;
    }

}
