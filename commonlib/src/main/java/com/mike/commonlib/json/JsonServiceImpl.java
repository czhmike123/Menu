package com.mike.commonlib.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

class JsonServiceImpl implements JsonService {
    JsonServiceImpl() {
    }

    public <T> T parseObject(String text, Class<T> clazz) {
        return new Gson().fromJson(text, clazz);
    }

    public <T> List<T> parseArray(String text, Class<T> clazz) {
        return new Gson().fromJson(text,new TypeToken<List<T>>() {}.getType());
    }

    public String toJsonString(Object instance) {
        return new Gson().toJson(instance);
    }
}
