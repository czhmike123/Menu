package com.mike.commonlib.acmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称: Menu
 * 类描述:Action
 * 作者: Mike
 * 创建时间: 2018/9/4 14:45
 * 邮箱:2468139903@qq.com
 */
public class Action<D extends BaseData, S extends SendData> {
    public Map<String, Object> paramsMap = new HashMap<>();
    public String actionUrl;
    public String baseUrl;
    public String message;
    public int code;
    public D data;
    public List<D> datas;

    public Action<D, S> putStringParams(String key, String value) {
        paramsMap.put(key, value);
        return this;
    }

    public Action<D, S> putIntParams(String key, int value) {
        paramsMap.put(key, value);
        return this;
    }

    public String getString(String key) {
        return (String) paramsMap.get(key);
    }

    public int getInt(String key) {
        return (int) paramsMap.get(key);
    }

    public Object getObject(String key) {
        return paramsMap.get(key);
    }

    public Action<D, S> putObject(String key, Object o) {
        paramsMap.put(key, o);
        return this;
    }

    public Action() {

    }

    public S sendData;

    public Action<D, S> sendData(S data) {
        this.sendData = data;
        return this;
    }

    public S getSendData() {
        return sendData;
    }

    public Action<D, S> setAcionUrl(String acionUrl) {
        this.actionUrl = acionUrl;
        paramsMap.put("actionUrl", acionUrl);
        return this;
    }

    public Map<String, Object> getParamsMap() {
        return paramsMap;
    }

    public String getActionUrl() {
        return getString("actionUrl");
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setListData(List<D> listData) {
        this.datas = listData;
    }

    public List<D> getListData() {
        return datas;
    }

    public void setData(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }
}
